package org.sid.controller;
import org.sid.entities.Role;
import org.sid.entities.Users;
import org.sid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
	
	@Autowired
	UserService userService;
	@GetMapping("nouveauUtilisateur")
	public String NewUser(@RequestParam("nouveauUtilisateur") String cp,String role) {
		userService.addRoleToUser(cp, role);
		return "card.html";
	}
	@GetMapping("/index")
	public String cards() {
		return "index.html";
	}
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	@RequestMapping(value="/")
	public String home() {
		return  "redirect:/index";
	}
	
	


}