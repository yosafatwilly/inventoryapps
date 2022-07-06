package datakategori;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelKategori extends AbstractTableModel {

    private List<Kategori> kat = new ArrayList<>();

    public TabelModelKategori(List<Kategori> kate) {
        this.kat = kate;
    }

    @Override
    public int getRowCount() {
        return kat.size();
    }

    @Override
    public int getColumnCount() {
        return 4; //menentukan jumlah koloms
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kategori k = kat.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdKategori();
            case 1:
                return k.getName();
            case 2:
                return k.getDescription();
            case 3:
                return k.getLastUpdated();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Kategori";
            case 1:
                return "Nama Kategori";
            case 2:
                return "Description";
            case 3:
                return "Last Updated";
            default:
                return "";
        }
    }
}
