package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.bean.Post;
import model.bo.PostBO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import model.bean.User;

@WebServlet(name = "PostManagementServlet", value = "/PostManagementServlet")
public class PostManagementServlet extends HttpServlet {
    private PostBO postBO;
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
                        } catch (ClassNotFoundException | SQLException e) {
                            throw new RuntimeException(e);
                        }
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