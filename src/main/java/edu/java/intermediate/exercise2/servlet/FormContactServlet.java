package edu.java.intermediate.exercise2.servlet;

import edu.java.intermediate.exercise2.models.Contact;
import edu.java.intermediate.exercise2.repositories.ContactRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contacts/form")
public class FormContactServlet extends HttpServlet {

    private ContactRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        repository = ContactRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String strId = req.getParameter("id");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Title Exercise 2 - Contactos </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2> Contactos </h2>");
        out.println("<form method='POST' action='./save'>");
        out.println("<table>");

        StringBuffer strBuffer = new StringBuffer("\t\t<tr>\n");
        strBuffer.append("<td>");
        strBuffer.append("<input type='text' id='firstName' name='firstName'");
        strBuffer.append("</td><td>");
        strBuffer.append("<input type='text' id='lastName' name='lastName'");
        strBuffer.append("</td><td>");
        strBuffer.append("<input type='text' id='email' name='email'");
        strBuffer.append("</td>");
        out.println("</tr>");
        out.println(strBuffer.toString());



        out.println("</table>");
        out.println("<input type='submit' name='submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("<html>");

        out.close();
    }
}
