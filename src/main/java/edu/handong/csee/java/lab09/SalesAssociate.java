package edu.handong.csee.java.lab09; //The file is in this package

/**
 * The class have getter and setter of Name, Sale member variable
 */
public class SalesAssociate { //declare public type SalesAssociate class
	public String mName; //declare member variable
	public double mSales; //declare member variable
	
	SalesAssociate(String name, double sales){
		mName = name;
		sales = mSales;
	}
	SalesAssociate(){
		mName = "";
		mSales = 0;
	}
	SalesAssociate(String name){
		mName = name;;
	}
	SalesAssociate(double sales){
		sales = mSales;
	}
	
	/**
	 * getter of mName
	 */
	public String getName() { //declare public type, return type: String
		return mName; //return mName value
	}
	
	/**
	 * setter of mName
	 */
	public void setName(String name) { //declare public type, parameter type :String
		this.mName = name; //put name value to mName
	}
	
	/**
	 * getter of mSales
	 */
	public double getSales() { //declare public type, return type: double
		return mSales; //return mSales value
	}
	
	/**
	 * setter of mSales
	 */
	public void setSales(double sales) { //declare public type, parameter type: double
		this.mSales = sales; //put sales value to mSales
	}
}