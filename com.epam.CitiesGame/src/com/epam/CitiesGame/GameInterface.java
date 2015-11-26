package com.epam.CitiesGame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class GameInterface {
	private static final String FILENAME = "cities";
	private HashSet<String> citiesPool = new HashSet<>();
	private char lastKey = 'М';
	private String word;
	private boolean winFlag = false;

	public static void main(String[] args) {
		GameInterface app = new GameInterface();
		app.functioning();
	}

	public void functioning() {
		fillPool();
		Scanner scan = new Scanner(System.in);
		while (!winFlag) {
			computerWord();
			if(winFlag)break;
			boolean temp = false;
			while (!temp) {
				temp = userWord(scan.nextLine());
			}
		}
		scan.close();
		System.out.println("У меня кончились города, ты победил!");
	}

	public void fillPool() {
		citiesPool = CitiesFiller.fillCities(FILENAME);
	}

	public boolean userWord(String city) {
		if (citiesPool.contains(city) && (city.charAt(0) == lastKey)) {
			lastKey = city.toUpperCase().charAt(city.length() - 1);
			citiesPool.remove(city);
			return true;
		} else {
			System.out.println("Не подходит");
			return false;
		}
	}

	public void computerWord() {
		Iterator<String> iter = citiesPool.iterator();
		boolean temp = false;
		while (!temp) {
			if (iter.hasNext()) {
				word = iter.next();
				if (word.charAt(0) == lastKey) {
					System.out.println(word + "!");
					lastKey = word.toUpperCase().charAt(word.length() - 1);
					iter.remove();
					temp = true;
				}
			} else {
				temp = true;
				winFlag = true;
			}
		}
	}
}
