package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.CourseList;
import gr.hua.dit.service.CourseService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/course")
public class CourseApiController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseList courseList;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Course getCourse(@PathVariable("id") int id) {

		Course course = courseService.getCourse(id);
		System.out.println("course :" + course);

		return course;
	}

	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteCourse(@PathVariable("id") int id) {
		courseService.deleteCourse(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public CourseList getCourses() {

		List<Course> courses = courseService.getCourses();
		System.out.println("courses :" + courses);
		this.courseList.setCourseList(courses);
		return this.courseList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Course createCourse(@RequestParam("firstName") String firstName,
			@RequestParam("title") String title) {
		Course course = new Course(title);
		courseService.saveCourse(course);
		return course;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Course createCoursefromJson(@RequestBody Course course) {
		courseService.saveCourse(course);
		return course;
	}
	
	

}
