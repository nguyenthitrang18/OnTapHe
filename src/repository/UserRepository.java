/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.JDBCUtils;
/**
 *
 * @author ADMIN
 */
public class UserRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conn;

    public UserRepository() {
        conn = JDBCUtils.getConnection();
    }
    
    public User getList(String username, String password){
        try {
            String sql = "select * from account"
                    + " where username = ?"
                    + " and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
