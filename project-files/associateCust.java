/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 Associate Customer class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : associateCust.java
Purpose: A child class which extends the parent customer class. Associate customers do not pay the subscription fees by themselves.They are associated with customer who paid for their fees.
Assumption: 
 */
package assign1q2;
import java.util.*; //import all java classes

public class associateCust extends customer { //associate customer class is inherited from customer class
    private String payCustName;
    
    public associateCust() //default constructor
    {
        super();
        payCustName = "abc";
    }
    
    public associateCust(String n, String e)//constructor with 2 parameters
    {
        super(n, e);
}
    
    public associateCust(String n, String e, String pcn)//construtor with 3 parameters
    {
        super(n, e);
        payCustName = pcn;
    }
    
    public associateCust(String n, String e, String pcn, supplement s)//constructor with 4 parameters
    {
        super(n, e, s);
        payCustName = pcn;
    }
    
    public void setAssoCust(String n, String e, String pcn) //function to set associate customer with 3 parameters
    {
        super.setCust(n, e);
        payCustName = pcn;
    }
    
    public void setPayCustName(String pcn) //set paying customer name
    {
        payCustName = pcn;
    }
    
    public String getPayCustName() //get paying customer name
    {
        return payCustName;
    }
    
    @Override
    public ArrayList<supplement> getListOfSupplement() //functoin to get list of supplements which is in parent customer class
    {
        return super.getListOfSupplement();
    }
    
    @Override
    public void addSupp(supplement s) //cuntion to add supplement wihch is in parent customer class
    {
        super.addSupp(s);
    }
    
    @Override
    public void removeSupp(supplement s)//function to remove supplement which is in parent customer class
    {
        super.removeSupp(s);
    }
    
    @Override
    public void output()//function to output which is in parent customer class
    {
        super.output();
        System.out.println("Paying customer name: " + payCustName);
    }
        
}
