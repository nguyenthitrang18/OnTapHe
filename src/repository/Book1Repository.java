/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book1;
import utils.JDBCUtils;

/**
 *
 * @author ADMIN
 */
public class Book1Repository {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    public Book1Repository() {
        conn = JDBCUtils.getConnection();
    }
    
    public List<Book1> getList(){
        try {
            List<Book1> lstb1 = new ArrayList<>();
            String sql = "select b.book_code as ma,b.book_name as ten,b.current_price as gia,ct.category_name as danhmuc,b.quantity as soluong"
                    +" from book as b left join category as ct on b.category_id  = ct.id";
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.getResultSet();
            while(rs.next()){
                String madm = rs.getString("danhmuc");
                String masp = rs.getString("ma");
                String tensp = rs.getString("ten");
                BigDecimal gia = rs.getBigDecimal("gia");
                Integer slg = rs.getInt("soluong");
                
                Book1 b1 = new Book1(madm, masp, tensp, gia, slg);
                lstb1.add(b1);
            }   
            return lstb1;
        } catch (SQLException ex) {
            Logger.getLogger(Book1Repository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public boolean insert(Book1 b){
        try {
            String sql = "insert into book values"
                    + "(category_id, book_code, book_name, current_price, quantity)"
                    + "(?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMadanhmuc());
            ps.setString(2, b.getMasp());
            ps.setString(3, b.getTensp());
            ps.setBigDecimal(4, b.getGia());
            ps.setInt(5, b.getSoluong());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    
    public boolean insertBook(Book1 b){
        try {
            String sql = "insert into book "
                    + "(category_id, book_code, book_name, current_price, quantity) values"
                    + " (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMadanhmuc());
            ps.setString(2, b.getMasp());
            ps.setString(3, b.getTensp());
            ps.setBigDecimal(4, b.getGia());
            ps.setInt(5, b.getSoluong());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateBook(String ma, Book1 b){
        try {
            String sql = "update book"
                    + " set category_id = ?,"
                    + " book_name = ?,"
                    + " current_price = ?,"
                    + " quantity = ?"
                    + " where book_code = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMadanhmuc());
            ps.setString(2, b.getTensp());
            ps.setBigDecimal(3, b.getGia());
            ps.setInt(4, b.getSoluong());
            ps.setString(5, ma);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
}
