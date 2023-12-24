package model;

import java.sql.Date;

public class Reservasi {
    private Date tanggalMasuk; 
    private Date tanggalKeluar;
    private Pelanggan pelanggan;
    private Kamar kamar;
    private Pembayaran pembayaran;

    public Reservasi() {
        this.pelanggan = new Pelanggan();
        this.kamar = new Kamar();
        this.tanggalMasuk = null;
        this.tanggalKeluar = null;
        this.pembayaran = new Pembayaran();
    }

    public int getId(){
        return pelanggan.getId();
    }
    
    public String getNamaPelanggan(){
        return pelanggan.getNamaPelanggan();
    }
    
    public String getNohp(){
        return pelanggan.getNohp();
    }
    
    public int getJumlahPelanggan(){
        return pelanggan.getJumlahPelanggan();
    }
    
    public String getTipeKamar(){
        return kamar.getTipeKamar();
    }
    
    public int getNoKamar(){
        return kamar.getNoKamar();
    }
    
    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }
    
    public int getHarga(){
        return pembayaran.getHarga();
    }
    
    public String getTipePembayaran(){
        return pembayaran.getTipePembayaran();
    }
    
    public void setId(int id) {
        pelanggan.setId(id);
    }
    
    public void setNamaPelanggan(String namaPelanggan) {
        pelanggan.setNamaPelanggan(namaPelanggan);
    }
    
    public void setNohp(String nohp) {
        pelanggan.setNohp(nohp);
    }
    
    public void setJumlahPelanggan(int jumlahPelanggan) {
        pelanggan.setJumlahPelanggan(jumlahPelanggan);
    }
    
    public void setTipeKamar(String tipeKamar) {
        kamar.setTipeKamar(tipeKamar);
    }
    
    public void setNoKamar(int noKamar) {
        kamar.setNoKamar(noKamar);
    }
    
    public void setHarga(int harga) {
        pembayaran.setHarga(harga);
    }

    public void setTipePembayaran(String tipePembayaran) {
        pembayaran.setTipePembayaran(tipePembayaran);
    }
    
    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public void setTanggalKeluar(Date tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }
}
