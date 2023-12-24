/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.DaoReservasi;
import dao.ReservasiInterface;
import java.util.List;
import javax.swing.table.TableModel;
import model.Reservasi;
import model.tableModelReservasi;
import view.Beranda;
import view.InformasiKamar;
/**
 *
 * @author ASUS
 */
public class BerandaController {
    Beranda frame;
    ReservasiInterface reservasiInfc;
    List<Reservasi> listReservasi;

    public BerandaController(Beranda frame) {
        this.frame = frame;
        reservasiInfc = new DaoReservasi();
    }
    
    public void load_table() {
        listReservasi = reservasiInfc.getData();
        tableModelReservasi tmp = new tableModelReservasi(listReservasi);
        frame.getTabelPelanggan().setModel((TableModel) tmp);
    }
    
    public void showInformasiKamar() {
        InformasiKamar informasiKamarFrame = new InformasiKamar(listReservasi);
        informasiKamarFrame.setVisible(true);
    }
    
}
