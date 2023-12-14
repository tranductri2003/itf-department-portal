package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.Post;
import model.bo.PostBO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import model.bean.User;
import model.bo.UserBO;
import model.bo.CategoryBO;
import model.bean.Category;
@WebServlet(name = "PostManagementServlet", value = "/PostManagementServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,   // 2MB
				 maxFileSize = 1024 * 1024 * 10,        // 10MB
				 maxRequestSize = 1024 * 1024 * 50)    // 50MB
public class PostManagementServlet extends HttpServlet {
    private PostBO postBO;
    private UserBO userBO;
    private CategoryBO categoryBO;
    private User user;

    private static double[][] similarityMatrix = {
            {1, 0.9, 0.8, 0.6, 0.7, 0.5, 0.5},
            {0.9, 1, 0.9, 0.6, 0.7, 0.8, 0.7},
            {0.8, 0.9, 1, 0.9, 0.7, 0.8, 0.7},
            {0.6, 0.6, 0.9, 1, 0.7, 0.9, 0.7},
            {0.7, 0.7, 0.7, 0.7, 1, 0.7, 0.8},
            {0.5, 0.8, 0.8, 0.9, 0.7, 1, 0.8},
            {0.5, 0.7, 0.7, 0.7, 0.8, 0.8, 1},
    };

    public PostManagementServlet(){
        super();
        postBO = new PostBO();
        userBO = new UserBO();
        categoryBO = new CategoryBO();

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
                    Post currentPost;
                    try {
                        currentPost = postBO.getPost(postId);
                        listPost = postBO.getAllPost();
                    } catch (ClassNotFoundException | SQLException e) {
                        throw new RuntimeException("Error retrieving post information", e);
                    }

                    System.out.println("Number of articles: " + listPost.size());

                    List<Integer> similarPostsId = calculateSimilarity(currentPost, listPost);
                    List<Post> similarPosts = new ArrayList<>();
                    for (Integer id : similarPostsId) {
                        try {
                            Post similarPost = postBO.getPost(id);
                            if (similarPost != null) {
                                similarPosts.add(similarPost);
                            }
                        } catch (ClassNotFoundException | SQLException e) {
                            throw new RuntimeException("Error retrieving similar post information", e);
                        }
                    }

                    request.setAttribute("post", currentPost);
                    request.setAttribute("listPost", similarPosts);

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

                case "delete":
                    int idToDelete = Integer.parseInt(request.getParameter("delete"));
                    String userIdToDelete = request.getParameter("userId");
                    System.out.println(idToDelete);
                    System.out.println(userIdToDelete);
                    try {
                        postBO.deletePost(idToDelete);
                        System.out.println("Đã xóa thành công");
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    String redirectURL = "PostManagementServlet?action=viewUserPosts&userId=" + userIdToDelete;
                    response.sendRedirect(redirectURL);
                    break;
                case "updateForm":
                	int idToUpdate = Integer.parseInt(request.getParameter("update"));
                	String userIdToUpdate = request.getParameter("userId");
                    System.out.println(idToUpdate);
                    System.out.println(userIdToUpdate);
                    try {
                        Post updatePost = postBO.getPost(idToUpdate);
                        List<Category> categoryList = categoryBO.getAllCategory();
                        request.setAttribute("post", updatePost);
                        request.setAttribute("categoryList", categoryList);
                        dispatcher = request.getRequestDispatcher("update_post_form.jsp");
                        dispatcher.forward(request, response);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                	break;
                case "update":
                	Part filePart = request.getPart("image"); // "image" is the name of the file input field in your HTML form
                    String fileName = extractFileName(filePart);
                    // Define the relative path where you want to save the image
                    String relativePath = "media/post";  // Change this to your desired relative path
                    
                    int id = Integer.parseInt(request.getParameter("id"));
                    int category = Integer.parseInt(request.getParameter("category"));
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
                    
                    String title = request.getParameter("title");
                    String excerpt = request.getParameter("excerpt");
                    String content = request.getParameter("content");
                    int numViews = -1;

					try {
						postBO.updatePost(id, category, title, image, excerpt, content, numViews);
					} catch (Exception e) {
						e.printStackTrace();
					}   
					request.setAttribute("userId", request.getParameter("userId"));
					List<Post> post = null;
                    try {
                        listPost = postBO.getAllPost();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", post);
                    String redirURL = "PostManagementServlet?action=detailPost&id=" + id;
                    response.sendRedirect(redirURL);
                    break;
                case "insertForm":
                	String userIdToInsert= request.getParameter("userId");
                    System.out.println(userIdToInsert);
                    try {
                        List<Category> categoryList = categoryBO.getAllCategory();
                        request.setAttribute("categoryList", categoryList);
                        dispatcher = request.getRequestDispatcher("insert_post_form.jsp");
                        dispatcher.forward(request, response);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                	break;
                case "insert":
                	Part fPart = request.getPart("image"); // "image" is the name of the file input field in your HTML form
                    String fName = extractFileName(fPart);
                    // Define the relative path where you want to save the image
                    String relPath = "media/post";  // Change this to your desired relative path
                    
                    int categoryInsert = Integer.parseInt(request.getParameter("category"));
                    String imageInsert = null;
                    if (fName != null && fName != "") {
                    	imageInsert = relPath + "/" + fName;
                    	System.out.println(imageInsert);
                    	// Get the real path of the web application and concatenate the relative path
                        ServletContext context = getServletContext();
                        String uploadPath = context.getRealPath(relPath);

                        File uploadDir = new File(uploadPath);
                        System.out.print(uploadPath);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdir();
                        }
                        fPart.write(uploadPath + File.separator + fName);
                    }
                    
                    String titleInsert = request.getParameter("title");
                    String excerptInsert = request.getParameter("excerpt");
                    String contentInsert = request.getParameter("content");
                    int numViewsInsert = 0;
                    
                    jakarta.servlet.http.HttpSession session = request.getSession();

                    User user = (User) session.getAttribute("user");
                    String author = user.getId();

					try {
						postBO.insertPost(categoryInsert, titleInsert, imageInsert, excerptInsert, contentInsert, author, numViewsInsert);
					} catch (Exception e) {
						e.printStackTrace();
					}   
					request.setAttribute("userId", request.getParameter("userId"));
					List<Post> posts = null;
                    try {
                        listPost = postBO.getAllPost();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("listPost", posts);
                    String redireURL = "PostManagementServlet?action=viewHome";
                    response.sendRedirect(redireURL);
                    break;
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

    // Các phương thức khác giữ nguyên

    private List<Integer> calculateSimilarity(Post currentPost, List<Post> listPost) {
        Map<Integer, Double> similarityMap = new HashMap<>();

        for (Post post : listPost) {
            if (post != currentPost) {
                Double similarity = calculateCosineSimilarity(currentPost, post);
                similarityMap.put(post.getId(), similarity);
            }
        }

        // Sắp xếp map theo giảm dần của giá trị tương đồng
        List<Map.Entry<Integer, Double>> sortedSimilarityList = new ArrayList<>(similarityMap.entrySet());
        sortedSimilarityList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Lấy danh sách id của các bài viết có độ tương đồng cao nhất
        List<Integer> similarPosts = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : sortedSimilarityList) {
            similarPosts.add(entry.getKey());
        }

        return similarPosts;
    }


    private static double calculateCosineSimilarity(Post post1, Post post2) {
        int category1 = post1.getCategory();
        int category2 = post2.getCategory();

        String author1 = post1.getAuthor();
        String author2 = post2.getAuthor();


        // Use a constant to emphasize the importance of the same category or author
        double categorySimilarity = similarityMatrix[category1-1][category2-1];
        double authorSimilarity = author1.equals(author2) ? 1.0 : 0.5;

        // Calculate cosine similarity
        // Vector1 = [1, author]; vector2 = [category, 1]
        double dotProduct = 1 * categorySimilarity + 1 * authorSimilarity;
        double magnitude1 = Math.sqrt(1 + Math.pow(categorySimilarity, 2));
        double magnitude2 = Math.sqrt(1 + Math.pow(authorSimilarity, 2));


        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        }

        double similarity = dotProduct / (magnitude1 * magnitude2);

        // Print details of both posts and similarity metrics
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Post 1: " + post1.getId() + " " + post1.getTitle() + " " + post1.getCategory() + " " + post1.getAuthor());
        System.out.println("Post 2: " + post2.getId() + " " + post2.getTitle() + " " + post2.getCategory() + " " + post2.getAuthor());
        System.out.println("Cosine Similarity: " + similarity);
        System.out.println("Author Similarity: " + authorSimilarity);
        System.out.println("Category Similarity: " + categorySimilarity);
        System.out.println("-------------------------------------------------------------------------------------------------------");

        return similarity;
    }


}