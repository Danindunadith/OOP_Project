package com.pharmacist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/pharmacistServlet")
public class pharmacistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pemail=request.getParameter("uid");
		String pphone=request.getParameter("pass");
		
		try {
			List<pharmacist>pregDetails=pharmacistDBUtil.validate(pemail, pphone);
			request.setAttribute("pregDetails", pregDetails);
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		
		RequestDispatcher dis = request.getRequestDispatcher("puseraccount.jsp");
		dis.forward(request, response);
	}

}
