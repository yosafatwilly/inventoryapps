package datakategori;

import connection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class KategoriController {

    public static Kategori getById(String id) {
        Kategori kategori = new Kategori();
        try {
            String sql = "SELECT * from kategori where id_kategori = ?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                kategori.setIdKategori(rs.getString(1));
                kategori.setName(rs.getString(2));
                kategori.setDescription(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategori;
    }

    public static void insert(Kategori kat) {
        try {
            String sql = "INSERT INTO KATEGORI(id_kategori, name,description) VALUES(?,?,?)";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, kat.getIdKategori());
            st.setString(2, kat.getName());
            st.setString(3, kat.getDescription());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan.");
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(String id) {
        try {
            String sql = "delete from kategori where id_kategori=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Delete");
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Kategori kat) {
        try {
            String sql = "UPDATE KATEGORI SET name =?,description=? where id_kategori =?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, kat.getName());
            st.setString(2, kat.getDescription());
            st.setString(3, kat.getIdKategori());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Update");
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Kategori> getAll(String key) {
        List<Kategori> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM kategori WHERE LOWER(name) LIKE '%" + key + "%'\n"
                    + "			OR UPPER(name) LIKE '%" + key + "%'\n"
                    + "			OR LOWER(name) LIKE '" + key + "%'\n"
                    + "			OR UPPER(name) LIKE '" + key + "%'\n"
                    + "			OR LOWER(name) LIKE '%" + key + "'\n"
                    + "			OR UPPER(name) LIKE '%" + key + "'";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Kategori kate = new Kategori();
                kate.setIdKategori(rs.getString(1));
                kate.setName(rs.getString(2));
                kate.setDescription(rs.getString(3));
                list.add(kate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static String getCount() {
        String count = null;
        try {
            String sql = "SELECT COUNT(*) FROM KATEGORI";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                count = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
