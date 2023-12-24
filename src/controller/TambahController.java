package controller;

import dao.DaoReservasi;
import dao.ReservasiInterface;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Reservasi;
import view.Beranda;
import controller.BerandaController;
import java.util.List;

public class TambahController {
    Beranda frame;
    ReservasiInterface reservasiInfc;

    public TambahController(Beranda frame) {
        this.frame = frame;
        reservasiInfc = new DaoReservasi();
    }
    
    public void tambah_data() {
        String namaPelanggan = frame.getTxtNamaPelanggan().getText().trim();
        String nohp = frame.getTxtNohp().getText().trim();
        String jumlahPelangganStr = frame.getTxtJumlahPelanggan().getText().trim();
        String tipeKamar = (String) frame.getCbTipeKamar().getSelectedItem();
        String noKamarStr = frame.getTxtNoKamar().getText().trim();

        if (namaPelanggan.isEmpty() || nohp.isEmpty() || jumlahPelangganStr.isEmpty() || tipeKamar.isEmpty() || noKamarStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Semua kolom harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
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

        Reservasi reservasi = new Reservasi();
        reservasi.setNamaPelanggan(namaPelanggan);
        reservasi.setNohp(nohp);
        reservasi.setJumlahPelanggan(jumlahPelanggan);
        reservasi.setTipeKamar(tipeKamar);
        reservasi.setNoKamar(noKamar);

        java.util.Date tanggalMasukUtil = frame.getDtTanggalMasuk().getDate();
        java.sql.Date tanggalMasukSql = new java.sql.Date(tanggalMasukUtil.getTime());
        reservasi.setTanggalMasuk(tanggalMasukSql);

        java.util.Date tanggalKeluarUtil = frame.getDtTanggalKeluar().getDate();
        java.sql.Date tanggalKeluarSql = new java.sql.Date(tanggalKeluarUtil.getTime());
        reservasi.setTanggalKeluar(tanggalKeluarSql);

        reservasi.setHarga(Integer.parseInt(frame.getLabelTotalharga().getText()));
        reservasi.setTipePembayaran((String) frame.getCbTipePembayaran().getSelectedItem());

        reservasiInfc.insert(reservasi);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan data baru");
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
