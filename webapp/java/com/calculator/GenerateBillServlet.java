package com.calculator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GenerateBillServlet")
public class GenerateBillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // Retrieve the list of data from the session
        HttpSession session = request.getSession();
        List<Data> dataList = (List<Data>) session.getAttribute("dataList");

        // Prepare the response HTML
        response.setContentType("text/html");

        out.println("<html>");
        out.println("<head><title>Generate Bill</title></head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; margin: 0; padding: 0;}");
        out.println("h1 { background-color: #007BFF; color: #fff; padding: 10px; text-align: center;}");
        out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
        out.println("th, td { border: 1px solid #ccc; padding: 8px; text-align: center;}");
        out.println("th { background-color: #007BFF; color: #fff;}");
        out.println("p { text-align: center;}");
        out.println("h2 { text-align: center;}");

        out.println("</style>");
        out.println("<body>");
        out.println("<h1>Bill</h1>");

        if (dataList != null && !dataList.isEmpty()) {
            out.println("<table>");
            out.println("<tr><th>Item</th><th>Quantity</th><th>Cost</th></tr>");

            double totalCost = 0.0;

            for (Data data : dataList) {
                String item = data.getArray1();
                int quantity = data.getArray2();
                 

                out.println("<tr><td>" + item + "</td><td>" + quantity + "</td><td>" + calculateCost(item, quantity) + "</td></tr>");
                totalCost += calculateCost(item, quantity);
            }

            out.println("</table>");
            out.println("<p><h2>Total Cost: " + totalCost + "</h2></p>");
            out.println("<p>Thank You for Dining with Us!</p>");
            
            
        } else {
            out.println("No data found.");
        }

        out.println("</body>");
        out.println("</html>");
    }

    private double calculateCost(String item, int quantity) {
        // You can implement your own logic to calculate the cost for each item.
        // This is a placeholder method.
        double itemCost = 0.0;

        if ("BlackTea".equals(item)) {
            itemCost = 10.0;
        } else if ("MilkTea".equals(item)) {
            itemCost = 15.0;
        } else if ("GreenTea".equals(item)) {
            itemCost = 20.0;
        } else if ("Samosa".equals(item)) {
            itemCost = 15.0;
        } else if ("ChocoSamosa".equals(item)) {
            itemCost = 40.0;
        } else if ("PaneerSamosa".equals(item)) {
            itemCost = 45.0;
        } else if ("PuriBhaji".equals(item)) {
            itemCost = 45.0;
        }else if ("IdliSambar".equals(item)) {
            itemCost = 40.0;
        }else if ("IdliChutaney".equals(item)) {
            itemCost = 30.0;
        }else if ("Dosa".equals(item)) {
            itemCost = 25.0;
        }else if ("MasalaDosa".equals(item)) {
            itemCost = 30.0;
        }else if ("PaperDosa".equals(item)) {
            itemCost = 30.0;
        }else if ("CheeseDosa".equals(item)) {
            itemCost = 45.0;
        }else if ("RavaDosa".equals(item)) {
            itemCost = 20.0;
        }else if ("Upama".equals(item)) {
            itemCost = 20.0;
        }else if ("Pohe".equals(item)) {
            itemCost = 20.0;
        }

        return itemCost * quantity;
    }
}

