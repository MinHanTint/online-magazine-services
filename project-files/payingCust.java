/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 paying customer class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : payingCust.java
Purpose: A child class which is inherited from the parent customer class. Paying customer are the customers who pay the fees for themselves and their associate customers. 
Assumption: 
 */
package assign1q2;
import java.util.*; //import all java classes

public class payingCust extends customer {
    private payment pType;
    private ArrayList<associateCust> listOfAssoCust = new ArrayList<associateCust>();
    
    public payingCust() //default constructor
    {
        super();
        pType = new payment();
        listOfAssoCust = new ArrayList<associateCust>();
    }
    
    public payingCust(String n, String e, String t, String b)//constructor with 4 parameters
    {
        super(n, e);
        pType = new payment(t, b);
        listOfAssoCust = new ArrayList<associateCust>();
    }
    
    public payingCust(String n, String e, String t, String b, supplement s)//constructor with 5 parameters
    {
        super(n, e, s);
        pType = new payment(t, b);
        listOfAssoCust = new ArrayList<associateCust>();
    }
    
    public payingCust(String n, String e, String t, String b, supplement s, associateCust ass)//constructor with 6 parameters
    {
        super(n, e, s);
        pType = new payment(t, b);
        listOfAssoCust.add(ass);
    }
    
    public void setPayment(String t, String b)//function to set payment 
    {
        pType.setType(t);
        pType.setBank(b);
    }
    
    public payment getPayment()//function to get payment
    {
        return pType;
    }
    
    public void setPayingCust(String n, String e, String t, String b)//function to set paying customer with 4 parameters
    {
        super.setCust(n, e);
        pType.setType(t);
        pType.setBank(b);
    }
    
    public void addAssoCust(associateCust ass)//function to add associate customer
    {
        int a = 0;
        for (int i = 0; i < listOfAssoCust.size(); i++)
        {
            associateCust newCust = listOfAssoCust.get(i);
            if ( newCust == ass)
            {
                a = 1;
            }
            
        }
        if (a == 1)
        {
            System.out.println("Associate Customer is already existed!");
            
        }
        else
        {
            listOfAssoCust.add(ass);
        }
             
    }
    
    public void removeAssoCust(associateCust ass)//function to remove associate customer
    {
        int a = 0;
        for (int i = 0; i < listOfAssoCust.size(); i++)
        {
            associateCust newCust = listOfAssoCust.get(i);
            if ( newCust == ass)
            {
                listOfAssoCust.remove(i);
                a = 1;
            }
          
        }
        if ( a != 1)
        {
            System.out.println("Associate Customer does not exist!");
        }
    }
    
    public ArrayList<associateCust> getListOfAssoCust()//function to get list of associate customer list
    {
        return listOfAssoCust;
    }
    
    @Override
    public ArrayList<supplement> getListOfSupplement()//function to get list of supplement which is in parent customer class
    {
        return super.getListOfSupplement();
    }
    
    @Override
    public void addSupp(supplement s)//function to add supplement which is in parent customer class
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
        pType.toString();
        for (int i = 0; i < listOfAssoCust.size(); i++)
        {
            associateCust ac = listOfAssoCust.get(i);
            System.out.print("Associate Customers: " + ac.getName() + "\n");
        }
    }
}
