package edu.java.intermediate.exercise2.servlets2;

import edu.java.intermediate.exercise2.repositories.ContactRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v2/contacts/form")
public class FormContactServlet extends HttpServlet {

    private ContactRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        repository = ContactRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("../../contacts/form.jsp");
        String strId = req.getParameter("id");

        if(strId != null && !strId.equals("")){
            for (int index = 0; index < this.repository.getContact().size(); index++) {
                if (this.repository.getContact().get(index).getId() == Integer.parseInt(strId)) {
                    req.setAttribute("contact", this.repository.getContact().get(index));
                    index = this.repository.getContact().size();
                }
            }
        }



        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
