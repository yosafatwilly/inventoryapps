package datatransaksi;

import datadetailtransaksi.DetailTransaksi;
import connection.DatabaseConnection;
import datadetailtransaksi.DetailTransaksiController;
import datauser.UserController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TransaksiController {

    public static String insert(Transaksi txn) {
        String id = null;
        String generatedColumns[] = {"id_transaksi"};
        try {
            String sql = "INSERT INTO TRANSAKSI(id_userpeminjam, status,tanggal_request, last_updated) VALUES(?,?,?,?)";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql, generatedColumns);
            st.setString(1, txn.getUserPeminjam().getIdUser());
            st.setString(2, txn.getStatus().toString());
            st.setTimestamp(3, txn.getTanggalRequest());
            st.setTimestamp(4, txn.getLastUpdated());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static void insertDetail(Transaksi txn, DetailTransaksi dtxn) {
        try {
            String sql = "INSERT INTO DETAILTRANSAKSI(id_transaksi, id_barang,jumlah_dipinjam, keterangan) VALUES(?,?,?,?)";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, txn.getIdTransaksi());
            st.setString(2, dtxn.getBarang().getIdBarang());
            st.setInt(3, dtxn.getJumlahBarang());
            st.setString(4, dtxn.getKeterangan());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Transaksi> getAll() {
        List<Transaksi> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TRANSAKSI order by last_updated desc";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transaksi txn = new Transaksi();
                txn.setIdTransaksi(rs.getString(1));
                txn.setUserPeminjam(UserController.getById(rs.getString(2)));
                txn.setUserOperator(UserController.getById(rs.getString(3)));
                txn.setStatus(Transaksi.Status.valueOf(rs.getString(4)));
                txn.setTanggalRequest(rs.getTimestamp(5));
                txn.setLastUpdated(rs.getTimestamp(6));
                txn.setDetailTransaksis(DetailTransaksiController.getById(rs.getString(1)));
                list.add(txn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static List<Transaksi> getAllByUser(String id) {
        List<Transaksi> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TRANSAKSI where id_userpeminjam='"+id+"' order by last_updated desc";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transaksi txn = new Transaksi();
                txn.setIdTransaksi(rs.getString(1));
                txn.setUserPeminjam(UserController.getById(rs.getString(2)));
                txn.setUserOperator(UserController.getById(rs.getString(3)));
                txn.setStatus(Transaksi.Status.valueOf(rs.getString(4)));
                txn.setTanggalRequest(rs.getTimestamp(5));
                txn.setLastUpdated(rs.getTimestamp(6));
                txn.setDetailTransaksis(DetailTransaksiController.getById(rs.getString(1)));
                list.add(txn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void updateStatus(Transaksi txn) {
        try {
            String sql = "UPDATE transaksi set status=?, last_updated=?, id_useroperator =? where id_transaksi=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, txn.getStatus().name());
            st.setTimestamp(2, new Timestamp(new Date().getTime()));
            st.setString(3, txn.getUserOperator().getIdUser());
            st.setString(4, txn.getIdTransaksi());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Ubah Status.");
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getCount() {
        String count = null;
        try {
            String sql = "SELECT COUNT(*) FROM TRANSAKSI";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                count = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
