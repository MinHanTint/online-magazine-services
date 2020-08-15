/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 customer class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : customer.java
Purpose: A parent class to associate customer class and paying customer class.
Assumption: 
 */
package assign1q2;
import java.util.*;//import all java classes

public class customer {
    private String name;
    private String email;
    ArrayList<supplement> listOfSupplement = new ArrayList<supplement>();
    
    public customer()//default constructor
    {
        name = "";
        email = "";
        listOfSupplement = new ArrayList<supplement>();
    }
    
    public customer(String n, String e)//constructor with 2 parameters
    {
        name = n;
        email = e;
        listOfSupplement = new ArrayList<supplement>();
    }
    
    public customer(String n, String e, supplement s)//constructor with 3 parameters
    {
        name = n;
        email = e;
        listOfSupplement.add(s);
    }
    
    public void setName(String n)//function to set customer name
    {
        name = n;
    }
    
    public void setEmail(String e)//funciton to set customer email
    {
        email = e;
    }
    
    public void setCust(String n, String e)//funciton to set customer with 2 parameters
    {
        name = n;
        email = e;
    }
    
    public String getName()//function ot get customer name
    {
        return name;
    }
    public String getEmail()//function ot get customer email
    {
        return email;
    }
    
    public ArrayList<supplement> getListOfSupplement()//function to get list of supplements
    {
        return listOfSupplement;
    }
    
    public void addSupp(supplement s)//function to add supplement
    {
        int a = 0;
        for (int i = 0; i < listOfSupplement.size(); i++)
        {
            supplement e = listOfSupplement.get(i);
            if (e == s)
            {
               a = 1;
            }           
        }
        if (a == 1)
        {
            System.out.println("Supplememt is already existed!");
        }
        else
        {
            listOfSupplement.add(s);
        }
        
    }
    
    public void removeSupp(supplement s)//function to remove supplement
    {
        int a = 0;
        for (int i = 0; i < listOfSupplement.size(); i++)
        {
            supplement e = listOfSupplement.get(i);
            if (e == s)
            {
                listOfSupplement.remove(i);
                a = 1;
            }
        }
        if ( a != 1)
        {
                System.out.println("The supplement does not exist!");
        }
    }
    
    public void output()//function to output detail
    {
        System.out.println("Name: " +name);
        System.out.println("Email Address: " +email);
        for (int i = 0; i < listOfSupplement.size(); i++)
        {
            System.out.println("List of Supplement-\n" + listOfSupplement.get(i));
        }
    }
}
