package com.project.my.homeworks.hw14.forfun.school;

/**
 * @author MoMi
 *
 */
public class School {
	private String name;
	private int degree; // 1 or 2 or 3

	public School(String name, int degree) {
		this.name = name;
		this.degree = degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	@Override
	public String toString() {
		return name +" with degree "+ degree;
	}
}
