package com;

public class Student implements Comparable<Student> {

	private String name;
	private int score;

	public Student() {
		name = "";
		score = 0;
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}

	@Override
	public String toString() {
		return name + " " + score;
	}

}
