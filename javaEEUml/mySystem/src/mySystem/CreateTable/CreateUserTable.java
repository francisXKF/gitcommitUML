package mySystem.CreateTable;

import java.sql.*;
import java.util.*;

public class CreateUserTable {
	private String protocol = "jdbc:mysql:";
	private String username = "root";
	private String password = "";
	private String dbName = "mysystem";
	private String tableName = "userinfo";
	private Properties userInfo;
	private String dbUrl = protocol + "//localhost:3306/" +
	                 dbName;
	public CreateUserTable() {
	    userInfo = new Properties();
	    userInfo.put("user", username);
	    userInfo.put("password", password);
	  }
	public void createTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		User users = new User("201240703048", "francis", "123456", "admin");
		try {
		      Connection connection = 
		        DriverManager.getConnection(dbUrl, userInfo);
		      Statement statement = connection.createStatement();
		      String format = "VARCHAR(20)";
		      String tableDescription = 
		        String.format
		          ("CREATE TABLE %s" +
		              "(id INT(255) NOT NULL auto_increment, school_id %s unique, name %s, password %s, " +
		        		    "identify %s, PRIMARY KEY(id))",
		        	tableName, format, format, format, format);
		      try{
		      statement.execute(tableDescription);
		      }
		      catch(Exception e){
		    	  System.out.println(e);
		      }
		      String template =
		        String.format("INSERT INTO %s(school_id, name, password, identify)VALUES(?, ?, ?, ?)",
		                      tableName);
		      PreparedStatement inserter = 
		        connection.prepareStatement(template);
		      try{
		      //inserter.setInt(1, users.getId());
		      inserter.setString(1, users.getSchoolId());
		      inserter.setString(2, users.getName());
		      inserter.setString(3, users.getPassword());
		      inserter.setString(4, users.getIdentify());
		      inserter.executeUpdate();
		      }
		      catch(Exception e){
		    	  System.out.println("insert  " + e);
		      }
		      inserter.close();
		      connection.close();
		    } catch (SQLException sqle) {
		      // If table already exists, then skip everything else
		    }
	}
	
	public void showTable() {  
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	      Connection connection;
	      connection = DriverManager.getConnection(dbUrl, userInfo);
	      Statement statement = connection.createStatement();
	      String query =
	        String.format("SELECT * FROM %s", tableName);
	      ResultSet resultSet = statement.executeQuery(query);
	      while(resultSet.next()) {
	        int id = resultSet.getInt("id");
	        String school_id = resultSet.getString("school_id");
	        String name = resultSet.getString("name");
	        String password = resultSet.getString("password");
	        String identify = resultSet.getString("identify");
	        System.out.printf("%s %s %s (%s, id=%s)",
	                          school_id, name, password, identify, id);
	      }
	      connection.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }  
	  }
	
	public static void main(String[] args){
		CreateUserTable createuser = new CreateUserTable();
		createuser.createTable();
		createuser.showTable();
	}
}