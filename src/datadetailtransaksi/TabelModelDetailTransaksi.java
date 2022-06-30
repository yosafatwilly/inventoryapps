package datadetailtransaksi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelDetailTransaksi extends AbstractTableModel {

    private List<DetailTransaksi> det = new ArrayList<>();

    public TabelModelDetailTransaksi(List<DetailTransaksi> kate) {
        this.det = kate;
    }

    @Override
    public int getRowCount() {
        return det.size();
    }

    @Override
    public int getColumnCount() {
        return 4; //menentukan jumlah koloms
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetailTransaksi k = det.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getBarang().getNama();
            case 1:
                return k.getBarang().getDeskripsi();
            case 2:
                return k.getJumlahBarang();
            case 3:
                return k.getKeterangan();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Barang";
            case 1:
                return "Deskripsi Barang";
            case 2:
                return "Jumlah yang dipinjam";
            case 3:
                return "Keterangan";
            default:
                return "";
        }
    }
}
