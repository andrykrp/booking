package org.octocode.booking.controller;

import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;

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
}