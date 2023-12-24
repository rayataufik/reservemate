/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Pelanggan;
import java.util.List;
import model.Reservasi;
/**
 *
 * @author ASUS
 */
public interface ReservasiInterface {
    
    public void insert(Reservasi reservasi);
    public void update(Reservasi reservasi);
    public void delete(int id);
    public List<Reservasi> getData();
}
