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
        User uEdit = new User();

        String email = (String) request.getParameter("emailEdit");
        String fName = (String) request.getParameter("fNameEdit");
        String lName = (String) request.getParameter("lNameEdit");
        //String role = (String) request.getParameter("roleEdit");
        //String active = (String) request.getParameter("activeEdit");
        String action = (String) request.getParameter("action");

        try {
            uEdit = us.get(email, fName, lName);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (action != null && action.equals("delete")) {
            try {
                us.delete(email, fName, lName);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("user");
        }

        if (action != null && action.equals("edit")) {
            //request.setAttribute("editView", true);
            //request.setAttribute("addView", false);
            try {
                session = request.getSession();
                List<User> users = us.getAll();
                request.setAttribute("users", users);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                //request.setAttribute("message", "error");
            }

            //***************************
            try {
                uEdit = us.get(email, fName, lName);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            String emailEdit = uEdit.getEmail();
            request.setAttribute("emailEdit", emailEdit);

            String fNameEdit = uEdit.getFirstname();
            request.setAttribute("firstNameEdit", fNameEdit);

            String lNameEdit = uEdit.getLastname();
            request.setAttribute("lastNameEdit", lNameEdit);

            String pswEdit = uEdit.getPassword();
            request.setAttribute("passwordEdit", pswEdit);

            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

            return;

            //***************************
        }

        if (action != null && action.equals("save")) {

            String fNameADD = (String) request.getParameter("fNameADD");
            request.setAttribute("fNameATTAdd", fNameADD);

            String lNameADD = (String) request.getParameter("lNameADD");
            request.setAttribute("lNameATTAdd", lNameADD);

            String passwordADD = (String) request.getParameter("passwordADD");
            request.setAttribute("passwordATTAdd", passwordADD);

            Integer roleADD = Integer.parseInt((String) request.getParameter("roleADD"));

            String emailADD = (String) request.getParameter("emailADD");
            request.setAttribute("emailATTAdd", emailADD);

            if (emailADD == null || emailADD.equals("") || fNameADD == null || fNameADD.equals("")
                    || lNameADD == null || lNameADD.equals("") || passwordADD == null || passwordADD.equals("")
                    || (roleADD == 0)) {

                try {

                    List<User> users = us.getAll();
                    request.setAttribute("users", users);
                } catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
                return;
            }

            User userOne = null;
            Boolean status = Boolean.parseBoolean((String) request.getParameter("activeADD"));

            try {

                userOne = new User(emailADD, status, fNameADD, lNameADD, passwordADD, roleADD);
                us.insert(userOne);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("user");
        }

        String actionADD = (String) request.getParameter("actionADD");
        String actionEdit = (String) request.getParameter("actionEdit");

        if (actionADD != null && actionADD.equals("save")) {

            uEdit = new User(request.getParameter("emailEdit"), Boolean.parseBoolean(request.getParameter("activeEdit")),
                    request.getParameter("fNameEdit"), request.getParameter("lNameEdit"),
                    request.getParameter("passwordEdit"), Integer.parseInt((request.getParameter("roleEdit"))));

            response.sendRedirect("user");

        } else if (actionEdit != null && actionEdit.equals("save")) {

            response.sendRedirect("user");
        }
    }
}
