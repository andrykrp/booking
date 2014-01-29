package org.octocode.booking.controller;

import org.apache.log4j.Logger;
import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.octocode.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public String editProfile(@ModelAttribute("model") ModelMap model, Principal p) {
        String user = p.getName();
        Person person = personRepository.findByUsername(user);
        model.addAttribute("user", person);
        return "edit_profile";
    }

    @Transactional
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveProfile(@RequestParam("firstName") String fn,
                              @RequestParam("lastName") String ln,
                              @RequestParam("address") String address,
                              @RequestParam("city") String city,
                              @RequestParam("telephone") String phone,
                              @ModelAttribute("model") ModelMap model, Principal p) {
        String user = p.getName();
        Person person = personRepository.findByUsername(user);
        person.setFirstName(fn);
        person.setLastName(ln);
        person.setAddress(address);
        person.setCity(city);
        person.setTelephone(phone);

        personRepository.save(person);
        return "index";
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

    @RequestMapping("/save")
    public String savePerson() {
        //method 1
        /*
        Person person = personService.save(2);
        */

        //method 2
        /*
        Person person = personRepository.findById(2);
        person.setCity("OREN");
        personRepository.save(person);
        */
        //LOGGER.info(person);
        return "redirect:index";
    }
}