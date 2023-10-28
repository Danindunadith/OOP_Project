package com.mlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateMltServlet")
public class UpdateMltServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("mlid");
		String name= request.getParameter("name");
		String email=request.getParameter("email");
		String type=request.getParameter("type");
		String username=request.getParameter("uname");
		String password= request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue=mltDBUtill.updatemlt(id, name, email, type, username, password);
		
		if(isTrue==true)
		{
			List <mlt>mlDetails=mltDBUtill.getmltDetails(id);
			request.setAttribute("mlDetails", mlDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		
		else 
		{
			List <mlt>mlDetails=mltDBUtill.getmltDetails(id);
			request.setAttribute("mlDetails", mlDetails);
			
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
	}

}
