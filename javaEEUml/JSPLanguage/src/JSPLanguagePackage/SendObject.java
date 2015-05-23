package JSPLanguagePackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;

@WebServlet("/send-object")
public class SendObject extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		Name user1 = new Name("zhao", "yi");
		Name user2 = new Name("qian", "er");
		Name user3 = new Name("sun", "san");
		
		ArrayList user = new ArrayList();
		user.add(user1);
		user.add(user2);
		user.add(user3);
		String jspname = "/ShowUser.jsp";
		request.setAttribute("user", user);
		request.getRequestDispatcher(jspname).forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request, response);
		}
}

class Name{
	private String firstname;
	private String lastname;

	public Name(String firstname, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;
	}
}