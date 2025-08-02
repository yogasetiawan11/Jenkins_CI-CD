package com.mycompany.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set the content type of the response
        response.setContentType("text/html");

        // Get a PrintWriter to write the response body
        PrintWriter out = response.getWriter();

        // Write the HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("<style>");
        out.println("body { font-family: 'Arial', sans-serif; text-align: center; margin-top: 50px; background-color: #f0f0f0; }");
        out.println("h1 { color: #333; }");
        out.println("p { color: #666; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello from the Servlet!</h1>");
        out.println("<p>This is a simple Java web application for CI/CD practice.</p>");
        out.println("<p>The current time is: " + new java.util.Date() + "</p>");
        out.println("<a href=\"./index.html\">Go back to home</a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
