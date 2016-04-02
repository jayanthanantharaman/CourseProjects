/**
 * Name: Jayanth Anantharaman
 * UID: U00807894
 * Email: anantharaman.2@wright.edu
 * Class: CEG-7380 Cloud Computing
 * 
 * Instructor - Dr.Junjie Zhang 
 * 
 * File: CFReducer.java Reducer class implementing reduce for Common Friends
 * 
 */
package com.edu.cloudcomputing.cf;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author Jayanth
 *
 */
public class CFReducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterable<Text> values, Context context) {
		
		String[] splits;
		String friends;
		Set<String> friendsSet = new HashSet<String>();
		StringBuilder commonFriends = new StringBuilder("[");
		for(Text entry : values){
			friends = entry.toString();
			splits = friends.split(" ");
			for(String frnd:splits){
				if(friendsSet.contains(frnd)){
					commonFriends.append(frnd).append(" ");
				}else{
					friendsSet.add(frnd);
				}
			}
		}
		if(commonFriends.length()>1){
			commonFriends.deleteCharAt(commonFriends.length()-1);
		}
		commonFriends.append("]");
		Text result = new Text(commonFriends.toString());
		try {
			context.write(key, result);
		} catch (IOException | InterruptedException e) {
			System.out.println("Exception occured in Reducer" + e);
		}
	}
}
