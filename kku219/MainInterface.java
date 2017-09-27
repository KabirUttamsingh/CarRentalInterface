/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package my.Hurts_Rent_a_Lemon_Kabir_Uttamsingh;

import java.util.Scanner;
import java.sql.*;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/**
 *
 * @author Kabir Uttamsingh
 */
public class MainInterface 
{
    static boolean eorc= true;
    static String username;
    static String password;
    static String pl;
    static String dl;
    static String pd;
    static String dd;
    static String VINa;
    static String Makea;
    static String Modela;
    static String Yeara;
    static String Typea;
    public static void main(String[]args)
    {
       
        
        
    try 
    {Class.forName ("oracle.jdbc.driver.OracleDriver");}     
    catch(Exception e)   
    {System.out.println("Missing driver"); }  
    int result9 =0;
    int timeCost = 0;
    int cscost = 0;
    int radcost = 0;
    int navcost = 0;
    int insurance = 0;
     String VIN = null;
                String Make = null;
                String Model = null;
                String Year = null;
                String Type = null;
                String currL = null;
                 String odometer = null;
    Date pdate1 = null;
    Date ddate1 = null;
    boolean reg = true;
    boolean reg1 = true;
    Scanner input = new Scanner(System.in);
    String ans = null;
    String pdate=null;
    boolean flag3 =true;
    boolean flag4=true;
    boolean flag5 =true;
    int flag = 1;
    String dl = null;
    String fname=null;
    String lname = null;
    String street = null;
    String city = null;
    String state = null;
    long dln=0;
    int cid = 0;
    String cid1 = null;
    String add= null;
    ResultSet result;
    ResultSet result2;
    ResultSet result3;
    String ddate= null;
    int result1 = 0;
    String plid1 =null;
    String rVin =null;
    String dlid1 = null;
    int dropoffc = 0;
    int basecost=0;
    boolean flaga=true;
    boolean flag15 = true;
    boolean flag16 = true;
    boolean flag17 = true;
    boolean flag18 = true;
    boolean flag19 = true;
    boolean flag20 = true;
    boolean flag21 = true;
    boolean flag22 = true;
    boolean flag23 = true;
    boolean flag24 = true;
    boolean flag25 = true;
    boolean flag26 = true;
    boolean flag27 = true;
            
            boolean flag32 = true;
    boolean flag28= true;
    boolean flag29 = true;
    boolean flag30 = true;
    boolean flag31 = true;
    boolean flag6=true;
             boolean flag2 = true;
             boolean flag7 = true;
             boolean flag1 = true;
             boolean flag8 = true;
             boolean flag9 = true;
             boolean flag10 = true;
             boolean flag11 = true;
             boolean flag12= true;
             boolean flag13 = true;
             int tmp =0;
    
    System.out.println("Hello! Welcome to Hurts Rent-A-Lemon!" );	
    System.out.println();	
    System.out.println();
    System.out.println();
    System.out.println();	
    System.out.println("Please input your Oracle ID and Password to continue:");
    System.out.println();
    System.out.println();
    System.out.println();
  
    while (flag ==1) //ORACLE LOG IN
    {	
        
        
    System.out.println("Enter Oracle userid: ");
    username = input.nextLine();
    System.out.println("Enter Oracle password for " + username + ": ");
    password = input.nextLine(); 
    
    
    try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241",username,password);
         Statement s= con.createStatement();
         Statement p = con.createStatement();
         Statement q = con.createStatement();
         ) 
	{
            
	   flag = 0;
	   System.out.println("Successful Connection");
           System.out.println();
           System.out.println();
           
             try// Update all cars that are currently being rented to a status of in transit
          {
          String currl = "Select rental_id, rental.vin as vin, curr_location from rental, vehicle_info where pick_up_date <=current_date and drop_off_date >= current_date and rental.vin = vehicle_info.vin and curr_location !=0";
          result = s.executeQuery(currl);
          
          while(result.next())
          {
          
              String upd = "Update vehicle_info SET curr_location = 0 where VIN = '" +result.getString("vin") +"'";
              result1 = s.executeUpdate(upd);
          }
          }
          catch(Exception e)
          {
             // e.printStackTrace();
              System.out.println("error");
          }
           
           EorC(input);
           
           
           if(eorc==false) //CUSTOMER
           {
         
            Customer(input, con);       
         System.out.println("Thank you for chosing Hurts-Rent-A-Lemon Car Company! Before we begin, have you made a rental with us before? ");
         while(flag3 == true)//ARE YOU EXISTING CUSTOMER OR NOT
         {
             
         System.out.println("Enter yes if you have made a rental with us and no if you have not in order to Register");
         ans = input.nextLine();
         
         if(ans.equalsIgnoreCase("yes"))//BEGINNING OF EXISTING CUSTOMER RENTAL
         {
          flag3 = false;   
          reg1 = true;
           while(reg1 == true)
               {
               System.out.println("Excellent! Please enter your Driver's License Number so we can confirm you are in our system");
               dl = input.nextLine();
       
               String dnum = "Select Cast(DL_number as varchar(10))as dl_number from customer";
               result = s.executeQuery(dnum);
               
               
               while(result.next())
               {
                   
                  // System.out.println(result.getString("dl_number")));
                   if(dl.equals(result.getString("dl_number")))
                   {
                       reg = true;
                       System.out.println("We found a match!");
                       break;
                   }
                   else
                   {
                     reg = false;
                   }
               }
               
               
               if(reg == true)
               {
                   reg1 = false;
                   System.out.println("Please Confirm the Information below is correct. If you see anything wrong, please contact a Hurts Employee so they can update your information in our system");
                   System.out.println();
                   System.out.println();
                   String regis = "SELECT * FROM CUSTOMER WHERE DL_number = " + dl;
                   result = s.executeQuery(regis);
                   result.next();
                   String tfname = "First Name";
                   String tlname = "Last Name";
                   String tstreet = "Street";
                   String tcity = "City";
                   String tstate = "State";
                   String tdln = "DL_number";  
                   String tcid = "Corporate_ID";
                System.out.format("%10s %10s %20s %20s %2s \t %10s %5s\n",tfname,tlname,tstreet,tcity,tstate, tdln, tcid );
                  do
                   {
                   fname = result.getString("First_Name");
                   lname = result.getString("Last_Name");
                   street = result.getString("Address");
                    city = result.getString("City");
                    state = result.getString("State");
                   dln = result.getLong("DL_number");  
                    cid = result.getInt("Corporate_ID");
                       System.out.format("%10s %10s \t %20s %20s %2s \t %10d %5d\n ",fname,lname,street,city,state, dln, cid );
                   }while(result.next());
                 
               
               
               
               
               }
               else
               {
                  
                   System.out.println("Sorry we didnt find a match would you like to try again or register?");
                   System.out.println("Enter 1 to try again or enter 2 to go back and register");
                   flag28 = true;
                   while(flag28 == true)
                   {
                   String dec = input.nextLine();
                   if(dec.equals("1"))
                   {
                      flag28= false;
                      reg1 = true;
                   }
                   else if (dec.equals("2"))
                   {
                       flag28 = false;
                       flag3 = true;
                       reg1 = false;
                   }
                   else
                   {
                       System.out.println("Invalid Input: Enter 1 or 2");
                   }
                   }
               }
               }
           
           
             while(flag16 == true) //RENTAL CONFIRMATION LOOP   
             {  
              
              if(flag3 == true)
              {
                  break;
              }
             
             System.out.println();
             System.out.println();
                   System.out.println();
            while(flag27 == true) 
            {       //Pickup location
           
                while(flag15==true)
             {
             
             
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             System.out.println("LOCATION ID        Street      City    State");
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Please enter one of the Location ID's above to select your pick up locatoin");
             plid1 = input.nextLine();
             String lid2 = "Select Location_id from Location where location_id != 0";
             result = s.executeQuery(lid2);
        
             while(result.next())
                {
                 if(plid1.equals(result.getString("location_id")))
                     {
                  flag15 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  System.out.println(plid1);
                  break;
                    }
                }
             if(flag15 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //DROP OFF LOCATION
             while(flag18== true)
             {
            
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Enter one of the Location ID's above as your Drop off Location.");
             System.out.println("Note if you select a Drop off location different from the pick up location there will be a fixed drop-off charge of $100");
             dlid1 = input.nextLine();
             String lid2 = "Select Location_id from Location";
             result = s.executeQuery(lid2);
             result.next();
             while(result.next())
                {
                 if(dlid1.equals(result.getString("location_id")))
                     {
                  flag18 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  if(dlid1.equals(plid1))
                  {
                      dropoffc = 0;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  else
                  {
                      dropoffc = 100;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  break;
                    }
                }
             if(flag18 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //PICK UP DATE
             while(flag17 == true)
             {
              System.out.println("Please enter a Pick up date");
              System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
              pdate = input.nextLine();
              DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
           
              Date current = new Date();
              try{
              pdate1 = formatter.parse(pdate); 
             
              
              if(pdate1.compareTo(current)<0)
              {
                  System.out.println("Error: Date inputed has passed, Try again");
              }
              else
              {
                  flag27 = false;
                  flag17 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
              
             }
             
            //Drop off date
             while(flag19 == true)
             {
             System.out.println("Please enter a Dropoff date");
             System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
             ddate = input.nextLine();
             DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            
              try{
              ddate1 = formatter.parse(ddate); 
             
              
              if(ddate1.compareTo(pdate1)<=0)
              {
                  System.out.println("Error: Drop off date is before entered pick up date. Try again");
              }
              else
              {
                  flag27 = false;
                  flag19 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
             } 
             
            while(flag20 ==true)//Vehicle CHOICE
             {
           
            String avail = "Select * from vehicle_info natural join vehicle_type where curr_location =" + plid1;
            result = s.executeQuery(avail);
            
            if(!(result.next()))
            {
                       flag27 = true;
                       //flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                System.out.println("sorry no available cars at given pick_up location");
                break;
            }
            else
            {
                 System.out.println("Here are all the vehicles available from your desired pick up location");
            String vin1 = "VIN";
            String make1="Make";
            String model1 = "Model";
            String year1="Year";
            String type1 = "Type";
            System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
           
            do
            {
                VIN = result.getString("VIN");
                Make = result.getString("Make");
                Model = result.getString("Model");
                Year = result.getString("Year");
                Type = result.getString("Type");
                String exists = "Select vin from rental where vin = '" + VIN +"'";
                
                result2 = p.executeQuery(exists);
                
                if(!(result2.next()))
                  {
                      flag27 = false;
                      flag31 = false;
                      System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                      continue;
                  }
                else
                {
                    
                    String availa = " Select * from rental where VIN = '" + VIN + "' and('" + pdate + "' <drop_off_date and '" + ddate +"' > pick_up_date)";
                    result3 = q.executeQuery(availa);
                    
                    if(result3.next())
                    {
                        if(flag31== false)
                        {
                            continue;
                        }
                       flag27 = true;
                       flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                      
                    }
                    else
                    {
                        do
                        {
                        System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                   //     System.out.println("Printing here");
                        flag27 = false;
                       flag31 = false;
                       continue;
                    }while(result3.next());
                   }
                } //END OF CHECKING CARS IN RENTAL
            }while(result.next()); 
            
            } //END IF CARS ARE AT LOCATION
           
            if(flag31 == true)
            {
                System.out.println("No available cars at entered location during period requested");
              
                break;
            }
            
            
           System.out.println("Enter the VIN to choose your vehicle");
           rVin = input.nextLine();
           result = s.executeQuery(avail);
          
            while(result.next())
            {
                if(rVin.equals(result.getString("VIN")))
                {
                    System.out.println("Succesfully chosen valid VIN");
                    Make = result.getString("Make");
                    Model = result.getString("Model");
                    Year = result.getString("Year");
                    Type = result.getString("Type");
                    switch(result.getString("Type"))
                    {
                        case "Sport":
                          basecost = 100;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                         case "Truck":
                          basecost = 90;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Convertible":
                          basecost = 110;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "SUV":
                          basecost = 80;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Sedan":
                          basecost = 70;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Minivan":
                          basecost = 75;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          
                    }
                    System.out.println();
                    flag20 = false;
                    break;
                    
                }
            }
           
            //if vin does not exist in rental table contine
            //else check if it is availabe during dates
               // if not available; Ask if they would like to change dates or choose another vehicle
            if(flag20 == true)
            {
                System.out.println("Invalid VIN entered, Try again");
            }
           
             } // END OF VIN decision
            }
            
             while(flag21 == true)//Ask about Child Seat
             {
                 System.out.println("Will you require a Child Seat for your rental?");
                  System.out.println("Please enter yes or no.");
                 String cs = input.nextLine();
                 if(cs.equalsIgnoreCase("yes"))
                 {
                     flag21 = false;
                     System.out.println("How many Child Seat's will you require?");
                     System.out.println("Note: The maximum is 3");
                     
                     try
                     {
                         int numcs = input.nextInt();
                         if(numcs>=1 && numcs <=3)
                         {
                             cscost = 10 * numcs;
                             input.nextLine();
                             System.out.println("Child Seat Cost: $" +cscost);
                         }
                         else
                         {
                            System.out.println("Error: Please enter a number 1 to 3");
                            input.nextLine();
                            flag21 = true;
                         }
                     }
                     catch(Exception e)
                     {
                         flag21 = true;
                         input.nextLine();
                         System.out.println("Error: Please enter a number 1 to 3");
                     }
                     
                 }
                 else if(cs.equalsIgnoreCase("no"))
                 {
                     cscost = 0;
                     flag21 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please Enter Yes/No");
                 }
             }
             while(flag22 ==true)//Ask about radio
             {
                 System.out.println("Will you require a radio?");
                 System.out.println("Please enter yes or no.");
                 String rad = input.nextLine();
                 if(rad.equalsIgnoreCase("yes"))
                 {
                     flag22 = false;
                     radcost = 30;
                     System.out.println("Radio Cost: $" + radcost);
                 }
                 else if(rad.equalsIgnoreCase("no"))
                 {
                     radcost = 0;
                     flag22 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag23 ==true)// Ask about insurance
             {
                 System.out.println("Will you require Insurance?");
                 System.out.println("Please enter yes or no.");
                 String ins = input.nextLine();
                 if(ins.equalsIgnoreCase("yes"))
                 {
                     flag23 = false;
                     insurance = 50;
                     System.out.println("Insurance Cost: $" + insurance);
                 }
                 else if(ins.equalsIgnoreCase("no"))
                 {
                     insurance = 0;
                     flag23 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag24 == true) // Ask about navigation
             {
                 System.out.println("Will you require a Navigation System?");
                 System.out.println("Please enter yes or no.");
                 String nav = input.nextLine();
                 if(nav.equalsIgnoreCase("yes"))
                 {
                     flag24 = false;
                     navcost = 20;
                     System.out.println("Navigation Cost: $" + navcost);
                 }
                 else if(nav.equalsIgnoreCase("no"))
                 {
                     navcost = 0;
                     flag24 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             
              long diff = Math.abs(pdate1.getTime()-ddate1.getTime());
              long diffDays = diff / (24 * 60 * 60 * 1000);
              timeCost = 5 * (int)diffDays;
              int estimate = basecost + dropoffc +cscost + insurance + navcost + radcost +timeCost;
              System.out.println("Before we complete your rental, Please confrim the following information");
              System.out.println("1. Pick Up Location: " + plid1);
              System.out.println("2. Drop Off Location: " +dlid1 );
              System.out.println("3. Base Cost: " + basecost);
              System.out.println(("4. Vehicle: " + rVin + " " + Make + " " + Model + " " + Year + " " + Type));
              System.out.println("5. Pick Up Date: " + pdate);
              System.out.println("7. Drop Off Date: " + ddate);
              System.out.println("8. Insurance Charge: $" + insurance);
              System.out.println("9. Child Seat Charge: $" + cscost);
              System.out.println("10. Radio Charge: $" + radcost);
              System.out.println("11. Navigation Charge: $" + navcost);
             
              System.out.println("12. Estimated Invoice (Without Fuel and Carbon offset charges): $" + estimate);
             
              flag25 = true;
              while(flag25 == true)
             {
              System.out.println("Enter yes or no to confirm the information above");
              String confirm = input.nextLine();
              if(confirm.equalsIgnoreCase("yes"))
              {
                  flag25= false;
                  flag16 = false;
            
              }
              else if(confirm.equalsIgnoreCase("no"))
              {
                  flag25 = false;
              
              System.out.println("1. Pick Up Location" );
              System.out.println("2. Drop Off Location" );
              System.out.println(("3. Vehicle" ));
              System.out.println("4. Pick Up Date");
              System.out.println("5. Drop Off Date" );
              System.out.println("6. Insurance Charge" );
              System.out.println("7. Child Seat Charge");
              System.out.println("8. Radio Charge" );
              System.out.println("9. Navigation Charge" );
              System.out.println("10. Update All" );
              System.out.println("11. CANCEL RENTAL AND EXIT");
              flag26 = true;
               while(flag26 == true)
              {
              System.out.println("Please enter a number 1 to 11 to update a given field");
              
              String update = input.nextLine();
              if(containsOnlyNumbers(update))
              {
              tmp = Integer.parseInt(update);
              if(tmp >=1 && tmp <= 11)
              {
               flag26 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 10");
                flag26=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 11");
                  flag26 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag15 = true;
                          flag20 =true;
                          flag27 = true;
                          flag17 = true;
                          flag19 = true;
                          break;
                      case 2:
                          flag27 = true;
                          flag18 = true;
                          break;
                      case 3:
                          flag27 = true;
                          flag20 = true;
                          break;
                      case 4:
                          flag20 = true;
                          flag17 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 5:
                          flag20 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 6:
                          flag23 = true;
                          break;
                      case 7:
                          flag21 = true;
                          break;
                      case 8:
                          flag22 = true;
                          break;
                      case 9:
                          flag24 = true;
                          break;
                      case 10:
                          flag15 = true;
                          flag18 = true;
                          flag17 = true;
                          flag19 = true;
                          flag20 = true;
                          flag21 = true;
                          flag22 = true;
                          flag23 = true;
                          flag24 = true;
                          flag27 = true;
                          break;
                      case 11:
                          System.exit(0);
                          break;
                    }
              
              }
              else
              {
                  System.out.println("Error: Enter yes or no");
              }
             }
         }//END CONFIRMATION LOOP
          
         }//END OF EXISTING CUSTOMER RENTAL
         else if(ans.equalsIgnoreCase("no")) // BEGINNING OF NEW CUSTOMER RENTAL
         { 
             flag3 =false;
             System.out.println("Okay Lets Get Started!");
             while(flag13 == true)
             {
             while(flag4 ==true)
             {
       
             System.out.println("Please enter your First Name ");
             fname = input.nextLine();
             if(!((validateS(20,fname)== true) && (isAlpha(fname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             
             }
             else
             {
                 flag4=false;
             }
             }
             
             while(flag6 == true)
             {
             System.out.println("Please enter your Last Name ");
             lname = input.nextLine();
             if(!((validateS(20,lname)== true) && (isAlpha(lname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             }
              else
             {
                 flag6=false;
             }
             }
             
             while(flag7 == true)
             {
             System.out.println("Please enter your Street Address");
             street = input.nextLine();
             if(!(validateS(40,street)==true))
             {
              System.out.println("Invalid Input: Enter a street address less than 40 characters ");
             }
             else
             {
             flag7=false;
             }
             }
             
             
             while(flag8 == true)
             {
             System.out.println("Please enter your City");
             city = input.nextLine();
               if((validateS(20,city)== false) || (city.matches(".*\\d+.*")==true))
               {
                   System.out.println("Invalid Input: Enter a city lass than or equal to 20 characters with no numbers");
               }
               else
               {
                   flag8 = false;
               }
             }
             
             while(flag9 == true)
             {   
             System.out.println("Please enter your State in abreviated form (i.e. New Jersey = NJ)");
             state = input.nextLine();
             if(!((state.length()==2)&&(isAlpha(state)==true)))
             {
              System.out.println("Invalid Input: Please enter letters only and your state in abreviated form");
             }
             else
             {
             flag9 = false;
             }
             }
             
             
             while(flag10 == true)
             {
              System.out.println("Please enter a Corporate ID if you have one. If you do not have a Corporate ID associated with a discount, Please enter 0 ");
              cid1 = input.nextLine();
              if(cid1.equals("0"))
              {
                  flag10 = false;
                  break;
              }
              String corp = "Select corporate_id from discounts";
              result = s.executeQuery(corp);
              result.next();
                while(result.next())
               {
                   String res = Integer.toString(result.getInt("corporate_id"));
                   if(cid1.equals(res))
                   {
                       flag10 = false;
                       break;
                   }
                   else
                   {
                     flag10 = true;
                   }
               }
                if(flag10==false)
                {
                    System.out.println("SUCCESSS");
                }
                else
                {
                    System.out.println("Invalid Input: Enter valid Corporate_ID");
                }
              
             }
             
             
             while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                dl = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
                if(dl.length()!= 10 || !(dl.matches("[0-9.]*")==true) )
                {
                    System.out.println("Invalid Input: Please enter a valid Driver's License Number of 10 digits");
                }
                else
                {
                flag11 = false;
                }  
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(dl.equals(result.getString("dl_number")))
                {
                    flag11 = true;
                    System.out.println("Error: DL_Number already registered with other user");
                    System.out.println("Enter 1 to try again or Enter 2 to quit");
                    while(flaga== true)
                    {
                    String ch = input.nextLine();
                    if(ch.equals("1"))
                    {
                        flaga = false;
                    }
                    else if(ch.equals("2"))
                    {
                        con.close();
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Please enter 1 or 2");
                    }
                    }
                    break;
                }
                } //END OF CHECK IF EXIST
             } // End of validate DL
          System.out.println("Congrats! You have succesfully filled out all of the information we need");
           System.out.println();
          System.out.println("Before we continue, Please confirm the information you have just entered");
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("First Name: " + fname);
          System.out.println("Last Name: " + lname);
          System.out.println("Street: " + street);
          System.out.println("City: " + city);
          System.out.println("State: " + state);
          System.out.println("Driver's License Number: " + dl);
          System.out.println("Corporate ID: " + cid1);
          
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("If information is correct, Enter 'yes', otherwise enter 'no'");
          flag5=true;
        while(flag5 == true)
        {
            String val = input.nextLine();
        
        if(val.equalsIgnoreCase("yes"))
          {
         flag5 = false;     //continue
         flag13 = false;
          }
          else if(val.equalsIgnoreCase("no"))
          {
              flag5 = false;
              System.out.println("What parts incorrect?");
              System.out.println("1. First Name");
              System.out.println("2. Last Name");
              System.out.println("3. Street");
              System.out.println("4. City");
              System.out.println("5. State");
              System.out.println("6. Driver's License number");
              System.out.println("7. Corporate ID");
              System.out.println("8. UPDATE ALL");
              flag12= true;
              while(flag12 == true)
              {
              System.out.println("Please enter a number 1 to 8 to update a given field");
              
              String in = input.nextLine();
              if(containsOnlyNumbers(in))
              {
              tmp = Integer.parseInt(in);
              if(tmp >=1 && tmp <= 8)
              {
               flag12 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 7");
                flag12=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 7");
                  flag12 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag4 = true;
                          break;
                      case 2:
                          flag6 = true;
                          break;
                      case 3:
                          flag7 = true;
                          break;
                      case 4:
                          flag8 = true;
                          break;
                      case 5:
                          flag9 = true;
                          break;
                      case 6:
                          flag11 = true;
                          break;
                      case 7:
                          flag10 = true;
                          break;
                      case 8:
                          flag4 = true;
                          flag6= true;
                          flag7=true;
                          flag8=true;
                          flag9=true;
                          flag10=true;
                          flag11 =true;
                          break;
              }
          }
        
          else
          {
              System.out.println("Invalid Input: Enter yes if infomration is correct and no if otherwise");
          }
        } 
         
             
         }//END FLAG 13
        
             dln = Long.parseLong(dl);
             cid = Integer.parseInt(cid1);
             if(cid!=0)
             {
            add = ("INSERT INTO CUSTOMER(First_name,Last_name,Address, City,State,Corporate_id,DL_number) VALUES('" + fname +"','"+lname +"','"+street +"','"+city +"','"+state +"',"+cid +","+dln + ")");
             }
             else
             {
             add = ("INSERT INTO CUSTOMER(First_name,Last_name,Address, City,State,DL_number) VALUES('" + fname +"','"+lname +"','"+street +"','"+city +"','"+state +"',"+dln + ")");    
             }
             
             try
             {
             result1 = s.executeUpdate(add);
             }
             catch(Exception e)
             {
           System.out.println("Error");
             }
        
             System.out.println();
             System.out.println();
             System.out.println("You have succesfully registered!");
             System.out.println();
             System.out.println();
             System.out.println("Now Let's Begin the Rental");
             System.out.println();
             
             
            while(flag16 == true) //RENTAL CONFIRMATION LOOP   
             {  
              
              if(flag3 == true)
              {
                  break;
              }
             
             System.out.println();
             System.out.println();
                   System.out.println();
            while(flag27 == true) 
            {       //Pickup location
           
                while(flag15==true)
             {
             
             
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             System.out.println("LOCATION ID        Street      City    State");
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Please enter one of the Location ID's above to select your pick up locatoin");
             plid1 = input.nextLine();
             String lid2 = "Select Location_id from Location where location_id != 0";
             result = s.executeQuery(lid2);
        
             while(result.next())
                {
                 if(plid1.equals(result.getString("location_id")))
                     {
                  flag15 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  System.out.println(plid1);
                  break;
                    }
                }
             if(flag15 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //DROP OFF LOCATION
             while(flag18== true)
             {
            
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Enter one of the Location ID's above as your Drop off Location.");
             System.out.println("Note if you select a Drop off location different from the pick up location there will be a fixed drop-off charge of $100");
             dlid1 = input.nextLine();
             String lid2 = "Select Location_id from Location";
             result = s.executeQuery(lid2);
             result.next();
             while(result.next())
                {
                 if(dlid1.equals(result.getString("location_id")))
                     {
                  flag18 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  if(dlid1.equals(plid1))
                  {
                      dropoffc = 0;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  else
                  {
                      dropoffc = 100;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  break;
                    }
                }
             if(flag18 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //PICK UP DATE
             while(flag17 == true)
             {
              System.out.println("Please enter a Pick up date");
              System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
              pdate = input.nextLine();
              DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
           
              Date current = new Date();
              try{
              pdate1 = formatter.parse(pdate); 
             
              
              if(pdate1.compareTo(current)<0)
              {
                  System.out.println("Error: Date inputed has passed, Try again");
              }
              else
              {
                  flag27 = false;
                  flag17 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
              
             }
             
            //Drop off date
             while(flag19 == true)
             {
             System.out.println("Please enter a Dropoff date");
             System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
             ddate = input.nextLine();
             DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            
              try{
              ddate1 = formatter.parse(ddate); 
             
              
              if(ddate1.compareTo(pdate1)<=0)
              {
                  System.out.println("Error: Drop off date is before entered pick up date. Try again");
              }
              else
              {
                  flag27 = false;
                  flag19 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
             } 
             
            while(flag20 ==true)//Vehicle CHOICE
             {
           
            String avail = "Select * from vehicle_info natural join vehicle_type where curr_location =" + plid1;
            result = s.executeQuery(avail);
            
            if(!(result.next()))
            {
                       flag27 = true;
                       //flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                System.out.println("sorry no available cars at given pick_up location");
                break;
            }
            else
            {
                 System.out.println("Here are all the vehicles available from your desired pick up location");
            String vin1 = "VIN";
            String make1="Make";
            String model1 = "Model";
            String year1="Year";
            String type1 = "Type";
            System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
           
            do
            {
                VIN = result.getString("VIN");
                Make = result.getString("Make");
                Model = result.getString("Model");
                Year = result.getString("Year");
                Type = result.getString("Type");
                String exists = "Select vin from rental where vin = '" + VIN +"'";
                
                result2 = p.executeQuery(exists);
                
                if(!(result2.next()))
                  {
                      flag27 = false;
                      flag31 = false;
                      System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                      continue;
                  }
                else
                {
                    
                    String availa = " Select * from rental where VIN = '" + VIN + "' and('" + pdate + "' <drop_off_date and '" + ddate +"' > pick_up_date)";
                    result3 = q.executeQuery(availa);
                    
                    if(result3.next())
                    {
                        if(flag31== false)
                        {
                            continue;
                        }
                       flag27 = true;
                       flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                      
                    }
                    else
                    {
                        do
                        {
                        System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                     //   System.out.println("Printing here");
                        flag27 = false;
                       flag31 = false;
                       continue;
                    }while(result3.next());
                   }
                } //END OF CHECKING CARS IN RENTAL
            }while(result.next()); 
            
            } //END IF CARS ARE AT LOCATION
           
            if(flag31 == true)
            {
                System.out.println("No available cars at entered location during period requested");
              
                break;
            }
            
            
           System.out.println("Enter the VIN to choose your vehicle");
           rVin = input.nextLine();
           result = s.executeQuery(avail);
          
            while(result.next())
            {
                if(rVin.equals(result.getString("VIN")))
                {
                    System.out.println("Succesfully chosen valid VIN");
                    Make = result.getString("Make");
                    Model = result.getString("Model");
                    Year = result.getString("Year");
                    Type = result.getString("Type");
                    switch(result.getString("Type"))
                    {
                        case "Sport":
                          basecost = 100;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                         case "Truck":
                          basecost = 90;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Convertible":
                          basecost = 110;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "SUV":
                          basecost = 80;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Sedan":
                          basecost = 70;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Minivan":
                          basecost = 75;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          
                    }
                    System.out.println();
                    flag20 = false;
                    break;
                    
                }
            }
           
            //if vin does not exist in rental table contine
            //else check if it is availabe during dates
               // if not available; Ask if they would like to change dates or choose another vehicle
            if(flag20 == true)
            {
                System.out.println("Invalid VIN entered, Try again");
            }
           
             } // END OF VIN decision
            }
            
             while(flag21 == true)//Ask about Child Seat
             {
                 System.out.println("Will you require a Child Seat for your rental?");
                  System.out.println("Please enter yes or no.");
                 String cs = input.nextLine();
                 if(cs.equalsIgnoreCase("yes"))
                 {
                     flag21 = false;
                     System.out.println("How many Child Seat's will you require?");
                     System.out.println("Note: The maximum is 3");
                     
                     try
                     {
                         int numcs = input.nextInt();
                         if(numcs>=1 && numcs <=3)
                         {
                             cscost = 10 * numcs;
                             input.nextLine();
                             System.out.println("Child Seat Cost: $" +cscost);
                         }
                         else
                         {
                            System.out.println("Error: Please enter a number 1 to 3");
                            input.nextLine();
                            flag21 = true;
                         }
                     }
                     catch(Exception e)
                     {
                         flag21 = true;
                         input.nextLine();
                         System.out.println("Error: Please enter a number 1 to 3");
                     }
                     
                 }
                 else if(cs.equalsIgnoreCase("no"))
                 {
                     cscost = 0;
                     flag21 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please Enter Yes/No");
                 }
             }
             while(flag22 ==true)//Ask about radio
             {
                 System.out.println("Will you require a radio?");
                 System.out.println("Please enter yes or no.");
                 String rad = input.nextLine();
                 if(rad.equalsIgnoreCase("yes"))
                 {
                     flag22 = false;
                     radcost = 30;
                     System.out.println("Radio Cost: $" + radcost);
                 }
                 else if(rad.equalsIgnoreCase("no"))
                 {
                     radcost = 0;
                     flag22 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag23 ==true)// Ask about insurance
             {
                 System.out.println("Will you require Insurance?");
                 System.out.println("Please enter yes or no.");
                 String ins = input.nextLine();
                 if(ins.equalsIgnoreCase("yes"))
                 {
                     flag23 = false;
                     insurance = 50;
                     System.out.println("Insurance Cost: $" + insurance);
                 }
                 else if(ins.equalsIgnoreCase("no"))
                 {
                     insurance = 0;
                     flag23 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag24 == true) // Ask about navigation
             {
                 System.out.println("Will you require a Navigation System?");
                 System.out.println("Please enter yes or no.");
                 String nav = input.nextLine();
                 if(nav.equalsIgnoreCase("yes"))
                 {
                     flag24 = false;
                     navcost = 20;
                     System.out.println("Navigation Cost: $" + navcost);
                 }
                 else if(nav.equalsIgnoreCase("no"))
                 {
                     navcost = 0;
                     flag24 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             
              long diff = Math.abs(pdate1.getTime()-ddate1.getTime());
              long diffDays = diff / (24 * 60 * 60 * 1000);
              timeCost = 5 * (int)diffDays;
              int estimate = basecost + dropoffc +cscost + insurance + navcost + radcost +timeCost;
              System.out.println("Before we complete your rental, Please confrim the following information");
              System.out.println("1. Pick Up Location: " + plid1);
              System.out.println("2. Drop Off Location: " +dlid1 );
              System.out.println("3. Base Cost: " + basecost);
              System.out.println(("4. Vehicle: " + rVin + " " + Make + " " + Model + " " + Year + " " + Type));
              System.out.println("5. Pick Up Date: " + pdate);
              System.out.println("7. Drop Off Date: " + ddate);
              System.out.println("8. Insurance Charge: $" + insurance);
              System.out.println("9. Child Seat Charge: $" + cscost);
              System.out.println("10. Radio Charge: $" + radcost);
              System.out.println("11. Navigation Charge: $" + navcost);
             
              System.out.println("12. Estimated Invoice (Without Fuel and Carbon offset charges): $" + estimate);
             
              flag25 = true;
              while(flag25 == true)
             {
              System.out.println("Enter yes or no to confirm the information above");
              String confirm = input.nextLine();
              if(confirm.equalsIgnoreCase("yes"))
              {
                  flag25= false;
                  flag16 = false;
            
              }
              else if(confirm.equalsIgnoreCase("no"))
              {
                  flag25 = false;
              
              System.out.println("1. Pick Up Location" );
              System.out.println("2. Drop Off Location" );
              System.out.println(("3. Vehicle" ));
              System.out.println("4. Pick Up Date");
              System.out.println("5. Drop Off Date" );
              System.out.println("6. Insurance Charge" );
              System.out.println("7. Child Seat Charge");
              System.out.println("8. Radio Charge" );
              System.out.println("9. Navigation Charge" );
              System.out.println("10. Update All" );
              System.out.println("11. CANCEL RENTAL AND EXIT");
              flag26 = true;
               while(flag26 == true)
              {
              System.out.println("Please enter a number 1 to 11 to update a given field");
              
              String update = input.nextLine();
              if(containsOnlyNumbers(update))
              {
              tmp = Integer.parseInt(update);
              if(tmp >=1 && tmp <= 11)
              {
               flag26 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 10");
                flag26=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 11");
                  flag26 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag15 = true;
                          flag20 =true;
                          flag27 = true;
                          flag17 = true;
                          flag19 = true;
                          break;
                      case 2:
                          flag27 = true;
                          flag18 = true;
                          break;
                      case 3:
                          flag27 = true;
                          flag20 = true;
                          break;
                      case 4:
                          flag20 = true;
                          flag17 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 5:
                          flag20 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 6:
                          flag23 = true;
                          break;
                      case 7:
                          flag21 = true;
                          break;
                      case 8:
                          flag22 = true;
                          break;
                      case 9:
                          flag24 = true;
                          break;
                      case 10:
                          flag15 = true;
                          flag18 = true;
                          flag17 = true;
                          flag19 = true;
                          flag20 = true;
                          flag21 = true;
                          flag22 = true;
                          flag23 = true;
                          flag24 = true;
                          flag27 = true;
                          break;
                      case 11:
                          System.exit(0);
                          break;
                    }
              
              }
              else
              {
                  System.out.println("Error: Enter yes or no");
              }
             }
         }//END CONFIRMATION LOOP
          
      
         }//End of New Customer
         }//END OF are you existing customer loop
         try
          {
           String rental = "insert into Rental(Pick_up_loc, Drop_off_loc, DL_number, Base_Cost, VIN, Pick_up_date, Drop_off_date) Values(" + plid1 + "," + dlid1 +"," +dl + "," + basecost + ",'" + rVin + "','" +pdate + "','" +ddate + "')";
        
           result1 = s.executeUpdate(rental);
           String getRID= "Select rental_id from rental where pick_up_loc =" + plid1 + " and drop_off_loc =" + dlid1 + " and VIN = '" + rVin + "' and Pick_up_date = '" + pdate + "' and drop_off_date = '" + ddate + "'"; 
          //System.out.println(getRID);
           result = s.executeQuery(getRID);
          result.next();
          String rid1  = result.getString("rental_id");
           String charges = "insert into Charges(Rental_ID,Child_Seat,Insurance,Radio,Navigation) Values (" + rid1 +"," + cscost + ", " + insurance + "," + radcost +", " + navcost + ")" ;
           result1 = s.executeUpdate(charges);
         
          }
          catch(Exception e)
          {
              System.out.println("error with processing your rental, Sorry! Please Try again");
          //e.printStackTrace();
          }
         
        
           System.out.println("Thank you for your choosing Hurts Rent-A-Lemon Car Company.");
           System.out.println();
           System.out.println("If you would like to make any changes to your rental, Please contact a Hurts Reservation Manager");
           con.close();
           System.exit(0);
           } // END OFCUSTOMER
           
           
           
           
           
           
           
           
           
           
           
     
           
           else//BEGINNING EMPLOYEE
           {
          
                        
         boolean man = true;  
           
           System.out.println("Welcome Hurts Rent-A-Lemon Employee!");          
           System.out.println(" ");         
           System.out.println(" ");   
           System.out.println(" ");
          
           
           System.out.println("What Type of Employee Are You?");
           System.out.println(" ");   
           System.out.println("1. Reservation Manager "); 
           System.out.println("2. Inventory Manager ");
           System.out.println("3. Financial Manager ");
           System.out.println("4. EXIT");
       
           while(man == true)
           {
               System.out.println("Enter 1,2,3,or 4 to select what type of manager you are or exit");
               String manager = input.nextLine();    
           if(manager.equals("1"))
           {
               man = false;
          System.out.println(" Welcome Reservation Manager ");
          System.out.println("1. Make a rental");
          System.out.println("2. View/Update Customers");
          System.out.println("3. View/Update Rentals");
          System.out.println("4. Process a Return");
          System.out.println("5. EXIT");
          String rdec = input.nextLine();
          while(flag30 == true)//BEG RDEC
          {
          if(rdec.equals("1"))
          {
              flag30 = false;
              System.out.println("Excellent Let's Make a Rental");
             while(flag3 == true)//ARE YOU EXISTING CUSTOMER OR NOT
         {
             
         System.out.println("Enter yes if you have made a rental with us and no if you have not in order to Register");
         ans = input.nextLine();
         
         if(ans.equalsIgnoreCase("yes"))//BEGINNING OF EXISTING CUSTOMER RENTAL
         {
          flag3 = false;   
          reg1 = true;
           while(reg1 == true)
               {
               System.out.println("Excellent! Please enter your Driver's License Number so we can confirm you are in our system");
               dl = input.nextLine();
       
               String dnum = "Select Cast(DL_number as varchar(10))as dl_number from customer";
               result = s.executeQuery(dnum);
               
               
               while(result.next())
               {
                   
                  // System.out.println(result.getString("dl_number")));
                   if(dl.equals(result.getString("dl_number")))
                   {
                       reg = true;
                       System.out.println("We found a match!");
                       break;
                   }
                   else
                   {
                     reg = false;
                   }
               }
               
               
               if(reg == true)
               {
                   reg1 = false;
                   System.out.println("Please Confirm the Information below is correct. If you see anything wrong, please contact a Hurts Employee so they can update your information in our system");
                   System.out.println();
                   System.out.println();
                   String regis = "SELECT * FROM CUSTOMER WHERE DL_number = " + dl;
                   result = s.executeQuery(regis);
                   result.next();
                   String tfname = "First Name";
                   String tlname = "Last Name";
                   String tstreet = "Street";
                   String tcity = "City";
                   String tstate = "State";
                   String tdln = "DL_number";  
                   String tcid = "Corporate_ID";
                System.out.format("%10s %10s %20s %20s %2s \t %10s %5s\n",tfname,tlname,tstreet,tcity,tstate, tdln, tcid );
                  do
                   {
                   fname = result.getString("First_Name");
                   lname = result.getString("Last_Name");
                   street = result.getString("Address");
                    city = result.getString("City");
                    state = result.getString("State");
                   dln = result.getLong("DL_number");  
                    cid = result.getInt("Corporate_ID");
                       System.out.format("%10s %10s \t %20s %20s %2s \t %10d %5d\n ",fname,lname,street,city,state, dln, cid );
                   }while(result.next());
                 
               
               
               
               
               }
               else
               {
                  
                   System.out.println("Sorry we didnt find a match would you like to try again or register?");
                   System.out.println("Enter 1 to try again or enter 2 to go back and register");
                   flag28 = true;
                   while(flag28 == true)
                   {
                   String dec = input.nextLine();
                   if(dec.equals("1"))
                   {
                      flag28= false;
                      reg1 = true;
                   }
                   else if (dec.equals("2"))
                   {
                       flag28 = false;
                       flag3 = true;
                       reg1 = false;
                   }
                   else
                   {
                       System.out.println("Invalid Input: Enter 1 or 2");
                   }
                   }
               }
               }
           
           
             while(flag16 == true) //RENTAL CONFIRMATION LOOP   
             {  
              
              if(flag3 == true)
              {
                  break;
              }
             
             System.out.println();
             System.out.println();
                   System.out.println();
            while(flag27 == true) 
            {       //Pickup location
           
                while(flag15==true)
             {
             
             
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             System.out.println("LOCATION ID        Street      City    State");
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Please enter one of the Location ID's above to select your pick up locatoin");
             plid1 = input.nextLine();
             String lid2 = "Select Location_id from Location where location_id != 0";
             result = s.executeQuery(lid2);
        
             while(result.next())
                {
                 if(plid1.equals(result.getString("location_id")))
                     {
                  flag15 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  System.out.println(plid1);
                  break;
                    }
                }
             if(flag15 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //DROP OFF LOCATION
             while(flag18== true)
             {
            
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Enter one of the Location ID's above as your Drop off Location.");
             System.out.println("Note if you select a Drop off location different from the pick up location there will be a fixed drop-off charge of $100");
             dlid1 = input.nextLine();
             String lid2 = "Select Location_id from Location";
             result = s.executeQuery(lid2);
             result.next();
             while(result.next())
                {
                 if(dlid1.equals(result.getString("location_id")))
                     {
                  flag18 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  if(dlid1.equals(plid1))
                  {
                      dropoffc = 0;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  else
                  {
                      dropoffc = 100;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  break;
                    }
                }
             if(flag18 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //PICK UP DATE
             while(flag17 == true)
             {
              System.out.println("Please enter a Pick up date");
              System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
              pdate = input.nextLine();
              DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
           
              Date current = new Date();
              try{
              pdate1 = formatter.parse(pdate); 
             
              
              if(pdate1.compareTo(current)<0)
              {
                  System.out.println("Error: Date inputed has passed, Try again");
              }
              else
              {
                  flag27 = false;
                  flag17 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
              
             }
             
            //Drop off date
             while(flag19 == true)
             {
             System.out.println("Please enter a Dropoff date");
             System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
             ddate = input.nextLine();
             DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            
              try{
              ddate1 = formatter.parse(ddate); 
             
              
              if(ddate1.compareTo(pdate1)<=0)
              {
                  System.out.println("Error: Drop off date is before entered pick up date. Try again");
              }
              else
              {
                  flag27 = false;
                  flag19 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
             } 
             
            while(flag20 ==true)//Vehicle CHOICE
             {
           
            String avail = "Select * from vehicle_info natural join vehicle_type where curr_location =" + plid1;
            result = s.executeQuery(avail);
            
            if(!(result.next()))
            {
                       flag27 = true;
                       //flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                System.out.println("sorry no available cars at given pick_up location");
                break;
            }
            else
            {
                 System.out.println("Here are all the vehicles available from your desired pick up location");
            String vin1 = "VIN";
            String make1="Make";
            String model1 = "Model";
            String year1="Year";
            String type1 = "Type";
            System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
           
            do
            {
                VIN = result.getString("VIN");
                Make = result.getString("Make");
                Model = result.getString("Model");
                Year = result.getString("Year");
                Type = result.getString("Type");
                String exists = "Select vin from rental where vin = '" + VIN +"'";
                
                result2 = p.executeQuery(exists);
                
                if(!(result2.next()))
                  {
                      flag27 = false;
                      flag31 = false;
                      System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                      continue;
                  }
                else
                {
                    
                    String availa = " Select * from rental where VIN = '" + VIN + "' and('" + pdate + "' <drop_off_date and '" + ddate +"' > pick_up_date)";
                    result3 = q.executeQuery(availa);
                    
                    if(result3.next())
                    {
                        if(flag31== false)
                        {
                            continue;
                        }
                       flag27 = true;
                       flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                      
                    }
                    else
                    {
                        do
                        {
                        System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                        //System.out.println("Printing here");
                        flag27 = false;
                       flag31 = false;
                       continue;
                    }while(result3.next());
                   }
                } //END OF CHECKING CARS IN RENTAL
            }while(result.next()); 
            
            } //END IF CARS ARE AT LOCATION
           
            if(flag31 == true)
            {
                System.out.println("No available cars at entered location during period requested");
              
                break;
            }
            
            
           System.out.println("Enter the VIN to choose your vehicle");
           rVin = input.nextLine();
           result = s.executeQuery(avail);
          
            while(result.next())
            {
                if(rVin.equals(result.getString("VIN")))
                {
                    System.out.println("Succesfully chosen valid VIN");
                    Make = result.getString("Make");
                    Model = result.getString("Model");
                    Year = result.getString("Year");
                    Type = result.getString("Type");
                    switch(result.getString("Type"))
                    {
                        case "Sport":
                          basecost = 100;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                         case "Truck":
                          basecost = 90;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Convertible":
                          basecost = 110;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "SUV":
                          basecost = 80;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Sedan":
                          basecost = 70;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Minivan":
                          basecost = 75;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          
                    }
                    System.out.println();
                    flag20 = false;
                    break;
                    
                }
            }
           
            //if vin does not exist in rental table contine
            //else check if it is availabe during dates
               // if not available; Ask if they would like to change dates or choose another vehicle
            if(flag20 == true)
            {
                System.out.println("Invalid VIN entered, Try again");
            }
           
             } // END OF VIN decision
            }
            
             while(flag21 == true)//Ask about Child Seat
             {
                 System.out.println("Will you require a Child Seat for your rental?");
                  System.out.println("Please enter yes or no.");
                 String cs = input.nextLine();
                 if(cs.equalsIgnoreCase("yes"))
                 {
                     flag21 = false;
                     System.out.println("How many Child Seat's will you require?");
                     System.out.println("Note: The maximum is 3");
                     
                     try
                     {
                         int numcs = input.nextInt();
                         if(numcs>=1 && numcs <=3)
                         {
                             cscost = 10 * numcs;
                             input.nextLine();
                             System.out.println("Child Seat Cost: $" +cscost);
                         }
                         else
                         {
                            System.out.println("Error: Please enter a number 1 to 3");
                            input.nextLine();
                            flag21 = true;
                         }
                     }
                     catch(Exception e)
                     {
                         flag21 = true;
                         input.nextLine();
                         System.out.println("Error: Please enter a number 1 to 3");
                     }
                     
                 }
                 else if(cs.equalsIgnoreCase("no"))
                 {
                     cscost = 0;
                     flag21 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please Enter Yes/No");
                 }
             }
             while(flag22 ==true)//Ask about radio
             {
                 System.out.println("Will you require a radio?");
                 System.out.println("Please enter yes or no.");
                 String rad = input.nextLine();
                 if(rad.equalsIgnoreCase("yes"))
                 {
                     flag22 = false;
                     radcost = 30;
                     System.out.println("Radio Cost: $" + radcost);
                 }
                 else if(rad.equalsIgnoreCase("no"))
                 {
                     radcost = 0;
                     flag22 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag23 ==true)// Ask about insurance
             {
                 System.out.println("Will you require Insurance?");
                 System.out.println("Please enter yes or no.");
                 String ins = input.nextLine();
                 if(ins.equalsIgnoreCase("yes"))
                 {
                     flag23 = false;
                     insurance = 50;
                     System.out.println("Insurance Cost: $" + insurance);
                 }
                 else if(ins.equalsIgnoreCase("no"))
                 {
                     insurance = 0;
                     flag23 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag24 == true) // Ask about navigation
             {
                 System.out.println("Will you require a Navigation System?");
                 System.out.println("Please enter yes or no.");
                 String nav = input.nextLine();
                 if(nav.equalsIgnoreCase("yes"))
                 {
                     flag24 = false;
                     navcost = 20;
                     System.out.println("Navigation Cost: $" + navcost);
                 }
                 else if(nav.equalsIgnoreCase("no"))
                 {
                     navcost = 0;
                     flag24 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             
              long diff = Math.abs(pdate1.getTime()-ddate1.getTime());
              long diffDays = diff / (24 * 60 * 60 * 1000);
              timeCost = 5 * (int)diffDays;
              int estimate = basecost + dropoffc +cscost + insurance + navcost + radcost +timeCost;
              System.out.println("Before we complete your rental, Please confrim the following information");
              System.out.println("1. Pick Up Location: " + plid1);
              System.out.println("2. Drop Off Location: " +dlid1 );
              System.out.println("3. Base Cost: " + basecost);
              System.out.println(("4. Vehicle: " + rVin + " " + Make + " " + Model + " " + Year + " " + Type));
              System.out.println("5. Pick Up Date: " + pdate);
              System.out.println("7. Drop Off Date: " + ddate);
              System.out.println("8. Insurance Charge: $" + insurance);
              System.out.println("9. Child Seat Charge: $" + cscost);
              System.out.println("10. Radio Charge: $" + radcost);
              System.out.println("11. Navigation Charge: $" + navcost);
             
              System.out.println("12. Estimated Invoice (Without Fuel and Carbon offset charges): $" + estimate);
             
              flag25 = true;
              while(flag25 == true)
             {
              System.out.println("Enter yes or no to confirm the information above");
              String confirm = input.nextLine();
              if(confirm.equalsIgnoreCase("yes"))
              {
                  flag25= false;
                  flag16 = false;
            
              }
              else if(confirm.equalsIgnoreCase("no"))
              {
                  flag25 = false;
              
              System.out.println("1. Pick Up Location" );
              System.out.println("2. Drop Off Location" );
              System.out.println(("3. Vehicle" ));
              System.out.println("4. Pick Up Date");
              System.out.println("5. Drop Off Date" );
              System.out.println("6. Insurance Charge" );
              System.out.println("7. Child Seat Charge");
              System.out.println("8. Radio Charge" );
              System.out.println("9. Navigation Charge" );
              System.out.println("10. Update All" );
              System.out.println("11. CANCEL RENTAL AND EXIT");
              flag26 = true;
               while(flag26 == true)
              {
              System.out.println("Please enter a number 1 to 11 to update a given field");
              
              String update = input.nextLine();
              if(containsOnlyNumbers(update))
              {
              tmp = Integer.parseInt(update);
              if(tmp >=1 && tmp <= 11)
              {
               flag26 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 10");
                flag26=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 11");
                  flag26 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag15 = true;
                          flag20 =true;
                          flag27 = true;
                          flag17 = true;
                          flag19 = true;
                          break;
                      case 2:
                          flag27 = true;
                          flag18 = true;
                          break;
                      case 3:
                          flag27 = true;
                          flag20 = true;
                          break;
                      case 4:
                          flag20 = true;
                          flag17 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 5:
                          flag20 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 6:
                          flag23 = true;
                          break;
                      case 7:
                          flag21 = true;
                          break;
                      case 8:
                          flag22 = true;
                          break;
                      case 9:
                          flag24 = true;
                          break;
                      case 10:
                          flag15 = true;
                          flag18 = true;
                          flag17 = true;
                          flag19 = true;
                          flag20 = true;
                          flag21 = true;
                          flag22 = true;
                          flag23 = true;
                          flag24 = true;
                          flag27 = true;
                          break;
                      case 11:
                          System.exit(0);
                          break;
                    }
              
              }
              else
              {
                  System.out.println("Error: Enter yes or no");
              }
             }
         }//END CONFIRMATION LOOP
          
         }//END OF EXISTING CUSTOMER RENTAL
         else if(ans.equalsIgnoreCase("no")) // BEGINNING OF NEW CUSTOMER RENTAL
         { 
             flag3 =false;
             System.out.println("Okay Lets Get Started!");
             while(flag13 == true)
             {
             while(flag4 ==true)
             {
       
             System.out.println("Please enter your First Name ");
             fname = input.nextLine();
             if(!((validateS(20,fname)== true) && (isAlpha(fname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             
             }
             else
             {
                 flag4=false;
             }
             }
             
             while(flag6 == true)
             {
             System.out.println("Please enter your Last Name ");
             lname = input.nextLine();
             if(!((validateS(20,lname)== true) && (isAlpha(lname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             }
              else
             {
                 flag6=false;
             }
             }
             
             while(flag7 == true)
             {
             System.out.println("Please enter your Street Address");
             street = input.nextLine();
             if(!(validateS(40,street)==true))
             {
              System.out.println("Invalid Input: Enter a street address less than 40 characters ");
             }
             else
             {
             flag7=false;
             }
             }
             
             
             while(flag8 == true)
             {
             System.out.println("Please enter your City");
             city = input.nextLine();
               if((validateS(20,city)== false) || (city.matches(".*\\d+.*")==true))
               {
                   System.out.println("Invalid Input: Enter a city lass than or equal to 20 characters with no numbers");
               }
               else
               {
                   flag8 = false;
               }
             }
             
             while(flag9 == true)
             {   
             System.out.println("Please enter your State in abreviated form (i.e. New Jersey = NJ)");
             state = input.nextLine();
             if(!((state.length()==2)&&(isAlpha(state)==true)))
             {
              System.out.println("Invalid Input: Please enter letters only and your state in abreviated form");
             }
             else
             {
             flag9 = false;
             }
             }
             
             
             while(flag10 == true)
             {
              System.out.println("Please enter a Corporate ID if you have one. If you do not have a Corporate ID associated with a discount, Please enter 0 ");
              cid1 = input.nextLine();
              if(cid1.equals("0"))
              {
                  flag10 = false;
                  break;
              }
              String corp = "Select corporate_id from discounts";
              result = s.executeQuery(corp);
              result.next();
                while(result.next())
               {
                   String res = Integer.toString(result.getInt("corporate_id"));
                   if(cid1.equals(res))
                   {
                       flag10 = false;
                       break;
                   }
                   else
                   {
                     flag10 = true;
                   }
               }
                if(flag10==false)
                {
                    System.out.println("SUCCESSS");
                }
                else
                {
                    System.out.println("Invalid Input: Enter valid Corporate_ID");
                }
              
             }
             
             
             while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                dl = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
                if(dl.length()!= 10 || !(dl.matches("[0-9.]*")==true) )
                {
                    System.out.println("Invalid Input: Please enter a valid Driver's License Number of 10 digits");
                }
                else
                {
                flag11 = false;
                }  
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(dl.equals(result.getString("dl_number")))
                {
                    flag11 = true;
                    System.out.println("Error: DL_Number already registered with other user");
                    System.out.println("Enter 1 to try again or Enter 2 to quit");
                    while(flaga== true)
                    {
                    String ch = input.nextLine();
                    if(ch.equals("1"))
                    {
                        flaga = false;
                    }
                    else if(ch.equals("2"))
                    {
                        con.close();
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Please enter 1 or 2");
                    }
                    }
                    break;
                }
                } //END OF CHECK IF EXIST
             } // End of validate DL
          System.out.println("Congrats! You have succesfully filled out all of the information we need");
           System.out.println();
          System.out.println("Before we continue, Please confirm the information you have just entered");
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("First Name: " + fname);
          System.out.println("Last Name: " + lname);
          System.out.println("Street: " + street);
          System.out.println("City: " + city);
          System.out.println("State: " + state);
          System.out.println("Driver's License Number: " + dl);
          System.out.println("Corporate ID: " + cid1);
          
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("If information is correct, Enter 'yes', otherwise enter 'no'");
          flag5=true;
        while(flag5 == true)
        {
            String val = input.nextLine();
        
        if(val.equalsIgnoreCase("yes"))
          {
         flag5 = false;     //continue
         flag13 = false;
          }
          else if(val.equalsIgnoreCase("no"))
          {
              flag5 = false;
              System.out.println("What parts incorrect?");
              System.out.println("1. First Name");
              System.out.println("2. Last Name");
              System.out.println("3. Street");
              System.out.println("4. City");
              System.out.println("5. State");
              System.out.println("6. Driver's License number");
              System.out.println("7. Corporate ID");
              System.out.println("8. UPDATE ALL");
              flag12= true;
              while(flag12 == true)
              {
              System.out.println("Please enter a number 1 to 8 to update a given field");
              
              String in = input.nextLine();
              if(containsOnlyNumbers(in))
              {
              tmp = Integer.parseInt(in);
              if(tmp >=1 && tmp <= 8)
              {
               flag12 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 7");
                flag12=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 7");
                  flag12 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag4 = true;
                          break;
                      case 2:
                          flag6 = true;
                          break;
                      case 3:
                          flag7 = true;
                          break;
                      case 4:
                          flag8 = true;
                          break;
                      case 5:
                          flag9 = true;
                          break;
                      case 6:
                          flag11 = true;
                          break;
                      case 7:
                          flag10 = true;
                          break;
                      case 8:
                          flag4 = true;
                          flag6= true;
                          flag7=true;
                          flag8=true;
                          flag9=true;
                          flag10=true;
                          flag11 =true;
                          break;
              }
          }
        
          else
          {
              System.out.println("Invalid Input: Enter yes if infomration is correct and no if otherwise");
          }
        } 
         
             
         }//END FLAG 13
        
             dln = Long.parseLong(dl);
             cid = Integer.parseInt(cid1);
             if(cid!=0)
             {
            add = ("INSERT INTO CUSTOMER(First_name,Last_name,Address, City,State,Corporate_id,DL_number) VALUES('" + fname +"','"+lname +"','"+street +"','"+city +"','"+state +"',"+cid +","+dln + ")");
             }
             else
             {
             add = ("INSERT INTO CUSTOMER(First_name,Last_name,Address, City,State,DL_number) VALUES('" + fname +"','"+lname +"','"+street +"','"+city +"','"+state +"',"+dln + ")");    
             }
             
             try
             {
             result1 = s.executeUpdate(add);
             }
             catch(Exception e)
             {
           System.out.println("Error");
             }
        
             System.out.println();
             System.out.println();
             System.out.println("You have succesfully registered!");
             System.out.println();
             System.out.println();
             System.out.println("Now Let's Begin the Rental");
             System.out.println();
             
             
            while(flag16 == true) //RENTAL CONFIRMATION LOOP   
             {  
              
              if(flag3 == true)
              {
                  break;
              }
             
             System.out.println();
             System.out.println();
                   System.out.println();
            while(flag27 == true) 
            {       //Pickup location
           
                while(flag15==true)
             {
             
             
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             System.out.println("LOCATION ID        Street      City    State");
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Please enter one of the Location ID's above to select your pick up locatoin");
             plid1 = input.nextLine();
             String lid2 = "Select Location_id from Location where location_id != 0";
             result = s.executeQuery(lid2);
        
             while(result.next())
                {
                 if(plid1.equals(result.getString("location_id")))
                     {
                  flag15 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  System.out.println(plid1);
                  break;
                    }
                }
             if(flag15 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //DROP OFF LOCATION
             while(flag18== true)
             {
            
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Enter one of the Location ID's above as your Drop off Location.");
             System.out.println("Note if you select a Drop off location different from the pick up location there will be a fixed drop-off charge of $100");
             dlid1 = input.nextLine();
             String lid2 = "Select Location_id from Location";
             result = s.executeQuery(lid2);
             result.next();
             while(result.next())
                {
                 if(dlid1.equals(result.getString("location_id")))
                     {
                  flag18 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  if(dlid1.equals(plid1))
                  {
                      dropoffc = 0;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  else
                  {
                      dropoffc = 100;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  break;
                    }
                }
             if(flag18 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //PICK UP DATE
             while(flag17 == true)
             {
              System.out.println("Please enter a Pick up date");
              System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
              pdate = input.nextLine();
              DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
           
              Date current = new Date();
              try{
              pdate1 = formatter.parse(pdate); 
             
              
              if(pdate1.compareTo(current)<0)
              {
                  System.out.println("Error: Date inputed has passed, Try again");
              }
              else
              {
                  flag27 = false;
                  flag17 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
              
             }
             
            //Drop off date
             while(flag19 == true)
             {
             System.out.println("Please enter a Dropoff date");
             System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
             ddate = input.nextLine();
             DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            
              try{
              ddate1 = formatter.parse(ddate); 
             
              
              if(ddate1.compareTo(pdate1)<=0)
              {
                  System.out.println("Error: Drop off date is before entered pick up date. Try again");
              }
              else
              {
                  flag27 = false;
                  flag19 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
             } 
             
            while(flag20 ==true)//Vehicle CHOICE
             {
           
            String avail = "Select * from vehicle_info natural join vehicle_type where curr_location =" + plid1;
            result = s.executeQuery(avail);
            
            if(!(result.next()))
            {
                       flag27 = true;
                       //flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                System.out.println("sorry no available cars at given pick_up location");
                break;
            }
            else
            {
                 System.out.println("Here are all the vehicles available from your desired pick up location");
            String vin1 = "VIN";
            String make1="Make";
            String model1 = "Model";
            String year1="Year";
            String type1 = "Type";
            System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
           
            do
            {
                VIN = result.getString("VIN");
                Make = result.getString("Make");
                Model = result.getString("Model");
                Year = result.getString("Year");
                Type = result.getString("Type");
                String exists = "Select vin from rental where vin = '" + VIN +"'";
                
                result2 = p.executeQuery(exists);
                
                if(!(result2.next()))
                  {
                      flag27 = false;
                      flag31 = false;
                      System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                      continue;
                  }
                else
                {
                    
                    String availa = " Select * from rental where VIN = '" + VIN + "' and('" + pdate + "' <drop_off_date and '" + ddate +"' > pick_up_date)";
                    result3 = q.executeQuery(availa);
                    
                    if(result3.next())
                    {
                        if(flag31== false)
                        {
                            continue;
                        }
                       flag27 = true;
                       flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                      
                    }
                    else
                    {
                        do
                        {
                        System.out.format("%20s %15s %7s %4s %12s\n", VIN,Make,Model,Year,Type);
                       // System.out.println("Printing here");
                        flag27 = false;
                       flag31 = false;
                       continue;
                    }while(result3.next());
                   }
                } //END OF CHECKING CARS IN RENTAL
            }while(result.next()); 
            
            } //END IF CARS ARE AT LOCATION
           
            if(flag31 == true)
            {
                System.out.println("No available cars at entered location during period requested");
              
                break;
            }
            
            
           System.out.println("Enter the VIN to choose your vehicle");
           rVin = input.nextLine();
           result = s.executeQuery(avail);
          
            while(result.next())
            {
                if(rVin.equals(result.getString("VIN")))
                {
                    System.out.println("Succesfully chosen valid VIN");
                    Make = result.getString("Make");
                    Model = result.getString("Model");
                    Year = result.getString("Year");
                    Type = result.getString("Type");
                    switch(result.getString("Type"))
                    {
                        case "Sport":
                          basecost = 100;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                         case "Truck":
                          basecost = 90;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Convertible":
                          basecost = 110;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "SUV":
                          basecost = 80;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Sedan":
                          basecost = 70;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Minivan":
                          basecost = 75;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          
                    }
                    System.out.println();
                    flag20 = false;
                    break;
                    
                }
            }
           
            //if vin does not exist in rental table contine
            //else check if it is availabe during dates
               // if not available; Ask if they would like to change dates or choose another vehicle
            if(flag20 == true)
            {
                System.out.println("Invalid VIN entered, Try again");
            }
           
             } // END OF VIN decision
            }
            
             while(flag21 == true)//Ask about Child Seat
             {
                 System.out.println("Will you require a Child Seat for your rental?");
                  System.out.println("Please enter yes or no.");
                 String cs = input.nextLine();
                 if(cs.equalsIgnoreCase("yes"))
                 {
                     flag21 = false;
                     System.out.println("How many Child Seat's will you require?");
                     System.out.println("Note: The maximum is 3");
                     
                     try
                     {
                         int numcs = input.nextInt();
                         if(numcs>=1 && numcs <=3)
                         {
                             cscost = 10 * numcs;
                             input.nextLine();
                             System.out.println("Child Seat Cost: $" +cscost);
                         }
                         else
                         {
                            System.out.println("Error: Please enter a number 1 to 3");
                            input.nextLine();
                            flag21 = true;
                         }
                     }
                     catch(Exception e)
                     {
                         flag21 = true;
                         input.nextLine();
                         System.out.println("Error: Please enter a number 1 to 3");
                     }
                     
                 }
                 else if(cs.equalsIgnoreCase("no"))
                 {
                     cscost = 0;
                     flag21 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please Enter Yes/No");
                 }
             }
             while(flag22 ==true)//Ask about radio
             {
                 System.out.println("Will you require a radio?");
                 System.out.println("Please enter yes or no.");
                 String rad = input.nextLine();
                 if(rad.equalsIgnoreCase("yes"))
                 {
                     flag22 = false;
                     radcost = 30;
                     System.out.println("Radio Cost: $" + radcost);
                 }
                 else if(rad.equalsIgnoreCase("no"))
                 {
                     radcost = 0;
                     flag22 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag23 ==true)// Ask about insurance
             {
                 System.out.println("Will you require Insurance?");
                 System.out.println("Please enter yes or no.");
                 String ins = input.nextLine();
                 if(ins.equalsIgnoreCase("yes"))
                 {
                     flag23 = false;
                     insurance = 50;
                     System.out.println("Insurance Cost: $" + insurance);
                 }
                 else if(ins.equalsIgnoreCase("no"))
                 {
                     insurance = 0;
                     flag23 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             while(flag24 == true) // Ask about navigation
             {
                 System.out.println("Will you require a Navigation System?");
                 System.out.println("Please enter yes or no.");
                 String nav = input.nextLine();
                 if(nav.equalsIgnoreCase("yes"))
                 {
                     flag24 = false;
                     navcost = 20;
                     System.out.println("Navigation Cost: $" + navcost);
                 }
                 else if(nav.equalsIgnoreCase("no"))
                 {
                     navcost = 0;
                     flag24 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
             
              long diff = Math.abs(pdate1.getTime()-ddate1.getTime());
              long diffDays = diff / (24 * 60 * 60 * 1000);
              timeCost = 5 * (int)diffDays;
              int estimate = basecost + dropoffc +cscost + insurance + navcost + radcost +timeCost;
              System.out.println("Before we complete your rental, Please confrim the following information");
              System.out.println("1. Pick Up Location: " + plid1);
              System.out.println("2. Drop Off Location: " +dlid1 );
              System.out.println("3. Base Cost: " + basecost);
              System.out.println(("4. Vehicle: " + rVin + " " + Make + " " + Model + " " + Year + " " + Type));
              System.out.println("5. Pick Up Date: " + pdate);
              System.out.println("7. Drop Off Date: " + ddate);
              System.out.println("8. Insurance Charge: $" + insurance);
              System.out.println("9. Child Seat Charge: $" + cscost);
              System.out.println("10. Radio Charge: $" + radcost);
              System.out.println("11. Navigation Charge: $" + navcost);
             
              System.out.println("12. Estimated Invoice (Without Fuel and Carbon offset charges): $" + estimate);
             
              flag25 = true;
              while(flag25 == true)
             {
              System.out.println("Enter yes or no to confirm the information above");
              String confirm = input.nextLine();
              if(confirm.equalsIgnoreCase("yes"))
              {
                  flag25= false;
                  flag16 = false;
            
              }
              else if(confirm.equalsIgnoreCase("no"))
              {
                  flag25 = false;
              
              System.out.println("1. Pick Up Location" );
              System.out.println("2. Drop Off Location" );
              System.out.println(("3. Vehicle" ));
              System.out.println("4. Pick Up Date");
              System.out.println("5. Drop Off Date" );
              System.out.println("6. Insurance Charge" );
              System.out.println("7. Child Seat Charge");
              System.out.println("8. Radio Charge" );
              System.out.println("9. Navigation Charge" );
              System.out.println("10. Update All" );
              System.out.println("11. CANCEL RENTAL AND EXIT");
              flag26 = true;
               while(flag26 == true)
              {
              System.out.println("Please enter a number 1 to 11 to update a given field");
              
              String update = input.nextLine();
              if(containsOnlyNumbers(update))
              {
              tmp = Integer.parseInt(update);
              if(tmp >=1 && tmp <= 11)
              {
               flag26 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 10");
                flag26=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 11");
                  flag26 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag15 = true;
                          flag20 =true;
                          flag27 = true;
                          flag17 = true;
                          flag19 = true;
                          break;
                      case 2:
                          flag27 = true;
                          flag18 = true;
                          break;
                      case 3:
                          flag27 = true;
                          flag20 = true;
                          break;
                      case 4:
                          flag20 = true;
                          flag17 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 5:
                          flag20 = true;
                          flag27 = true;
                          flag19 = true;
                          break;
                      case 6:
                          flag23 = true;
                          break;
                      case 7:
                          flag21 = true;
                          break;
                      case 8:
                          flag22 = true;
                          break;
                      case 9:
                          flag24 = true;
                          break;
                      case 10:
                          flag15 = true;
                          flag18 = true;
                          flag17 = true;
                          flag19 = true;
                          flag20 = true;
                          flag21 = true;
                          flag22 = true;
                          flag23 = true;
                          flag24 = true;
                          flag27 = true;
                          break;
                      case 11:
                          System.exit(0);
                          break;
                    }
              
              }
              else
              {
                  System.out.println("Error: Enter yes or no");
              }
             }
         }//END CONFIRMATION LOOP
          
      
         }//End of New Customer
         }//END OF are you existing customer loop
             try
          {
           String rental = "insert into Rental(Pick_up_loc, Drop_off_loc, DL_number, Base_Cost, VIN, Pick_up_date, Drop_off_date) Values(" + plid1 + "," + dlid1 +"," +dl + "," + basecost + ",'" + rVin + "','" +pdate + "','" +ddate + "')";
        
           result1 = s.executeUpdate(rental);
           String getRID= "Select rental_id from rental where pick_up_loc =" + plid1 + " and drop_off_loc =" + dlid1 + " and VIN = '" + rVin + "' and Pick_up_date = '" + pdate + "' and drop_off_date = '" + ddate + "'"; 
          //System.out.println(getRID);
           result = s.executeQuery(getRID);
          result.next();
          String rid1  = result.getString("rental_id");
           String charges = "insert into Charges(Rental_ID,Child_Seat,Insurance,Radio,Navigation) Values (" + rid1 +"," + cscost + ", " + insurance + "," + radcost +", " + navcost + ")" ;
           result1 = s.executeUpdate(charges);
         
          }
          catch(Exception e)
          {
              System.out.println("error with processing your rental, Sorry! Please Try again");
          //e.printStackTrace();
          }
         
        
           System.out.println("Thank you for your choosing Hurts Rent-A-Lemon Car Company.");
           System.out.println();
           System.out.println("If you would like to make any changes to your rental, Please contact a Hurts Reservation Manager");
           con.close();
           System.exit(0);
          }//END OF MAKE RENTAL
          else if(rdec.equals("2"))
          {
              
              System.out.println("Excellent Let's Look at the Customers");
              displayCustomers(s);
             
              System.out.println("Would you like to Add, Delete, or Update a Customer");
              System.out.println("1. Add Customer");
              System.out.println("2. Delete Customer");
              System.out.println("3. Update Customer");
              System.out.println("4. EXIT");
              String cdec = input.nextLine();
              
              if(cdec.equals("1"))
              {
                  
                   while(flag13 == true)
             {
             while(flag4 ==true)
             {
       
             System.out.println("Please enter your First Name ");
             fname = input.nextLine();
             if(!((validateS(20,fname)== true) && (isAlpha(fname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             
             }
             else
             {
                 flag4=false;
             }
             }
             
             while(flag6 == true)
             {
             System.out.println("Please enter your Last Name ");
             lname = input.nextLine();
             if(!((validateS(20,lname)== true) && (isAlpha(lname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             }
              else
             {
                 flag6=false;
             }
             }
             
             while(flag7 == true)
             {
             System.out.println("Please enter your Street Address");
             street = input.nextLine();
             if(!(validateS(40,street)==true))
             {
              System.out.println("Invalid Input: Enter a street address less than 40 characters ");
             }
             else
             {
             flag7=false;
             }
             }
             
             
             while(flag8 == true)
             {
             System.out.println("Please enter your City");
             city = input.nextLine();
               if((validateS(20,city)== false) || (city.matches(".*\\d+.*")==true))
               {
                   System.out.println("Invalid Input: Enter a city lass than or equal to 20 characters with no numbers");
               }
               else
               {
                   flag8 = false;
               }
             }
             while(flag9 == true)
             {   
             System.out.println("Please enter your State in abreviated form (i.e. New Jersey = NJ)");
             state = input.nextLine();
             if(!((state.length()==2)&&(isAlpha(state)==true)))
             {
              System.out.println("Invalid Input: Please enter letters only and your state in abreviated form");
             }
             else
             {
             flag9 = false;
             }
             }
             
             
             while(flag10 == true)
             {
              System.out.println("Please enter a Corporate ID if you have one. If you do not have a Corporate ID associated with a discount, Please enter 0 ");
              cid1 = input.nextLine();
              if(cid1.equals("0"))
              {
                  flag10 = false;
                  break;
              }
              String corp = "Select corporate_id from discounts";
              result = s.executeQuery(corp);
              result.next();
                while(result.next())
               {
                   String res = Integer.toString(result.getInt("corporate_id"));
                   if(cid1.equals(res))
                   {
                       flag10 = false;
                       break;
                   }
                   else
                   {
                     flag10 = true;
                   }
               }
                if(flag10==false)
                {
                    System.out.println("SUCCESSS");
                }
                else
                {
                    System.out.println("Invalid Input: Enter valid Corporate_ID");
                }
              
             }
             
             
             while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                dl = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
                if(dl.length()!= 10 || !(dl.matches("[0-9.]*")==true) )
                {
                    System.out.println("Invalid Input: Please enter a valid Driver's License Number of 10 digits");
                }
                else
                {
                flag11 = false;
                }  
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(dl.equals(result.getString("dl_number")))
                {
                    flag11 = true;
                    System.out.println("Error: DL_Number already registered with other user");
                    System.out.println("Enter 1 to try again or Enter 2 to quit");
                    while(flaga== true)
                    {
                    String ch = input.nextLine();
                    if(ch.equals("1"))
                    {
                        flaga = false;
                    }
                    else if(ch.equals("2"))
                    {
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Please enter 1 or 2");
                    }
                    }
                    break;
                }
                } //END OF CHECK IF EXIST
             } // End of validate DL
          System.out.println("Congrats! You have succesfully filled out all of the information we need");
          System.out.println("Before we continue, Please confirm the information you have just entered");
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("First Name: " + fname);
          System.out.println("Last Name: " + lname);
          System.out.println("Street: " + street);
          System.out.println("City: " + city);
          System.out.println("State: " + state);
          System.out.println("Driver's License Number: " + dl);
          System.out.println("Corporate ID: " + cid1);
          
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("If information is correct, Enter 'yes', otherwise enter 'no'");
          flag5=true;
        while(flag5 == true)
        {
            String val = input.nextLine();
        
        if(val.equalsIgnoreCase("yes"))
          {
         flag5 = false;     //continue
         flag13 = false;
          }
          else if(val.equalsIgnoreCase("no"))
          {
              flag5 = false;
              System.out.println("What parts incorrect?");
              
              System.out.println("1. First Name");
              System.out.println("2. Last Name");
              System.out.println("3. Street");
              System.out.println("4. City");
              System.out.println("5. State");
              System.out.println("6. Driver's License number");
              System.out.println("7. Corporate ID");
              System.out.println("8. UPDATE ALL");
              flag12= true;
              while(flag12 == true)
              {
              System.out.println("Please enter a number 1 to 8 to update a given field");
              
              String in = input.nextLine();
              if(containsOnlyNumbers(in))
              {
              tmp = Integer.parseInt(in);
              if(tmp >=1 && tmp <= 8)
              {
               flag12 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 7");
                flag12=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 7");
                  flag12 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag4 = true;
                          break;
                      case 2:
                          flag6 = true;
                          break;
                      case 3:
                          flag7 = true;
                          break;
                      case 4:
                          flag8 = true;
                          break;
                      case 5:
                          flag9 = true;
                          break;
                      case 6:
                          flag11 = true;
                          break;
                      case 7:
                          flag10 = true;
                          break;
                      case 8:
                          flag4 = true;
                          flag6= true;
                          flag7=true;
                          flag8=true;
                          flag9=true;
                          flag10=true;
                          flag11 =true;
                          break;
              }
          }
        
          else
          {
              System.out.println("Invalid Input: Enter yes if infomration is correct and no if otherwise");
          }
        } 
         
             //System.out.println("Information ready....");
             dln = Long.parseLong(dl);
             cid = Integer.parseInt(cid1);
             if(cid!=0)
             {
            add = ("INSERT INTO CUSTOMER(First_name,Last_name,Address, City,State,Corporate_id,DL_number) VALUES('" + fname +"','"+lname +"','"+street +"','"+city +"','"+state +"',"+cid +","+dln + ")");
             }
             else
             {
             add = ("INSERT INTO CUSTOMER(First_name,Last_name,Address, City,State,DL_number) VALUES('" + fname +"','"+lname +"','"+street +"','"+city +"','"+state +"',"+dln + ")");    
             }
           
         }//END FLag 13
                     try
             {
             result1 = s.executeUpdate(add);
             }
             catch(Exception e)
             {
           System.out.println("ERROR ADDING CUSTOMER");
           con.close();
           System.exit(0);
             }
                     System.out.println();
                     System.out.println();
                     System.out.println("Succesfully Added Customer!");
                     
             con.close();
             System.exit(0);
              } //END ADD CUSTOMER
              else if(cdec.equals("2"))//BEG DELETE CUStomer
              {
                        
                  while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                dl = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
               
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(dl.equals(result.getString("dl_number")))
                {
                    flag11 = false;
                    break;
                }
                } //END OF CHECK IF EXIST
                if(flag11==true)
                {
                    System.out.println("DL_Number entered does not exist");
                }
             } // End of validate DL
               String delete = "Delete from customer where dl_number = " + dl;         
               try
               {
               result1 = s.executeUpdate(delete);
               }
               catch(Exception e)
               {
                   System.out.println("ERROR DELETING CUSTOMER");
               }
               System.out.println();
               System.out.println("Succesfully Deleted!");
               con.close();
               System.exit(0);
              }//END Delete customer
              
              
              
              else if(cdec.equals("3"))//BEG UPDATE CUstomer
              {
             
                  while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                dl = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
               
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(dl.equals(result.getString("dl_number")))
                {
                    flag11 = false;
                    break;
                }
                } //END OF CHECK IF EXIST
                if(flag11==true)
                {
                    System.out.println("DL_Number entered does not exist");
                }
             } // End of validate DL
                  
                  
            System.out.println("This is the customer your would like to update");
            System.out.println();
            System.out.println();
            
            String regis = "SELECT * FROM CUSTOMER WHERE DL_number = " + dl;
                   result = s.executeQuery(regis);
                   result.next();
                   String tfname = "First Name";
                   String tlname = "Last Name";
                   String tstreet = "Street";
                   String tcity = "City";
                   String tstate = "State";
                   String tdln = "DL_number";  
                   String tcid = "Corporate_ID";
                System.out.format("%10s %10s %20s %20s %2s \t %10s %5s\n",tfname,tlname,tstreet,tcity,tstate, tdln, tcid );
                  do
                   {
                   fname = result.getString("First_Name");
                   lname = result.getString("Last_Name");
                   street = result.getString("Address");
                    city = result.getString("City");
                    state = result.getString("State");
                   dln = result.getLong("DL_number");  
                    cid = result.getInt("Corporate_ID");
                       System.out.format("%10s %10s \t %20s %20s %2s \t %10d %5d\n ",fname,lname,street,city,state, dln, cid );
                   }while(result.next());   
                  
                  System.out.println();
                  System.out.println();
                  System.out.println("What would you like to update?");
              System.out.println("1. First Name");
              System.out.println("2. Last Name");
              System.out.println("3. Street");
              System.out.println("4. City");
              System.out.println("5. State");
              System.out.println("6. Driver's License number");
              System.out.println("7. Corporate ID");
              System.out.println("8. UPDATE ALL");
              flag12= true;
              while(flag12 == true)
              {
              System.out.println("Please enter a number 1 to 8 to update a given field");
              
              String in = input.nextLine();
              if(containsOnlyNumbers(in))
              {
              tmp = Integer.parseInt(in);
              if(tmp >=1 && tmp <= 8)
              {
               flag12 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 8");
                flag12=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 8");
                  flag12 = true;
              }
              }
              String update5 = null;
              switch(tmp)
              {
                      case 1:
                        while(flag4 ==true)
             {
       
             System.out.println("Please enter your First Name ");
             fname = input.nextLine();
             if(!((validateS(20,fname)== true) && (isAlpha(fname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             
             }
             else
             {
                 flag4=false;
             }
             }
                   update5 = "Update Customer Set First_name = '"+fname + "' where dl_number =" +dl;     
                          break;
                      case 2:
                         while(flag6 == true)
             {
             System.out.println("Please enter your Last Name ");
             lname = input.nextLine();
             if(!((validateS(20,lname)== true) && (isAlpha(lname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             }
              else
             {
                 flag6=false;
             }
             }
                         update5 = "Update Customer Set Last_name = '"+lname + "' where dl_number =" +dl;     
                         break;
                      case 3:
                         while(flag7 == true)
             {
             System.out.println("Please enter your Street Address");
             street = input.nextLine();
             if(!(validateS(40,street)==true))
             {
              System.out.println("Invalid Input: Enter a street address less than 40 characters ");
             }
             else
             {
             flag7=false;
             }
             }
                         update5 = "Update Customer Set Address = '"+street + "' where dl_number =" +dl;     
                         break;
                      case 4:
                        while(flag8 == true)
             {
             System.out.println("Please enter your City");
             city = input.nextLine();
               if((validateS(20,city)== false) || (city.matches(".*\\d+.*")==true))
               {
                   System.out.println("Invalid Input: Enter a city lass than or equal to 20 characters with no numbers");
               }
               else
               {
                   flag8 = false;
               }
             }
                         update5 = "Update Customer Set City = '"+city + "' where dl_number =" +dl;     
                          break;
                      case 5:
                          while(flag9 == true)
             {   
             System.out.println("Please enter your State in abreviated form (i.e. New Jersey = NJ)");
             state = input.nextLine();
             if(!((state.length()==2)&&(isAlpha(state)==true)))
             {
              System.out.println("Invalid Input: Please enter letters only and your state in abreviated form");
             }
             else
             {
             flag9 = false;
             }
             }
                           update5 = "Update Customer Set State = '"+state + "' where dl_number =" +dl;     
                          break;
                      case 6:
                          String newDL = null;
                        while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                newDL = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
                if(newDL.length()!= 10 || !(newDL.matches("[0-9.]*")==true) )
                {
                    System.out.println("Invalid Input: Please enter a valid Driver's License Number of 10 digits");
                }
                else
                {
                flag11 = false;
                }  
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(newDL.equals(result.getString("dl_number")))
                {
                    flag11 = true;
                    System.out.println("Error: DL_Number already registered with other user");
                    System.out.println("Enter 1 to try again or Enter 2 to quit");
                    while(flaga== true)
                    {
                    String ch = input.nextLine();
                    if(ch.equals("1"))
                    {
                        flaga = false;
                    }
                    else if(ch.equals("2"))
                    {
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Please enter 1 or 2");
                    }
                    }
                    break;
                }
                } //END OF CHECK IF EXIST
             } // End of validate DL
                         update5 = "Update Customer Set DL_number =" + newDL + "' where dl_number =" +dl;     
                          break;
                      case 7:
                       while(flag10 == true)
             {
              System.out.println("Please enter a Corporate ID if you have one. If you do not have a Corporate ID associated with a discount, Please enter 0 ");
              cid1 = input.nextLine();
              if(cid1.equals("0"))
              {
                  flag10 = false;
                  break;
              }
              String corp = "Select corporate_id from discounts";
              result = s.executeQuery(corp);
              result.next();
                while(result.next())
               {
                   String res = Integer.toString(result.getInt("corporate_id"));
                   if(cid1.equals(res))
                   {
                       flag10 = false;
                       break;
                   }
                   else
                   {
                     flag10 = true;
                   }
               }
                if(flag10==false)
                {
                    System.out.println("SUCCESSS");
                }
                else
                {
                    System.out.println("Invalid Input: Enter valid Corporate_ID");
                }
              
             }
                       if(!cid1.equals("0"))
                       {
                        update5 = "Update Customer Set Corporate_ID = "+cid1 + " where dl_number =" +dl;     
                       }
                       else
                       {
                           update5 = "Update Customer Set Corporate_ID = null where dl_number =" +dl;      
                       }
                        break;
                      case 8:
                           newDL =null;
                       while(flag13 == true)
             {
             while(flag4 ==true)
             {
       
             System.out.println("Please enter your First Name ");
             fname = input.nextLine();
             if(!((validateS(20,fname)== true) && (isAlpha(fname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             
             }
             else
             {
                 flag4=false;
             }
             }
             
             while(flag6 == true)
             {
             System.out.println("Please enter your Last Name ");
             lname = input.nextLine();
             if(!((validateS(20,lname)== true) && (isAlpha(lname)==true)) )
             {
              System.out.println("Invalid Input: Please enter letters only and a name less than or equal to 20 characters");   
             }
              else
             {
                 flag6=false;
             }
             }
             
             while(flag7 == true)
             {
             System.out.println("Please enter your Street Address");
             street = input.nextLine();
             if(!(validateS(40,street)==true))
             {
              System.out.println("Invalid Input: Enter a street address less than 40 characters ");
             }
             else
             {
             flag7=false;
             }
             }
             
             
             while(flag8 == true)
             {
             System.out.println("Please enter your City");
             city = input.nextLine();
               if((validateS(20,city)== false) || (city.matches(".*\\d+.*")==true))
               {
                   System.out.println("Invalid Input: Enter a city lass than or equal to 20 characters with no numbers");
               }
               else
               {
                   flag8 = false;
               }
             }
             while(flag9 == true)
             {   
             System.out.println("Please enter your State in abreviated form (i.e. New Jersey = NJ)");
             state = input.nextLine();
             if(!((state.length()==2)&&(isAlpha(state)==true)))
             {
              System.out.println("Invalid Input: Please enter letters only and your state in abreviated form");
             }
             else
             {
             flag9 = false;
             }
             }
             
             
             while(flag10 == true)
             {
              System.out.println("Please enter a Corporate ID if you have one. If you do not have a Corporate ID associated with a discount, Please enter 0 ");
              cid1 = input.nextLine();
              if(cid1.equals("0"))
              {
                  flag10 = false;
                  break;
              }
              String corp = "Select corporate_id from discounts";
              result = s.executeQuery(corp);
              result.next();
                while(result.next())
               {
                   String res = Integer.toString(result.getInt("corporate_id"));
                   if(cid1.equals(res))
                   {
                       flag10 = false;
                       break;
                   }
                   else
                   {
                     flag10 = true;
                   }
               }
                if(flag10==false)
                {
                    System.out.println("SUCCESSS");
                }
                else
                {
                    System.out.println("Invalid Input: Enter valid Corporate_ID");
                }
              
             }
             
             
             while(flag11 ==true)//ENTER DL
             {
                System.out.println("Please enter your Driver's License Number");
                newDL = input.nextLine();
                String dlexists = "select dl_number from customer";
                result = s.executeQuery(dlexists);
                
                if(newDL.length()!= 10 || !(newDL.matches("[0-9.]*")==true) )
                {
                    System.out.println("Invalid Input: Please enter a valid Driver's License Number of 10 digits");
                }
                else
                {
                flag11 = false;
                }  
                
                while(result.next()) //CHECK IF DL EXISTS
                {
                    
                if(newDL.equals(result.getString("dl_number")))
                {
                    flag11 = true;
                    System.out.println("Error: DL_Number already registered with other user");
                    System.out.println("Enter 1 to try again or Enter 2 to quit");
                    while(flaga== true)
                    {
                    String ch = input.nextLine();
                    if(ch.equals("1"))
                    {
                        flaga = false;
                    }
                    else if(ch.equals("2"))
                    {
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Please enter 1 or 2");
                    }
                    }
                    break;
                }
                } //END OF CHECK IF EXIST
             } // End of validate DL
          System.out.println("Congrats! You have succesfully filled out all of the information we need");
          System.out.println("Before we continue, Please confirm the information you have just entered");
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("First Name: " + fname);
          System.out.println("Last Name: " + lname);
          System.out.println("Street: " + street);
          System.out.println("City: " + city);
          System.out.println("State: " + state);
          System.out.println("Driver's License Number: " + dl);
          System.out.println("Corporate ID: " + cid1);
          
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("If information is correct, Enter 'yes', otherwise enter 'no'");
          flag5=true;
        while(flag5 == true)
        {
            String val = input.nextLine();
        
        if(val.equalsIgnoreCase("yes"))
          {
         flag5 = false;     //continue
         flag13 = false;
          }
          else if(val.equalsIgnoreCase("no"))
          {
              flag5 = false;
              System.out.println("What parts incorrect?");
              System.out.println("1. First Name");
              System.out.println("2. Last Name");
              System.out.println("3. Street");
              System.out.println("4. City");
              System.out.println("5. State");
              System.out.println("6. Driver's License number");
              System.out.println("7. Corporate ID");
              System.out.println("8. UPDATE ALL");
              flag12= true;
              while(flag12 == true)
              {
              System.out.println("Please enter a number 1 to 8 to update a given field");
              
              String in = input.nextLine();
              if(containsOnlyNumbers(in))
              {
              tmp = Integer.parseInt(in);
              if(tmp >=1 && tmp <= 8)
              {
               flag12 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 8");
                flag12=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 8");
                  flag12 = true;
              }
              }
              
              switch(tmp)
              {
                      case 1:
                          flag4 = true;
                          break;
                      case 2:
                          flag6 = true;
                          break;
                      case 3:
                          flag7 = true;
                          break;
                      case 4:
                          flag8 = true;
                          break;
                      case 5:
                          flag9 = true;
                          break;
                      case 6:
                          flag11 = true;
                          break;
                      case 7:
                          flag10 = true;
                          break;
                      case 8:
                          flag4 = true;
                          flag6= true;
                          flag7=true;
                          flag8=true;
                          flag9=true;
                          flag10=true;
                          flag11 =true;
                          break;
              }
          }//END OF NO CONFIRMATION
          else
          {
              System.out.println("Invalid Input: Enter yes if infomration is correct and no if otherwise");
          }
        } 
         
         //    System.out.println("Information ready....");
         
         }
                       update5 = "Update Customer Set first_name = '" + fname +"', last_name = '" +lname +"', DL_number = "+newDL + ", Address = '"+ street +"', City = '"+ city +"', State = '" + state + "', Corporate_ID = "+cid1;
                          break;
              }
              
              try
              {
                  System.out.println(update5);
             result1 = s.executeUpdate(update5);     
              }
              catch(Exception e)
              {
            //      e.printStackTrace();
                  System.out.println("Error Updating");
              }
             System.out.println();
             System.out.println("Success! You have succesfully updated Customer");  
             con.close();
             System.exit(0);
              }
              else if(cdec.equals("4"))//EXIT
              {
                  con.close();
                  System.exit(0);
              }
              else
              {
                  System.out.println("Error: Enter a number 1 -4");
              }
          } //END OF VIEW/UPDATE CUSTOMER
             else if(rdec.equals("3"))
          {
              
              System.out.println("Excellent Let's Look at the Rentals");
              displayRentals(s);
              
              System.out.println("Would you like to Delete or Update a Rental");
         
              System.out.println("1. Delete Rental");
              System.out.println("2. Update Rental");
              System.out.println("3. EXIT");
              while(flag31 == true)
              {
              String rrdec = input.nextLine();
              
              if(rrdec.equals("1"))
              {
                  System.out.println("Enter Rental_ID to delete rental");
                  while(flag32 == true)
                  {
                  String rid = input.nextLine();
                  if(rentalExists(rid,s))
                  {
                      String deleteR = "Delete from Rental where rental_id = " + rid;
                      String deleteC = "Delete from Charges where rental_id = " +rid;
                   int result25 = 0;
                      result25 = p.executeUpdate(deleteC);
                      result1 = s.executeUpdate(deleteR);
                     
                 
                      if(result1==1 && result25 ==1)
                      {
                          System.out.println();
                          System.out.println("Succesfully Deleted");
                          con.close();
                          System.exit(0);
                      }
                      else
                      {
                          System.out.println("ERROR: Unable to delete rental");
                          con.close();
                          System.exit(0);
                      }
                  }
                  else
                  {
                      System.out.println("Error: Enter a valid rental Please");
                  }
                  }
              } //END DELETE RENTAL
              else if(rrdec.equals("2"))//BEG UPDATE RENTAL
              { 
                System.out.println("Enter Rental_ID to update rental");
                String rid = input.nextLine();
                if(rentalExists(rid,s))
                {
                    if(futureRental(rid,s))
                    {
                 
                        updateRental(rid,s,p,q,input);
                        con.close();
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Rental Entered has past or is in transit");
                          System.out.println("Would you like to Delete or Update a Rental\n" +
"1. Delete Rental\n" +
"2. Update Rental\n" +
"3. EXIT");
                    }
                }
                else
                {
                    System.out.println("Rental does not exist.");
                    System.out.println("Would you like to Delete or Update a Rental\n" +
"1. Delete Rental\n" +
"2. Update Rental\n" +
"3. EXIT");
                }
                  }
              //END UPDATE RENTAL
              else if(rrdec.equals("3"))
              {
                  con.close();
                  System.exit(0);
              }
              else
              {
                  System.out.println("Error enter 1 to 3");
              }
            }
          }//END DELETE/UPDATE RENTAL 
             else if(rdec.equals("4"))//BEGIN PROCESS RETURN
          {
              System.out.println("Excellent Let's Process this Return");
              System.out.println("Enter associated Rental_ID");
              String rid = input.nextLine();
              if(rentalExists(rid,s))
              {
                  
                  if(canReturn(rid,s))
                  {
                
                      boolean test=true;
                      boolean test1 = true;
                      String fuel = null;
                      String offset = null;
                      while(test == true)
                      {
                    System.out.println("Enter Fuel charge");
                    fuel = input.nextLine();
                    if(containsOnlyNumbers(fuel) && fuel.length()<=2 && fuel.length()>=1)
                    {
                       test = false; 
                      }
                    else
                    {
                        System.out.println("Enter a number only");
                      }
                      }
                      while(test1 == true)
                      {
                    System.out.println("Enter carbon off set charge");
                     offset= input.nextLine();
                    if(containsOnlyNumbers(offset) && offset.length()<=2 && offset.length()>=1)
                    {
                       test1 = false; 
                      }
                    else
                    {
                        System.out.println("Enter a number only");
                      }
                      }
                  
                  String addFC = "Update charges Set fuel =  "+ fuel + ", Carbon_offset = " + offset + "where rental_id = " + rid;
                  result1 = s.executeUpdate(addFC);
                  generateInvoice(rid);
                  String upvin = "Update vehicle_info Set curr_location = (select drop_off_loc from rental where rental_id =" + rid +") Where Vin = (Select vin from rental where rental_id = " +rid +")";
                  result1 = s.executeUpdate(upvin);
                  System.out.println("VEHICLE RETURNED");
                    con.close();       
                    System.exit(0);
                    flag30 = false;
                  }
                  {
                      System.out.println("Vehicle is either in transit or has already been returned");
                  }
              }
              else
              {
                  System.out.println("Rental Does Not Exist");
              }
             
          }
          //END PROCESS RETURN
             else if(rdec.equals("5"))
          {
              con.close();
              System.exit(0);
          }
             else 
          {
              System.out.println("Error: Enter 1-5");
                      
          }
          }//END Rdec
           }//ENED RESERVATION MANAGER
           else if(manager.equals("2"))//BEGIN INVENTORY MANAGER
           {    man = false;
                System.out.println(" Welcome Inventory Manager ");
                System.out.println();
                
                while(flag15 == true) //INVENTORY DECISIONS
                {
                System.out.println("What would you like to do?");
                System.out.println("1. View Inventory by location");
                System.out.println("2. View Current Locaiton of a vehicle");
                System.out.println("3. Add a car to a Location");
                System.out.println("4. EXIT");
                System.out.println();
                System.out.println("Enter 1,2,3, or 4");
                String idec = input.nextLine();
                if(idec.equals("1"))
                {
                    flag15 = false;
                    System.out.println("Awesome! Let's View Some Rentals");
             
                    
                String locs= "Select * from Location Where state is not Null";
                result = s.executeQuery(locs);
                result.next();
             System.out.println("LOCATION ID        Street      City    State");
             
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             while(flag16==true) //ENTER LOCATION
             {
       
            int tmp2;
             while(flag17 == true)
             {
                 
             result = s.executeQuery(locs);
                 tmp2=0;
                 System.out.println("Please enter a location_ID above");
                 plid1 = input.nextLine();
            
                 while(result.next())
                {
                    
                 if(plid1.equals(result.getString("location_id")))
                     {
                  flag16 = false;
                  flag17 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  System.out.println(plid1);
                  break;
                    }
                 else
                 {
                     tmp2 = 1;
                 }
               }
             if(tmp2 ==1)
             {
                 System.out.println("Error: Enter valid id");
             }
             }
             
             System.out.println(plid1);
             
             String vloc = "Select vin from vehicle_info where curr_location =" + plid1;
             result = s.executeQuery(vloc);
             System.out.println("");
           
             if(!(result.next()))
             {
                 flag16 = true;
                 flag17 = true;
                 System.out.println(" Sorry! No current vehicles at this location");
                 continue;
             }
             else
             {
                String atl = "Select * from vehicle_info natural join vehicle_type where curr_location = " +plid1;
                result = s.executeQuery(atl);
                String vin1 = "VIN";
                String make1="Make";
                String model1 = "Model";
                String year1="Year";
                String type1 = "Type"; 
                System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
                result.next();
                 do
                 {
                     System.out.format("%20s %15s %7s %4s %12s\n", result.getString("VIN"), result.getString("Make"), result.getString("Model"), result.getString("year"), result.getString("type"));
                             
                 }while(result.next());
             }
             
                if(flag16 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             
                //END ENTER LOCATION
             String vchoice = null;
             flag18 = true;
             while(flag18 == true)
             {
                 String atl = "Select * from vehicle_info natural join vehicle_type where curr_location = " +plid1;
                 result = s.executeQuery(atl);
                 System.out.println("Enter VIN to view all rentals associated with that vehicle ");
                 vchoice = input.nextLine();
                 while(result.next())
                 {
                 if(vchoice.equals(result.getString("Vin")))
                 {
                     flag18 = false;
                    break;
                 }
           
                 }
               if(flag18 == true)
               {
                   System.out.println("Error: Select a vin from the list above");
               }
               else
               {
                   String hasRentals = "Select * from rental where vin = '" + vchoice + "'";
                   result = s.executeQuery(hasRentals);
                   
                   if(!result.next())
                   {
                       System.out.println("Vehicle has no associated rentals");
                      flag19 = true;
                       while(flag19 == true)
                       {
                       System.out.println("Enter 1 to try another vehicle at this location");
                       System.out.println("Enter 2 to view the inventory of a different location");
                       System.out.println("Enter 3 to EXIT");
                       String nextChoice = input.nextLine();
                           if(nextChoice.equals("1"))
                           {
                               flag18 = true;
                            
                               flag19 = false;
                           }
                           else if(nextChoice.equals("2"))
                                   {
                                       flag16 = true;
                                       flag17 = true;
                                       flag19 = false;
                                   }
                           else if(nextChoice.equals("3"))
                                   {
                                       con.close();
                                       System.exit(0);
                                   }
                           else
                           {
                               System.out.println("ERROR: ENTER 1,2, or 3");
                           }
                       }
                   }
                   else
                   {
                       System.out.format("%5s %17s %5s %5s %10s %10s","Rental ID", "VIN", "Pick up Location", "Drop off Location", "Pick up Date", "Drop off date");
                       System.out.println();
                       do
                       {
                       System.out.format("%5s %17s %5s %5s %10s %10s\n",result.getString("Rental_ID"),result.getString("VIN"), result.getString("pick_up_loc"), result.getString("Drop_off_loc"),result.getString("Pick_up_Date"), result.getString("Drop_off_date"));
                       }while(result.next());
                       flag19 = true;
                       while(flag19 == true)
                       {
                       System.out.println("Enter 1 to try another vehicle at this location");
                       System.out.println("Enter 2 to view the inventory of a different location");
                       System.out.println("Enter 3 to EXIT");
                       String nextChoice = input.nextLine();
                           if(nextChoice.equals("1"))
                           {
                      
                               flag18 = true;
                               flag19 = false;
                           }
                           else if(nextChoice.equals("2"))
                                   {
                                       flag16 = true;
                                       flag17 = true;
                                       flag19 = false;
                                   }
                           else if(nextChoice.equals("3"))
                                   {
                                       con.close();
                                       System.exit(0);
                                   }
                           else
                           {
                               System.out.println("ERROR: ENTER 1,2, or 3");
                           }
                       }
                   }
               }
             }
             }//END FLAG 16 ENTER LOCATION
            
             
                 
             }//end view inventory at location
                else if(idec.equals("2"))// view current location of vehicle
                {
                          flag15 = false;
                    System.out.println("Here are all registered Vehicles");

            String vehicles = "select * from vehicle_info natural join vehicle_type";
            String vin1 = "VIN";
            String make1="Make";
            String model1 = "Model";
            String year1="Year";
            String type1 = "Type";    
           
            //PRINT VEHICLES
           
           
           while(flag16==true)
           {
            System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
            result = s.executeQuery(vehicles);
            result.next();
            do
            {
            System.out.format("%20s %15s %7s %4s %12s\n", result.getString("Vin"),result.getString("Make"),result.getString("model"),result.getString("year"),result.getString("Type"));    
            }while(result.next());
           //END PRINT VEHICLES 
           System.out.println("Enter a VIN from the list above");
           String vchoice = input.nextLine();
           result= s.executeQuery(vehicles);
           
           while(result.next())
           {
           if(vchoice.equals(result.getString("VIN")))
           {
               flag16 = false;
               break;
           }
           }
           
           if(flag16==true)
           {
               System.out.println("Error: Enter a VIN from the list above");
           }
           else
           {
                String loc=null;
               String currLocation = "select curr_location from vehicle_info where vin = '" + vchoice + "'";
               result = s.executeQuery(currLocation);
               while(result.next())
               {
                  loc= result.getString("curr_location");
               }
               
               if(loc.equals("0"))
               {
                   System.out.println("The vehicle you entered is currently being rented");
                   flag28 = true;   
                   while(flag28 == true)
                {
                  System.out.println("View location of another vehicle or exit");
                  System.out.println("1. View location of another vehicle");
                  System.out.println("2. EXIT");
                  String nex1 = input.nextLine();
                  if(nex1.equals("1"))
                  {
                 flag28 = false;     
                 flag16 = true;
                  }
                  else if(nex1.equals("2"))
                  {
                      con.close();
                      System.exit(0);
                  }
                  else
                  {
                      System.out.println("Error: Enter 1 or 2");
                  }
                }  
               }
               else
               {
                   System.out.println("The car you have selected is at the following location:");
                   System.out.println();
                   String locationdetails = "select * from location where location_id = " + loc;
                   result2 = p.executeQuery(locationdetails);
                   result2.next();
                System.out.println("LOCATION ID        Street      City    State");
                    
                 int lid = result2.getInt("location_id");
                 String lstreet = result2.getString("Street");
                 String lcity = result2.getString("City");
                 String lstate = result2.getString("state");
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 System.out.println();
                  System.out.println();
                  flag28 = true;
                while(flag28 == true)
                {
                  System.out.println("View location of another vehicle or exit");
                  System.out.println("1. View location of another vehicle");
                  System.out.println("2. EXIT");
                  String nex1 = input.nextLine();
                  if(nex1.equals("1"))
                  {
                 flag28 = false;     
                 flag16 = true;
                  }
                  else if(nex1.equals("2"))
                  {
                      con.close();
                      System.exit(0);
                  }
                  else
                  {
                      System.out.println("Error: Enter 1 or 2");
                  }
                }  
               }//end of location of car at lcoation
               
           }//end location of car
           
           }//end flag16
            
            
            
            
            
                }// end view current location of vehicle
                 else if(idec.equals("3"))// Add Car
                {
                    while(flag30 == true)
                    {
                    flag15 = false;
                    System.out.println("Awesome! Let's Add a car");
                    flag16 = true;
                   while(flag16==true)
                   {
                   
                       while(flag17 == true)
                       {
                     System.out.println("Please enter the VIN");
                                          VIN = input.nextLine();
                     if(VIN.length()==17 && !(vinExists(VIN,s)))
                     {
                         flag17 = false;
                     }
                     else
                     {
                       System.out.println("Error: Enter a VIN exists or does not equal 17 characters");  
                     }
                       }
                  
                       while(flag18==true)
                       {
                    System.out.println("Please enter the Odomoter reading");
                 odometer = input.nextLine();
                    if(containsOnlyNumbers(odometer) && odometer.length()<= 6)
                    {
                    flag18=false;
                       }
                    else
                    {
                        System.out.println("Error: Enter a number less than or equal to 6 digits");
                    }
                       }
                       
                    while(flag19==true)
                    {
                    System.out.println("Please enter the Current Location ID");
                    currL = input.nextLine();
                    if(validLocation(currL,s))
                    {
                    flag19 = false;
                    }
                    else
                    {
                     System.out.println("Invalid Location try again");       
                    }
                    }
                    
                    while(flag20==true)
                    {
                    System.out.println("Please enter the Make");
                    Make = input.nextLine();
                    if(validateS(15,Make) && isAlpha(Make))
                    {
                         flag20 = false;
                    }
                    else
                    {
                        System.out.println("Error: Enter a make less than or equal to 15 letters");
                    }
                   
                    }
                    
                    while(flag21 == true)
                    {    
                    System.out.println("Please enter the Model");
                    Model = input.nextLine();
                    if(validateS(7,Model))
                    {
                        flag21 = false;
                    }
                    else
                    {
                        System.out.println("Error: Enter a valid Model less than or equal to 7 characters");
                    }
                    }
                   
                    while(flag22==true)
                    {
                    System.out.println("Please enter the Year");
                    Year = input.nextLine();
                    if(containsOnlyNumbers(Year) && Year.length()==4)
                     {
                         if(Integer.parseInt(Year)<2018)
                         {
                            flag22 = false;
                        }
                         else
                         {
                             System.out.println("Error: Enter a valid year");
                         }
                     }
                    else
                    {
                     System.out.println("Error: Enter a valid Year");   
                    }
                    }
                    
                    while(flag23==true)
                    {
                    System.out.println("Please enter the type");
                    Type= input.nextLine();
                    if(validateS(12,Type) && isAlpha(Type))
                    {
                    switch(Type)
                    {
                        case "Sport":
                             flag23 = false;
                          break;
                         case "Truck":
                              flag23 = false;
                          break;
                          case "Convertible":
                               flag23 = false;
                          break;
                          case "SUV":
                               flag23 = false;
                          break;
                          case "Sedan":
                               flag23 = false;
                          break;
                          case "Minivan":
                                flag23 = false;
                          break;
                          
                          default:
                              System.out.println("Error: Enter a valid type from the list below.");
                              System.out.println("Sedan");
                                 System.out.println("SUV");
                                    System.out.println("Minivan");
                                       System.out.println("Convertible");
                                          System.out.println("Truck");
                                             System.out.println("Sprt");
                    }     
                    }
                    else
                    {
                        System.out.println("Error: Enter a type less than or equal to 12 character");
                    }
                    }
                   
                    
                    System.out.println("Please confirm the information below before vehicle is added");
                    System.out.println("1. VIN: " + VIN);
                    System.out.println("2. Make: " + Make);
                    System.out.println("3. Model: " + Model);
                    System.out.println("4. Year: " + Year);
                    System.out.println("5. Type: " + Type);                    
                    System.out.println("6. Current Location: " + currL);
                    System.out.println("7. Odometer: " + odometer);
                    flag24 = true;
                    while(flag24==true)
                    {
                    System.out.println("Is the info above correct Yes or No?");
                    String doo = input.nextLine();
                    
                    if(doo.equalsIgnoreCase("yes"))
                    {
                     flag16 =false;
                     flag24 = false;   
                    }
                    else if(doo.equalsIgnoreCase("no"))
                    {
                    flag24 = false;
                    System.out.println("What part is incorrect? Enter the corresponding number to fix a certain field");   
                    System.out.println("1. VIN: ");
                    System.out.println("2. Make: " );
                    System.out.println("3. Model: ");
                    System.out.println("4. Year: " );
                    System.out.println("5. Type: " );                    
                    System.out.println("6. Current Location: ");
                    System.out.println("7. Odometer: ");
                    System.out.println("8. Update all");
                     
                    flag26 = true;
               
              while(flag26 == true)
              {
              System.out.println("Please enter a number 1 to 7 to update a given field");
              
              String update = input.nextLine();
              if(containsOnlyNumbers(update))
              {
              tmp = Integer.parseInt(update);
              if(tmp >=1 && tmp <= 8)
              {
               flag26 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 7");
                flag26=true;
              }
              }
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 7");
                  flag26 = true;
              }
              } // flag26 = true
              
               switch(tmp)
              {
                      case 1:
                          flag17 = true;
                          break;
                      case 2:
                          flag20 = true;
                          break;
                      case 3:
                          flag21 = true;
                          break;
                      case 4:
                          flag22 = true;
                          break;
                      case 5:
                          flag23 = true;
                          break;
                      case 6:
                          flag19 = true;
                          break;
                      case 7:
                          flag18 = true;
                          break;
                      case 8:
                          flag17 = true;
                          flag18 = true;
                          flag19 = true;
                          flag20 = true;
                          flag21 = true;
                          flag22 = true;
                          flag23 = true;
                          break;
                    }
              
                    
                    } //INFO ABOVE NOT VALID
                    else
                    {
                        System.out.println("Enter yes or no");
                    }
                    }
                    
                   }//END CONFIRMATION flag16
                 
                   System.out.println("Information Correct");
                   System.out.println(currL);
                   String addCarInfo = "Insert into vehicle_info (VIN,Odometer, Curr_location) Values( '" + VIN + "', " + odometer + ", " + currL +")";
                   String addCarDetails = "Insert into vehicle_type (VIN, Make, Model,Year, Type) Values( '"+ VIN + "', '" + Make + "','"+ Model + "', "+Year + ", '" + Type +"')";
                 // System.out.println(addCarDetails);
                   try{
                   result1 = s.executeUpdate(addCarInfo);
                   
                   result9 = s.executeUpdate(addCarDetails);
                    }
                   catch(Exception e)
                   {
                       System.out.println("error adding car");
                      // e.printStackTrace();
                   }
                   System.out.println("What's Next!");
                   flag29 = true;
                   while(flag29 == true)
                   {
                   System.out.println("1. Would you like to add another car?");
                   System.out.println("2. EXIT");
                   String nex4 = input.nextLine();
                   if(nex4.equals("1"))
                   {
                       flag29 = false;
                       flag30 = true;  
                       flag17 = true;
                       flag18 = true;
                       flag19 = true;
                       flag20 = true;
                       flag21 = true;
                       flag22 = true;
                   }
                   else if(nex4.equals("2"))
                   {
                       con.close();
                       System.exit(0);
                   }
                   else
                   {
                       System.out.println("Error: Enter 1 or 2");
                   }
                   }
                    }
                 }//END ADD CAR
                else if(idec.equals("4"))
                  {
                      con.close();
                    System.exit(0);         
                  }
                else
                 {
                     System.out.println("Invalid Input: Try again");
                 }
                } // END INVENTORY DECISIONS Flag15
           } //END INVENTORY Manager
           
           
           
           else if(manager.equals("3")) //FINANCIAL MANAGER
           {
                man = false;
                System.out.println(" Welcome Financial Manager ");
                System.out.println();
                System.out.println("Enter a number to exit or retrieve an invoice");
                System.out.println("1. Get Invoice");
                System.out.println("2. EXIT");
              while(flag20 == true)
              {
                String fdec = input.nextLine();
                
                if(fdec.equals("1"))
                {
                    flag20 = false;
                    
                    while(flag15 == true)
                    {
                    displayRentals(s);
                    System.out.println("Enter a rental ID above to get the associated invoice");
                    String rid= input.nextLine();
                    result = s.executeQuery("select * from rental");
                    result.next();
                    do
                    {
                        if(rid.equals(result.getString("rental_id")))
                        {
                            flag15 = false;
                            break;
                        }
                    }while(result.next());
                   
                    if(flag15==true)
                    {
                        System.out.println("Error: Entrer rental_id from list above");
                    }
                    else
                    {
                        generateInvoice(rid);
                        System.out.println("View another invoice or exit?");
                        System.out.println("1. View another invoice");
                        System.out.println("2. EXIT");
                        
                        while(flag26 == true)
                        {
                             String nex = input.nextLine();
                            if(nex.equals("1"))
                            {
                                flag15 = true;
                                break;
                            }
                            else if(nex.equals("2"))
                            {
                                con.close();
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Error: Enter 1 or 2");
                            }
                        }
                    }
                    }
                    
                    
                }
                else if(fdec.equals("2"))
                {
                    con.close();
                    System.exit(0);
                }
                else
                {
                    System.out.println("Error: Enter 1 or 2");
                }
                }
           }//END FINANCIAL MANAGER
           
           
           else if(manager.equals("4"))
           {
               con.close();
               
               System.exit(0);
           }
           else
           {
               System.out.println("Invalid Input: Please enter 1, 2, or 3 to decide what type of manager you are ");
           }
           
           }
           
           System.out.println("EXITING...");
           con.close();
           
         
           
           
           
           
           
           
           
           }//END EMPLOYEE
        
        
        
        con.close();
        
        } //End of try
	
	catch(Exception e)
	{   
	System.out.println("Invalid Username and/or Password: ");
        System.out.println("Would you like to try again or exit the program?");
        System.out.println("Press any key to try again or enter '1' to exit");
        String exit = input.nextLine();
       //e.printStackTrace();
        if(exit.equals("1"))
        {
            
            System.exit(0);
        }
        } // End Catch
        }
    }
    public static boolean vinExists(String vin, Statement s)
    {
        boolean flag = false;
        try
        {
            ResultSet r;
            r = s.executeQuery("Select vin from vehicle_info");
            r.next();
            do
            {
                if(vin.equals(r.getString("vin")))
                {
                    flag = true;
                }
                
            }while(r.next());
            return flag;
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
        return flag;
    }
    public static void updateRental(String rid, Statement s, Statement p, Statement q, Scanner input)
    {
        boolean flag16 = true;
        boolean flag26 = true;
        boolean flag29 = true;
        boolean flag23 = true;
        boolean flag22 = true;
        boolean flag21 = true;
        boolean flag24 = true;
        boolean flag31 = true;
        int navcost = 0;
                int cscost = 0;
        int radcost = 0;
        int insurance = 0;
        int tmp = 0;
        ResultSet r;
        ResultSet r1;
        ResultSet r2;
        int result1;
         String getCharge = "Select * from charges where rental_id = " + rid;
         String getInfo = "Select * from rental where rental_id = " + rid;
        
         try{     
             while(flag29 == true)
             {
        r = s.executeQuery(getInfo);
        r.next();
        r1 = p.executeQuery(getCharge);
             String vehicleInfo = "Select * from vehicle_info natural join vehicle_type where VIN = '"+r.getString("VIN") +"'";
        r2 = q.executeQuery(vehicleInfo);
     //   System.out.println("GETS HERE");
        //r.next();
        r1.next();
        r2.next();
              System.out.println("Before we complete your rental, Please confrim the following information");
              System.out.println("1. Pick Up Location: " + r.getString("pick_up_loc"));
              System.out.println("2. Drop Off Location: " + r.getString("drop_off_loc"));
              System.out.println("3. Base Cost: " +  r.getString("Base_cost"));
              System.out.println(("4. Vehicle: " + r.getString("Vin") + " " + r2.getString("Make") + " " + r2.getString("Model") + " " + r2.getString("Year") + " " + r2.getString("Type")));
              System.out.println("5. Pick Up Date: " + r.getString("pick_up_date"));
              System.out.println("7. Drop Off Date: " + r.getString("Drop_off_date"));
              System.out.println("8. Insurance Charge: $" + r1.getString("Insurance"));
              System.out.println("9. Child Seat Charge: $" + r1.getString("Child_Seat"));
              System.out.println("10. Radio Charge: $" + r1.getString("Radio"));
              System.out.println("11. Navigation Charge: $" + r1.getString("Navigation"));

             System.out.println("Enter yes or Confrim the info above or no to update a field");
             flag31 = true;
             while(flag31 == true)
             {
             String conf = input.nextLine();
             if(conf.equalsIgnoreCase("yes"))
             {
             System.out.println("UPDATED");
             System.exit(0);
             }
             else if(conf.equalsIgnoreCase("no"))
             {
                 flag31 = false;
                 flag29 = true;
             }
             else
             {
                 System.out.println("ERROR: ENTER YES OR NO");
             }
             }
             System.out.println();
             System.out.println();
             System.out.println();
             System.out.println("Enter a number 1-5 to update the corresponding information");
                System.out.println();
                          
              System.out.println("1." );
              System.out.println("  - Pick Up Location");
              System.out.println("  - Drop Off Location" );
              System.out.println("  - Vehicle" );
              System.out.println("  - Pick Up Date");
              System.out.println("  - Drop Off Date" );
              System.out.println("2. Insurance Charge" );
           
              System.out.println("3. Radio Charge" );
                 System.out.println("4. Child Seat Charge");
              System.out.println("5. Navigation Charge" );
        
             flag26 = true;
              while(flag26 == true)
              {
                  
              System.out.println("Please enter a number 1 to 5 to update a given field");
              
              String updateL = input.nextLine();
            
              if(containsOnlyNumbers(updateL))
              {
              tmp = Integer.parseInt(updateL);
              if(tmp >=1 && tmp <= 5)
              {
               flag26 = false;   
              }
              else
              {
                System.out.println("Invalid Input: Enter a number 1 to 5");
                flag26=true;
              }
              }
              
              else
              {
                  System.out.println("Invalid Input: Enter a number 1 to 5");
                  flag26 = true;
              }
              
              }//END OF Update Field Choice
             
              String update=null;
              switch(tmp)
              {
                      case 1:
                      pldl( s, p, q, input);
                      update = "Update rental Set pick_up_loc = " + pl + ", drop_off_loc = " + dl + ", VIN = '"+ VINa +"', pick_up_date = '" +pd + "', drop_off_date = '"+dd+"' where Rental_id = "+rid; 
                      result1 = s.executeUpdate(update);
                      System.out.println(result1);
                      break;
                      case 2:
                          flag23 = true;
                         while(flag23 ==true)// Ask about insurance
             {
                 System.out.println("Will you require Insurance?");
                 System.out.println("Please enter yes or no.");
                 String ins = input.nextLine();
                 if(ins.equalsIgnoreCase("yes"))
                 {
                     flag23 = false;
                     insurance = 50;
                     System.out.println("Insurance Cost: $" + insurance);
                 }
                 else if(ins.equalsIgnoreCase("no"))
                 {
                     insurance = 0;
                     flag23 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
                 
                         update = "Update Charges Set Insurance = " +insurance +" where rental_id =" +rid;
                         result1 = s.executeUpdate(update);
                         System.out.println(result1);
                          break;
                      case 3:
                          flag22 = true;
                 while(flag22 ==true)//Ask about radio
             {
                 System.out.println("Will you require a radio?");
                 System.out.println("Please enter yes or no.");
                 String rad = input.nextLine();
                 if(rad.equalsIgnoreCase("yes"))
                 {
                     flag22 = false;
                     radcost = 30;
                     System.out.println("Radio Cost: $" + radcost);
                 }
                 else if(rad.equalsIgnoreCase("no"))
                 {
                     radcost = 0;
                     flag22 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
              update = "Update Charges Set Radio = " +radcost +" where rental_id =" +rid;
                         result1 = s.executeUpdate(update);
                         System.out.println(result1);
                          break;
                      case 4:
                          flag21 = true;
                           while(flag21 == true)//Ask about Child Seat
             {
                 System.out.println("Will you require a Child Seat for your rental?");
                  System.out.println("Please enter yes or no.");
                 String cs = input.nextLine();
                 if(cs.equalsIgnoreCase("yes"))
                 {
                     flag21 = false;
                     System.out.println("How many Child Seat's will you require?");
                     System.out.println("Note: The maximum is 3");
                     
                     try
                     {
                         int numcs = input.nextInt();
                         if(numcs>=1 && numcs <=3)
                         {
                             cscost = 10 * numcs;
                             input.nextLine();
                             System.out.println("Child Seat Cost: $" +cscost);
                         }
                         else
                         {
                            System.out.println("Error: Please enter a number 1 to 3");
                            input.nextLine();
                            flag21 = true;
                         }
                     }
                     catch(Exception e)
                     {
                         flag21 = true;
                         input.nextLine();
                         System.out.println("Error: Please enter a number 1 to 3");
                     }
                     
                 }
                 else if(cs.equalsIgnoreCase("no"))
                 {
                     cscost = 0;
                     flag21 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please Enter Yes/No");
                 }
             }
                            update = "Update Charges Set Child_seat = " +cscost +" where rental_id =" +rid;
                         result1 = s.executeUpdate(update);
                         System.out.println(result1);

                          break;
                     
                      
                      case 5:
                          flag24 = true;
                      while(flag24 == true) // Ask about navigation
             {
                 System.out.println("Will you require a Navigation System?");
                 System.out.println("Please enter yes or no.");
                 String nav = input.nextLine();
                 if(nav.equalsIgnoreCase("yes"))
                 {
                     flag24 = false;
                     navcost = 20;
                     System.out.println("Navigation Cost: $" + navcost);
                 }
                 else if(nav.equalsIgnoreCase("no"))
                 {
                     navcost = 0;
                     flag24 = false;
                 }
                 else
                 {
                     System.out.println("Invalid Input: Please enter Yes or No.");
                 }
             }
                       update = "Update Charges Set Navigation = " +navcost +" where rental_id =" +rid;
                         result1 = s.executeUpdate(update);
                         System.out.println(result1);
                      
                          break;
   
                    }
             
         }
         }
             
        catch(Exception e)
        {
         //   e.printStackTrace();
            System.out.println("ERROR UPDATING");
        }            
     }
           
    public static boolean futureRental(String rid, Statement s)
    {
        try
        {
            ResultSet r;
            String future = "select rental_id from rental where pick_up_Date>= current_date and rental_id ="+rid;
            r = s.executeQuery(future);
            if(!r.next())
            {
                return false;
            }
            else
            {
            return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
        return false;
    }
    public static boolean rentalExists(String rid, Statement s)
            {
                
                try
                {
                    ResultSet r;
                    r = s.executeQuery("Select rental_id from rental where rental_id = " + rid);
                    if(!r.next())
                    {
                     return false;       
                    }
                    else
                    {
                        return true;
                    }
                }
                catch(Exception e)
                {
                    return false;
                }
              
            }
    
    public static boolean isAlpha(String name) // Checks if given string has letters
  	{
    return name.matches("[a-zA-Z]+");
	}
	
      public static boolean containsOnlyNumbers(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i)))
        return false;
    }
    return true;
  }
    
    public static void displayRentals(Statement s)
    {
         try 
          
         {
             ResultSet r;
             r = s.executeQuery("Select * from rental");
             r.next();
           System.out.format("%5s %17s %5s %5s %10s %10s","Rental ID", "VIN", "Pick up Location", "Drop off Location", "Pick up Date", "Drop off date");
                       System.out.println();
                       do
                       {
                       System.out.format("%5s %17s %5s %5s %10s %10s\n",r.getString("Rental_ID"),r.getString("VIN"), r.getString("pick_up_loc"), r.getString("Drop_off_loc"),r.getString("Pick_up_Date"), r.getString("Drop_off_date"));
                       }while(r.next());
         }
         catch(Exception e)
         {
            //  e.printStackTrace();
             System.out.println("Error");
         }
    }
    
       public static void displayCustomers(Statement s)
    {
         try  
             
         {
             ResultSet r;
             r = s.executeQuery("Select * from Customer");
             r.next();
           System.out.format("%20s %20s %10s %35s %20s %5s %4s","First Name", "Last Name","DL Numver", "Street", "City", "State", "CID");
                       System.out.println();
                       do
                       {
                       System.out.format("%20s %20s %10s %35s %20s %5s %4s\n",r.getString("First_name"),r.getString("Last_Name"), r.getString("DL_number"),r.getString("Address"), r.getString("City"), r.getString("State"), r.getString("Corporate_ID"));
                       }while(r.next());
         }
         catch(Exception e)
         {
             // e.printStackTrace();
             System.out.println("Error");
         }
    }
      
    public static boolean validateS(int size, String info)
    {
        boolean result = false;
        if(info.length()<=size)
        {
            result = true;
        }
        return result;
    }
    
    public static boolean validLocation(String loc, Statement s)
    {
         boolean flag = true;
         try 
         {
            
             ResultSet result4;
             String locations = "Select location_id from location where state is not null";
             result4 = s.executeQuery(locations);
             while(result4.next())
             {
                 if(loc.equals(result4.getString("location_id")))
                 {
                     flag = true;
                 }
             }
             
         }
             catch(Exception e)
                     {
                     return false;
                     }
         return flag;
         
    }
 
   
    public static void pldl(Statement s, Statement p, Statement q, Scanner input)
    {
        try
        {
            int basecost =0;
            Date pdate1 = null;
            Date ddate1 =null;
        ResultSet result;
        ResultSet result2;
        ResultSet result3;
        boolean flag27 = true;
                boolean flag20 = true;
                boolean flag18 = true;
                boolean flag17 = true;
                boolean flag19 =true;
                boolean flag15 = true;
                boolean flag31 = true;
          while(flag27 == true) 
            {       //Pickup location
           
                while(flag15==true)
             {
             
             
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             System.out.println("LOCATION ID        Street      City    State");
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Please enter one of the Location ID's above to select your pick up locatoin");
             pl = input.nextLine();
             String lid2 = "Select Location_id from Location where location_id != 0";
             result = s.executeQuery(lid2);
        
             while(result.next())
                {
                 if(pl.equals(result.getString("location_id")))
                     {
                  flag15 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
              
                  break;
                    }
                }
             if(flag15 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //DROP OFF LOCATION
             while(flag18== true)
             {
            
             String locs= "Select * from Location Where state is not Null";
             result = s.executeQuery(locs);
             result.next();
             do
             {
                 int lid = result.getInt("location_id");
                 String lstreet = result.getString("Street");
                 String lcity = result.getString("City");
                 String lstate = result.getString("state");
                 
                 System.out.format("%4d  %30s %15s %2s\n", lid,lstreet,lcity,lstate);
                 
             }while(result.next());
             
             
             System.out.println("Enter one of the Location ID's above as your Drop off Location.");
             System.out.println("Note if you select a Drop off location different from the pick up location there will be a fixed drop-off charge of $100");
             dl = input.nextLine();
             String lid2 = "Select Location_id from Location";
             result = s.executeQuery(lid2);
             result.next();
             while(result.next())
                {
                 if(dl.equals(result.getString("location_id")))
                     {
                  flag18 = false;
                  flag27 = false;
                  System.out.println("Succeses! You have entered a valid Location ID");
                  if(dl.equals(pl))
                  {
                      int dropoffc = 0;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  else
                  {
                      int dropoffc = 100;
                      System.out.println("Dropoff Charge: $" + dropoffc);
                  }
                  break;
                    }
                }
             if(flag18 == true)
             {
                 System.out.println("Invalid Input: Enter a valid Location ID");
             }
             }
             
             //PICK UP DATE
             while(flag17 == true)
             {
              System.out.println("Please enter a Pick up date");
              System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
              pd = input.nextLine();
              DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
           
              Date current = new Date();
              try{
              pdate1 = formatter.parse(pd); 
             
              
              if(pdate1.compareTo(current)<0)
              {
                  System.out.println("Error: Date inputed has passed, Try again");
              }
              else
              {
                  flag27 = false;
                  flag17 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
              
             }
             
            //Drop off date
             while(flag19 == true)
             {
             System.out.println("Please enter a Dropoff date");
             System.out.println("Enter in format 'dd-MMM-yy' (i.e. 05-May-17)");
             dd = input.nextLine();
             DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            
              try{
              ddate1 = formatter.parse(dd); 
             
              
              if(ddate1.compareTo(pdate1)<=0)
              {
                  System.out.println("Error: Drop off date is before entered pick up date. Try again");
              }
              else
              {
                  flag27 = false;
                  flag19 = false;
              }
              }
              catch(ParseException e)
              {
              System.out.println("Sorry, that's not valid. Please try again.");
              }
             } 
             
            while(flag20 ==true)//Vehicle CHOICE
             {
           
            String avail = "Select * from vehicle_info natural join vehicle_type where curr_location =" + pl;
            result = s.executeQuery(avail);
            
            if(!(result.next()))
            {
                System.out.println("sorry no available cars at given pick_up location");
                break;
            }
            else
            {
                 System.out.println("Here are all the vehicles available from your desired pick up location");
            String vin1 = "VIN";
            String make1="Make";
            String model1 = "Model";
            String year1="Year";
            String type1 = "Type";
            System.out.format("%20s %15s %7s %4s %12s\n", vin1,make1,model1,year1,type1);
           
            do
            {
               String VINa1 = result.getString("VIN");
                String Makea1 = result.getString("Make");
                String Modela1 = result.getString("Model");
                String Yeara1 = result.getString("Year");
                String Typea1 = result.getString("Type");
                String exists = "Select vin from rental where vin = '" + VINa1 +"'";
                
                result2 = p.executeQuery(exists);
                
                if(!(result2.next()))
                  {
                      flag27 = false;
                       System.out.format("%20s %15s %7s %4s %12s\n", VINa1,Makea1,Modela1,Yeara1,Typea1);
                      continue;
                  }
                else
                {
                    
                    String availa = " Select * from rental where VIN = '" + VINa1 + "' and('" + pd + "' <drop_off_date and '" + dd +"' > pick_up_date)";
                    result3 = q.executeQuery(availa);
                    
                    if(result3.next())
                    {
                        if(flag31== false)
                        {
                            continue;
                        }
                       flag27 = true;
                       flag31 = true;
                       flag15 = true;
                       flag17= true;
                       flag18 = true;
                       flag19= true;
                      
                    }
                    else
                    {
                        do
                        {
                        System.out.format("%20s %15s %7s %4s %12s\n", VINa1,Makea1,Modela1,Yeara1,Typea1);
                       flag27 = false;
                       flag31 = false;
                       continue;
                    }while(result3.next());
                   }
                } //END OF CHECKING CARS IN RENTAL
            }while(result.next()); 
            
            } //END IF CARS ARE AT LOCATION
           
            if(flag31 == true)
            {
                System.out.println("No available cars at entered location during period requested");
              
                break;
            }
            
            
           System.out.println("Enter the VIN to choose your vehicle");
           VINa= input.nextLine();
           result = s.executeQuery(avail);
          
            while(result.next())
            {
                if(VINa.equals(result.getString("VIN")))
                {
                    System.out.println("Succesfully chosen valid VIN");
                    Makea = result.getString("Make");
                    Modela = result.getString("Model");
                    Yeara = result.getString("Year");
                    Typea = result.getString("Type");
                    switch(result.getString("Type"))
                    {
                        case "Sport":
                          basecost = 100;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                         case "Truck":
                          basecost = 90;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Convertible":
                          basecost = 110;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "SUV":
                          basecost = 80;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Sedan":
                          basecost = 70;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          case "Minivan":
                          basecost = 75;
                          System.out.println("Base Cost: $" + basecost);
                          break;
                          
                    }
                    System.out.println();
                    flag20 = false;
                    break;
                    
                }
            }
           
            //if vin does not exist in rental table contine
            //else check if it is availabe during dates
               // if not available; Ask if they would like to change dates or choose another vehicle
            if(flag20 == true)
            {
                System.out.println("Invalid VIN entered, Try again");
            }
           
             } // END OF VIN decision
            }
        }
        catch(Exception e)
        {
            
        }
    }
   
    public static void Customer(Scanner input, Connection con)
    {
          boolean flag = true;
         System.out.println("Welcome Customer!");
         System.out.println();
         System.out.println();
         System.out.println("Would you like to make a rental or Exit?");
         System.out.println("1. Make a rental");
         System.out.println("2. Exit");
         System.out.println("Enter 1  to Make a Rental, Enter 2 to exit");
         while(flag == true)
         {
         String m = input.nextLine();
         
         if(m.equals("1"))
         {
             flag = false;
           
         }
         else if(m.equals("2"))
         {
             flag = false;
             try
             {
             con.close();
             }
             catch(Exception e)
             {
                 System.out.println("Error:");
             }
             System.exit(0);
         }
         else
         {
             System.out.println("Invalid Input; Enter 1 to Make a rental and Enter 2 to exit ");
         }
         }
   
    }
    public static void generateInvoice(String rid)
    {
     
        try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar0.cse.lehigh.edu:1521:cse241",username,password);
         Statement s= con.createStatement();
         ) 
     {
       String rentalinfo = "Select * from rental natural join charges where rental_id = " + rid;
       ResultSet result;
       
       double invoice = 0;
       int fuel = 0;
       int co= 0;
       
       if(futureRental(rid,s))
       {
           co = 0;
           fuel = 0;
              result = s.executeQuery(rentalinfo);
           result.next();
       }
       else
       {
           result = s.executeQuery(rentalinfo);
           result.next(); 
             fuel = Integer.parseInt(result.getString("fuel"));
              co = Integer.parseInt(result.getString("Carbon_offset"));
       }
           int bcost = Integer.parseInt(result.getString("base_cost"));
     
       int cs = Integer.parseInt(result.getString("Child_seat"));
       int ins = Integer.parseInt(result.getString("Insurance"));
       int rad = Integer.parseInt(result.getString("Radio"));
       int nav = Integer.parseInt(result.getString("Navigation"));
      
       int dc = 0;
       String dl = result.getString("dl_number");

       int disc = 1;
       double disc1= 1;
       if(!(result.getString("pick_up_loc").equals(result.getString("drop_off_loc"))))
       {
           dc = 100;
       }
       
       result = s.executeQuery("Select Corporate_id, Percentage from customer natural join discounts where dl_number = " + dl);
      // result.next();
       
       if(result.next())
       {
           disc =Integer.parseInt(result.getString("Percentage"));
           disc1 = (double)disc / 100;
           disc1 = 1-disc1;
       }
      
       if(disc ==1)
       {
           invoice = bcost + fuel + cs + ins + rad + nav + co + dc;
       }
       else
       {
           invoice = disc1 * (bcost + fuel + cs + ins + rad + nav + co + dc);
       }
       System.out.println("Base Cost: $" +bcost);
       System.out.println("Drop Off Cost: $" +dc);
       System.out.println("Fuel Cost: $" +fuel);
       System.out.println("Carbon Offset Cost: $" +co);
       System.out.println("Child Seat Cost: $" + cs);
       System.out.println("Radio Cost: $" + rad);
       System.out.println("Insurance Cost: $" + ins);
       System.out.println("Navigation Cost: $" + nav);
       System.out.println("-------------------");
       System.out.println("TOTAL Cost: $" + invoice);
       
     }
     catch(Exception e)
     {
       //  e.printStackTrace();
         System.out.println("error");
     }
    }
    
    public static boolean canReturn(String rid, Statement s)
    {
        
        try
        {
              DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
              formatter.setLenient(false);
              Date current = new Date(); 
             
            java.sql.Date ddate = null;
              ResultSet r;
            
            LocalDate cdate = current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            String check ="Select * from rental where rental_id = " + rid;
            r = s.executeQuery(check);
            r.next();
            ddate = r.getDate("drop_off_date");
             LocalDate myDate = ddate.toLocalDate();
            
            if(myDate.equals(cdate))
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error in can return");
         //   e.printStackTrace();
        }
        return false;
    }
    
    public static void EorC(Scanner input)
    {
           boolean flag = true;
          System.out.println("Are you an Employee or Customer");
    while(flag==true)
    {
   String choice = input.nextLine();
    if(choice.equalsIgnoreCase("Employee"))
    {
     flag = false;   
     eorc=true;
    }
    else if(choice.equalsIgnoreCase("Customer"))
    {
     flag = false;
     eorc= false;
    }
    else
    {
        System.out.println("Invalid Choice; Please enter 'Customer' or 'Employee'");
    }
    }
    }
 
}
        
        
	
	