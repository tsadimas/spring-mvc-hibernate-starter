package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		return "redirect:/user/list";
	}

}
