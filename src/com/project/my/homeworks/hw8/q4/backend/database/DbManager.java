package com.project.my.homeworks.hw8.q4.backend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.my.homeworks.hw8.q4.backend.entities.City;
import com.project.my.homeworks.hw8.q4.backend.entities.Coach;
import com.project.my.homeworks.hw8.q4.backend.entities.Stadium;
import com.project.my.homeworks.hw8.q4.backend.exceptions.DbException;

public class DbManager {
	private static class Statements {
		private static class Schema {
			private static String CREATE = "CREATE DATABASE IF NOT EXISTS maktab_league_schema";
		}

		private static class City {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.city (name varchar(25) NOT NULL,  PRIMARY KEY (name)) ENGINE=InnoDB";
			private static String INSERT_CITY = "INSERT INTO maktab_league_schema.city (name) VALUES(?);";
		}

		private static class Stadium {
			private static String CREATE_TABLE = " CREATE TABLE IF NOT EXISTS maktab_league_schema.stadium ("
					+ " name varchar(25) NOT NULL," + " capacity int NOT NULL," + " city_name varchar(25) NOT NULL,"
					+ " PRIMARY KEY (name)," + " KEY stadium_city_FK (city_name),"
					+ " CONSTRAINT stadium_city_FK FOREIGN KEY (city_name) REFERENCES city (name) ON DELETE CASCADE ON UPDATE CASCADE"
					+ " )" + " ENGINE=InnoDB;";

			private static String INSERT_STADIUM = "INSERT INTO maktab_league_schema.stadium (name, capacity, city_name) VALUES(?, ?, ?);";
		}

		private static class Coach {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.coach ("
					+ " id int NOT NULL," + " name varchar(25) NOT NULL," + " PRIMARY KEY (id)" + ")"
					+ " ENGINE=InnoDB;";
			private static String INSERT_COACH = "INSERT INTO maktab_league_schema.coach (id, name) VALUES(?, ?);";
		}

		private static class Team {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.team ("
					+ " name varchar(25) NOT NULL," + " coach_id int NOT NULL," + " captain_id int NOT NULL,"
					+ " city_name varchar(25) NOT NULL," + " PRIMARY KEY (name)," + " KEY team_city_FK (city_name),"
					+ " KEY team_coach_FK (coach_id),"
					+ " CONSTRAINT team_city_FK FOREIGN KEY (city_name) REFERENCES city (name) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ " CONSTRAINT team_coach_FK FOREIGN KEY (coach_id) REFERENCES coach (id) ON DELETE CASCADE ON UPDATE CASCADE"
					+ " ) ENGINE=InnoDB;";
		}

		private static class Player {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.player ("
					+ " id int NOT NULL," + " name varchar(25) NOT NULL," + " position varchar(3) NOT NULL,"
					+ " skill_level int NOT NULL," + " team_name varchar(100) NOT NULL," + " PRIMARY KEY (id),"
					+ " KEY player_FK (team_name),"
					+ " CONSTRAINT player_FK FOREIGN KEY (team_name) REFERENCES team (name) ON DELETE CASCADE ON UPDATE CASCADE"
					+ " ) ENGINE=InnoDB;";
		}

		private static class Match {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.match ("
					+ " id int NOT NULL," + " home_team_name varchar(25) NOT NULL,"
					+ " away_team_name varchar(25) NOT NULL," + " date date NOT NULL,"
					+ " stadium_name varchar(25) NOT NULL," + " PRIMARY KEY (id),"
					+ " KEY match_stadium_FK (stadium_name)," + " KEY match_hometeam_FK (home_team_name),"
					+ " KEY match_awayteam_FK (away_team_name),"
					+ " CONSTRAINT match_awayteam_FK FOREIGN KEY (away_team_name) REFERENCES team (name) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ " CONSTRAINT match_hometeam_FK FOREIGN KEY (home_team_name) REFERENCES team (name) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ " CONSTRAINT match_stadium_FK FOREIGN KEY (stadium_name) REFERENCES stadium (name) ON DELETE CASCADE ON UPDATE CASCADE"
					+ " ) ENGINE=InnoDB;";
		}

		private static class Contract {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.contract ("
					+ " id int NOT NULL," + " team_name varchar(25) NOT NULL," + " person_id int NOT NULL,"
					+ " person_role varchar(100) NOT NULL," + " payment double NOT NULL," + " year int NOT NULL,"
					+ " length int NOT NULL," + " PRIMARY KEY (id)," + " KEY contract_FK (team_name),"
					+ " CONSTRAINT contract_FK FOREIGN KEY (team_name) REFERENCES team (name) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ") ENGINE=InnoDB;";
		}

		private static class PlayerMatchInfo {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.player_match_info ("
					+ " player_id int NOT NULL," + " match_id int NOT NULL," + " number_of_goals int NOT NULL,"
					+ " number_of_assists int NOT NULL," + " PRIMARY KEY (player_id,match_id),"
					+ " KEY player_match_info_match_FK (match_id),"
					+ " CONSTRAINT player_match_info_player_FK FOREIGN KEY (player_id) REFERENCES player (id) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ " CONSTRAINT player_match_info_match_FK FOREIGN KEY (match_id) REFERENCES maktab_league_schema.match (id) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ") ENGINE=InnoDB;";
		}

		private static class TeamMatchInfo {
			private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS maktab_league_schema.team_match_info ("
					+ " team_name varchar(25) NOT NULL," + " match_id int NOT NULL," + " score int NOT NULL,"
					+ " number_of_scored_goals int NOT NULL," + " number_of_received_goals int NOT NULL,"
					+ " PRIMARY KEY (team_name,match_id)," + " KEY team_match_info_match_FK (match_id),"
					+ " CONSTRAINT team_match_info_match_FK FOREIGN KEY (match_id) REFERENCES maktab_league_schema.match (id) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ " CONSTRAINT team_match_info_team_FK FOREIGN KEY (team_name) REFERENCES team (name) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ") ENGINE=InnoDB;";
		}
	}

	private Connection getConnection() throws SQLException {
		return DbConnection.getConnection();
	}

	public void initializeDatabase() throws DbException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
			try {
				statement.execute(Statements.Schema.CREATE);
			} catch (SQLException e) {
				throw new DbException("Error while creating Schema", e);
			}

			try {
				statement.execute(Statements.City.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (city)", e);
			}

			try {
				statement.execute(Statements.Stadium.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (stadium)", e);
			}

			try {
				statement.execute(Statements.Coach.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (coach)", e);
			}

			try {
				statement.execute(Statements.Team.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (team)", e);
			}

			try {
				statement.execute(Statements.Player.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (player)", e);
			}

			try {
				statement.execute(Statements.Match.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (match)", e);
			}

			try {
				statement.execute(Statements.Contract.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (contract)", e);
			}

			try {
				statement.execute(Statements.PlayerMatchInfo.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (player_match_info)", e);
			}

			try {
				statement.execute(Statements.TeamMatchInfo.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (team_match_info)", e);
			}

		} catch (SQLException e) {
			throw new DbException("Error while connecting to database", e);
		} catch (DbException e) {
			throw e;
		}
	}

	public void clearDatabase() throws DbException {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement();) {
			try {
				statement.execute(Statements.Schema.CREATE);
			} catch (SQLException e) {
				throw new DbException("Error while creating Schema", e);
			}

			try {
				statement.execute(Statements.City.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (city)", e);
			}

			try {
				statement.execute(Statements.Stadium.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (stadium)", e);
			}

			try {
				statement.execute(Statements.Coach.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (coach)", e);
			}

			try {
				statement.execute(Statements.Team.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (team)", e);
			}

			try {
				statement.execute(Statements.Player.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (player)", e);
			}

			try {
				statement.execute(Statements.Match.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (match)", e);
			}

			try {
				statement.execute(Statements.Contract.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (contract)", e);
			}

			try {
				statement.execute(Statements.PlayerMatchInfo.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (player_match_info)", e);
			}

			try {
				statement.execute(Statements.TeamMatchInfo.CREATE_TABLE);
			} catch (SQLException e) {
				throw new DbException("Error while creating table (team_match_info)", e);
			}

		} catch (SQLException e) {
			throw new DbException("Error while connecting to database", e);
		} catch (DbException e) {
			throw e;
		}
	}

	public void insertCity(City city) throws DbException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(Statements.City.INSERT_CITY);) {
			statement.setString(1, city.getName());
			statement.execute();

		} catch (SQLException e) {
			throw new DbException("Error while inserting city: " + city.toString(), e);
		}
	}

	public void insertStadium(Stadium stadium) throws DbException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(Statements.Stadium.INSERT_STADIUM);) {
			statement.setString(1, stadium.getName());
			statement.setInt(2, stadium.getCapacity());
			statement.setString(3, stadium.getCity().getName());
			statement.execute();

		} catch (SQLException e) {
			throw new DbException("Error while inserting stadium: " + stadium.toString(), e);
		}
	}

	public void insertCoach(Coach coach) throws DbException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(Statements.Coach.INSERT_COACH);) {
			statement.setInt(1, coach.getId());
			statement.setString(2, coach.getName());
			statement.execute();

		} catch (SQLException e) {
			throw new DbException("Error while inserting coach: " + coach.toString(), e);
		}
	}

}