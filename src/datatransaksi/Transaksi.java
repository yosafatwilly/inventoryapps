package datatransaksi;

import databarang.Barang;
import datadetailtransaksi.DetailTransaksi;
import datauser.User;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Transaksi {

    private String idTransaksi;
    private User userPeminjam;
    private User userOperator;
    private Status status;
    private Timestamp tanggalRequest;
    private Timestamp lastUpdated;
    private List<DetailTransaksi> detailTransaksis = new ArrayList<>();

    public static enum Status {
//        REQUESTED, APPROVED, REJECTED, INPROGRESS, CANCELED, CLOSE
        DISETUJUI, DIAMBIL, DIKEMBALIKAN, DIBATALKAN, REQUEST
    }

    public Transaksi() {
    }

    public Transaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Transaksi(User userPeminjam, Status status, Timestamp tanggalRequest, Timestamp lastUpdated) {
        this.userPeminjam = userPeminjam;
        this.status = status;
        this.tanggalRequest = tanggalRequest;
        this.lastUpdated = lastUpdated;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public User getUserPeminjam() {
        return userPeminjam;
    }

    public void setUserPeminjam(User userPeminjam) {
        this.userPeminjam = userPeminjam;
    }

    public User getUserOperator() {
        return userOperator;
    }

    public void setUserOperator(User userOperator) {
        this.userOperator = userOperator;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getTanggalRequest() {
        return tanggalRequest;
    }

    public void setTanggalRequest(Timestamp tanggalRequest) {
        this.tanggalRequest = tanggalRequest;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<DetailTransaksi> getDetailTransaksis() {
        return detailTransaksis;
    }

    public void setDetailTransaksis(List<DetailTransaksi> detailTransaksis) {
        this.detailTransaksis = detailTransaksis;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "idTransaksi=" + idTransaksi + ", userPeminjam=" + userPeminjam + ", userOperator=" + userOperator + ", status=" + status + ", tanggalRequest=" + tanggalRequest + ", lastUpdated=" + lastUpdated + ", detailTransaksis=" + detailTransaksis + '}';
    }

}
