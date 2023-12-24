package dao;
import controller.KoneksiController;
import model.Reservasi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReservasi implements ReservasiInterface{
    Connection connection;
    final String insert = "INSERT INTO pelanggan (namaPelanggan,nohp,jumlahPelanggan,tipeKamar,noKamar,tanggalMasuk,tanggalKeluar,harga,tipePembayaran) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE pelanggan SET namaPelanggan=?,nohp=?,jumlahPelanggan=?,tipeKamar=?,noKamar=?,tanggalMasuk=?,tanggalKeluar=?,harga=?,tipePembayaran=? WHERE id=? ;";
    final String delete = "DELETE FROM pelanggan WHERE id=? ;";
    final String select = "SELECT * FROM pelanggan";
    
    public DaoReservasi() {
        connection = KoneksiController.connection();
    }
    
    @Override
    public void insert(Reservasi reservasi){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, reservasi.getNamaPelanggan());
            statement.setString(2, reservasi.getNohp());
            statement.setInt(3, reservasi.getJumlahPelanggan());
            statement.setString(4, reservasi.getTipeKamar());
            statement.setInt(5, reservasi.getNoKamar());
            statement.setDate(6, reservasi.getTanggalMasuk());
            statement.setDate(7, reservasi.getTanggalKeluar());
            statement.setInt(8, reservasi.getHarga());
            statement.setString(9, reservasi.getTipePembayaran());
            statement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Override
    public void update(Reservasi reservasi){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, reservasi.getNamaPelanggan());
            statement.setString(2, reservasi.getNohp());
            statement.setInt(3, reservasi.getJumlahPelanggan());
            statement.setString(4, reservasi.getTipeKamar());
            statement.setInt(5, reservasi.getNoKamar());
            statement.setDate(6, reservasi.getTanggalMasuk());
            statement.setDate(7, reservasi.getTanggalKeluar());
            statement.setInt(8, reservasi.getHarga());
            statement.setString(9, reservasi.getTipePembayaran());
            statement.setInt(10, reservasi.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public List<Reservasi> getData() {
        List<Reservasi> listReservasi = new ArrayList<>();

        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(select);

                while (rs.next()) {
                    Reservasi reservasi = new Reservasi();
                    reservasi.setId(rs.getInt("id"));
                    reservasi.setNamaPelanggan(rs.getString("namaPelanggan"));
                    reservasi.setNohp(rs.getString("nohp"));
                    reservasi.setJumlahPelanggan(rs.getInt("jumlahPelanggan"));
                    reservasi.setTipeKamar(rs.getString("tipeKamar"));
                    reservasi.setNoKamar(rs.getInt("noKamar"));
                    reservasi.setTanggalMasuk(rs.getDate("tanggalMasuk"));
                    reservasi.setTanggalKeluar(rs.getDate("tanggalKeluar"));
                    reservasi.setHarga(rs.getInt("harga"));
                    reservasi.setTipePembayaran(rs.getString("tipePembayaran"));

                    listReservasi.add(reservasi);
                }
            } else {
                System.out.println("Connection is null. Ensure it is properly initialized before calling getData.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoReservasi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listReservasi;
    }


}
