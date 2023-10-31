package com.registered_user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DeleteRegisteruserServlet")
public class DeleteRegisteruserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id =request.getParameter("regid");  
		boolean isTrue;
		
		isTrue=Register_UserDButil.deleteregister(id);
		
		if(isTrue==true) {
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("registerinsert.jsp");
			dispatcher.forward(request, response); 
			
			
		}else {
			
			List<Register_User> regDetail = Register_UserDButil.getRegisterUserDetails(id);
			request.setAttribute("regDetails",regDetail);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		}
	
	
	
	}

}
