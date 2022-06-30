package datadetailtransaksi;

import databarang.Barang;
import datatransaksi.Transaksi;

public class DetailTransaksi {
    
    private Transaksi transaksi;
    private Barang barang;
    private int jumlahBarang;
    private String keterangan;

    public DetailTransaksi() {
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "DetailTransaksi{" + "transaksi=" + transaksi + ", barang=" + barang + ", jumlahBarang=" + jumlahBarang + ", keterangan=" + keterangan + '}';
    }
    
    
    
}
