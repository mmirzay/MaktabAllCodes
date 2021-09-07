package com.project.my.homeworks.hw5.optional;

import java.util.Scanner;

import com.project.my.homeworks.hw5.optional.api.TripMethod;
import com.project.my.homeworks.hw5.optional.api.TripSituation;
import com.project.my.homeworks.hw5.optional.entities.OnlineTaxi;
import com.project.my.homeworks.hw5.optional.entities.TripParameters;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter source area [0-4] >> ");
		int source = input.nextInt();
		System.out.print("Enter destination area [0-4] >> ");
		int destination = input.nextInt();
		System.out.print("Select the situation [1-4]: \n" + " 1- Rainy and Peak Time\n" + " 2- Only Rainy\n"
				+ " 3- Only Peak Time\n" + " 4- none of them\n" + " >> ");
		TripSituation tripSituation = TripSituation.None;
		int selectedSituation = input.nextInt();
		switch (selectedSituation) {
		case 1:
			tripSituation = TripSituation.RainyAndPeakTime;
			break;
		case 2:
			tripSituation = TripSituation.Rainy;
			break;
		case 3:
			tripSituation = TripSituation.PeakTime;
		}
		System.out.print("Select Trip Method [1-3]\n" + " 1- Economic\n" + " 2- VIP\n" + " 3- Bike\n" + " >> ");
		TripMethod tripMethod = null;
		int selectedTripMethod = input.nextInt();
		switch (selectedTripMethod) {
		case 1:
			tripMethod = TripMethod.Economic;
			break;
		case 2:
			tripMethod = TripMethod.Vip;
			break;
		case 3:
			tripMethod = TripMethod.Bike;
		}
		TripParameters tripParameters = new TripParameters(source, destination, tripSituation);
		OnlineTaxi onlineTaxi = new OnlineTaxi(tripMethod, tripParameters);
		System.out.printf("Price is %d.", onlineTaxi.getPrice());
		input.close();
	}
}
