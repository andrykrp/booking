package org.octocode.booking.controller;

import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
        //Person person = personRepository.findById(2);
        model.addAttribute("userList", personRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/userProfile/{username}", method = RequestMethod.GET)
    public String editProfile(@PathVariable("username") String user, @ModelAttribute("model") ModelMap model) {
        Person person = personRepository.findByUsername(user);
        model.addAttribute("user", person);
        return "edit_profile";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveProfile(@RequestParam("id") int id,
                              @RequestParam("username") String user,
                              @RequestParam("firstName") String fn,
                              @RequestParam("lastName") String ln,
                              @RequestParam("address") String address,
                              @RequestParam("city") String city,
                              @RequestParam("telephone") String phone,
                              @ModelAttribute("model") ModelMap model) {
        Person person = new Person();
        person.setId(id);
        person.setUsername(user);
        person.setFirstName(fn);
        person.setLastName(ln);
        person.setAddress(address);
        person.setCity(city);
        person.setTelephone(phone);

        personRepository.save(person);
        return "persons";
    }

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute("model") ModelMap model) {
        Person person = personRepository.findById(1);
		model.addAttribute("message", person == null ? "Hello world!" : person.toString());
		return "layout/home";
	}

    @RequestMapping("/persons")
    public @ResponseBody List<Person> persons() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginFrom(@ModelAttribute("model") ModelMap model) {
        if(model.containsAttribute("logged_in_user")) return "index";
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProcess(@RequestParam("userId") String userId, @RequestParam("password") String pswd,
                        @ModelAttribute("model") ModelMap model) {
        //if (userId == null)
        Person p = personRepository.findByUsername(userId);

        if(p == null)
        {
            model.addAttribute("login_error_msg", "User with the username provided does not exist");
            return "login";
        }
        if(!pswd.equals(p.getPassword()))
        {
            model.addAttribute("login_error_msg", "You've entered the wrong password");
            return "login";
        }
        model.addAttribute("logged_in_user", p);
        model.remove("login_error_msg");
        return "index";
    }
}