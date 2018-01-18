package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	

	// inject the teacher service
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		
		// get teachers from the service
		List<User> users = userService.getUsers();
		
		// add the teachers to the model
		model.addAttribute("users",users);
		
		// add page title
		model.addAttribute("pageTitle", "List Users");
		return "list-users";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);
		
		// add page title
		model.addAttribute("pageTitle", "Add User");
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveStudent(@ModelAttribute("user") User user) {
		// save the student using the service
		userService.save(user);
		
		return "redirect:/user/assignRole/"+user.getUsername();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/assignRole/{username}")
	public String assignRole(Model model,  @PathVariable("username") String username) {
		User user = userService.getUser(username);
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
	    model.addAttribute("roles", roles);
	    model.addAttribute("user", user);
		return "assign-role";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/assignRole/{username}")
	public String assignRoleToUser(@PathVariable("username") String username, @RequestParam("role") String role) {
		User user = userService.getUser(username);
		
		System.out.println("Role : " + role);
		userService.saveRole(user, role);
		return "redirect:/user/list";
	}

}
