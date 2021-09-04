package com.project.my.homeworks.hw2.api;

public class GameConstants {
	public static final int NUMBER_OF_SOLDIERS = 15;
	public static final int MAX_RANGE_OF_SCORE = 10;
	public static final int MAX_NUMBER_OF_BULLETS = 4;
	public static final int MAX_RANK_SCORE = 28;
	public static final double TEST_THRESHOLD = 60;

	public enum Rank {
		Corporal, Sergeant, Lieutenant;

		public Rank next() {
			return this == Corporal ? Sergeant : Lieutenant;
		}

		public Rank previous() {
			return this == Lieutenant ? Sergeant : Corporal;
		}
	}
}
