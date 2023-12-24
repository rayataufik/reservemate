/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class tableModelReservasi extends AbstractTableModel {
    private List<Reservasi> data;
    private String[] columnNames = {"Id","Nama Pelanggan", "No HP", "Jumlah Pelanggan", "Tipe Kamar", "No Kamar", "Tanggal Masuk", "Tanggal Keluar", "Harga", "Tipe Pembayaran"};

    public tableModelReservasi(List<Reservasi> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservasi reservasi = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return reservasi.getId();
            case 1:
                return reservasi.getNamaPelanggan();
            case 2:
                return reservasi.getNohp();
            case 3:
                return reservasi.getJumlahPelanggan();
            case 4:
                return reservasi.getTipeKamar();
            case 5:
                return reservasi.getNoKamar();
            case 6:
                return reservasi.getTanggalMasuk().toString(); 
            case 7:
                return reservasi.getTanggalKeluar().toString(); 
            case 8:
                return reservasi.getHarga();
            case 9:
                return reservasi.getTipePembayaran();
            default:
                return null;
        }
    }


    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Reservasi> newData) {
        data = newData;
        fireTableDataChanged();
    }
}