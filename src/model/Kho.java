/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Kho {
    private Integer masp;
    private String maphieu;
    private Integer loaiphieu;
    private Date ngaytao;
    private Integer soluong;

    public Kho() {
    }

    public Kho(Integer masp, String maphieu, Integer loaiphieu, Date ngaytao, Integer soluong) {
        this.masp = masp;
        this.maphieu = maphieu;
        this.loaiphieu = loaiphieu;
        this.ngaytao = ngaytao;
        this.soluong = soluong;
    }

    public Integer getMasp() {
        return masp;
    }

    public void setMasp(Integer masp) {
        this.masp = masp;
    }

    public String getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(String maphieu) {
        this.maphieu = maphieu;
    }

    public Integer getLoaiphieu() {
        return loaiphieu;
    }

    public void setLoaiphieu(Integer loaiphieu) {
        this.loaiphieu = loaiphieu;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }
    
    
}
