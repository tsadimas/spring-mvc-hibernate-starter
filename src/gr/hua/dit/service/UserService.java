package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.User;

public interface UserService {

	public void save(User user);

	public List<User> getUsers();

	public User getUser(String username);
	
	public void saveRole(User user, String role);


}
