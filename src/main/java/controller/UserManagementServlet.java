package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import model.bo.UserBO;

@WebServlet(name = "UserManagementServlet", value = "/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserBO userBO = new UserBO();

        if (action != null && action.equals("update")) {
        	String id = request.getParameter("userId");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("eMail");
            String phoneNumber = request.getParameter("phone");
            String address = request.getParameter("Address");
            String about = request.getParameter("about");
            System.out.println(fullName);
            try {
				boolean success = userBO.updateUser(id, fullName, phoneNumber, email, address, about);
				 if (success) {
		                // Redirect or forward to a success page
			            response.sendRedirect("PostManagementServlet?action=viewUserPosts&userId=" + id); // Modify this URL as per your application's URL pattern
		            } else {
		                // Handle update failure
		                request.setAttribute("errorMessage", "Update failed");
		                RequestDispatcher dispatcher = request.getRequestDispatcher("PostManagementServlet?action=viewUserPosts&userId=" + id); // Modify as needed
		                dispatcher.forward(request, response);
		            }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

        }

    }
}
