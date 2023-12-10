package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Account;

public class AccountDAO {
	
	public List<Account> getAllAccount() throws SQLException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM Account";
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	Account account = new Account(rs);
        	accounts.add(account);
        }
        Connector.closeConnection(conn, stmt);
        return accounts;
    }
	
	public Account getAccount(String username) throws SQLException, ClassNotFoundException {
		Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM account WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();
        Account account = null;
        if (rs.next()) {
        	account =  new Account(rs);
        }
        Connector.closeConnection(conn, stmt);
        return account;
	}
	
	public boolean insertAccount(String username, String password) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
		
		String sql = "INSERT INTO account (username, password) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, username);
        stmt.setString(2, password);

        int affectedRows = stmt.executeUpdate();
		
        Connector.closeConnection(conn, stmt);
		return affectedRows > 0;
	}
	
	public boolean updateAccount(String username, String password) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
	
		String sql = "UPDATE account SET password = ? WHERE username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, password);
        
        int affectedRows = stmt.executeUpdate();
        
        Connector.closeConnection(conn, stmt);
        
        return affectedRows > 0;
	}
	
	public boolean deleteAccount(String username) throws ClassNotFoundException, SQLException {
		Connection conn = Connector.getConnection();
		
		String sql = "DELETE FROM account WHERE username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		
		int affectedRows = stmt.executeUpdate();
		
		Connector.closeConnection(conn, stmt);
		
		return affectedRows > 0;
	}
	
	public List<Account> searchAccount(String searchString) throws ClassNotFoundException, SQLException {
		List<Account> accounts = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM account WHERE username LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + searchString + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	Account account = new Account(rs);
        	accounts.add(account);
        }
        Connector.closeConnection(conn, stmt);
        return accounts;
	}
}
