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

import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TeacherList;
import gr.hua.dit.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherApiController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private TeacherList teacherList;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Teacher getTeacher(@PathVariable("id") int id) {

		Teacher teacher = teacherService.getTeacher(id);
		System.out.println("teacher :" + teacher);

		return teacher;
	}

	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteTeacher(@PathVariable("id") int id) {
		teacherService.deleteTeacher(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public TeacherList getTeachers() {

		List<Teacher> teachers = teacherService.getTeachers();
		System.out.println("teachers :" + teachers);
		this.teacherList.setTeacherList(teachers);
		return this.teacherList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Teacher createTeacher(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Teacher teacher = new Teacher(firstName, lastName, email);
		teacherService.saveTeacher(teacher);
		return teacher;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Teacher createTeacherfromJson(@RequestBody Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return teacher;
	}
	
	

}
