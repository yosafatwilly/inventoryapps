package datauser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelUserOperator extends AbstractTableModel {

    private List<User> kat = new ArrayList<>();

    public TabelModelUserOperator(List<User> kate) {
        this.kat = kate;
    }

    @Override
    public int getRowCount() {
        return kat.size();
    }

    @Override
    public int getColumnCount() {
        return 11; //menentukan jumlah koloms
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User k = kat.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return k.getIdUser();
            case 2:
                return k.getName();
            case 3:
                return k.getUsername();
            case 4:
                return k.getRole();
            case 5:
                return k.getJenisPeminjam();
            case 6:
                return k.getNoHandphone();
            case 7:
                return k.getJenisKelamin();
            case 8:
                return k.getAlamat();
            case 9:
                return k.getMatapelajaranOrKelas();
            case 10:
                return k.getLastUpdated();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "NIS/NIP";
            case 2:
                return "Nama";
            case 3:
                return "Username";
            case 4:
                return "Role";
            case 5:
                return "Jenis Peminjam";
            case 6:
                return "No Handphone";
            case 7:
                return "Jenis Kelamin";
            case 8:
                return "Alamat";
            case 9:
                return "Mata Pelajaran / Kelas";
            case 10:
                return "Last Updated";
            default:
                return "";
        }
    }
}
