package model.bo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.Post;
import model.dao.PostDAO;

public class PostBO {
	
	private PostDAO postDAO;
	
	public PostBO() {
		this.postDAO = new PostDAO();
	}
	
	public List<Post> getAllPost() throws ClassNotFoundException, SQLException {
		return this.postDAO.getAllPost();
	}
	public List<Post> getUserPost(String id) throws ClassNotFoundException, SQLException {
		return this.postDAO.getUserPost(id);
	}
	
	public Post getPost(int id) throws ClassNotFoundException, SQLException {
		Post post = this.postDAO.getPost(id);
		if (post != null) {
			this.postDAO.updatePost(id, post.getCategory(), post.getTitle(), post.getImage(), post.getExcerpt(), post.getContent(), post.getNumViews() + 1);
		}
		return post;
	}
	
	public boolean insertPost(int category, String title, String image, String excerpt, String content, String author, int numViews) throws ClassNotFoundException, SQLException {
		return this.postDAO.insertPost(category, title, image, excerpt, content, author, numViews);
	}
	
	public boolean updatePost(int id, int category, String title, String image, String excerpt, String content, int numViews) throws ClassNotFoundException, SQLException {
		return this.postDAO.updatePost(id, category, title, image, excerpt, content, numViews);
	}
	
	public boolean deletePost(int id, String userId) throws ClassNotFoundException, SQLException {
		return this.postDAO.deletePost(id, userId);
	}
	
	public List<Post> searchPost(String searchString) throws ClassNotFoundException, SQLException {
		return this.postDAO.searchPost(searchString);
	}
	
	public List<Post> searchPostByCategory(int category) throws ClassNotFoundException, SQLException {
		return this.postDAO.searchPostByCategory(category);
	}
}
