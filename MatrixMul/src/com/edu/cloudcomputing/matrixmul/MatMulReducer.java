/**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: MatMulReducer.java - Reducer class implementing reduce for Matrix multiplication
  * 
  */
package com.edu.cloudcomputing.matrixmul;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MatMulReducer extends Reducer<Text, Text, Text, Text> {
	private static DecimalFormat df = new DecimalFormat("#.#");
	
	public void reduce(Text key, Iterable<Text> values, Context context) {

		Map<Integer, Float> matrixA = new HashMap<Integer, Float>();
		Map<Integer, Float> matrixB = new HashMap<Integer, Float>();
		String[] splitval;
		String val;
		for (Text entry : values) {
			val = entry.toString();
			splitval = val.split(",");
			if ("A".equalsIgnoreCase(splitval[0])) {
				matrixA.put(Integer.parseInt(splitval[1]), Float.parseFloat(splitval[2]));
			} else {
				matrixB.put(Integer.parseInt(splitval[1]), Float.parseFloat(splitval[2]));
			}
		}
		int resMul = Integer.parseInt(context.getConfiguration().get("resMul"));
		float res = 0.0f;
		float matRowA = 0.0f;
		float matColB = 0.0f;
		Text result = null;
		for (int i = 0; i < resMul; i++) {
			matRowA = 0.0f;
			matColB = 0.0f;
			if (matrixA.containsKey(i)) {
				matRowA = matrixA.get(i);
			}
			if (matrixB.containsKey(i)) {
				matColB = matrixB.get(i);
			}
			res += matRowA * matColB;
		}
		result = new Text(key.toString() + "," + df.format(res));
		try {
			context.write(null, result);
		} catch (IOException | InterruptedException e) {
			System.out.println("Exception occured in Reducer" + e);
		} 
	}

}
