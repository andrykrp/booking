package org.octocode.booking.controller;

import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        Person person = personRepository.findById(2);
        model.addAttribute("userList", "model: " + person);
        return "index";
    }

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute("model") ModelMap model) {
        Person person = personRepository.findById(1);
		model.addAttribute("message", person == null ? "Hello world!" : person.toString());
		return "layout/home";
	}
}