/**
 * Name: Jayanth Anantharaman
 * UID: U00807894
 * Email: anantharaman.2@wright.edu
 * Class: CEG-7380 Cloud Computing
 * 
 * Instructor - Dr.Junjie Zhang 
 * 
 * File: MatMulDriver.java - Driver class to schedule Matrix multiplication job
 * 
 */
package com.edu.cloudcomputing.matrixmul;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MatMulDriver {
	private static final String PROPERTIES = "application.properties";
	private static final String MATRIXA_ROWS = "martixA.rows";
	private static final String MATRIXA_COLS = "matrixA.cols";
	private static final String MATRIXB_COLS = "matrixB.cols";
	private static final String PATH = "path";
	private static Properties prop;

	public static void main(String[] args) {
		loadPropertyFile();
		Configuration configuration = new Configuration();
		configuration.set("a", getPropertyValue(MATRIXA_ROWS));
		configuration.set("c", getPropertyValue(MATRIXB_COLS));
		configuration.set("resMul", getPropertyValue(MATRIXA_COLS));
		String otherArgs[];
		String path = getPropertyValue(PATH);
		try {
			otherArgs = new GenericOptionsParser(configuration, args).getRemainingArgs();
			Job job =new Job(configuration, "Matrix Multiplication");
			job.setJarByClass(MatMulDriver.class);
			job.setMapOutputKeyClass(Text.class); 
			job.setMapOutputValueClass(Text.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			job.setMapperClass(MatMulMapper.class); 
			job.setReducerClass(MatMulReducer.class); 
			
			
			FileInputFormat.addInputPath(job, new Path(path+ otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(path + otherArgs[1])); 
			System.exit(job.waitForCompletion(true) ? 0 : 1);
			
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		} 
	}

	private static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	
	private static void loadPropertyFile() {
		try {
			InputStream input = MatMulDriver.class.getClassLoader().getResourceAsStream(PROPERTIES);
			if(prop==null){
				prop = new Properties();
				prop.load(input);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + PROPERTIES);
		} catch (IOException e) {
			System.out.println("IOException while reading properties " + e.getMessage());
		}
	}
	

}
