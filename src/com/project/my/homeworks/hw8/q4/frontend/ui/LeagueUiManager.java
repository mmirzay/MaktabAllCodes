package com.project.my.homeworks.hw8.q4.frontend.ui;

import java.util.List;

import com.project.my.homeworks.hw8.q4.backend.entities.TeamLeagueInfo;
import com.project.my.homeworks.hw8.q4.util.Printer;

public class LeagueUiManager {
	public void showMenu() {
		System.out.println("1- show league table");
		System.out.println("2- show highest paid coach");
		System.out.println("3- show 10 highest paid players");
		System.out.println("4- show cities teams number");
	}

	public void showLeageTable(List<TeamLeagueInfo> table) {
		StringBuilder result = new StringBuilder();
		result.append(Printer.formatter("Team", 13));
		result.append(" | ");
		result.append(Printer.formatter("Win"));
		result.append(" | ");
		result.append(Printer.formatter("Draw"));
		result.append(" | ");
		result.append(Printer.formatter("Loss"));
		result.append(" | ");
		result.append(Printer.formatter("SG"));
		result.append(" | ");
		result.append(Printer.formatter("RG"));
		result.append(" | ");
		result.append(Printer.formatter("GD"));
		result.append(" | ");
		result.append(Printer.formatter("Score"));
		result.append(System.lineSeparator());
		result.append("-".repeat(75));
		System.out.println(String.format("%-4s %s", "   ", result.toString()));
		int position = 1;
		for (TeamLeagueInfo teamLeagueInfo : table)
			System.out.println(String.format("%-4s %s", "#" + position++ + "-", teamLeagueInfo.toString()));
		System.out.println("-".repeat(75));
	}

	public void showMostPaidCoach(String highestPaidCoach) {
		Printer.printInfoMessage(highestPaidCoach);
	}

	public void showStringList(List<String> mostPaidPlayersList) {
		int row = 1;
		for (String s : mostPaidPlayersList)
			System.out.println("#" + row++ + " " + s);
	}

}
