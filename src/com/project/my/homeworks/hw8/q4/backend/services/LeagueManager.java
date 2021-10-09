package com.project.my.homeworks.hw8.q4.backend.services;

import java.util.List;

import com.project.my.homeworks.hw8.q4.backend.database.DbManager;
import com.project.my.homeworks.hw8.q4.backend.entities.City;
import com.project.my.homeworks.hw8.q4.backend.entities.Coach;
import com.project.my.homeworks.hw8.q4.backend.entities.LeagueTable;
import com.project.my.homeworks.hw8.q4.backend.entities.Match;
import com.project.my.homeworks.hw8.q4.backend.entities.Player;
import com.project.my.homeworks.hw8.q4.backend.entities.PlayerMatchInfo;
import com.project.my.homeworks.hw8.q4.backend.entities.Stadium;
import com.project.my.homeworks.hw8.q4.backend.entities.Team;
import com.project.my.homeworks.hw8.q4.backend.entities.TeamMatchInfo;
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

	public void addTeam(Team team) throws ServiceExeption {
		try {
			dbManager.insertTeam(team);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig team:" + team.getName(), e);
		}

	}

	public void addPlayer(Player player) throws ServiceExeption {
		try {
			dbManager.insertPlayer(player);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig player:" + player.getName(), e);
		}

	}

	public void addMatch(Match match) throws ServiceExeption {
		try {
			dbManager.insertMatch(match);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig match:" + match.getId(), e);
		}

	}

	public void addTeamMatchInfo(TeamMatchInfo teamMatchInfo) throws ServiceExeption {
		try {
			dbManager.insertTeamMatchInfo(teamMatchInfo);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig team match info:" + teamMatchInfo.getMatch().getId(), e);
		}

	}

	public void addPlayerMatchInfo(PlayerMatchInfo playerMatchInfo) throws ServiceExeption {
		try {
			dbManager.insertPlayerMatchInfo(playerMatchInfo);
		} catch (DbException e) {
			throw new ServiceExeption("error while addig player match info:" + playerMatchInfo.getMatch().getId(), e);
		}

	}

	public LeagueTable getLeagueTable() throws ServiceExeption {
		try {
			return new LeagueTable(dbManager.fetchAllTeamsLeagueInfo());
		} catch (DbException e) {
			throw new ServiceExeption("error while getting league table", e);
		}
	}

	public String getHighestPaidCoach() throws ServiceExeption {
		try {
			return dbManager.fetchHigestPaidCoach();
		} catch (DbException e) {
			throw new ServiceExeption("error while getting most paid coach", e);
		}
	}

	public List<String> getMostPaidPlayersList() throws ServiceExeption {
		try {
			return dbManager.fetchMostPaidPlayersList();
		} catch (DbException e) {
			throw new ServiceExeption("error while getting most paid players list", e);
		}
	}

	public List<String> getCityTeamsNumberList() throws ServiceExeption {
		try {
			return dbManager.fetchCitiesTeamNumberList();
		} catch (DbException e) {
			throw new ServiceExeption("error while getting cities teams number list", e);
		}
	}
}
