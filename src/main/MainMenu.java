package main;

import connection.DatabaseConnection;
import datauser.User;
import datauser.User.Role;
import form.FormDashboardAdminOperator;
import form.FormDashboardPeminjam;
import form.FormListBarang;
import form.FormListUser;
import form.FormMasterBarang;
import form.FormMasterKategori;
import form.FormMasterSatuan;
import form.FormMasterUser;
import form.FormReport;
import form.FormRequestPeminjaman;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu(User u) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
      
//Set user ke dalam komponent header untuk menampilkan nama, role dan profile picture
        header.setUser(u);
        
//Init moving agar layar bisa dipindah - pindah dengan cara drag & drop Icon Aplikasi (Template)
        menu.initMoving(MainMenu.this);


//Check Roles untuk menentukan menu yang ditampilkan
//Setiap Role menampilkan menu yang berbeda
        if (u.getRole() == Role.ADMIN) {
            menu.initAdmin();
            menu.addEventMenuSelected((int index) -> {
                switch (index) {
                    case 0:
                        setForm(new FormDashboardAdminOperator());
                        break;
                    case 1:
                        setForm(new FormMasterUser());
                        break;
                    case 2:
                        setForm(new FormMasterKategori());
                        break;
                    case 3:
                        setForm(new FormMasterSatuan());
                        break;
                    case 4:
                        setForm(new FormMasterBarang());
                        break;
                    case 5:
                        setForm(new FormReport());
                        break;
                    case 6:
                        if (JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Konfirmasi.", JOptionPane.YES_NO_OPTION) == 0) {
                            
                            dispose();
                            new Login().setVisible(true);
                        }
                        break;
                    default:
                        break;
                }
            });

            //  set when system open start with home form
            setForm(new FormDashboardAdminOperator());

        } else if (u.getRole() == Role.PEMINJAM) {
            menu.initPeminjam();
            menu.addEventMenuSelected((int index) -> {
                switch (index) {
                    case 0:
                        setForm(new FormDashboardPeminjam(u));
                        break;
                    case 1:
                        setForm(new FormListBarang());
                        break;
                    case 2:
                        setForm(new FormRequestPeminjaman(u));
                        break;
                    case 3:
                        if (JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Konfirmasi.", JOptionPane.YES_NO_OPTION) == 0) {
                            dispose();
                            new Login().setVisible(true);
                        }
                        break;
                    default:
                        break;
                }
            });

            setForm(new FormDashboardPeminjam(u));
        } else {
            menu.initOperator();
            menu.addEventMenuSelected((int index) -> {
                switch (index) {
                    case 0:
                        setForm(new FormDashboardAdminOperator());
                        break;
                    case 1:
                        setForm(new FormListUser());
                        break;
                    case 2:
                        setForm(new FormListBarang());
                        break;
                    case 3:
                        setForm(new FormReport());
                        break;
                    case 4:
                        if (JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Konfirmasi.", JOptionPane.YES_NO_OPTION) == 0) {
                            dispose();
                            new Login().setVisible(true);
                        }
                        break;
                    default:
                        break;
                }
            });
            setForm(new FormDashboardAdminOperator());
        }

    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DatabaseConnection.getInstance().connectToDatabase();
                } catch (SQLException e) {
                    System.err.println(e);
                }
                new Login().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu = new component.Menu();
        mainPanel = new javax.swing.JPanel();
        header = new component.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header header;
    private javax.swing.JPanel mainPanel;
    private component.Menu menu;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
