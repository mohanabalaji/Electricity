package Dbsample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Dbmain1
{
	
	static Scanner sn;
   static InputStreamReader r;   
	 static BufferedReader brr; 
	 static DBSample obj;
   
	
        
	
	public static void main(String[] args) throws IOException, SQLException 
	{
		

		
		
		r=new InputStreamReader(System.in);
		brr=new BufferedReader(r);
		obj = new DBSample();
		sn = new Scanner(System.in);
		
		System.out.println("Your Choices::");
		
		System.out.println("1. Reading");
		System.out.println("2. Display");
		System.out.println("3. Delete");
		System.out.println("4. exit");
		
		
		int choice =0;
		
		do {
			System.out.println("Please Enter ::");
			choice = sn.nextInt();
			switch (choice) {
			case 1:
				register();
				break;				
			case 2:
				Display();
				break;	
			case 3:
				Delete();
				break;	
			case 4:
				exit();
				break;

			default:
				break;
			}
		}while(choice!=4);
		
		System.out.println("Thanks for use");
		
	}
	

	
	



	







	public static void register() throws IOException 
	{
		
		System.out.println("Enter house no: ");
		int  houseno=Integer.parseInt(brr.readLine()); 
		System.out.println("Enter Name: ");
		String name = brr.readLine();
		System.out.println("Enter units :");
		int  units=Integer.parseInt(brr.readLine()); 
		
		 // check whether units are less than 100  
		 double billToPay=0; 
		
        if(units < 100)  
        {  
            billToPay = units * 1.20;  
        }  
        // check whether the units are less than 300  
        else if(units < 300){  
            billToPay = 100 * 1.20 + (units - 100) * 2.50;  
        }  
        // check whether the units are greater than 300  
        else if(units > 300)  
        {  
            billToPay = 100 * 1.20 + 200 * 2.50 + (units - 300) * 3;  
        }  
        System.out.println("The electricity bill for " +units+ " is : " + billToPay);   
        
		
		
		
		obj.insert( houseno , name, units , billToPay  );
		
	}
	
	private static void Display() throws IOException 
	{
		System.out.print("   Enter house number to Display: ");
		int  houseno=Integer.parseInt(brr.readLine()); 
        obj.select(houseno);
		
	}
	
	private static void Delete() throws IOException
	{
		System.out.print("   Enter house number to Delete: ");
		int  houseno=Integer.parseInt(brr.readLine()); 
        obj.delete(houseno);	
	}
	
	public static void exit()
	{
		System.exit(0);	
	}
	

}

