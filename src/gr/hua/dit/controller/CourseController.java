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

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.service.CourseService;
import gr.hua.dit.service.TeacherService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	// inject the course service
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;

	
	
	@GetMapping("/list")
	public String listCourses(Model model) {
		
		// get courses from the service
		List<Course> courses = courseService.getCourses();
		
		// add the courses to the model
		model.addAttribute("courses",courses);
		
		// add page title
		model.addAttribute("pageTitle", "List Courses");
		return "list-courses";
	}
	
	@GetMapping("/{id}")
	public String getCourse(Model model, @PathVariable("id") int id) {
		// get the course
		Course course = courseService.getCourse(id);
		
		model.addAttribute("course", course);
		
		return "course-form";
	}
	
	@GetMapping("/showAddForm/{teacherId}")
	public String showAddForm(Model model, @PathVariable("teacherId") int teacherId) {
		// create model attribute to get form data
		Course course = new Course();
		Teacher teacher = teacherService.getTeacher(teacherId);
		course.setTeacher(teacher);
		System.out.println("teacher in show form -- > " + course.getTeacher());

		model.addAttribute("course", course);

		// add page title
		model.addAttribute("pageTitle", "Add Course");
		return "course-form";
	}
	
	@PostMapping("/saveCourse/{teacherId}")
	public String saveCourse(@ModelAttribute("course") Course course, @PathVariable("teacherId") int teacherId) {
		// save the course using the service
		Teacher teacher = teacherService.getTeacher(teacherId);
		course.setTeacher(teacher);
		System.out.println("teacher -- > " + course.getTeacher());
		courseService.saveCourse(course);
		
		return "redirect:/course/list";
	}
	

}
