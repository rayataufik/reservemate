/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoReservasi;
import dao.ReservasiInterface;
import javax.swing.JOptionPane;
import model.Reservasi;
import view.Beranda;

/**
 *
 * @author ASUS
 */
public class HapusController {
    Beranda frame;
    ReservasiInterface reservasiInfc;

    public HapusController(Beranda frame) {
        this.frame = frame;
        reservasiInfc = new DaoReservasi();
    }
    
    public void hapus(int id) {
        int confirmDialogResult = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            reservasiInfc.delete(id);
            JOptionPane.showMessageDialog(frame, "Berhasil Menghapus data");
            kosongkan_form();
        }
    }

    
    public void kosongkan_form() {
        frame.setTxtNamaPelanggan("");
        frame.setTxtNohp("");
        frame.setTxtJumlahPelanggan("");
        frame.setCbTipeKamar("");
        frame.setTxtNoKamar("");
        frame.getDtTanggalMasuk().setDate(null); 
        frame.getDtTanggalKeluar().setDate(null);
        frame.setCbTipePembayaran("");
    }
}
