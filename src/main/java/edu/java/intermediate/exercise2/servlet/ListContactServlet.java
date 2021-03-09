package edu.java.intermediate.exercise2.servlet;

import com.sun.net.httpserver.HttpsServer;
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

@WebServlet("/contacts")
public class ListContactServlet extends HttpServlet {

    private ContactRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        repository = ContactRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Title Exercise 2 - Contactos </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2> Exercise 2 - Contactos </h2>");
        out.println("<a href='./contacts/form'> Nuevo contacto </a>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>id</th><th>Nombre</th><th>Apellidos</th><th>Email</th>");
        out.println("</tr>");
        out.println("<tr>");
        for (Contact contact: this.repository.getContact()) {
            StringBuffer strBuffer = new StringBuffer("\t\t<td>");
            strBuffer.append("<a href=\"./contacts/view?id=");
            strBuffer.append(contact.getId());
            strBuffer.append("\">");
            strBuffer.append(contact.getId());
            strBuffer.append("</a>");
            strBuffer.append("</td><td>");
            strBuffer.append(contact.getFirstName());
            strBuffer.append("</td><td>");
            strBuffer.append(contact.getLastName());
            strBuffer.append("</td><td>");
            strBuffer.append(contact.getEmail());
            strBuffer.append("</td>");
            out.println("</tr>");
            out.println(strBuffer.toString());
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("<html>");

        out.close();
    }
}
