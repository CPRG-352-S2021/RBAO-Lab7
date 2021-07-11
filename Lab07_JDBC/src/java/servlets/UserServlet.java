package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 * https://github.com/CPRG-352-S2021/RBAO-Lab7.git
 *
 * @author Ridge 840288 and Andre 834557
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
        request.setAttribute("selectedAcc", true);
        try {
            HttpSession session = request.getSession();
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserService us = new UserService();

        String email = (String) request.getParameter("emailEdit");
        String lastName = (String) request.getParameter("lastName");
        String action = (String) request.getParameter("action");

        String actionTwo = "";
        String emailEdit = "";
        String firstNameEdit = "";
        String lastNameEdit = "";
        String passwordEdit = "";
        actionTwo = (String) request.getParameter("actionTwo");
        String prevEmail = "";
        String prevLastName = "";

        User userEdit = new User();

    }
}
