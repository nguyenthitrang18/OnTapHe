/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kho;
import utils.JDBCUtils;

/**
 *
 * @author ADMIN
 */
public class KhoRepository {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public KhoRepository() {
        conn = JDBCUtils.getConnection();
    }
    
    public List<Kho> getList(){
        try {
            List<Kho> lstkho = new ArrayList<>();
            String sql = "select * from inventory_log";
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.getResultSet();
            while(rs.next()){
                Integer masp = rs.getInt("product_id");
                String maphieu = rs.getString("form_id");
                Integer loai = rs.getInt("type_form");
                Date ngay = rs.getDate("created_date");
                Integer slg = rs.getInt("quantity");
                
                Kho k = new Kho(masp, maphieu, loai, ngay, slg);
                lstkho.add(k);
            }
            return lstkho;
        } catch (SQLException ex) {
            Logger.getLogger(KhoRepository.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
}
