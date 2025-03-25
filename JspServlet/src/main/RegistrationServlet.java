package com.mindprove;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegistrationServlet() {
        super();
    }

F    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        request.setAttribute("message", "Received from JSP -> Name: " + name + ", Email: " + email + ", Country: " + country);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

	

}
