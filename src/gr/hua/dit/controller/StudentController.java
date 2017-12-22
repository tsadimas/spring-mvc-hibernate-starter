package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Student;
import gr.hua.dit.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// inject the student service
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudents(Model model) {
		
		// get students from the service
		List<Student> students = studentService.getStudents();
		
		// add the students to the model
		model.addAttribute("students",students);
		
		// add page title
		model.addAttribute("pageTitle", "List Students");
		return "list-students";
	}
	
	@GetMapping("/{id}")
	public String getStudent(Model model, @PathVariable("id") int id) {
		// get the student
		Student student = studentService.getStudent(id);
		
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Student student = new Student();
		model.addAttribute("student", student);
		
		// add page title
		model.addAttribute("pageTitle", "Add Student");
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// save the student using the service
		studentService.saveStudent(student);
		
		return "redirect:/student/list";
	}
	

}