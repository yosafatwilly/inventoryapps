package databarang;

import datakategori.Kategori;
import datasatuan.Satuan;
import java.sql.Timestamp;
import javax.swing.Icon;

public class Barang {

    private String idBarang;
    private Kategori kategori;
    private Satuan satuan;
    private String nama;
    private int stok;
    private String deskripsi;
    private Timestamp lastUpdated;
    private Icon images;

    public Barang() {
    }

    public Barang(Kategori kategori, Satuan satuan, String nama, int stok, String deskripsi, Timestamp lastUpdated) {
        this.kategori = kategori;
        this.satuan = satuan;
        this.nama = nama;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.lastUpdated = lastUpdated;
    }

    public Barang(Kategori kategori, Satuan satuan, String nama, int stok, String deskripsi, Timestamp lastUpdated, Icon images) {
        this.kategori = kategori;
        this.satuan = satuan;
        this.nama = nama;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.lastUpdated = lastUpdated;
        this.images = images;
    }

    public Barang(String idBarang, Kategori kategori, Satuan satuan, String nama, int stok, String deskripsi, Timestamp lastUpdated) {
        this.idBarang = idBarang;
        this.kategori = kategori;
        this.satuan = satuan;
        this.nama = nama;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.lastUpdated = lastUpdated;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Icon getImages() {
        return images;
    }

    public void setImages(Icon images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Barang{" + "idBarang=" + idBarang + ", kategori=" + kategori + ", satuan=" + satuan + ", nama=" + nama + ", stok=" + stok + ", deskripsi=" + deskripsi + ", lastUpdated=" + lastUpdated + '}';
    }

}
