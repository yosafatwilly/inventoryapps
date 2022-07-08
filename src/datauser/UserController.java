package datauser;

import connection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserController {

    public static boolean checkUserByUsername(String username) {
        boolean isAlreadyTaken = false;
        User user = new User();
        try {
            String sql = "SELECT * from USER where username = ?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                isAlreadyTaken = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAlreadyTaken;
    }

    public static boolean insert(User usr) {
        //check id apakah sudah dipakai
        if (UserController.getById(usr.getIdUser()).getIdUser() != null) {
            JOptionPane.showMessageDialog(null, "NIS/NIP Sudah dipakai");
            return false;
        }
        
        //check username apakah sudah dipakai
        if (UserController.checkUserByUsername(usr.getUsername())) {
            JOptionPane.showMessageDialog(null, "NIS/NIP Sudah dipakai");
            return false;
        }
        
        try {
            String sql = "INSERT INTO USER(id_user,name,username,password,role,jenis_peminjam,no_handphone,jenis_kelamin,alamat,mata_pelajaran_or_kelas,last_updated) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, usr.getIdUser());
            st.setString(2, usr.getName());
            st.setString(3, usr.getUsername());
            st.setString(4, usr.getPassword());
            st.setString(5, usr.getRole().toString());
            st.setString(6, usr.getJenisPeminjam().toString());
            st.setString(7, usr.getNoHandphone());
            st.setString(8, usr.getJenisKelamin().toString());
            st.setString(9, usr.getAlamat());
            st.setString(10, usr.getMatapelajaranOrKelas());
            st.setTimestamp(11, usr.getLastUpdated());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static void delete(String id) {
        try {
            String sql = "delete from USER where id_user=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Delete User");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(User usr) {
        try {
            String sql = "UPDATE USER SET name=?,username=?,password=?,role=?,jenis_peminjam=?,no_handphone=?,jenis_kelamin=?,alamat=?,mata_pelajaran_or_kelas=?,last_updated=? where id_user =?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, usr.getName());
            st.setString(2, usr.getUsername());
            st.setString(3, usr.getPassword());
            st.setString(4, usr.getRole().toString());
            st.setString(5, usr.getJenisPeminjam().toString());
            st.setString(6, usr.getNoHandphone());
            st.setString(7, usr.getJenisKelamin().toString());
            st.setString(8, usr.getAlamat());
            st.setString(9, usr.getMatapelajaranOrKelas());
            st.setTimestamp(10, usr.getLastUpdated());
            st.setString(11, usr.getIdUser());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Update");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<User> getAll(String key) {
        List<User> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user WHERE (LOWER(name) LIKE '%" + key + "%'\n"
                    //                    + "			OR UPPER(username) LIKE '%" + key + "') AND ROLE != 'ADMIN'";
                    + "			OR UPPER(username) LIKE '%" + key + "')";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getString(1));
                user.setName(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setRole(User.Role.valueOf(rs.getString(5)));
                user.setJenisPeminjam(User.JenisPeminjam.valueOf(rs.getString(6)));
                user.setNoHandphone(rs.getString(7));
                user.setJenisKelamin(User.JenisKelamin.valueOf(rs.getString(8)));
                user.setAlamat(rs.getString(9));
                user.setMatapelajaranOrKelas(rs.getString(10));
                user.setLastUpdated(rs.getTimestamp(11));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static User cekUserLogin(User user) {
        try {
            String sql = "select * FROM USER WHERE username=? AND password=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user.setIdUser(rs.getString("id_user"));
                user.setName(rs.getString("name"));
                Icon icon = null;
                if (rs.getObject("avatar") != null) {
                    icon = new ImageIcon(rs.getBytes("avatar"));
                }
                user.setAvatar(icon);
                user.setRole(User.Role.valueOf(rs.getString("role")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static User getById(String id) {
        User user = new User();
        try {
            String sql = "select * FROM USER WHERE id_user=?";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user.setIdUser(rs.getString(1));
                user.setName(rs.getString(2));
                user.setUsername(rs.getString(3));
//                user.setPassword(rs.getString(4));
                user.setRole(User.Role.valueOf(rs.getString(5)));
                user.setJenisPeminjam(User.JenisPeminjam.valueOf(rs.getString(6)));
                user.setNoHandphone(rs.getString(7));
                user.setJenisKelamin(User.JenisKelamin.valueOf(rs.getString(8)));
                user.setAlamat(rs.getString(9));
                user.setMatapelajaranOrKelas(rs.getString(10));
                user.setLastUpdated(rs.getTimestamp(11));
                Icon icon = null;
                if (rs.getObject("avatar") != null) {
                    icon = new ImageIcon(rs.getBytes("avatar"));
                }
                user.setAvatar(icon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static String getCount() {
        String count = null;
        try {
            String sql = "SELECT COUNT(*) FROM USER";
            PreparedStatement st = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                count = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
