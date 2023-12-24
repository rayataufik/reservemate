/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;
/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private int id; 
    private String namaPelanggan;
    private String nohp; 
    private int jumlahPelanggan;
    
    public int getId() {
        return id;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNohp() {
        return nohp;
    }

    public int getJumlahPelanggan() {
        return jumlahPelanggan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public void setJumlahPelanggan(int jumlahPelanggan) {
        this.jumlahPelanggan = jumlahPelanggan;
    }

}
