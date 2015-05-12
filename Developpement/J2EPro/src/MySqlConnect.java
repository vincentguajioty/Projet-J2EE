import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public abstract class MySqlConnect
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://bdd.davanture.fr:3306/j2ee"; 
	
	//	Database credentials
	static final String DB_USER = "j2ee";  // username
	static final String DB_PASS = "projetEPSIj2ee"; // password
	
	static Connection connection = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static Boolean jdbcRegister()
	{
		System.out.println("-------- MySql JDBC Connection Testing ------\nRegistering...");
		
		try
		{
			Class.forName(JDBC_DRIVER); 
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Where is your MySql JDBC Driver?");
			e.printStackTrace();
			return false;
 
		}
 
		System.out.println("MySql JDBC Driver Registered!\n----------------------------------------------");
		return true;
	}
	
	public static Boolean connect()
	{
		System.out.println("Connecting...");
		try
		{
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		}
 
		if (connection != null)
		{
			System.out.println("You made it, take control your database now!");
			return true;
		}
		else
		{
			System.out.println("Failed to make connection!");
			return false;
		}
		
	}
	
	@SuppressWarnings("finally")
	public static ResultSet query(String sqlQuery)
	{
		ResultSet returnValue = null;
		//DefaultTableModel dtm = null;
		
		if(sqlQuery.length() == 0)
			return null;
		
		if( !jdbcRegister() )
			return null;
		
		if( !connect() )
			return null;
		
		try
		{
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = connection.createStatement();
			
			System.out.println("Querying...\n\t" + sqlQuery);
			rs = stmt.executeQuery(sqlQuery);
			// dtm = buildTableModel(rs);
			returnValue = rs;
		}
		catch(SQLException se)
		{
			System.out.print("SQLException...");
		    se.printStackTrace();	
		    returnValue = null;
		}
		finally
		{
			//STEP 6: Clean-up environment
			//disconnect();
			return returnValue;
		}
	}
	
	public static void disconnect()
	{
		try
		{
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close();
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
			    if(stmt != null)
				stmt.close();
			}
			catch(SQLException se2)
			{
			    if( se2.getErrorCode() != 1 )
			    {
					System.out.println("An error occured Jim... [" + Integer.toString( se2.getErrorCode() ) + "]");
					se2.printStackTrace();
			    }
			}// nothing we can do
			try
			{
			    if(connection!=null)
			    	connection.close();
			}
			catch(SQLException se)
			{
			    se.printStackTrace();
			}//end finally try
		}//end try

		System.out.println("Disconnected!");
	}
	
	/*
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException
	{
	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++)
	    {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next())
	    {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
	        {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
    	}

	    return new DefaultTableModel(data, columnNames);
	}
	*/
	
	public static void main(String[] argv)
	{
		if(connect())
			disconnect();
	}
}