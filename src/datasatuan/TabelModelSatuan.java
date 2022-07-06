package datasatuan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelSatuan extends AbstractTableModel {

    private List<Satuan> kat = new ArrayList<>();

    public TabelModelSatuan(List<Satuan> kate) {
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
        Satuan k = kat.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdSatuan();
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
                return "Kode";
            case 1:
                return "Nama Satuan";
            case 2:
                return "Description";
            case 3:
                return "Last Updated";
            default:
                return "";
        }
    }
}
