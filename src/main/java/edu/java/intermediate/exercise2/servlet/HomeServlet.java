package edu.java.intermediate.exercise2.servlet;

import com.sun.net.httpserver.HttpsServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Title Exercise 2 - Servlets </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2> Exercise 2 - Servlets </h2>");
        out.println("</body>");
        out.println("<html>");

        out.close();
    }
}
