package datauser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelUser extends AbstractTableModel {

    private List<User> kat = new ArrayList<>();

    public TabelModelUser(List<User> kate) {
        this.kat = kate;
    }

    @Override
    public int getRowCount() {
        return kat.size();
    }

    @Override
    public int getColumnCount() {
        return 12; //menentukan jumlah koloms
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
                return k.getPassword();
            case 5:
                return k.getRole();
            case 6:
                return k.getJenisPeminjam();
            case 7:
                return k.getNoHandphone();
            case 8:
                return k.getJenisKelamin();
            case 9:
                return k.getAlamat();
            case 10:
                return k.getMatapelajaranOrKelas();
            case 11:
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
                return "Password";
            case 5:
                return "Role";
            case 6:
                return "Jenis Peminjam";
            case 7:
                return "No Handphone";
            case 8:
                return "Jenis Kelamin";
            case 9:
                return "Alamat";
            case 10:
                return "Mata Pelajaran / Kelas";
            case 11:
                return "Last Updated";
            default:
                return "";
        }
    }
}
