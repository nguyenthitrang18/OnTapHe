/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import utils.JDBCUtils;

/**
 *
 * @author ADMIN
 */
public class BookRepository {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    public BookRepository() {
        conn = JDBCUtils.getConnection();
    }
    
    public List<Book> getList(){
        try {
            List<Book> lstbook = new ArrayList<>();
            String sql = "select * from book";
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.getResultSet();
            while(rs.next()){
                Integer madm = rs.getInt("category_id");
                String masp = rs.getString("book_code");
                String tensp = rs.getString("book_name");
                BigDecimal gia = rs.getBigDecimal("current_price");
                Integer slg = rs.getInt("quantity");
                
                Book b = new Book(madm, masp, tensp, gia, slg);
                lstbook.add(b);
            }
            return lstbook;
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return  null;
    }
    
    public boolean insert(Book b){
        try {
            String sql = "insert into book "
                    + "(category_id, book_code, book_name, current_price, quantity) values"
                    + "(?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getMadanhmuc());
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
    
    
    public boolean update(String ma, Book b){
        try {
            String sql = "update book"
                    + " set category_id = ?,"
                    + " book_name = ?,"
                    + " current_price = ?,"
                    + " quantity = ?"
                    + " where book_code = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getMadanhmuc());
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
    
    
    public boolean delete(String ma) {
        try {
            String sql = "delete from book"
                    + " where book_code = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ma);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    

    public Book findName(String ten){
        try {
            String sql = "select * from book"
                    +" where book_name like '%"+ten+"%'" ;
            ps = conn.prepareStatement(sql);
            //ps.setString(1, ten);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Book(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBigDecimal(5), rs.getInt(6));
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }  
    }
    
    
}
