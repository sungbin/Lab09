package edu.handong.csee.java.lab09; //The file is in this package

import java.util.Scanner; //I will use Scanner method
import java.util.ArrayList; //including ArrayList method
/**
 * This class have Three method :getData, computeStats, displayResults
 * help getting data, compute data of highestSales and averageSales
 * Print Result
 */
public class SalesReporter { //declare public type class

	public double highestSales=0; //declare member variable public double type
	public double averageSales=0; //declare member variable public double type
	ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>(); //make SalesAssociate type ArrayList instance, naming team
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
		boolean done = false; //declare boolean type, value is false
		while(!done) // if done is ture, loop 
		{
			SalesAssociate tempotaryTeam = new SalesAssociate(); //declare member variable private SalesAssociate type, because of tempotary saving*/
			System.out.print("Enter name of sales associate: "); //print sentence
			tempotaryTeam.setName(mykeyboard.nextLine());//scan one line from user
			System.out.print("Enter associate's sales: $"); //print sentence
			tempotaryTeam.setSales(mykeyboard.nextDouble()); //scan Double type value
			mykeyboard.nextLine(); //prevent error of scan
			team.add(tempotaryTeam);//add tempotaryTeam to team arraylist
			System.out.print ("More items for the list? "); //print sentence
            String ans = mykeyboard.nextLine (); //declare string type, ans
            if (!ans.equalsIgnoreCase ("yes")) //if ans is not equal yes
                done = true; // put true to done
		}
	}
	
	/**
	 * compute the data for average and highest value
	 * for this, sorting team Array in regular sequence of Sales
	 */
	public void computeStats() //declare public type method
	{
		for(SalesAssociate temporaryTeam1 : team) //put team arraylist first index temporaryTeam1, and repeat, while temporaryTeam1 index plus 1
		{
			this.averageSales += temporaryTeam1.getSales(); //plus teamporaryTeam.getSales() value to averageSales
			if(temporaryTeam1.getSales()>highestSales) //if highestSales value bigger than temporaryTeam1's mSales
			{
				highestSales = temporaryTeam1.getSales(); //put the value to highestSales
				highest = temporaryTeam1; //put temporaryTeam1 to highest
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
		for(SalesAssociate temporaryTeam1 : team) //put team arraylist first index temporaryTeam1, and repeat, while temporaryTeam1 index plus 1
		{
			if(temporaryTeam1.getSales() == highestSales) //if highestSales value equal temporaryTeam1's mSales
				continue;//ignore one repeat under
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
