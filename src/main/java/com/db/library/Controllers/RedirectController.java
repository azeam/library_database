package com.db.library.Controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
    @RequestMapping(value= {"/redirect"}, method = RequestMethod.GET)
    public String redirectAfterLogin() {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String role = authorities.toArray()[0].toString();
        if (role.equals("ADMIN")) {
            return "redirect:/admin";
        }
        return "redirect:/library";
    }

}
