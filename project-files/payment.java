/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 payment class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : payment.java
Purpose: A class which is composition to paying customer class as it is used by paying customer to make payment.
Assumption: 
 */
package assign1q2;
import java.util.*; //import all java classes

public class payment {
    private String type;
    private String bank;
    
    public payment() //default constructor
    {
        type = "none";
        bank = "DBS";
    }
    
    public payment(String t, String b)//constructor with 2 parameters
    {
        type = t;
        bank = b;
    }
    
    public void setType(String t)//function to set payment type with 1 parameter
    {
        type = t;
    }
    
    public void setBank(String b)//function to set bank name with 1 parameter
    {
        bank = b;
    }
    
    public String getType()//function to get payment type
    {
        return type;
    }
    
    public String getBank()//function to get bank name
    {
        return bank;
    }
    
    public String toString()//function to get string for payment type and bank name
    {
        return ("Payment type: " +type+ " Name of Bank: " +bank);
    }
}
