/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Book1;
import repository.Book1Repository;

/**
 *
 * @author ADMIN
 */
public class Book1Service {
    private Book1Repository repos;

    public Book1Service() {
        repos = new Book1Repository();
    }
    
    public List<Book1> ListSrv(){
        return repos.getList();
    }
    public boolean insertB(Book1 b){
        return repos.insertBook(b);
    }
    public boolean updateB(String ma,Book1 b){
        return repos.updateBook(ma,b);
    }
    
    
}
