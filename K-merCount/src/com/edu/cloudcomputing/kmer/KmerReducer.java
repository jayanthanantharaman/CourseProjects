/**
 * Name: Jayanth Anantharaman
 * UID: U00807894
 * Email: anantharaman.2@wright.edu
 * Class: CEG-7380 Cloud Computing
 * 
 * Instructor - Dr.Junjie Zhang 
 * 
 * File: KmerReducer.java Reducer class implementing reduce for TopN K-mers
 * 
 */
package com.edu.cloudcomputing.kmer;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author Jayanth
 * 
 */
public class KmerReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	private static TreeMap<Integer, Text> topNKmers = new TreeMap<Integer, Text>();
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int topNvalue = Integer.parseInt(context.getConfiguration().get("topN.value"));
		int sum = 0;
		for (IntWritable value : values) {
			sum += value.get();
		}
		topNKmers.put(new Integer(sum), new Text(key));
		if (topNKmers.size() > topNvalue) {
			topNKmers.remove(topNKmers.firstKey());
		}
	}

	@Override
	protected void cleanup(Context context) {
		
		try {
			for (Integer treeKey : topNKmers.descendingKeySet()) {
				context.write(topNKmers.get(treeKey), new IntWritable(treeKey));
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Exception occured in Reducer" + e);
		}
	}
}
