package edu.handong.csee.java.lab09; //The file is in this package

import java.util.Scanner; //I will use Scanner method
import java.util.ArrayList;
/**
 * This class have Three method :getData, computeStats, displayResults
 * help getting data, compute data of highestSales and averageSales
 * Print Result
 */
public class SalesReporter { //declare public type class

	public double highestSales=0; //declare member variable public double type
	public double averageSales=0; //declare member variable public double type
	ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>();
	SalesAssociate highest =new SalesAssociate(); // for saving highest instance
	Scanner mykeyboard = new Scanner(System.in); //make instance of Scanner

	/**
	 * setting data of salesman
	 */
	public void getData() //declare public type method
	{
		/*System.out.println("Enter number of sales associates:"); //print the sentence
		this.numberOfAssociate=mykeyboard.nextInt(); //scan one Integer from user*/
		/*this.team = new SalesAssociate[length]; //define the Arrays length*/
		boolean done = false;
		while(!done)
		{
			SalesAssociate tempotaryTeam = new SalesAssociate(); //declare member variable private SalesAssociate type, because of tempotary saving*/
			/*team[i] = new SalesAssociate(); //make instance of SalesAssociate*/
			System.out.print("Enter name of sales associate: "); //print sentence
			tempotaryTeam.setName(mykeyboard.nextLine());//scan one line from user
			System.out.print("Enter associate's sales: $"); //print sentence
			tempotaryTeam.setSales(mykeyboard.nextDouble()); //scan Double type value
			mykeyboard.nextLine(); //prevent error of scan
			team.add(tempotaryTeam);
			System.out.print ("More items for the list? ");
            String ans = mykeyboard.nextLine ();
            if (!ans.equalsIgnoreCase ("yes"))
                done = true;
		}
	}
	
	/**
	 * compute the data for average and highest value
	 * for this, sorting team Array in regular sequence of Sales
	 */
	public void computeStats() //declare public type method
	{
		for(SalesAssociate temporaryTeam1 : team)
		{
			this.averageSales += temporaryTeam1.getSales(); //plus teamporaryTeam.getSales() value to averageSales
			if(temporaryTeam1.getSales()>highestSales)
			{
				highestSales = temporaryTeam1.getSales();
				highest = temporaryTeam1;
			}
		}
		this.averageSales /= team.size(); //calculate average of Sales
	}
		
	
	/**
	 * print data of salesman and
	 * display Results after computing
	 */
	public void displayResults() //declare public type method
	{
		System.out.println("\nAverage sales per associate is $"+ this.averageSales); //print sentence
		System.out.println("The hightest sales figure is $" + this.highestSales); //print sentence
		System.out.println("\nThe following had the hightest sales:"); //print this sentence
		System.out.println("Name: "+highest.getName()); //print sentence
		System.out.println("Sales: $" + highest.getSales()); //print sentence
		if(highest.getSales()-this.averageSales>0) //if highest.getSales() is bigger than averageSales
			System.out.println("$" + (highest.getSales()-this.averageSales) +" above the arverge."); //print sentence
		else if(highest.getSales()-this.averageSales<0) //if highest.getSales() is smaller than averageSales
			System.out.println("$" + (this.averageSales-highest.getSales()) +" below the arverge."); //print sentence
		else //else,
			System.out.println("The sale equal the averge."); //print this sentence
		System.out.println("\nThe rest performed as follows:"); //print this sentence
		for(SalesAssociate temporaryTeam1 : team) //repeat times of numberOfAssociate value
		{
			if(temporaryTeam1.getSales() == highestSales)
				continue;
			System.out.println("Name: "+temporaryTeam1.getName()); //print sentence
			System.out.println("Sales: $" + temporaryTeam1.getSales()); //print sentence
			if(temporaryTeam1.getSales()-this.averageSales>0) //if temporaryTeam1.getSales() is bigger than averageSales
				System.out.println("$" + (temporaryTeam1.getSales()-this.averageSales) +" above the arverge."); //print sentence
			else if(temporaryTeam1.getSales()-this.averageSales<0) //if temporaryTeam1.getSales() is smaller than averageSales
				System.out.println("$" + (this.averageSales-temporaryTeam1.getSales()) +" below the arverge."); //print sentence
			else //else,
				System.out.println("The sale equal the averge."); //print this sentence
		}
	}
}
