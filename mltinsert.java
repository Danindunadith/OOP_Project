package com.mlt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mltinsert")
public class mltinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		String type=request.getParameter("type");
		String username=request.getParameter("uid");
		String password=request.getParameter("pwd");
		
		boolean isTrue;
		
		isTrue=mltDBUtill.insertmlt(name, email, type, username, password);
		
		if(isTrue==true)
		{
			RequestDispatcher dis= request.getRequestDispatcher("Success.jsp");
			dis.forward(request, response);
		}
		
		else 
		{
			RequestDispatcher dis2=request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
