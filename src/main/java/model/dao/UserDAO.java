package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.User;


public class UserDAO {

    public List<User> getAllUser() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM user";
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User user = new User(rs);
            users.add(user);
        }
        Connector.closeConnection(conn, stmt);
        return users;
    }

    public User Validate(String username, String password) throws SQLException, ClassNotFoundException {
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM account WHERE username = ? and password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();


        User user = null;
        if (rs.next()) {
            return this.getUser(username);
        }
        Connector.closeConnection(conn, stmt);
        return user;
    }




    public User getUser(String id) throws SQLException, ClassNotFoundException {
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);

        ResultSet rs = stmt.executeQuery();
        User user = null;
        if (rs.next()) {
            user =  new User(rs);
        }
        Connector.closeConnection(conn, stmt);
        return user;
    }

    public boolean insertUser(String id, String fullName, String phoneNumber, String email, String role, String address) throws ClassNotFoundException, SQLException {
        Connection conn = Connector.getConnection();

        String sql = "INSERT INTO user (id, full_name, phone_number, email, role, address) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, id);
        stmt.setString(2, fullName);
        stmt.setString(3, phoneNumber);
        stmt.setString(4, email);
        stmt.setString(5, role);
        stmt.setString(6, address);

        int affectedRows = stmt.executeUpdate();

        Connector.closeConnection(conn, stmt);
        return affectedRows > 0;
    }

    public boolean updateUser(String id, String fullName, String phoneNumber, String email, String role, String address, String about) throws ClassNotFoundException, SQLException {
        Connection conn = Connector.getConnection();

        String sql = "UPDATE user SET full_name = ?, phone_number = ?, email = ?, role = ?, address = ?, about = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, fullName);
        stmt.setString(2, phoneNumber);
        stmt.setString(3, email);
        stmt.setString(4, role);
        stmt.setString(5, address);
        stmt.setString(6, about); 
        stmt.setString(7, id); 


        int affectedRows = stmt.executeUpdate();

        Connector.closeConnection(conn, stmt);

        return affectedRows > 0;
    }

    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException {
        Connection conn = Connector.getConnection();

        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);

        int affectedRows = stmt.executeUpdate();

        Connector.closeConnection(conn, stmt);

        return affectedRows > 0;
    }

    public List<User> searchUser(String searchString) throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<>();
        Connection conn = Connector.getConnection();
        String sql = "SELECT * FROM user WHERE full_name LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + searchString + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User user = new User(rs);
            users.add(user);
        }
        Connector.closeConnection(conn, stmt);
        return users;
    }
}
