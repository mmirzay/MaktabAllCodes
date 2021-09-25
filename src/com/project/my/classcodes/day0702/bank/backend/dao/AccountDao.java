package com.project.my.classcodes.day0702.bank.backend.dao;

import com.project.my.classcodes.day0702.bank.backend.entities.Account;
import com.project.my.classcodes.day0702.bank.backend.exceptions.DatabaseException;

public class AccountDao {
	public void addAccount(Account account) throws DatabaseException {

	}

	public double getBalanceByAccountNumber(int accountNumber) throws DatabaseException {
		return 0;
	}

	public void transferMoney(int sourceNumber, int destinationNumber, double amount) throws DatabaseException {
	}
}
