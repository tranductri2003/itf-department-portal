package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Account;
import model.dao.AccountDAO;

public class AccountBO {
	
	private AccountDAO accountDAO;
	
	public AccountBO() {
		this.accountDAO = new AccountDAO();
	}
	
	public List<Account> getAllAccount() throws ClassNotFoundException, SQLException {
		return this.accountDAO.getAllAccount();
	}
	
	public Account getAccount(String username) throws ClassNotFoundException, SQLException {
		return this.accountDAO.getAccount(username);
	}
	
	public boolean insertAccount(String username, String password) throws ClassNotFoundException, SQLException {
		return this.accountDAO.insertAccount(username, password);
	}
	
	public boolean updateAccount(String username, String password) throws ClassNotFoundException, SQLException {
		return this.accountDAO.updateAccount(username, password);
	}
	
	public boolean deleteAccount(String username) throws ClassNotFoundException, SQLException {
		return this.accountDAO.deleteAccount(username);
	}
	
	public List<Account> searchAccount(String searchString) throws ClassNotFoundException, SQLException {
		return this.accountDAO.searchAccount(searchString);
	}
}
