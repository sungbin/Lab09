package edu.handong.csee.java.lab09; //The file is in this package

import java.util.Scanner; //I will use Scanner method

/**
 * This class have Three method :getData, computeStats, displayResults
 * help getting data, compute data of highestSales and averageSales
 * Print Result
 */
public class SalesReporter { //declare public type class

	public double highestSales; //declare member variable public double type
	public double averageSales=0; //declare member variable public double type
	private SalesAssociate[] team; //declare member variable private SalesAssociate[] type, because of arrange
	private int numberOfAssociate;  //declare member variable private integer type, because the variable is relative with arrange.
	Scanner mykeyboard = new Scanner(System.in); //make instance of Scanner

	/**
	 * setting data of salesman
	 */
	public void getData() //declare public type method
	{
		System.out.println("Enter number of sales associates:"); //print the sentence
		this.numberOfAssociate=mykeyboard.nextInt(); //scan one Integer from user
		this.team = new SalesAssociate[numberOfAssociate]; //define the Arrays length
		for(int i = 0; i <this.numberOfAssociate;i++) //repeat times of numberOfAssociate value
		{
			mykeyboard.nextLine(); //prevent error of scan
			team[i] = new SalesAssociate(); //make instance of SalesAssociate
			System.out.printf("Enter data for associate number %d\n",i+1); //print sentence
			System.out.print("Enter name of sales associate: "); //print sentence
			team[i].mName = mykeyboard.nextLine(); //scan one line from user
			System.out.print("Enter associate's sales: $"); //print sentence
			team[i].mSales= mykeyboard.nextDouble(); //scan Double type value
		}
	}
	
	/**
	 * compute the data for average and highest value
	 * for this, sorting team Array in regular sequence of Sales
	 */
	public void computeStats() //declare public type method
	{
		SalesAssociate Step; //declare SalesAssociate type variable for swapping
		this.highestSales = team[0].mSales; //put team[0].mSales value to highestSales
		for(int i =0 ;i<this.numberOfAssociate;i++) //repeat times of numberOfAssociate value
		{
			this.averageSales += team[i].mSales; //plus team[i].mSales value to averageSales
			for(int j = 0; j<i ;j++) //repeat times of i;
			{
				if(team[j].mSales<team[i].mSales) //if team[j].mSales is smaller than team[i].mSales
				{
					Step =team[j]; //put team[j] to Step
					team[j]=team[i]; //put team[i] to team[j]
					team[i]=Step; //put Step to team[i]
				}
			}
		}
		this.averageSales /= this.numberOfAssociate; //calculate average of Sales
		this.highestSales = team[0].mSales; //put team[0].mSales to highestSales
	}
	
	/**
	 * print data of salesman and
	 * display Results after computing
	 */
	public void displayResults() //declare public type method
	{
		System.out.println("\nAverage sales per associate is $"+ this.averageSales); //print sentence
		System.out.println("The hightest sales figure is $" + this.highestSales); //print sentence
		
		for(int i =0;i<this.numberOfAssociate;i++) //repeat times of numberOfAssociate value
		{
			if(i==0) //if i equal 0
				System.out.println("\nThe following had the hightest sales:"); //print this sentence
			if(i==1) //if i equal 1
				System.out.println("\nThe rest performed as follows:"); //print this sentence
			System.out.println("Name: "+team[i].mName); //print sentence
			System.out.println("Sales: $" + team[i].mSales); //print sentence
			if(team[i].mSales-this.averageSales>0) //if team[i].mSales is bigger than averageSales
				System.out.println("$" + (team[i].mSales-this.averageSales) +" above the arverge."); //print sentence
			else if(team[i].mSales-this.averageSales<0) //if team[i].mSales is smaller than averageSales
				System.out.println("$" + (this.averageSales-team[i].mSales) +" below the arverge."); //print sentence
			else //else,
				System.out.println("The sale equal the averge."); //print this sentence
		}
	}
}
