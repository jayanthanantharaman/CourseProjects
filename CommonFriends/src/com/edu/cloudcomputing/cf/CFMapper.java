/**
 * Name: Jayanth Anantharaman
 * UID: U00807894
 * Email: anantharaman.2@wright.edu
 * Class: CEG-7380 Cloud Computing
 * 
 * Instructor - Dr.Junjie Zhang 
 * 
 * File: CFMapper.java Mapper class implementing map for Common Friends
 * 
 */
package com.edu.cloudcomputing.cf;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author Jayanth
 *
 */
public class CFMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	public void map(LongWritable inKey, Text inValue, Context context) {
		
		String line = inValue.toString();
		String[] splits = line.split(",");
		String user = splits[0];
		String friends = splits[1];

		int userInt = Integer.parseInt(user);
		int friendInt = 0;
		splits = friends.split(" ");
		
		Text outKey = null;
		Text outValue = new Text(friends);
		for(String s:splits){
			friendInt = Integer.parseInt(s);
			if(friendInt < userInt){
				outKey = new Text(""+friendInt+","+""+userInt);
			}else{
				outKey = new Text(""+userInt+","+""+friendInt);
			}
			try {
				context.write(outKey, outValue);
			} catch (IOException | InterruptedException e) {
				System.out.println("Exception occured in Mapper" + e);
			}
		}
	}

}
