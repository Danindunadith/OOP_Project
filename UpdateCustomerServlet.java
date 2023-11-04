package com.agent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("agnid");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String trakingnumber = request.getParameter("trakingnumber");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = AgentDBUtil.updateagent(id, name, address, trakingnumber, username, password);
		
		if(isTrue==true) {
			
			List<Agent> agnDetails = AgentDBUtil.getAgentDetails(id);
			request.setAttribute("agnDetails",agnDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}else {
			
			List<Agent> agnDetails = AgentDBUtil.getAgentDetails(id);
			request.setAttribute("agnDetails",agnDetails);
			
			
			RequestDispatcher dis=request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
			
		}
		
	}

}
