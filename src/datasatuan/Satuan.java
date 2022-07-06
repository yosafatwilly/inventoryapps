package datasatuan;

import java.sql.Timestamp;

public class Satuan {

    private String idSatuan, name, description;
    private Timestamp lastUpdated;

    public Satuan() {
    }

    public Satuan(String idSatuan) {
        this.idSatuan = idSatuan;
    }
    
    public Satuan(String idSatuan, String name, String description, Timestamp lastUpdated) {
        this.idSatuan = idSatuan;
        this.name = name;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }

    public Satuan(String name, String description, Timestamp lastUpdated) {
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

    public String getIdSatuan() {
        return idSatuan;
    }

    public void setIdSatuan(String idSatuan) {
        this.idSatuan = idSatuan;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Satuan{" + "idSatuan=" + idSatuan + ", name=" + name + ", description=" + description + ", lastUpdated=" + lastUpdated + '}';
    }

}
