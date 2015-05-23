package JSPLanguagePackage;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;

@WebServlet("/send-message")
public class SendMessage extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String[] str = new String[3];
		String jspname = "/ShowString.jsp";
		str[0] = "Hello";
		str[1] = "Hi";
		str[2] = "Bye";
		request.setAttribute("str", str);
		request.getRequestDispatcher(jspname).forward(request, response); 
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request, response);
		}
}
