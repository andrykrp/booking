package org.octocode.booking.security;

import org.octocode.booking.data.PersonRepository;
import org.octocode.booking.model.Person;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;


public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Resource
    private PersonRepository personRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication auth) throws ServletException, IOException {
        User user = (User)auth.getPrincipal();
        String username = user.getUsername();
        Person person = personRepository.findByUsername(username);
        if (person != null)
        {
            request.getSession().setAttribute("user", person);
        }
        super.onAuthenticationSuccess(request, response, auth);
    }

}
