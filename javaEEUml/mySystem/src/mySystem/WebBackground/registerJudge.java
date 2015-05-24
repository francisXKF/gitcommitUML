package mySystem.WebBackground;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.websocket.Session;

import java.util.*;
import java.sql.*;

@WebServlet("/register-judge")
public class registerJudge extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String protocol = "jdbc:mysql:";
		String dbusername = "root";
		String dbpassword = "";
		String dbName = "mysystem";
		String tableName = "userinfo";
		Properties userInfo = new Properties();
		String dbUrl = protocol + "//localhost:3306/" +
		                 dbName;
		

		userInfo.put("user", dbusername);
		userInfo.put("password", dbpassword);
		
		String userschoolID = request.getParameter("schoolID");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String transmessage = "";
		String transpage = "";
		
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
		        String.format("SELECT name FROM %s WHERE school_id = %s",
		        			tableName, userschoolID);
		      ResultSet resultSet = statement.executeQuery(query);
		      
		      if(resultSet != null && resultSet.next()){
		    	  transmessage = "This user name already exists !";
		    	  transpage = "/JSP/register.jsp";
		      }
		      else{
		    	  String template =
		  		        String.format("INSERT INTO %s(school_id, name, password, identify)VALUES(?, ?, ?, ?)",
		  		                      tableName);
		    	  PreparedStatement inserter = connection.prepareStatement(template);
		    	  try{
				      //inserter.setInt(1, users.getId());
				      inserter.setString(1, userschoolID);
				      inserter.setString(2, username);
				      inserter.setString(3, password);
				      inserter.setString(4, "student");
				      inserter.executeUpdate();
				      transmessage = "register success please login!";
				      transpage = "/JSP/login.jsp";
				  }
				  catch(Exception e){
					  transmessage = "register fail!";
					  transpage = "/JSP/register.jsp";
				   }
			      inserter.close();
		      }
		      connection.close();
		      request.setAttribute("transmessage", transmessage);
		      request.getRequestDispatcher(transpage).forward(request, response);
		} 
		catch (SQLException sqle) {
		      sqle.printStackTrace();
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request, response);
	}
}
