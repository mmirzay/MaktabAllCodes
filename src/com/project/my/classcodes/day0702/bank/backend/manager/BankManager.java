package com.project.my.classcodes.day0702.bank.backend.manager;

import com.project.my.classcodes.day0702.bank.backend.dao.AccountDao;
import com.project.my.classcodes.day0702.bank.backend.dao.TransactionDao;
import com.project.my.classcodes.day0702.bank.backend.dao.UserDao;
import com.project.my.classcodes.day0702.bank.backend.entities.Account;
import com.project.my.classcodes.day0702.bank.backend.entities.User;
import com.project.my.classcodes.day0702.bank.backend.exceptions.DatabaseException;
import com.project.my.classcodes.day0702.bank.backend.exceptions.ManagerException;

public class BankManager {
	private UserDao userDao;
	private AccountDao accountDao;
	private TransactionDao transactionDao;

	public BankManager() {
		userDao = new UserDao();
		accountDao = new AccountDao();
		transactionDao = new TransactionDao();
	}

	public void registerUser(String name) throws ManagerException {
		User user = new User(null, name);
		try {
			userDao.registerUser(user);
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new ManagerException(String.format("Can not add user to database.%n Error: %s", e.getMessage()));
		}
	}

	public void addAccount(int userId, double balance) throws ManagerException {

		if (balance <= 0)
			throw new ManagerException(String.format("Can not add account.%n Error: %s", "Balance is invalid."));

		Account account = new Account(userId, null, balance);
		try {
			accountDao.addAccount(account);
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new ManagerException(String.format("Can not add account to database.%n Error: %s", e.getMessage()));
		}
	}

	public void transferMoney(int sourceNumber, int destinationNumber, double amount) throws ManagerException {
		try {

			if (amount > accountDao.getBalanceByAccountNumber(sourceNumber))
				throw new ManagerException(
						String.format("Can not transfer money.%n Error: %s", "Balance is not enough"));

			accountDao.transferMoney(sourceNumber, destinationNumber, amount);
			transactionDao.addNewTransaction(sourceNumber, destinationNumber, amount);

		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new ManagerException(String.format("Can not transfer money.%n Error: %s", e.getMessage()));
		}
	}

}
