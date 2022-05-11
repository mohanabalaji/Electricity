package Dbsample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db_connection.JDBC_Connection;

public class DBSample
{
	Connection obj;
	public DBSample() {
		obj = JDBC_Connection.db();
		}
	void insert(int houseno , String name , int units , double  billToPay)
	{
		
		
		try {
			PreparedStatement pd =obj.prepareStatement("Insert into test(houseno , name , units , billToPay ) values (?,?,?,?)");
			pd.setInt(1, houseno);
			pd.setString(2, name);
			pd.setInt(3, units);
			pd.setDouble(4, billToPay);
			
			int i = pd.executeUpdate();
			if(i>0) {
				System.out.println("successfully instered!");
			}
		}catch(Exception e) {
			System.out.println(e);
		} 
		
	}
	 void select(int houseno)
	{
		try
		{
		PreparedStatement pd =obj.prepareStatement("select * from test where houseno = '" +houseno+ "' ");
	    ResultSet rs = pd.executeQuery();    
		   
		  while (rs.next())    
		  {       
		   int a = rs.getInt(1);    
		   String  b= rs.getString(2);    
		   int c = rs.getInt(3);
		   String d= rs.getString(4);  
		   
		   System.out.println("Showing Details of House no: " +houseno);
			
		   System.out.println("   House number: " +a);  
		   System.out.println("   Owner name: " + b); 
		   System.out.println("   Units consumed: " +c); 
		   System.out.println("   Bill amount: " +d);
		  }  
		 			
		}catch(Exception e)
		{
			System.out.println(e);
		}	
	}
	public void delete(int houseno) 
	{
		try{
            String sql="delete from test where houseno =   '" +houseno+ "'  ";
             PreparedStatement p = obj.prepareStatement(sql);
             p.execute();
             
             int i = p.executeUpdate();
 			if(i==0) {
 				System.out.println("successfully deleted");
 			}
        }catch(SQLException  e){
            System.out.println(e);
             
        }	
	}

	


}
