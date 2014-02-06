package org.octocode.booking.controller;

import org.apache.log4j.Logger;
import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.octocode.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class PersonController {
    private static final Logger LOGGER = Logger.getLogger(PersonController.class);
    @Resource
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("userList", personRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public String editProfile(HttpServletRequest request, @ModelAttribute("model") ModelMap model, Principal p) {
        if(request.getSession().getAttribute("user") == null) {
            String user = p.getName();
            Person person = personRepository.findByUsername(user);
            if (person != null)
            {
                request.getSession().setAttribute("user", person);
            }
        }
        return "edit_profile";
    }

    @Transactional
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public @ResponseBody Person saveProfile(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public String registerProfile(Person person) {
        return "create_profile";
    }

    @Transactional
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody Person registerProfile(@RequestBody @Valid Person person,
                                  @RequestParam(value = "retypePassword", required = false) String retypePassword,
                                  BindingResult br, RedirectAttributes ra, HttpServletRequest request) {
        String pswd = person.getPassword();
        String user = person.getUsername();
        if(!pswd.equals(retypePassword)) {
            ra.addFlashAttribute("error", br.getFieldError().getDefaultMessage());
            return null;
        }
        Person p = personRepository.save(person);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, pswd);

        HttpSession session = request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        try {
            Authentication authenticatedUser = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            session.setAttribute("user", p);
        }
        catch (Exception e) {
            e.printStackTrace();
            //return null;
        }

        return p;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@ModelAttribute("model") ModelMap model) {
        Person person = personRepository.findById(2);
        model.addAttribute("userList", "model: " + person);
        return "search";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(@ModelAttribute("model") ModelMap model) {
        Person person = personRepository.findById(1);
        model.addAttribute("message", person == null ? "Hello world!" : person.toString());
        return "layout/home";
    }

    @RequestMapping("/persons")
    public
    @ResponseBody
    List<Person> persons() {
        return new ArrayList<>();
    }

}