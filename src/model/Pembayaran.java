/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Pembayaran {
    private int harga;
    private String tipePembayaran;
    
    public int getHarga() {
        return harga;
    }

    public String getTipePembayaran() {
        return tipePembayaran;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
    }
}
