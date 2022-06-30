package databarang;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelBarang extends AbstractTableModel {

    private List<Barang> brg = new ArrayList<>();

    public TabelModelBarang(List<Barang> kate) {
        this.brg = kate;
    }

    @Override
    public int getRowCount() {
        return brg.size();
    }

    @Override
    public int getColumnCount() {
        return 7; //menentukan jumlah koloms
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Barang k = brg.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdBarang();
            case 1:
                return k.getNama();
            case 2:
                return k.getKategori().getIdKategori() + " - " + k.getKategori().getName();
            case 3:
                return k.getSatuan().getIdSatuan() + " - " + k.getSatuan().getName();
            case 4:
                return k.getStok();
            case 5:
                return k.getDeskripsi();
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
                return "Id Barang";
            case 1:
                return "Nama";
            case 2:
                return "Kategori";
            case 3:
                return "Satuan";
            case 4:
                return "Stock";
            case 5:
                return "Deskripsi";
            case 6:
                return "Last Update";
            default:
                return "";
        }
    }
}
