package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.bean.Post;

public class PostDAO {
	
	public List<Post> getAllPost() throws SQLException, ClassNotFoundException {
        List<Post> posts = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM Post";
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
//            int id = rs.getInt("id");
//            int category = rs.getInt("category");
//            String title = rs.getString("title");
//            String image = rs.getString("image");
//            String excerpt = rs.getString("excerpt");
//            String content = rs.getString("content");
//            String author = rs.getString("author");
//            Date date = rs.getDate("date");
//            int num_views = rs.getInt("num_views");
//
//            Post post = new Post(id, category, title, image, excerpt, content, author, date, num_views);
        	Post post = new Post(rs);
        	posts.add(post);
        }
        Connector.closeConnection(conn, stmt);
        return posts;
    }
	
	public Post getPost(int id) throws SQLException, ClassNotFoundException {
		Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM post WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Post post = null;
        if (rs.next()) {
//            int category = rs.getInt("category");
//            String title = rs.getString("title");
//            String image = rs.getString("image");
//            String excerpt = rs.getString("excerpt");
//            String content = rs.getString("content");
//            String author = rs.getString("author");
//            Date date = rs.getDate("date");
//            int num_views = rs.getInt("num_views");
//
//            return new Post(id, category, title, image, excerpt, content, author, date, num_views);
        	post =  new Post(rs);
        }
        Connector.closeConnection(conn, stmt);
        return post;
	}
	
	public boolean insertPost(int id, int category, String title, String image, String excerpt, String content, String author, Date date, int numViews) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
		
		String sql = "INSERT INTO post (id, category, title, image, excerpt, content, author, date, num_views) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.setInt(2, category);
        stmt.setString(3, title);
        stmt.setString(4, image);
        stmt.setString(5, excerpt);
        stmt.setString(6, content);
        stmt.setString(7, author);
        stmt.setDate(8, new java.sql.Date(date.getTime()));
        stmt.setInt(9, numViews);

        int affectedRows = stmt.executeUpdate();
		
        Connector.closeConnection(conn, stmt);
		return affectedRows > 0;
	}
	
	public boolean updatePost(int id, int category, String title, String image, String excerpt, String content, String author, Date date, int numViews) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
	
		String sql = "UPDATE post SET category = ?, title = ?, image = ?, excerpt = ?, content = ?, author = ?, date = ?, num_views = ? WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, category);
        stmt.setString(2, title);
        stmt.setString(3, image);
        stmt.setString(4, excerpt);
        stmt.setString(6, content);
        stmt.setString(7, author);
        stmt.setDate(8, new java.sql.Date(date.getTime()));
        stmt.setInt(9, numViews);
        
        int affectedRows = stmt.executeUpdate();
        
        Connector.closeConnection(conn, stmt);
        
        return affectedRows > 0;
	}
	
	public boolean deletePost(int id) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
		
		String sql = "DELETE FROM post WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		int affectedRows = stmt.executeUpdate();
		
		Connector.closeConnection(conn, stmt);
		
		return affectedRows > 0;
	}
	
	public List<Post> searchPost(String searchString) throws ClassNotFoundException, SQLException {
		List<Post> posts = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM post WHERE title LIKE ? OR content LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + searchString + "%");
        stmt.setString(2, "%" + searchString + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	Post post = new Post(rs);
        	posts.add(post);
        }
        Connector.closeConnection(conn, stmt);
        return posts;
	}
	
	public List<Post> searchPostByCategory(int category) throws ClassNotFoundException, SQLException {
		List<Post> posts = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM post WHERE category LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, category);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	Post post = new Post(rs);
        	posts.add(post);
        }
        Connector.closeConnection(conn, stmt);
        return posts;
	}
}