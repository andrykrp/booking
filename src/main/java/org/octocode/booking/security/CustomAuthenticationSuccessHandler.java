package org.octocode.booking.security;

import org.octocode.booking.data.PersonRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    //@Resource
    //private PersonRepository personRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
    Authentication authentication) throws ServletException, IOException {
        String user = request.getRemoteUser();
        if (user == null) user = request.getUserPrincipal().getName();
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
