package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Course;



public interface CourseDAO {
	public List<Course> getCourses();

	public void saveCourse(Course course);
	
	public Course getCourse(int id);

	public void deleteCourse(int id);
}
