package com.javapoint;

public interface UserService {

	public User findUserByEmail(String email);
	public void saveUser(User user);

}
