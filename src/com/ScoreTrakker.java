package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ScoreTrakker {
	private ArrayList<Student> studentList;
	private String[] files = { "scores.txt", "badscore.txt", "nofile.txt" };

	public ScoreTrakker() {
		studentList = new ArrayList<Student>();
	}

	private void loadDataFromFile(String fileName) {
		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: " + fileName);
			System.exit(0);
		}
		Scanner scanner = new Scanner(in);
		while (scanner.hasNextLine()) {
			int tempScore = 0;
			String tempName = "";
			String tempScoreString = "";

			tempName = scanner.nextLine();
			tempScoreString = scanner.nextLine();
			try {
				tempScore = Integer.parseInt(tempScoreString);
				studentList.add(new Student(tempName, tempScore));
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + tempName + ": not a valid score: " + tempScoreString);
			}

		}
		scanner.close();

	}

	private void printInOrder() {
		Collections.sort(studentList);
		System.out.println("Student Score List:");
		studentList.forEach((k) -> System.out.println(k.toString()));
	}

	private void processFiles() {
		for (String s : files) {
			loadDataFromFile(s);
			printInOrder();
			System.out.println();
			studentList.clear();
		}
	}

	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
