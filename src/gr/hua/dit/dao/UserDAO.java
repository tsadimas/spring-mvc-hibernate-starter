package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.User;

public interface UserDAO {

	public void save(User user);

	public List<User> getUsers();

}