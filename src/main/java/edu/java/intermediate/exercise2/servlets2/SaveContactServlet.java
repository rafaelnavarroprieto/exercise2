package edu.java.intermediate.exercise2.servlets2;

import edu.java.intermediate.exercise2.models.Contact;
import edu.java.intermediate.exercise2.repositories.ContactRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/v2/contacts/save")
public class SaveContactServlet  extends HttpServlet {

    private ContactRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        repository = ContactRepository.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        Contact contact = null;

        if(strId.equalsIgnoreCase("")){
            contact = new Contact();
            contact.setId(this.repository.getContact().size() + 1);
            contact.setCreatedAt(new Date());
            this.repository.getContact().add(contact);
        } else {
            int id = Integer.parseInt(strId);
            contact = this.repository.getContact().get(id-1);
            contact.setModifiedAt(new Date());
        }

        contact.setFirstName(req.getParameter("firstName"));
        contact.setLastName(req.getParameter("lastName"));
        contact.setEmail(req.getParameter("email"));

        resp.sendRedirect("../contacts");
    }
}
