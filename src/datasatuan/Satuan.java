package datasatuan;

public class Satuan {

    private String idSatuan, name, description;

    public Satuan() {
    }

    public Satuan(String idSatuan) {
        this.idSatuan = idSatuan;
    }

    
    public Satuan(String idSatuan, String name, String description) {
        this.idSatuan = idSatuan;
        this.name = name;
        this.description = description;
    }

    public Satuan(String name, String description) {
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

    public String getIdSatuan() {
        return idSatuan;
    }

    public void setIdSatuan(String idSatuan) {
        this.idSatuan = idSatuan;
    }

    @Override
    public String toString() {
        return "Satuan{" + "idSatuan=" + idSatuan + ", name=" + name + ", description=" + description + '}';
    }
}
