package datakategori;

public class Kategori {

    private String idKategori, name, description;

    public Kategori() {
    }

    public Kategori(String idKategori, String name, String description) {
        this.idKategori = idKategori;
        this.name = name;
        this.description = description;
    }

    public Kategori(String idKategori) {
        this.idKategori = idKategori;
    }

    
    public Kategori(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Kategori{" + "idKategori=" + idKategori + ", name=" + name + ", description=" + description + '}';
    }



}
