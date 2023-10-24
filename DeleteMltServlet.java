 package com.mlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteMltServlet")
public class DeleteMltServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id =request.getParameter("mlid");  
		boolean isTrue;
		
		isTrue=mltDBUtill.deletemlt(id);
		
		if(isTrue==true) {
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("mltinsert.jsp");
			dispatcher.forward(request, response); 
			
			
		}else {
			
			List<mlt> mlDetails = mltDBUtill.getmltDetails(id);
			request.setAttribute("mlDetails",mlDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
		} 
	
	}

}
