package com.project.my.homeworks.hw6.q1.backend.managers;

import com.project.my.homeworks.hw6.q1.backend.services.entities.user.Admin;
import com.project.my.homeworks.hw6.q1.backend.services.entities.user.Customer;
import com.project.my.homeworks.hw6.q1.backend.services.entities.user.User;

public class UsersManager {
	private User[] users;
	private User adminUser;
	private int userIndex;

	public UsersManager(int numberOfAllUsers) {
		users = new User[numberOfAllUsers];
		adminUser = new Admin();
		userIndex = 0;
	}

	public boolean loginAdmin(String username, String password) {
		return adminUser.checkAuthority(username, password);
	}

	public boolean loginUser(String username, String password) {
		for (User user : users)
			if (user != null && user.checkAuthority(username, password))
				return true;
		return false;
	}

	public void addNewCustomer(Customer customer) {
		users[userIndex++] = customer;
	}

	public boolean isDuplicateUsername(String username) {
		for (User user : users)
			if (user == null)
				break;
			else if (user.getUsername().equals(username))
				return true;
		return false;
	}

	public int getNumberOfAddedCutomers() {
		return userIndex;
	}

	public boolean isCutomerArrayFull() {
		return userIndex == users.length;
	}

	public User getUser(String username) {
		for (User user : users)
			if (user == null)
				break;
			else if (user.getUsername().equals(username))
				return user;
		return null;
	}
}
