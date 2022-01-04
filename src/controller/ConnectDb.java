package controller;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectDb {
	
	static Connection conn=null;
	public static Connection getConnection() 
	    {
	        
			try{
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("org.sqlite.JDBC");
				conn=DriverManager.getConnection("jdbc:sqlite:C:/Users/HP/Desktop/projet/javaProjet/pharmacie.db");
				//conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projejavaexo");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return conn;
	    }
	  
	     public static void closeStatement(Statement st)
	     {
	         try
	         {
	            
				if(conn !=null)
	             {
	                 st.close();
	             }
	         }
	         catch(SQLException e)
	         {
	             e.printStackTrace();
	         }
	     }
	    
	     public static void closeConnection(Connection conn)
	     {
	         try
	         {
	             if(conn !=null)
	             {
	                 conn.close();
	             }
	         }
	         catch(SQLException e)
	         {
	             e.printStackTrace();
	         }
	     }
	    public static void main(String []args)
	    {
	        Connection conn=null;
	        try
	        {
	        	
	        conn=ConnectDb.getConnection();
	        System.out.println("connection success");           
	        }
	        finally
	        {
	            ConnectDb.closeConnection(conn);
	        }
	                
	    }

}


