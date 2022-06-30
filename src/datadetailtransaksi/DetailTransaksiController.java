package datadetailtransaksi;

import connection.DatabaseConnection;
import databarang.BarangController;
import datatransaksi.Transaksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetailTransaksiController {

//Mengambil Detail Transaksi Berdasarkan ID Transaksi
    public static List<DetailTransaksi> getById(String id) {
        List<DetailTransaksi> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detailtransaksi WHERE id_transaksi="+id;
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetailTransaksi dtxn = new DetailTransaksi();
                dtxn.setTransaksi(new Transaksi(rs.getString(1)));
                dtxn.setBarang(BarangController.getById(rs.getString(2)));
                dtxn.setJumlahBarang(3);
                dtxn.setKeterangan(rs.getString(4));
                list.add(dtxn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
