/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Kho;
import repository.KhoRepository;

/**
 *
 * @author ADMIN
 */
public class KhoService {
    private KhoRepository repos;

    public KhoService() {
        repos = new KhoRepository();
    }

    
    public List<Kho> ListKho() {
        return repos.getList();
    }
    
    
}
