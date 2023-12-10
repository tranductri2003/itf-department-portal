package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Category;
import model.dao.CategoryDAO;

public class CategoryBO {
	
	private CategoryDAO categoryDAO;
	
	public CategoryBO() {
		this.categoryDAO = new CategoryDAO();
	}
	
	public List<Category> getAllCategory() throws ClassNotFoundException, SQLException {
		return this.categoryDAO.getAllCategory();
	}
	
	public Category getCategory(int id) throws ClassNotFoundException, SQLException {
		return this.categoryDAO.getCategory(id);
	}
	
	public boolean insertCategory(int id, String title) throws ClassNotFoundException, SQLException {
		return this.categoryDAO.insertCategory(id, title);
	}
	
	public boolean updateCategory(int id, String title) throws ClassNotFoundException, SQLException {
		return this.categoryDAO.updateCategory(id, title);
	}
	
	public boolean deleteCategory(int id) throws ClassNotFoundException, SQLException {
		return this.categoryDAO.deleteCategory(id);
	}
	
	public List<Category> searchCategory(String searchString) throws ClassNotFoundException, SQLException {
		return this.categoryDAO.searchCategory(searchString);
	}
}
