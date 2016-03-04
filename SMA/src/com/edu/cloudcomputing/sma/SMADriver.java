 /**
  * Name: Jayanth Anantharaman
  * UID: U00807894
  * Email: anantharaman.2@wright.edu
  * Class: CEG-7380 Cloud Computing
  * 
  * Instructor - Dr.Junjie Zhang 
  * 
  * File: SMADriver.java - Driver class to schedule job
  * 
  */
package com.edu.cloudcomputing.sma;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import com.edu.cloudcomputing.utils.SMAUtil;
import com.edu.cloudcomputing.utils.Time_Series;

public class SMADriver {

	
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		String[] otherArgs;
		String path = SMAUtil.getInputOutputPath();
		try {
			otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
			Job job = new Job(conf, "Simple Moving Average");
			job.setJarByClass(SMADriver.class); 
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Time_Series.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			job.setMapperClass(SMAMapper.class);
			job.setReducerClass(SMAReducer.class);
			
			FileInputFormat.addInputPath(job, new Path(path+ otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(path + otherArgs[1])); 
			
			System.exit(job.waitForCompletion(true) ? 0 : 1);
		} catch (Exception e) {
			System.out.println("IOException occured " + e.getMessage());
		}
		
	}
}
