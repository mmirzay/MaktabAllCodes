package com.project.my.homeworks.hw8.q4.backend.services;

import com.project.my.homeworks.hw8.q4.backend.database.DbManager;
import com.project.my.homeworks.hw8.q4.backend.entities.City;
import com.project.my.homeworks.hw8.q4.backend.entities.Coach;
import com.project.my.homeworks.hw8.q4.backend.entities.Stadium;
import com.project.my.homeworks.hw8.q4.backend.exceptions.DbException;
import com.project.my.homeworks.hw8.q4.backend.exceptions.ServiceExeption;

public class LeagueManager {
	private DbManager dbManager;

	public void initializeDatabase() throws ServiceExeption {
		dbManager = new DbManager();
		try {
			dbManager.initializeDatabase();
		} catch (DbException e) {
			throw new ServiceExeption("Error while initializing Database", e);
		}
	}

	public void addCity(City city) throws ServiceExeption {
		try {
			dbManager.insertCity(city);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig city:" + city.getName(), e);
		}
	}

	public void addStadium(Stadium stadium) throws ServiceExeption {
		try {
			dbManager.insertStadium(stadium);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig stadium:" + stadium.getName(), e);
		}

	}

	public void addCoach(Coach coach) throws ServiceExeption {
		try {
			dbManager.insertCoach(coach);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig coach:" + coach.getName(), e);
		}
	}
}
