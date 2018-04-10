package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {

	public double highestSales;
	public double averageSales=0;
	private SalesAssociate[] team;
	private int numberOfAssociate;
	Scanner mykeyboard = new Scanner(System.in);

	public void getData()
	{
		System.out.println("Enter number of sales associates:");
		this.numberOfAssociate=mykeyboard.nextInt();
		this.team = new SalesAssociate[numberOfAssociate];
		for(int i = 0; i <this.numberOfAssociate;i++)
		{
			mykeyboard.nextLine();
			team[i] = new SalesAssociate();
			System.out.printf("Enter data for associate number %d\n",i+1);
			System.out.print("Enter name of sales associate: ");
			team[i].mName = mykeyboard.nextLine();
			System.out.print("Enter associate's sales: $");
			team[i].mSales= mykeyboard.nextDouble();
		}
	}
	
	public void computeStats()
	{
		SalesAssociate Step;
		this.highestSales = team[0].mSales;
		for(int i =0 ;i<this.numberOfAssociate;i++)
		{
			this.averageSales += team[i].mSales;
			for(int j = 0; j<i ;j++)
			{
				if(team[j].mSales<team[i].mSales)
				{
					Step =team[j];
					team[j]=team[i];
					team[i]=Step;
				}
			}
		}
		this.averageSales /= this.numberOfAssociate;
		this.highestSales = team[0].mSales;
	}
	public void displayResults()
	{
		System.out.println("\nAverage sales per associate is $"+ this.averageSales);
		System.out.println("The hightest sales figure is $" + this.highestSales);
		
		for(int i =0;i<this.numberOfAssociate;i++)
		{
			if(i==0)
				System.out.println("\nThe following had the hightest sales:");
			if(i==1)
				System.out.println("\nThe rest performed as follows:");
			System.out.println("Name: "+team[i].mName);
			System.out.println("Sales: $" + team[i].mSales);
			if(team[i].mSales-this.averageSales>0)
				System.out.println("$" + (team[i].mSales-this.averageSales) +" above the arverge.");
			else if(team[i].mSales-this.averageSales<0)
				System.out.println("$" + (this.averageSales-team[i].mSales) +" below the arverge.");
			else
				System.out.println("The sale equal the averge.");
		}

	}
}
