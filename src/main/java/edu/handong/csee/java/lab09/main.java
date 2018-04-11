package edu.handong.csee.java.lab09; //The file is in this package

/**
 * This main class call getData, computeStats, displayResults method in SalesReporter class
 * need SalesReporter class
 */
public class main { //declare main class public type

	/**
	 * this is main method
	 */
	public static void main(String[] args) { //main method
		SalesReporter mysale = new SalesReporter(); //make mysale instance of salesReporter
		mysale.getData(); //call getDate method
		mysale.computeStats(); //call computeStats method
		mysale.displayResults(); //call displayResults method

	}	
}