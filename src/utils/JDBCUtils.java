/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class JDBCUtils {
    private static java.sql.Connection conn;

    public static java.sql.Connection getConnection() { 
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "trang", dbPass = "123", dbUrl = "jdbc:sqlserver://localhost:1433;"
                        + ";databaseName=baitesthe;encrypt=false;";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Ket noi thanh cong");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}
