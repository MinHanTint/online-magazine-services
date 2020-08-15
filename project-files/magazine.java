/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 magazine class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : magazine.java
Purpose: A class which is composition to supplement class to create magazine with reasonable data members and supplements. 
Assumption: 
 */
package assign1q2;
import java.util.*;//import all java classes

public class magazine {
    private int week;
    private double mainCost;
    ArrayList<supplement> listOfSupplement = new ArrayList<supplement>();
    
    public magazine()//default constructor
    {
        week = 1;
        mainCost = 10;
        listOfSupplement = new ArrayList<supplement>();
    }
    
    public magazine(int w, double mc)//constructor with 2 parameters
    {
        week = w;
        mainCost = mc;
        listOfSupplement = new ArrayList<supplement>();
    }
    
    public magazine(int w, double mc, supplement s)//constructor with 3 parameters
    {
        week = w;
        mainCost = mc;
        listOfSupplement.add(s);
    }
    
    public void setWeek(int w)//function to set magazine week
    {
        week = w;
    }
    
    public void setMcost(double mc)//function to set main cost for magazine
    {
        mainCost = mc;
    }
    
    public int getWeek()//function to get magazine week
    {
        return week;
    }
    
    public double getMcost()//function to get main cost for magazine
    {
        return mainCost;
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
    
    public void output()//function to output 
    {
        System.out.println("Week: " +week);
        System.out.println("Main Cost: " +mainCost);
        for (int i = 0; i < listOfSupplement.size(); i++)
        {
            System.out.println(listOfSupplement.get(i));
        }
    }
    
}
