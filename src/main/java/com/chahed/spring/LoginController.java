package com.chahed.spring;
import java.util.Collection;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chahed.spring.model.*;

@Controller
public class LoginController {
	
	@RequestMapping(value = { "/" })
	public String welcomePage(Authentication authentication){
		if(authentication.isAuthenticated()){
			Object o = authentication.getPrincipal();
			 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		        for (GrantedAuthority grantedAuthority : authorities) {
		            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
		            	return "redirect:/user";
		            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
		            	return "redirect:/admin";
		            }
		            else if (grantedAuthority.getAuthority().equals("ROLE_PARENT")) {
		            	return "redirect:/userparent";
		            }
		        }
		}
		return "redirect:/login";
	}


	@RequestMapping(value="/login")
	public ModelAndView getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
        
		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("connexion", "message", message);
	}


	@RequestMapping("/user")
	public String getUserProfile() {
		return "user";}
	
	@RequestMapping(value="/admin")
	public String admin(Model model, @ModelAttribute Users users) {
		
		model.addAttribute("name", users);
		return "home";}
	
	@RequestMapping("/home")
	public String accueil() {
			return "index";}
		
	@RequestMapping("/userparent")
	public String parent() {
		return "userparent";
	}

	@RequestMapping("/403")
	public ModelAndView getAccessDenied() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
		}

		return new ModelAndView("403", "username", username);
	}

}
