/**
 * Name: Jayanth Anantharaman
 * UID: U00807894
 * Email: anantharaman.2@wright.edu
 * Class: CEG-7380 Cloud Computing
 * 
 * Instructor - Dr.Junjie Zhang 
 * 
 * File: KmerMapper.java Mapper class implementing map for TopN K-mers
 * 
 */
package com.edu.cloudcomputing.kmer;

/**
 * @author Jayanth
 *
 */
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KmerMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private static IntWritable ONE = new IntWritable(1);
	private static String kmer = "";
	private static int kmerValue =0;

	public void map(LongWritable inKey, Text inValue, Context context) {
		kmerValue = Integer.parseInt(context.getConfiguration().get("kmer.value"));;
		String sequence = inValue.toString();
		Text outkey = null;
		sequence = kmer + sequence;
		for (int i = 0; i < sequence.length(); i++) {
			kmer = getKmer(sequence, i);
			if (kmer.length() == kmerValue) {
				outkey = new Text(kmer);
				try {
					context.write(outkey, ONE);
				} catch (IOException | InterruptedException e) {
					System.out.println("Exception occured in Mapper" + e);
				}
			}else{
				break;
			}
		}
	}
	
	/**
	 * Method to extract k-mers from sequence
	 * @param sequence
	 * @param startIndex
	 * @return
	 */
	private static String getKmer(String sequence, int startIndex) {
		String kmer = null;
		int strLen = startIndex + kmerValue ;
 		if (!(strLen > sequence.length())) {
			kmer = sequence.substring(startIndex, strLen);
		}else {
			kmer = sequence.substring(startIndex);
		}
		return kmer;
	}

}
