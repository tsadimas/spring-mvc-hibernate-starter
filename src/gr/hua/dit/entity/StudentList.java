package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="StudentList")
@Component
public class StudentList {

	List<Student> studentList;
	
	public List<Student> getStudentList(){
		return studentList; 
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList=studentList;
	}
	
}
