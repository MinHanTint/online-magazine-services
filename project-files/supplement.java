/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 supplement class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : supplement.java
Purpose: A class to crate supplement which is associated to customer and magazine class.
Assumption: 
 */
package assign1q2;
import java.util.*; //import all java classes

public class supplement {
    private String name;
    private double cost;
    
    public supplement() //default constructor 
    {
        name="style";
        cost=8;
    }
    
    public supplement(String n, double c)//constructor with 2 parameters
    {
        name=n;
        cost=c;
    }
    
    public void setName(String n)//function to set supplement name
    {
        name = n;
    }
    
    public void setCost(double c)//function to set supplement cost
    {
        cost = c;
    }
    
    public String getName()//function to get supplement name
    {
        return name;
    }
    
    public double getCost()//function to get supplement cost
    {
        return cost;
    }
    
    public String toString()//function to get string with supplement name and cost
    {
        return ("Supplement name : " + name + "\n" + "Supplement cost : $" + cost);
    }
}
