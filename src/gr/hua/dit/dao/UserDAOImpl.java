package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(user);

	}

	@Override
	public List<User> getUsers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<User> query = currentSession.createQuery("from User order by username", User.class);

		// execute the query and get the results list
		List<User> users = query.getResultList();

		// return the results
		return users;

	}

}
