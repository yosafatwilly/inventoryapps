package datauser;

import java.sql.Timestamp;
import javax.swing.Icon;

public class User {

    private String idUser;
    private String name;
    private String username;
    private String password;
    private JenisPeminjam jenisPeminjam;
    private String noHandphone;
    private JenisKelamin jenisKelamin;
    private String alamat;
    private Role role;
    private String matapelajaranOrKelas;
    private Timestamp lastUpdated;
    private Icon avatar;

    public static enum Role {
        ADMIN, OPERATOR, PEMINJAM
    }

    public static enum JenisPeminjam {
        SISWA, GURU
    }

    public static enum JenisKelamin {
        PRIA, WANITA
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String idUser, String name, String username, String password, JenisPeminjam jenisPeminjam, String noHandphone, JenisKelamin jenisKelamin, String alamat, Role role, String matapelajaranOrKelas, Timestamp lastUpdated) {
        this.idUser = idUser;
        this.name = name;
        this.username = username;
        this.password = password;
        this.jenisPeminjam = jenisPeminjam;
        this.noHandphone = noHandphone;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.role = role;
        this.matapelajaranOrKelas = matapelajaranOrKelas;
        this.lastUpdated = lastUpdated;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JenisPeminjam getJenisPeminjam() {
        return jenisPeminjam;
    }

    public void setJenisPeminjam(JenisPeminjam jenisPeminjam) {
        this.jenisPeminjam = jenisPeminjam;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMatapelajaranOrKelas() {
        return matapelajaranOrKelas;
    }

    public void setMatapelajaranOrKelas(String matapelajaranOrKelas) {
        this.matapelajaranOrKelas = matapelajaranOrKelas;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Icon getAvatar() {
        return avatar;
    }

    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }

    
    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", name=" + name + ", username=" + username + ", password=" + password + ", jenisPeminjam=" + jenisPeminjam + ", noHandphone=" + noHandphone + ", jenisKelamin=" + jenisKelamin + ", alamat=" + alamat + ", role=" + role + ", matapelajaranOrKelas=" + matapelajaranOrKelas + ", lastUpdated=" + lastUpdated + '}';
    }

}
