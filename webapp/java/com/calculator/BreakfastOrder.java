package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BreakfastOrder")
public class BreakfastOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the list of data from the session
        HttpSession session = request.getSession();
        List<Data> dataList = (List<Data>) session.getAttribute("dataList");

        // Prepare the response HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Display Arrays</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; margin-left: 10%; margin-right: 10%; padding: 0;}");
        out.println("h1 { background-color: #007BFF; color: #fff; padding: 10px; text-align: center;}");
        out.println("table { width: 80%; margin: 0 auto; border-collapse: collapse; border: 1px solid #ccc;}");
        out.println("th, td { padding: 10px; text-align: left; border: 1px solid #ccc;}");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("tr:hover { background-color: #ddd; }");
        out.println("p { text-align: center;}");
        out.println("</style>");


        out.println("</head>");
        out.println("<body>");
        out.println("<h1>YOUR ORDER:</h1>");

        if (dataList != null && !dataList.isEmpty()) {
            int index = 1;
            for (Data data : dataList) {
                out.println("<ul>");
                out.println("<li>Order " + index + ": Ordered Item: " + data.getArray1() + ", Quantity: " + data.getArray2() + "</li>");
                out.println("</ul>");
                index++;
            }
        } else {
            out.println("No data found.");
        }

        out.println("<a href='breakfast.html'>Browse Menu</a><br><br>"); // Add a link to go back to the first form
        out.println("<form id=\"menuFormbill\" action=\"GenerateBillServlet\" method=\"get\">");
        out.println("<button value=\"Bill please!!!\">Bill Details</button>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
