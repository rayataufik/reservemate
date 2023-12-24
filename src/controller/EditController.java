/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.DaoReservasi;
import dao.ReservasiInterface;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Reservasi;
import view.Beranda;
/**
 *
 * @author ASUS
 */
public class EditController {
    Beranda frame;
    ReservasiInterface reservasiInfc;

    public EditController(Beranda frame) {
        this.frame = frame;
        reservasiInfc = new DaoReservasi();
    }
    
    public void simpan_edit(int id) {
        String namaPelanggan = frame.getTxtNamaPelanggan().getText().trim();
        String nohp = frame.getTxtNohp().getText().trim();
        String jumlahPelangganStr = frame.getTxtJumlahPelanggan().getText().trim();
        String tipeKamar = (String) frame.getCbTipeKamar().getSelectedItem();
        String noKamarStr = frame.getTxtNoKamar().getText().trim();

        if (namaPelanggan.isEmpty() || nohp.isEmpty() || jumlahPelangganStr.isEmpty() || tipeKamar.isEmpty() || noKamarStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap Pilih Terlebih Dahulu Di Tabel", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        int jumlahPelanggan;
        int noKamar;

        try {
            jumlahPelanggan = Integer.parseInt(jumlahPelangganStr);
            noKamar = Integer.parseInt(noKamarStr);

            if (!((101 <= noKamar && noKamar <= 109) || (201 <= noKamar && noKamar <= 209) || (301 <= noKamar && noKamar <= 309) || (401 <= noKamar && noKamar <= 409))) {
                JOptionPane.showMessageDialog(frame, "Nomor kamar harus dalam rentang 101-109, 201-209, 301-309, atau 401-409", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Reservasi> listReservasi = reservasiInfc.getData();

            if (isNoKamarExists(noKamar, listReservasi)) {
                JOptionPane.showMessageDialog(frame, "Nomor kamar sudah digunakan. Pilih nomor kamar lain.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Jumlah pelanggan dan nomor kamar harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Reservasi reservasi_edit = new Reservasi();
        reservasi_edit.setId(id);
        reservasi_edit.setNamaPelanggan(namaPelanggan);
        reservasi_edit.setNohp(nohp);
        reservasi_edit.setJumlahPelanggan(jumlahPelanggan);
        reservasi_edit.setTipeKamar(tipeKamar);
        reservasi_edit.setNoKamar(noKamar);

        java.util.Date tanggalMasukUtil = frame.getDtTanggalMasuk().getDate();
        java.sql.Date tanggalMasukSql = (tanggalMasukUtil != null) ? new java.sql.Date(tanggalMasukUtil.getTime()) : null;
        reservasi_edit.setTanggalMasuk(tanggalMasukSql);

        java.util.Date tanggalKeluarUtil = frame.getDtTanggalKeluar().getDate();
        java.sql.Date tanggalKeluarSql = (tanggalKeluarUtil != null) ? new java.sql.Date(tanggalKeluarUtil.getTime()) : null;
        reservasi_edit.setTanggalKeluar(tanggalKeluarSql);

        reservasi_edit.setHarga(Integer.parseInt(frame.getLabelTotalharga().getText()));
        reservasi_edit.setTipePembayaran((String) frame.getCbTipePembayaran().getSelectedItem());

        reservasiInfc.update(reservasi_edit);
        JOptionPane.showMessageDialog(frame, "Berhasil mengedit data");
        kosongkan_form();
    }

    private boolean isNoKamarExists(int noKamar, List<Reservasi> listReservasi) {
        for (Reservasi reservation : listReservasi) {
            if (reservation.getNoKamar() == noKamar) {
                return true;
            }
        }
        return false;
    }
    
    public void kosongkan_form(){
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
