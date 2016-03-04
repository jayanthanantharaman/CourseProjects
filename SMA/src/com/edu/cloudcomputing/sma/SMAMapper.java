 /**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: SMAMapper.java - Mapper class implementing map to calculate Simple Moving Average
  * 
  */
package com.edu.cloudcomputing.sma;

import java.io.IOException;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.edu.cloudcomputing.utils.Date_Util;
import com.edu.cloudcomputing.utils.Time_Series;

public class SMAMapper extends Mapper<LongWritable, Text, Text, Time_Series> {

	private Text compName = new Text();
	private Time_Series timeSeries = new Time_Series();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		if(line!=null && line.length()>0){
			String[] splitStr = line.split(",");
			compName.set(splitStr[0]);
			Date date = Date_Util.getDate(splitStr[1]);
			long timeStamp = date.getTime(); 
			double price = Double.parseDouble(splitStr[2]);
			timeSeries.set(timeStamp, price);
			context.write(compName, timeSeries);
		}
	}
}
