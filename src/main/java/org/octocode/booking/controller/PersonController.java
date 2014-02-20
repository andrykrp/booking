package org.octocode.booking.controller;

import org.apache.log4j.Logger;
import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.model.Person;
import org.octocode.booking.parser.agoda.AgodaParser;
import org.octocode.booking.parser.expedia.ExpediaParser;
import org.octocode.booking.parser.wego.WegoClient;
import org.octocode.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PersonController {
    private static final Logger LOGGER = Logger.getLogger(PersonController.class);
    @Resource
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private ExpediaParser expediaParser;
    @Autowired
    private AgodaParser agodaParser;
    @Autowired
    private WegoClient wegoParser;

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
    public @ResponseBody List<Person> persons() {
        return new ArrayList<>();
    }

    @RequestMapping("/save")
    public String savePerson() {
//        String url = null;
//        try {
//            url = parser.parseHotelList();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        parser.sendRequest(url);

//        agodaParser.parseHotelList("/tmp/test.csv");

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

    @RequestMapping("/wego")
    public String wego() {
        try {
            wegoParser.getHotelsList();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "redirect:index";
    }

    @RequestMapping("/expedia")
    public String expedia() {
//        try {
//            expediaParser.parseHotelList();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        return "redirect:index";
    }

    @RequestMapping("/expediaByCity")
    public String expediaByCity(ModelMap model, HttpServletRequest request) {
        List<Hotel> hotels = new ArrayList<>();
        try {
            Map<String, String> requestParams = new HashMap<>();
//            requestParams.put("destinationString", request.getParameter("destinationString"));
//            requestParams.put("countryCode", request.getParameter("countryCode"));
//            requestParams.put("arrivalDate", request.getParameter("arrivalDate"));
//            requestParams.put("departureDate", request.getParameter("departureDate"));

            requestParams.put("destinationString", "Rome");
            requestParams.put("countryCode", "IT");
            requestParams.put("arrivalDate", "02/21/2014");
            requestParams.put("departureDate", "02/27/2014");

            hotels = expediaParser.parseHotelList(requestParams);
        } catch (Exception e) {
            LOGGER.error("error", e);
        }
        model.addAttribute("hotels", hotels);

        return "layout/hotelsList";
    }
}