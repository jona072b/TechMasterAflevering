package controller;

import Model.Authenticator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by faisaljarkass on 22-10-2016.
 */
public class HomeController extends HttpServlet {

    private static Logger logger = Logger.getLogger(HomeController.class.getName());


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.log(Level.INFO, "doPost start...");
        logger.log(Level.INFO, "Username: " + username);
        logger.log(Level.INFO, "Password: " + password);
        logger.log(Level.INFO, "Checkbox: " + request.getParameter("rememberMe"));

        Authenticator auth = new Authenticator();
        String login = auth.authenticate(username, password);
        if (login.equals("succesAdmin")){
            RequestDispatcher rd = request.getRequestDispatcher("/loginSuccessAdmin.jsp");
            rd.forward(request, response);
        } else if (login.equals("succesUser")){
            RequestDispatcher rd = request.getRequestDispatcher("/loginSuccess.jsp");
            rd.forward(request, response);
        } else{
            logger.log(Level.INFO, "creds invalid");
            request.setAttribute("errorMessage", "true");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

        /*if (username.equals(username)) {
            //TODO: Common for both user and admin and username to the request


            if (password.equals(password)) {



                RequestDispatcher rd = request.getRequestDispatcher("/loginSuccessAdmin.jsp");
                rd.forward(request, response);
            } else {

                RequestDispatcher rd = request.getRequestDispatcher("/loginSuccess.jsp");
                rd.forward(request, response);
            }
        } else {
            logger.log(Level.INFO, "creds invalid");
            request.setAttribute("errorMessage", "true");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }*/

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
