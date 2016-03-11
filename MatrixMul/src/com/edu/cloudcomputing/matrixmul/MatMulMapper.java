 /**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: MatMulMapper.java - Mapper class implementing map for Matrix multiplication
  * 
  */
package com.edu.cloudcomputing.matrixmul;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MatMulMapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable inKey, Text inValue, Context context) {

		Configuration configuration = context.getConfiguration();
		int rows = Integer.parseInt(configuration.get("a"));
		int cols = Integer.parseInt(configuration.get("c"));

		String line = inValue.toString();
		String[] splits = line.split(",");

		Text outKey = new Text();
		Text outValue = new Text();
		try {
			if ("A".equalsIgnoreCase(splits[0])) {
				for (int i = 0; i < cols; i++) {
					outKey.set(splits[1] + "," + i);
					outValue.set("A," + splits[2] + "," + splits[3]);
					context.write(outKey, outValue);
				}
			} else {
				for (int i = 0; i < rows; i++) {
					outKey.set(i + "," + splits[2]);
					outValue.set("B," + splits[1] + "," + splits[3]);
					context.write(outKey, outValue);
				}
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Exception occured in Mapper" + e);
		}

	}

}
