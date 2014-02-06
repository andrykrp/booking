package org.octocode.booking.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;


public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    //@Resource
    //private PersonRepository personRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        String user = request.getRemoteUser();
        if (user == null) {
            Principal principal = request.getUserPrincipal();
            user = principal == null ? "none" : principal.getName();
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
