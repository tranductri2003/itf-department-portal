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


@WebServlet(name = "PostManagementServlet", value = "/PostManagementServlet")
public class PostManagementServlet extends HttpServlet {
    private PostBO postBO;
    public PostManagementServlet(){
        super();
        postBO = new PostBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action!=null && !action.isEmpty()){
            switch (action){
                case "viewHome":
                    List<Post> listPost = null;
                    try {
                        listPost = postBO.getAllPost();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    Map<Integer, Map<String, Object>> data = new HashMap<>();
                    for (Post post: listPost){
                        int id = post.getId();
                        Map<String, Object> article = new HashMap<>();
                        article.put("views", post.getNumViews());
                        article.put("author", post.getAuthor());
                        article.put("category", post.getCategory());
                        data.put(id, article);
                    }

//                    calculateSimilarity(data);


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


//    private static void calculateSimilarity(Map<Integer, Map<String, Object>> data) {
//        for (Map.Entry<Integer, Map<String, Object>> entry1 : data.entrySet()) {
//            String articleId1 = entry1.getKey();
//            Map<String, Object> features1 = entry1.getValue();
//
//            System.out.println("Bài viết gợi ý cho " + articleId1 + ":");
//
//            for (Map.Entry<String, Map<String, Object>> entry2 : data.entrySet()) {
//                String articleId2 = entry2.getKey();
//                Map<String, Object> features2 = entry2.getValue();
//
//                if (!articleId1.equals(articleId2)) {
//                    double similarity = calculateCosineSimilarity(features1, features2);
//                    System.out.println("- " + articleId2 + " (Similarity: " + similarity + ")");
//                }
//            }
//
//            System.out.println();
//        }
//    }

    private static double calculateCosineSimilarity(Map<String, Object> features1, Map<String, Object> features2) {
        int views1 = (int) features1.get("views");
        int views2 = (int) features2.get("views");
        String category1 = (String) features1.get("category");
        String category2 = (String) features2.get("category");
        String author1 = (String) features1.get("author");
        String author2 = (String) features2.get("author");

        // Normalize views to be between 0 and 1
        double normalizedViews1 = views1 / 1000.0;
        double normalizedViews2 = views2 / 1000.0;

        // Calculate cosine similarity
        double dotProduct = normalizedViews1 * normalizedViews2;
        double magnitude1 = Math.sqrt(Math.pow(normalizedViews1, 2) + Math.pow(category1.equals(category2) ? 1 : 0, 2) + Math.pow(author1.equals(author2) ? 1 : 0, 2));
        double magnitude2 = Math.sqrt(Math.pow(normalizedViews2, 2) + Math.pow(category1.equals(category2) ? 1 : 0, 2) + Math.pow(author1.equals(author2) ? 1 : 0, 2));

        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        }

        return dotProduct / (magnitude1 * magnitude2);
    }
}



