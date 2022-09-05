/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Book;
import repository.BookRepository;

/**
 *
 * @author ADMIN
 */
public class BookService {
    private BookRepository repos;

    public BookService() {
        repos = new BookRepository();
    }
    
    public List<Book> ListSrv(){
        return repos.getList();
    }
    
    public boolean insertSrv(Book b){
        return repos.insert(b);
    }
    
    public boolean updateSrv(String ma, Book b){
        return repos.update(ma,b);
    }
    
    public boolean deleteSrv(String ma){
        return repos.delete(ma);
    }
    
    public Book findName(String ten){
        return repos.findName(ten);
    }
    
    
}
