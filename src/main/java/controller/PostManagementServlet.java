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
                    Post post;
                    try {
                        post = postBO.getPost(postId);
                        listPost = postBO.getAllPost();
                    } catch (ClassNotFoundException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                    Map<Integer, Map<String, Object>> data = new HashMap<>();
                    for (Post bai : listPost) {
                        int idBai = bai.getId();
                        Map<String, Object> article = new HashMap<>();
                        article.put("views", bai.getNumViews());
                        article.put("author", bai.getAuthor());
                        article.put("category", bai.getCategory());
                        data.put(idBai, article);
                    }
                    System.out.println("Number of articles: " + data.size());

                    List<Post> similarPosts = calculateSimilarity(data, listPost);
                    request.setAttribute("post", post);
                    request.setAttribute("listPost", similarPosts);

// In thông tin vào console
                    System.out.println("Post Information:");
                    System.out.println("ID: " + post.getId());
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Author: " + post.getAuthor());

                    System.out.println("Similar Posts:");
                    for (Post similarPost : similarPosts) {
                        System.out.println("ID: " + similarPost.getId() + ", Title: " + similarPost.getTitle() + ", Similarity: ");
                    }

                    dispatcher = request.getRequestDispatcher("detail_post_view.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }
    }

    // Các phương thức khác giữ nguyên

    private List<Post> calculateSimilarity(Map<Integer, Map<String, Object>> data, List<Post> listPost) {
        List<SimilarityResult> similarityResults = new ArrayList<>();

        for (Map.Entry<Integer, Map<String, Object>> entry1 : data.entrySet()) {
            Integer articleId1 = entry1.getKey();
            Map<String, Object> features1 = entry1.getValue();

            for (Map.Entry<Integer, Map<String, Object>> entry2 : data.entrySet()) {
                Integer articleId2 = entry2.getKey();
                Map<String, Object> features2 = entry2.getValue();

                if (!articleId1.equals(articleId2)) {
                    double similarity = calculateCosineSimilarity(features1, features2);
                    similarityResults.add(new SimilarityResult(articleId1, articleId2, similarity));
                }
            }
        }

        // Sắp xếp danh sách theo độ tương đồng giảm dần
        similarityResults.sort(Comparator.comparingDouble(SimilarityResult::getSimilarity).reversed());

        // Tạo danh sách bài viết dựa trên kết quả đã sắp xếp
        List<Post> sortedPosts = new ArrayList<>();
        for (SimilarityResult result : similarityResults) {
            int postId = result.getArticleId2();
            Post post = getPostById(postId, listPost);
            if (post != null) {
                sortedPosts.add(post);
            }
        }

        return sortedPosts;
    }

    // Các phương thức khác giữ nguyên

    private Post getPostById(int postId, List<Post> listPost) {
        for (Post post : listPost) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }

    // Lớp để lưu trữ kết quả tương đồng
    private static class SimilarityResult {
        private final Integer articleId1;
        private final Integer articleId2;
        private final double similarity;

        public SimilarityResult(Integer articleId1, Integer articleId2, double similarity) {
            this.articleId1 = articleId1;
            this.articleId2 = articleId2;
            this.similarity = similarity;
        }

        public Integer getArticleId1() {
            return articleId1;
        }

        public Integer getArticleId2() {
            return articleId2;
        }

        public double getSimilarity() {
            return similarity;
        }
    }
    private static double calculateCosineSimilarity(Map<String, Object> features1, Map<String, Object> features2) {
        int views1 = (int) features1.get("views");
        int views2 = (int) features2.get("views");
        Object category1Obj = features1.get("category");
        Object category2Obj = features2.get("category");

// Convert to String if not null
        String category1 = (category1Obj != null) ? category1Obj.toString() : "";
        String category2 = (category2Obj != null) ? category2Obj.toString() : "";

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