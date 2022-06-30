/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datatransaksi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yosaf
 */
public class TabelModelTransaksi extends AbstractTableModel {

    private List<Transaksi> list = new ArrayList<>();

    public TabelModelTransaksi(List<Transaksi> kate) {
        this.list = kate;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7; //menentukan jumlah koloms
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaksi k = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdTransaksi();
            case 1:
                return k.getUserPeminjam().getName();
            case 2:
                return k.getUserOperator().getName();
            case 3:
                return k.getDetailTransaksis().size();
            case 4:
                return k.getStatus();
            case 5:
                return k.getTanggalRequest();
            case 6:
                return k.getLastUpdated();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Transaksi";
            case 1:
                return "Peminjam";
            case 2:
                return "Operator";
            case 3:
                return "Total Jenis Barang";
            case 4:
                return "Status";
            case 5:
                return "Tanggal Request";
            case 6:
                return "Last Updated";
            default:
                return "";
        }
    }
}
