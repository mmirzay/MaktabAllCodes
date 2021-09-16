package com.project.my.homeworks.hw6.q1.entities.user;

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

	public boolean addNewCustomer(String username, String password, String firstName, String lastName) {
		for (User user : users)
			if (user == null)
				break;
			else if (user.getUsername().equals(username))
				return false;
		User user = new Customer(username, password, firstName, lastName);
		users[userIndex++] = user;
		return true;
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
