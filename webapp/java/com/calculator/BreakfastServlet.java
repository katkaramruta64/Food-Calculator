package com.calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;



@WebServlet("/BreakfastServlet")
public class BreakfastServlet extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	         // Retrieve values from the request parameters
	         String selectedItems[] = request.getParameterValues("menu");
	         int selectedQuantity = Integer.parseInt(request.getParameter("quantity"));
	      

		        out.println("BreakfastServlet");


		     // Retrieve the list from the session or create a new one
		        HttpSession session = request.getSession();
		        List<Data> dataList = (List<Data>) session.getAttribute("dataList");
		        if (dataList == null) {
		            dataList = new ArrayList<>();
		        }
		        for (String item : selectedItems) {
		            dataList.add(new Data(item, selectedQuantity));
		        }

		        // Store the list in the session
		        session.setAttribute("dataList", dataList);


	         response.sendRedirect("BreakfastOrder");
	        System.out.println("Breakfast servlet");
	    }
    
}
