/*
Title: ICT 373 Software Architecture Assignment 1 Question 2 main class
Author: MIN HAN TINT
Date: 15/6/2019
Filename : main.java
Purpose: A client program to run the system. There are functions to send weekly email and monthly email, initializing the magazine service and display student details.
Assumption: When user input option 1-5, the system will perform chosen option with correct function.
 */
package assign1q2;

import java.util.*; //import all java classes

public class main {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in); //Scanner for input
        DisplayStudentDetails(); //to display student details
        
        //construct 4 supplemnts to be used in program
        supplement S1 = new supplement("Comedy", 9); 
        supplement S2 = new supplement("Si-Fi", 9);
        supplement S3 = new supplement("Mystery", 8);
        supplement S4 = new supplement("Horror", 8);
        
        magazine m1 = initMagazine(S1,S2,S3,S4); // call initialize magazine function
        
        ArrayList<customer> customerList = new ArrayList<customer>(); //declare customerList as new ArrayList to store customer
        
        //construct 6 various customers (2 paying customers and 4 associate customers)
        payingCust pc1 = new payingCust("Xanny" , "xanny99@gmail.com", "Bank Transfer", "POSB") ;
        payingCust pc2 = new payingCust("Leo", "leo33@gmail.com", "Prepaid","UOB");
        
        associateCust ac1 = new associateCust("Liam", "liam89@gmail.com", "Xanny");
        associateCust ac2 = new associateCust("Theo", "theo44@gmail.com", "Xanny");
        associateCust ac3 = new associateCust("Henry", "henry55@gmail.com", "Leo");
        associateCust ac4 = new associateCust("John", "john88@gmail.com", "Leo");
        
        //Assign supplements to customers
        pc1.addSupp(S4);pc1.addSupp(S1);
        pc1.addAssoCust(ac1);pc1.addAssoCust(ac2);
        pc2.addSupp(S2);pc2.addSupp(S3);
        pc2.addAssoCust(ac3);pc2.addAssoCust(ac4);
        ac1.addSupp(S2);
        ac2.addSupp(S1);ac2.addSupp(S4);
        ac3.addSupp(S3);
        ac4.addSupp(S3);ac4.addSupp(S2);
        
        //add customers to ArrayList
        customerList.add(pc1); customerList.add(pc2); customerList.add(ac1);
        customerList.add(ac2); customerList.add(ac3); customerList.add(ac4);
        
        int count = 1;
        int option = 0;
        while (count == 1) //while loop
        {
            System.out.println("----------------------------------------");
            System.out.println("Main Menu");
            System.out.println("1.Display the customers");
            System.out.println("2.Print out the text of all the emails for all customers for four weeks of magazines");
            System.out.println("3.Print out the text for the end of month emails for the paying customers");
            System.out.println("4.Add a new customer to the magazine service");
            System.out.println("5.Remove an existing customer from the magazine service");
            System.out.println("Enter the rest any characters to exit the program!");
            System.out.print("Enter option: ");
            
            if (keyboard.hasNextInt()) //check input is integer
            {
                option = keyboard.nextInt();
                
                    switch(option) //switch operator
                    {
                        case 1: // to operate option 1
                            System.out.println("------DISPLAYING CUSTOMERS DETAILS------");
                            for(int i = 0; i < customerList.size(); i++)
                            {
                                customerList.get(i).output();
                            }
                            break;

                        case 2: // to operate option 2
                            m1.setWeek(1);
                            System.out.println("WEEK 1");
                            System.out.println("------------------------------");
                            weeklyEmail(customerList, m1); //send email
                            
                            //make some changes for week 2
                            ac4.removeSupp(S3);
                            ac1.addSupp(S4);
                            pc2.removeSupp(S3);
                            m1.setWeek(2);
                            System.out.println("WEEK 2");
                            System.out.println("------------------------------");
                            weeklyEmail(customerList, m1);

                            //make some changes for week 3
                            ac4.addSupp(S1);
                            ac3.addSupp(S1);
                            pc1.removeSupp(S4);
                            m1.setWeek(3);
                            System.out.println("WEEK 3");
                            System.out.println("------------------------------");
                            weeklyEmail(customerList, m1);

                            //make some changes for week 4
                            ac2.removeSupp(S4);
                            ac1.removeSupp(S2);
                            pc1.addSupp(S2);
                            m1.setWeek(4);
                            System.out.println("WEEK 4");
                            System.out.println("------------------------------");
                            weeklyEmail(customerList, m1);
                            break;

                        case 3:
                            monthlyEmail(customerList, m1); //call monthlyEmail function to send monthly email to customers
                            break;

                        case 4:
                            keyboard.nextLine();
                            String type;
                            String name;
                            String email;
                            System.out.println("-------ADDING NEW CUSTOMER---------");
                            System.out.println("Type 'A' to add Associate Customer and Type 'P' to add Paying Customer");
                            type = keyboard.nextLine();
                            if (type.equals("A")) //if user input is equal to A
                            {
                                System.out.println("Enter customer name: ");
                                name = keyboard.nextLine();
                                System.out.println("Enter customer Email Address: ");
                                email = keyboard.nextLine();
                                int a = 0;
                                associateCust newCust = new associateCust(name, email); //declare new customer with constuctor 
                                for (int i = 0; i < customerList.size(); i++) //loop through the customerlist 
                                {
                                    if(newCust.getEmail().equals(customerList.get(i).getEmail())) //check if new customer email is already existed or not
                                    {
                                        a = 1;
                                    }
                                }
                                if ( a == 1)   
                                {
                                    System.out.println("Customer is already existed!");
                                }
                                else
                                {
                                    System.out.println("New Associate Customer is added!");
                                    customerList.add(newCust);
                                }
                            }
                            else if(type.equals("P"))//check if user input is equal to "P"
                            {
                                String pType;
                                String bank;
                                System.out.println("Enter Customer Name: ");
                                name = keyboard.nextLine();
                                System.out.println("Enter Customer Email Address: ");
                                email = keyboard.nextLine();
                                System.out.println("Enter Type of Payment: ");
                                pType = keyboard.nextLine();
                                System.out.println("Enter Bank Name: ");
                                bank = keyboard.nextLine();
                                int a = 0;
                                payingCust newCust = new payingCust(name, email, pType, bank); //declare new customer with constructor
                                for (int i = 0; i < customerList.size(); i++) //loop through the customer list
                                {
                                    if(newCust.getEmail().equals(customerList.get(i).getEmail())) //check if new customer email is already existed or not
                                    {
                                        a = 1;
                                    }
                                }
                                if ( a == 1)
                                {
                                    System.out.println("Customer is already existed!");
                                }
                                else
                                {
                                    System.out.println("New Paying Customer is added!");
                                    customerList.add(newCust);
                                }
                            } 
                            else //if user input is not equal to "A" or "P"
                            {
                                System.out.println("Invalid Input!");
                            }
                            break;

                        case 5:
                            keyboard.nextLine();
                            String remove;
                            System.out.println("-------REMOVING CUSTOMER--------");
                            System.out.println("Enter the email address of the customer to remove: ");
                            remove = keyboard.nextLine();
                            int a = 0;
                            for (int i = 0; i < customerList.size(); i++) //loop through customer list
                            {
                                if(remove.equals(customerList.get(i).getEmail())) // check if customer email exists
                                {
                                    System.out.println("Customer is successfully Removed!");
                                    customerList.remove(i);
                                    a = 1;
                                }
                            }
                            if(a != 1)
                            {
                                System.out.println("Customer does not exist!");
                            }
                            break;

                        default: //user do not uses option 1 - 5
                            count = 0;
                            System.out.println("------------Program Terminated-----------");
                            break;
                    }
                }
                else{ //users enters any characters which are not the options
                    count = 0;
                    System.out.println("------------Program Terminated-----------");
                }   
            }
}
    
    public static void DisplayStudentDetails() //to print out student details
    {
        System.out.println("------------------------STUDENT DETAILS------------------------");
        System.out.println("Name: MIN HAN TINT");
        System.out.println("Student ID: 33311318");
        System.out.println("Mode of Enrolement: Full Time ");
        System.out.println("Tutor Name: Sarita Singh");
        System.out.println("Tutorial Day and Time: 8:30am-10.30am every Wednesday");
        System.out.println("----------------------------------------------------------------\n");
    }
    
    public static magazine initMagazine(supplement S1, supplement S2, supplement S3, supplement S4) //initialize magazine with constructed supplement values
    {
        Scanner keyboard = new Scanner(System.in);
        double cost = 0;
        System.out.println("Initializing");
        System.out.println("--------------------------------");
        System.out.println("Enter the cost for subscription: ");
        cost = keyboard.nextDouble();
        while (cost <= 0) //if cost is negative values
        {
            System.out.println("Do not input negative values! Please try again.");
            System.out.println("Enter the cost for subscription: ");
            cost = keyboard.nextDouble();
        }
        int week = 0;
        System.out.println("Enter valid magazine week(1-4): ");
        week = keyboard.nextInt();
        while (week < 1 || week > 4) //if week is not valid
        {
            System.out.println("Invalid input! Please try again!");
            System.out.println("Enter valid magazine week(1-4): ");
            week = keyboard.nextInt();
        }
        
        magazine m1 = new magazine(week, cost); //declare new magazine with constructor
        m1.addSupp(S1);
        m1.addSupp(S2);
        m1.addSupp(S3);
        m1.addSupp(S4);
        
        return m1;  //return new magazine
    }
    
    public static void weeklyEmail(ArrayList<customer> cl, magazine m) // send out weekly emails
    {
        ArrayList<customer> customerList = cl; //store input parameters cl as new customer list
        magazine mag1 = m; //store input parameter m as new magazine
        for (int i = 0; i < customerList.size(); i++) //loop through the customer list
        {
            System.out.println("-----Weekly Email---------");
            System.out.println("Name: " + customerList.get(i).getName());
            System.out.println("Email Address: " + customerList.get(i).getEmail());
            System.out.println("Magazine is ready to look at");
            System.out.println("Week: " + mag1.getWeek());
            System.out.println("Subscribed Supplements: ");
            ArrayList<supplement> supplementList = customerList.get(i).getListOfSupplement(); //store lists of supplements according to the customer
            for (int x = 0; x < supplementList.size(); x++) //loop through the customer list
            {
                System.out.println("." + supplementList.get(x).getName());
            }
        }
    }
    
    public static void monthlyEmail(ArrayList<customer> cl, magazine m) //send out monthly email
    {
        ArrayList<customer> customerList = cl; //store input parameter cl as new customerlist
        magazine mag1 = m; //store input parameter m as new magazine
        double mCost = mag1.getMcost() * 4; //multiple the weekly magazine cost with 4 as a month has 4 weeks
        ArrayList<customer> listOfPayingCust= new ArrayList<customer>(); //declrea new paying customer list.
        for (int i = 0; i < customerList.size(); i++) 
        {
            if(customerList.get(i).getClass() == payingCust.class) //check if paying customer exist in customer list
            {
                customer cust = customerList.get(i); //declare new customer from customer list
                listOfPayingCust.add(cust); //add new customer to paying customer list
            }
        }
        for (int x = 0; x < listOfPayingCust.size(); x++) //loop through paying customer list
        {
            double total = 0;
            System.out.println("-----Monthly Email------");
            System.out.println("Name: " + listOfPayingCust.get(x).getName());
            System.out.println("Email Address: " + listOfPayingCust.get(x).getEmail());
            payingCust pCust = new payingCust(); //declare new paying customer
            pCust = (payingCust) listOfPayingCust.get(x); //store new paying customer with data members
            System.out.println(pCust.getPayment());
            System.out.println("Price: $" + mCost);
            total = total + mCost; 
            System.out.println("Supplement Cost: ");
            ArrayList<supplement> supplementList = listOfPayingCust.get(x).getListOfSupplement(); //declare supplement list from paying customer 
            for (int y = 0; y < supplementList.size(); y++) //loop through supplement list
            {
                System.out.print(supplementList.get(y).getName()+ ": $");
                double supplementCost = supplementList.get(y).getCost() * 4;
                System.out.println(supplementCost);
                total = total + supplementCost;
            }
            System.out.println("Paying for following associate customers!");
            ArrayList<associateCust> aCust = pCust.getListOfAssoCust(); //declare associate customer related to paying customer
            for (int z = 0; z < aCust.size(); z++)
            {
                System.out.println("Name: " +aCust.get(z).getName());
                ArrayList<supplement> assoSupplementList = aCust.get(z).getListOfSupplement();
                for (int v = 0; v < assoSupplementList.size(); v++)
                {
                    System.out.print(assoSupplementList.get(v).getName()+ ": $");
                    double assoSupplementCost = assoSupplementList.get(v).getCost() * 4;
                    System.out.println(assoSupplementCost);
                    total = total + assoSupplementCost;
                }
                System.out.println("Total Cost: $" +total+"\n");
            }
        }
    }
    
}