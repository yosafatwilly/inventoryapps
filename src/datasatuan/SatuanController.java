package datasatuan;

import connection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SatuanController {

    public static Satuan getById(String id) {
        Satuan satuan = new Satuan();
        try {
            String sql = "SELECT * from satuan where id_satuan = ?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                satuan.setIdSatuan(rs.getString(1));
                satuan.setName(rs.getString(2));
                satuan.setDescription(rs.getString(3));
                satuan.setLastUpdated(rs.getTimestamp(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SatuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satuan;
    }
    
    public static void insert(Satuan sat) {
        try {
            String sql = "INSERT INTO SATUAN(id_satuan, name,description,last_updated) VALUES(?,?,?,?)";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, sat.getIdSatuan());
            st.setString(2, sat.getName());
            st.setString(3, sat.getDescription());
            st.setTimestamp(4, sat.getLastUpdated());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan.");
        } catch (SQLException ex) {
            Logger.getLogger(SatuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(String id) {
        try {
            String sql = "delete from SATUAN where id_satuan=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Delete");
        } catch (SQLException ex) {
            Logger.getLogger(SatuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Satuan sat) {
        try {
            String sql = "UPDATE SATUAN SET name =?,description=?, last_updated=? where id_satuan =?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, sat.getName());
            st.setString(2, sat.getDescription());
            st.setTimestamp(3, sat.getLastUpdated());
            st.setString(4, sat.getIdSatuan());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Update");
        } catch (SQLException ex) {
            Logger.getLogger(SatuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Satuan> getAll(String key) {
        List<Satuan> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM satuan WHERE LOWER(name) LIKE '%" + key + "%'\n"
                    + "			OR UPPER(name) LIKE '%" + key + "%'\n"
                    + "			OR LOWER(name) LIKE '" + key + "%'\n"
                    + "			OR UPPER(name) LIKE '" + key + "%'\n"
                    + "			OR LOWER(name) LIKE '%" + key + "'\n"
                    + "			OR UPPER(name) LIKE '%" + key + "'";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Satuan sat = new Satuan();
                sat.setIdSatuan(rs.getString(1));
                sat.setName(rs.getString(2));
                sat.setDescription(rs.getString(3));
                sat.setLastUpdated(rs.getTimestamp(4));
                list.add(sat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SatuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static String getCount() {
        String count = null;
        try {
            String sql = "SELECT COUNT(*) FROM SATUAN";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                count = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SatuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
