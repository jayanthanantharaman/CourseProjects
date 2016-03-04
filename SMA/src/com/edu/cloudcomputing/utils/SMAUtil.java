/**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: SMAUtil.java - Utility class to retrieve configurable properties
  * 
  */

package com.edu.cloudcomputing.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.edu.cloudcomputing.sma.SMAReducer;

public class SMAUtil {

	private static final String PROPERTIES = "application.properties";
	private static final String WINDOW_SIZE = "windowsize";
	private static final String PATH = "path";

	/**
	 * Method to retrieve window size from properties file
	 * @return int
	 */
	public static int getWindowSize() {
		Properties prop = new Properties();
		int period = 0;
		try {
			InputStream input = SMAReducer.class.getClassLoader()
					.getResourceAsStream(PROPERTIES);
			prop.load(input);
			String windowSize = prop.getProperty(WINDOW_SIZE);
			period = Integer.parseInt(windowSize);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + PROPERTIES);
		} catch (IOException e) {
			System.out.println("IOException while reading properties "
					+ e.getMessage());
		}
		return period;
	}

	/**
	 * Method to retrieve hadoop localpath from properties
	 * @return String 
	 */
	public static String getInputOutputPath() {
		Properties prop = new Properties();
		String path=null;
		try {
			InputStream input = SMAReducer.class.getClassLoader()
					.getResourceAsStream(PROPERTIES);
			prop.load(input);
			path = prop.getProperty(PATH);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + PROPERTIES);
		} catch (IOException e) {
			System.out.println("IOException while reading properties "
					+ e.getMessage());
		}
		return path;
	}

}
