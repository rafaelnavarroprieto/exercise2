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

@WebServlet("/contacts/view")
public class ViewContactServlet extends HttpServlet {

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
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>id</th><th>Nombre</th><th>Apellidos</th><th>Email</th>");
        out.println("</tr>");
        out.println("<tr>");
        for (Contact contact: this.repository.getContact()) {
            if(contact.getId() == Integer.parseInt(strId)){
                StringBuffer strBuffer = new StringBuffer("\t\t<tr>\n");
                strBuffer.append("<td>");
                strBuffer.append(contact.getId());
                strBuffer.append("</td><td>");
                strBuffer.append(contact.getFirstName());
                strBuffer.append("</td><td>");
                strBuffer.append(contact.getLastName());
                strBuffer.append("</td><td>");
                strBuffer.append(contact.getEmail());
                strBuffer.append("</td>");
                out.println("</tr>");
                out.println(strBuffer.toString());
            }
        }
        out.println("</table>");
        out.println("</body>");
        out.println("<html>");

        out.close();
    }

}
