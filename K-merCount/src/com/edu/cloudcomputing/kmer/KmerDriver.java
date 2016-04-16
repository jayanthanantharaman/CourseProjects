/**
 * Name: Jayanth Anantharaman
 * UID: U00807894
 * Email: anantharaman.2@wright.edu
 * Class: CEG-7380 Cloud Computing
 * 
 * Instructor - Dr.Junjie Zhang 
 * 
 * File: KmerDriver.java  Driver class to schedule TopN K-mers job
 * 
 */
package com.edu.cloudcomputing.kmer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * @author Jayanth
 *
 */
public class KmerDriver {
	private static final String PATH = "path";
	private static final String PROPERTIES = "application.properties";
	private static Properties prop=null;
	private static final String KMER_VALUE = "kmer.value";
	private static final String TOPN_VALUE = "topN.value";
	
	
	public static void main(String[] args) {
		loadPropertyFile();
		Configuration configuration = new Configuration();
		configuration.set(KMER_VALUE, getPropertyValue(KMER_VALUE));
		configuration.set(TOPN_VALUE, getPropertyValue(TOPN_VALUE));
		String path = getPropertyValue(PATH);
		String otherArgs[];
		
		try {
			otherArgs = new GenericOptionsParser(configuration, args).getRemainingArgs();
			Job job =new Job(configuration, "TopN Kmers");
			job.setJarByClass(KmerDriver.class);
			job.setMapOutputKeyClass(Text.class); 
			job.setMapOutputValueClass(IntWritable.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			job.setMapperClass(KmerMapper.class); 
			job.setReducerClass(KmerReducer.class);
			
			FileInputFormat.addInputPath(job, new Path(path+ otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(path + otherArgs[1])); 
			System.exit(job.waitForCompletion(true) ? 0 : 1);
			
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		} 
	}
	

    
	
	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	public static void loadPropertyFile() {
		try {
			InputStream input = KmerDriver.class.getClassLoader()
					.getResourceAsStream(PROPERTIES);
			if (prop == null) {
				prop = new Properties();
				prop.load(input);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + PROPERTIES);
		} catch (IOException e) {
			System.out.println("IOException while reading properties "
					+ e.getMessage());
		}

	}

}
