package sait.cprg352;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 698437
 * September 18 2017
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usernameString = request.getParameter("username");
        String passwordString = request.getParameter("password");
        
        //checking if the username field is empty or if the password field is empty or null.
        if (usernameString == null || passwordString == null || usernameString.isEmpty() || passwordString.isEmpty()) {
            request.setAttribute("errorMessage", "Please enter a username and password");
            request.setAttribute("username", usernameString);
            request.setAttribute("password", passwordString);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        UserService us = new UserService();
        //if the user has logged in successfully.
        if (us.login(usernameString, passwordString)) {
            request.setAttribute("username", usernameString);
            getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
            return;
        } 
        
        //if the user has enteredan invalid username of password
        else {
            request.setAttribute("errorMessage", "Invalid username or password. Try again.");
            request.setAttribute("username", usernameString);
            request.setAttribute("password", passwordString);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
