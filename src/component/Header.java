package component;

import connection.DatabaseConnection;
import datauser.User;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class Header extends javax.swing.JPanel {

    public User user;

    public Header() {
        initComponents();
        setOpaque(false);
    }

    public void setUser(User usr) {
        user = usr;
        lbusername.setText(usr.getUsername());
        lbrole.setText(usr.getRole().name());
        if (usr.getAvatar()!= null) {
            imagesAvatar.setIcon(usr.getAvatar());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagesAvatar = new swing.ImageAvatar();
        lbusername = new javax.swing.JLabel();
        lbrole = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        imagesAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.jpg"))); // NOI18N
        imagesAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagesAvatarMouseClicked(evt);
            }
        });

        lbusername.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbusername.setForeground(new java.awt.Color(127, 127, 127));
        lbusername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbusername.setText("User Name");

        lbrole.setForeground(new java.awt.Color(127, 127, 127));
        lbrole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbrole.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbusername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbrole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagesAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbusername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbrole)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imagesAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imagesAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagesAvatarMouseClicked
        JFileChooser ch = new JFileChooser();
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName().toLowerCase();
                return file.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
            }
            @Override
            public String getDescription() {
                return "Image File";
            }
        });
        int option = ch.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = ch.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            imagesAvatar.setIcon(icon);
            repaint();
            try {
                String sql = "update USER set avatar=? where id_user=? limit 1";
                PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                p.setBinaryStream(1, Files.newInputStream(file.toPath()));
                System.out.println(user.getIdUser());
                p.setString(2, user.getIdUser());
                p.execute();
            } catch (IOException | SQLException e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_imagesAvatarMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar imagesAvatar;
    private javax.swing.JLabel lbrole;
    private javax.swing.JLabel lbusername;
    // End of variables declaration//GEN-END:variables
}
