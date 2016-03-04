/**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: SMAReducer.java - Reducer class implementing reduce to calculate Simple Moving Average
  * 
  */
package com.edu.cloudcomputing.sma;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.hadoop.io.Text;

import com.edu.cloudcomputing.utils.SMAUtil;
import com.edu.cloudcomputing.utils.Time_Series;

public class SMAReducer extends org.apache.hadoop.mapreduce.Reducer<Text, Time_Series, Text, Text>{
	private static double sum;
	private static Queue<Double> window = null;
	private static DecimalFormat df = new DecimalFormat("#.##");
	private static int period = SMAUtil.getWindowSize();

	public void reduce(Text key, Iterable<Time_Series> values, Context context)
			throws IOException, InterruptedException {
		PriorityQueue<Time_Series> queue = new PriorityQueue<Time_Series>();
		
		Time_Series timeseries = null;
		for(Time_Series series : values){
			timeseries = Time_Series.copy(series);
			queue.add(timeseries);
		}
		sum=0;
		double sma=0;
		 window = new LinkedList<Double>();
		Text value = null;
		while(!queue.isEmpty()){
			timeseries = queue.poll();
			addnxtNum(timeseries.getValue());
			if (window.size() == period) {
				sma = Double.parseDouble(df.format(sum / period));
				value = new Text("" + timeseries.getDate() + "," + sma);
				context.write(key, value);
			}
		}
	}

	/**
	 * Method to maintain the window size to calculate SMA
	 * @param nxtNum
	 */
	private static void addnxtNum(double nxtNum) {
		sum += nxtNum;
		window.add(nxtNum);
		if (window.size() > period) {
			sum -= window.remove();
		}
	}

}
