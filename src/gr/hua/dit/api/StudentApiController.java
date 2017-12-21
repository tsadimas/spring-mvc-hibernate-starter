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

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentList;
import gr.hua.dit.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentApiController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentList studentList;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Student getStudent(@PathVariable("id") int id) {

		Student student = studentService.getStudent(id);
		System.out.println("student :" + student);

		return student;
	}

	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public StudentList getStudents() {

		List<Student> students = studentService.getStudents();
		System.out.println("students :" + students);
		this.studentList.setStudentList(students);
		return this.studentList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Student createStudent(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Student student = new Student(firstName, lastName, email);
		studentService.saveStudent(student);
		return student;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Student createStudentfromJson(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}
	
	

}
