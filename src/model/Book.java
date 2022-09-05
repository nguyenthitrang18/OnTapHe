/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;


/**
 *
 * @author ADMIN
 */
public class Book {
    private Integer madanhmuc;
    private String masp;
    private String tensp;
    private BigDecimal gia;
    private Integer soluong;

    public Book() {
    }

    public Book(Integer madanhmuc, String masp, String tensp, BigDecimal gia, Integer soluong) {
        this.madanhmuc = madanhmuc;
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
    }

    public Integer getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(Integer madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    
    
    
}
