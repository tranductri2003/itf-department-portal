package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import model.bo.UserBO;

@WebServlet(name = "UserManagementServlet", value = "/UserManagementServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,   // 2MB
				 maxFileSize = 1024 * 1024 * 10,        // 10MB
				 maxRequestSize = 1024 * 1024 * 50)    // 50MB
public class UserManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserBO userBO = new UserBO();

        if (action != null) {
        	if (action.equals("update")) {
        		String id = request.getParameter("userId");
                String fullName = request.getParameter("fullName");
                String email = request.getParameter("eMail");
                String phoneNumber = request.getParameter("phone");
                String address = request.getParameter("Address");
                Part filePart = request.getPart("image");
                String fileName = extractFileName(filePart);
                String relativePath = "media/avatar";
                String image = null;
                if (fileName != null && fileName != "") {
                	image = relativePath + "/" + fileName;
                	// Get the real path of the web application and concatenate the relative path
                    ServletContext context = getServletContext();
                    String uploadPath = context.getRealPath(relativePath);

                    File uploadDir = new File(uploadPath);
                    System.out.print(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }
                    filePart.write(uploadPath + File.separator + fileName);
                }
                String about = request.getParameter("about");
                System.out.println(fullName);
                try {
    				boolean success = userBO.updateUser(id, fullName, phoneNumber, email, address, image, about);
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
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }
}
