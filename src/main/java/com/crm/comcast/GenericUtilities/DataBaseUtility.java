package com.crm.comcast.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
/**
 * 
 * @author RJ
 *
 */
public class DataBaseUtility {
	static Driver driverref;
	static Connection connection; 
	static ResultSet result;
	/**
	 * method to make connection to Data base
	 * @param DBname
	 */
	public void connectionToDB(String DBname)
	{
		try {
			driverref=new Driver();
			DriverManager.registerDriver(driverref);
			connection=DriverManager.getConnection(IConstants.Dburl+DBname,IConstants.Dbusername,IConstants.Dbpassword);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	/**
	 * method to close the database
	 */
	public void closeDB() {
		try {
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * method to execute query in database
	 * @param Query
	 * @param columnNum
	 * @param expedtedData
	 * @return
	 * @throws SQLException
	 */
	public boolean executeQuery(String Query,int columnNum,String expedtedData) throws SQLException {
		result=connection.createStatement().executeQuery(Query);
		boolean flag = false;
		while(result.next()) 
		{
			if(result.getString(columnNum).equals(expedtedData)){
				flag=true;
				break;
			}
		}
			if(flag) {
				System.out.println("data is present");
				return flag;
			}
			else {
				System.out.println("data not present");
				return flag;
				
	}
		}
	
	/**
	 * method to execute an update into database	
	 * @param query
	 * @throws SQLException
	 */
	public void executeUpdateQuery(String query) throws SQLException {
		int res=connection.createStatement().executeUpdate(query);
		if(res==1) {
			System.out.println("data is updated");
		}
		else {
			System.out.println("data not updated");
		}
	}
}
