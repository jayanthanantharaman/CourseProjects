/**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: SimpleMovingAverage.java - SMA implementation for single host
  */

package com.edu.cloudcomputing.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

public class SimpleMovingAverage {
	private static Queue<Double> window = new LinkedList<Double>();
    private static double sum;
    private static int count; 
    private static DecimalFormat df = new DecimalFormat("#.##");
    private static final String PROPERTIES = "application.properties";
    private static final String WINDOW_SIZE = "windowsize";

    
    /**
     * Method to maintain the window size and calculate SMA 
     * @param nxtnum
     * @param period
     */
    public void addnxtNum(double nxtnum,int period) {
    	sum+=nxtnum;
    	window.add(nxtnum);
    	if(window.size() > period){
    		sum -= window.remove();
    	}
    	if(window.size() == period){
    		System.out.println("SMA#"+ ++count +" "+df.format(getSMA()));
    	}
    }

    /**
     * Method to calculate SMA
     * @return double
     */
    public static double getSMA() {
        if (window.isEmpty()) return 0; 
        return sum / window.size();
    }
    
    /**
     * Method to retrieve Window Size from properties file
     * @return List<Integer>
     */
    private static List<Integer> getWindowSizes(){
    	Properties prop = new Properties();
    	List<Integer> windowSizes = new ArrayList<Integer>(); 
    	try {
			InputStream input = SimpleMovingAverage.class.getClassLoader().getResourceAsStream(PROPERTIES);
			prop.load(input);
			String windowSize = prop.getProperty(WINDOW_SIZE);
			String[] splits = windowSize.split(",");
			for(String split:splits){
				windowSizes.add(Integer.parseInt(split));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + PROPERTIES);
		} catch (IOException e) {
			System.out.println("IOException while reading properties " + e.getMessage());
		}
    	return windowSizes;
    }

    public static void main(String[] args) {
        double[] data = {11.30,12.40,19.00,22.2,23.5,28.00,27.00};
        List<Integer> windowSizes = getWindowSizes();
        SimpleMovingAverage sma = new SimpleMovingAverage();
        for (int windowSize : windowSizes) {
        	sum=0;
        	count=0;
        	window = new LinkedList<Double>();
        	System.out.println("SMA for window Size " + windowSize);
            for (double nxtnum : data) {
            	sma.addnxtNum(nxtnum,windowSize);
            }
        }
    }
}
