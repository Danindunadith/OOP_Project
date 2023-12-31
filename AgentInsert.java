package com.agent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AgentInsert")
public class AgentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String trakingnumber=request.getParameter("trakingnumber");
		String username=request.getParameter("uid");
		String password=request.getParameter("psw");

		boolean isTrue;
		
		isTrue = AgentDBUtil.insertagent(name, address, trakingnumber, username, password);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
			
		}else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
			
		}
	
		
	}

}
