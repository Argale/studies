package com.epam.CitiesGame;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CitiesFiller {
	private static final String FILE_TYPE=".txt";
	public static HashSet<String> fillCities(String filename){
		HashSet<String> result=new HashSet<String>();
		String loader;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename + FILE_TYPE));
			while ((loader = in.readLine()) != null) {
				result.add(loader);
			}
			in.close();

		} catch (IOException e) {
			System.err.println("IO error");
		}
		return result;
	}

}
