package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import model.bo.UserBO;
import model.bo.AccountBO;
import model.bean.User;
@WebServlet(name = "AuthenticationManagementServlet", value = "/AuthenticationManagementServlet")
public class AuthenticationManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserBO userBO = new UserBO();
        AccountBO accountBO = new AccountBO();
        if (action != null && action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username + password);
            try {
                User user = userBO.Validate(username, password);
                if (user != null) {
                    // Đăng nhập thành công, lưu thông tin người dùng vào session
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);

                    // Điều hướng đến trang chủ hoặc trang quản lý nếu cần
                    response.sendRedirect("PostManagementServlet?action=viewHome"); // Thay đổi 'homePage.jsp' với trang bạn muốn chuyển đến
                } else {
                    // Đăng nhập thất bại, hiển thị thông báo hoặc chuyển đến trang đăng nhập lại
                    request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không đúng");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login_view.jsp"); // Thay đổi 'loginPage.jsp' với trang đăng nhập của bạn
                    dispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new ServletException("Database error", e);
            }
        }else if(action != null && action.equals("register")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String fullName = request.getParameter("full_name");
            String phoneNumber = request.getParameter("phone_number");
            String address = request.getParameter("address");
            System.out.println(username+"-"+password+"-"+email+"-"+fullName+"-"+phoneNumber+"-"+address);
            try {
                // Giả sử bạn có một phương thức trong UserBO để xử lý đăng ký
                boolean isCreateAccount = accountBO.insertAccount(username, password);
                if(isCreateAccount) {
                    boolean isRegistered = userBO.insertUser(username, fullName, phoneNumber , email , address);

                    if (isRegistered) {
                        // Đăng ký thành công, chuyển hướng đến trang đăng nhập
                        response.sendRedirect("login_view.jsp");
                    } else {
                        // Đăng ký không thành công, trả về lỗi
                        request.setAttribute("errorMessage", "Đăng ký không thành công. Vui lòng thử lại.");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("register_view.jsp");
                        dispatcher.forward(request, response);
                    }
                }else {
                    request.setAttribute("errorMessage", "Tài khoản đã tồn tại. Vui lòng nhập tài khoản khác");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("register_view.jsp");
                    dispatcher.forward(request, response);
                }
            }catch (ClassNotFoundException | SQLException e) {
                throw new ServletException("Database error", e);
            }
        }
    }
}
