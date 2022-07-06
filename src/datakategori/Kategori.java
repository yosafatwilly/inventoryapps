package datakategori;

import java.sql.Timestamp;

public class Kategori {

    private String idKategori, name, description;

    private Timestamp lastUpdated;

    public Kategori() {
    }

    public Kategori(String idKategori, String name, String description, Timestamp lastUpdated) {
        this.idKategori = idKategori;
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }

    public Kategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public Kategori(String name, String description, Timestamp lastUpdated) {
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Kategori{" + "idKategori=" + idKategori + ", name=" + name + ", description=" + description + ", lastUpdated=" + lastUpdated + '}';
    }

}
