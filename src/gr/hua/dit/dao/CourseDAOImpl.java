package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getCourses() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Course> query = currentSession.createQuery("from Course", Course.class);

		// execute the query and get the results list
		List<Course> courses = query.getResultList();

		// return the results
		return courses;
	}

	@Override
	public void saveCourse(Course course) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (course.getId() != 0) {
		// update the course
			currentSession.update(course);
		}
		else {
			// save the course
		currentSession.save(course);
		}

	}

	@Override
	public Course getCourse(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Course
		Course course = currentSession.get(Course.class, id);
		return course;
	}

	@Override
	public void deleteCourse(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the course
		Course course = currentSession.get(Course.class, id);

		// delete course
		currentSession.delete(course);

	}

}
