package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.Post;
import model.bo.PostBO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import model.bean.User;
import model.bo.UserBO;
@WebServlet(name = "PostManagementServlet", value = "/PostManagementServlet")
public class PostManagementServlet extends HttpServlet {
    private PostBO postBO;
    private UserBO userBO;
    private User user;
    public PostManagementServlet(){
        super();
        postBO = new PostBO();
        userBO = new UserBO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action!=null && !action.isEmpty()){
            switch (action) {
                case "viewHome":
                    List<Post> listPost = null;
                    try {
                        listPost = postBO.getAllPost();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    request.setAttribute("listPost", listPost);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewIntroduction":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(1);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewTuyenSinh":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(2);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewDaoTao":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(3);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewNCKH":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(4);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewHopTac":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(5);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewSinhVien":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(6);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "viewCuuSinhVien":
                    listPost = null;
                    try {
                        listPost = postBO.searchPostByCategory(7);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;

                    
                case "viewUserPosts":
                    	String userId = request.getParameter("userId");
                    	System.out.println("đây là author"+userId);
                        List<Post> userPosts;
                        try {
                            userPosts = postBO.getUserPost(userId);
                            user = userBO.getUser(userId);
                            System.out.println(user.getFullName());
                        } catch (ClassNotFoundException | SQLException e) {
                            throw new RuntimeException(e);
                        }
                        request.setAttribute("author", user);
                        request.setAttribute("listUserPost", userPosts);
                        dispatcher = request.getRequestDispatcher("user_page_view.jsp");
                        dispatcher.forward(request, response);
                    

                case "detailPost":
                    int postId = Integer.parseInt(request.getParameter("id"));
                    Post post;
                    try {
                        post = postBO.getPost(postId);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("post", post);
                    dispatcher = request.getRequestDispatcher("detail_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action!=null && !action.isEmpty()) {
            switch (action) {
                case "search":
                    String value = request.getParameter("searchValue");

                    List<Post> listPost;
                    try {
                        listPost = postBO.searchPost(value);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", listPost);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("list_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }
    }
}
