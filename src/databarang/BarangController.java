package databarang;

import datakategori.KategoriController;
import datasatuan.SatuanController;
import connection.DatabaseConnection;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BarangController {

//Input Barang
    public static void insert(Barang brg, InputStream img) {
        try {
            String sql = "INSERT INTO BARANG(id_barang, id_kategori,id_satuan,nama,stok,deskripsi,last_updated,image) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, brg.getIdBarang());
            st.setString(2, brg.getKategori().getIdKategori());
            st.setString(3, brg.getSatuan().getIdSatuan());
            st.setString(4, brg.getNama());
            st.setInt(5, brg.getStok());
            st.setString(6, brg.getDeskripsi());
            st.setTimestamp(7, brg.getLastUpdated());
            st.setBinaryStream(8, img);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan.");
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Hapus barang
    public static void delete(String id) {
        try {
            String sql = "delete from barang where id_barang=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Delete");
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Update Barang
    public static void update(Barang brg) {
        try {
            String sql = "UPDATE BARANG SET id_kategori=?,id_satuan=?,nama=?,stok=?,deskripsi=?,last_updated=? where id_barang =?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, brg.getKategori().getIdKategori());
            st.setString(2, brg.getSatuan().getIdSatuan());
            st.setString(3, brg.getNama());
            st.setInt(4, brg.getStok());
            st.setString(5, brg.getDeskripsi());
            st.setTimestamp(6, brg.getLastUpdated());
            st.setString(7, brg.getIdBarang());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Update");
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Update Barang dengan gambar
    public static void updateWithImage(Barang brg, InputStream img) {
        try {
            String sql = "UPDATE BARANG SET id_kategori=?,id_satuan=?,nama=?,stok=?,deskripsi=?,last_updated=?,image=? where id_barang =?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, brg.getKategori().getIdKategori());
            st.setString(2, brg.getSatuan().getIdSatuan());
            st.setString(3, brg.getNama());
            st.setInt(4, brg.getStok());
            st.setString(5, brg.getDeskripsi());
            st.setTimestamp(6, brg.getLastUpdated());
            st.setBinaryStream(7, img);
            st.setString(8, brg.getIdBarang());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Update");
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Update Stok Barang
    public static void updateStok(Barang brg) {
        try {
            String sql = "UPDATE BARANG SET stok=? where id_barang =?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setInt(1, brg.getStok());
            st.setString(2, brg.getIdBarang());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Ambil data semua barang
//Jika paramater key terisi maka akan menampilkan barang sesuai dengan nama barang yang dicari
    public static List<Barang> getAll(String key) {
        List<Barang> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM BARANG WHERE LOWER(nama) LIKE '%" + key + "%'\n"
                    + "			OR UPPER(nama) LIKE '%" + key +"'";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setIdBarang(rs.getString(1));
                brg.setKategori(KategoriController.getById(rs.getString(2)));
                brg.setSatuan(SatuanController.getById(rs.getString(3)));
                brg.setNama(rs.getString(4));
                brg.setStok(rs.getInt(5));
                brg.setDeskripsi(rs.getString(6));
                brg.setLastUpdated(rs.getTimestamp(7));
                Icon icon = null;
                if (rs.getObject("image") != null) {
                    icon = new ImageIcon(rs.getBytes("image"));
                }
                brg.setImages(icon);
                list.add(brg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//Ambil barang berdasarkan id barang
    public static Barang getById(String id) {
        Barang brg = new Barang();
        try {
            String sql = "SELECT * FROM BARANG WHERE id_barang=" + id;
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                brg.setIdBarang(rs.getString(1));
                brg.setKategori(KategoriController.getById(rs.getString(2)));
                brg.setSatuan(SatuanController.getById(rs.getString(3)));
                brg.setNama(rs.getString(4));
                brg.setStok(rs.getInt(5));
                brg.setDeskripsi(rs.getString(6));
                brg.setLastUpdated(rs.getTimestamp(7));
                Icon icon = null;
                if (rs.getObject("image") != null) {
                    icon = new ImageIcon(rs.getBytes("image"));
                }
                brg.setImages(icon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brg;
    }

//Mengambil total jumlah barang
    public static String getCount() {
        String count = null;
        try {
            String sql = "SELECT COUNT(*) FROM BARANG";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                count = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
