package sait.cprg352;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 */
@WebServlet(urlPatterns = {"/MainPageServlet"})
public class MainPageServlet extends HttpServlet {
      
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String logout = request.getParameter("logout");
         
        if (logout != null) {
            
            request.setAttribute("logout", "Logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
}
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }  
  
    }

    


