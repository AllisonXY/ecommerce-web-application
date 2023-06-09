package com.shopio.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopio.common.entity.Role;
import com.shopio.common.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service; 
	
	@GetMapping("/users")
	public String listAll(Model model) {
		
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);  //attribute name, attribute object
		return "users";
	}
	
	@GetMapping("/users/new")  //register a new user
	public String newUser(Model model) {
		List<Role> listRoles = service.listRoles();
		
		User user = new User();
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);

		return "user_form";
	}
	
	@PostMapping("/users/save")   //save new user after submitting form
	public String saveUser(User user, RedirectAttributes redirectAttributes) {
		System.out.println(user);
		service.save(user);
		redirectAttributes.addFlashAttribute("message","The user has been saved successfully.");
		return "redirect:/users";  //redirect to /users page
	}
	

}


