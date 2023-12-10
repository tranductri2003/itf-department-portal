package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.bean.Category;

public class CategoryDAO {
	
	public List<Category> getAllCategory() throws SQLException, ClassNotFoundException {
        List<Category> categorys = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM Category";
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	Category category = new Category(rs);
        	categorys.add(category);
        }
        Connector.closeConnection(conn, stmt);
        return categorys;
    }
	
	public Category getCategory(int id) throws SQLException, ClassNotFoundException {
		Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM category WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Category category = null;
        if (rs.next()) {
        	category =  new Category(rs);
        }
        Connector.closeConnection(conn, stmt);
        return category;
	}
	
	public boolean insertCategory(int id, String title) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
		
		String sql = "INSERT INTO category (id, title) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.setString(2, title);

        int affectedRows = stmt.executeUpdate();
		
        Connector.closeConnection(conn, stmt);
		return affectedRows > 0;
	}
	
	public boolean updateCategory(int id, String title) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
	
		String sql = "UPDATE category SET title = ? WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, title);
        
        int affectedRows = stmt.executeUpdate();
        
        Connector.closeConnection(conn, stmt);
        
        return affectedRows > 0;
	}
	
	public boolean deleteCategory(int id) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
		
		String sql = "DELETE FROM category WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		int affectedRows = stmt.executeUpdate();
		
		Connector.closeConnection(conn, stmt);
		
		return affectedRows > 0;
	}
	
	public List<Category> searchCategory(String searchString) throws ClassNotFoundException, SQLException {
		List<Category> categorys = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM category WHERE title LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + searchString + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	Category category = new Category(rs);
        	categorys.add(category);
        }
        Connector.closeConnection(conn, stmt);
        return categorys;
	}
}
