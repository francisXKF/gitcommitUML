package mySystem.WebBackground;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;
import java.sql.*;

@WebServlet("/login-judge")
public class loginJudge extends HttpServlet{
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
	        String.format("SELECT name FROM %s WHERE school_id = %s AND name = '%s' AND password = '%s'",
	        			tableName, userschoolID, username, password);
	      ResultSet resultSet = statement.executeQuery(query);
	      
	      if(resultSet != null && resultSet.next()){
	    	  transmessage = "Welcome " + resultSet.getString("name") + " visit";
	      }
	      else{
	    	  transmessage = "Not hava the user!";
	      }
	      connection.close();
	      request.setAttribute("transmessage", transmessage);
	      request.getRequestDispatcher("/JSP/welcome.jsp").forward(request, response);
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }  
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request, response);
	}

}
