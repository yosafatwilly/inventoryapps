package form;

import databarang.BarangController;
import datadetailtransaksi.TabelModelDetailTransaksi;
import datakategori.KategoriController;
import datasatuan.SatuanController;
import datatransaksi.TabelModelTransaksi;
import datatransaksi.Transaksi;
import datatransaksi.TransaksiController;
import datauser.User;
import datauser.UserController;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ImageIcon;
import swing.Model_Card;
import swing.ScrollBarCustom;

public class FormDashboardAdminOperator extends javax.swing.JPanel {
    
    List<Transaksi> list;
    String id;
    Transaksi t;
    User usr;
    
    public FormDashboardAdminOperator(User u) {
        initComponents();
        datatable();
        usr = u;
        
        //Set Tebal Baris
        tbltransaksi.setRowHeight(20);
        tblbarang.setRowHeight(20);
        
        //Set background Table
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        
        //Set Scroll Panel Menggunakan Custom Scroll Panel (Tampilan lebih bagus)
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        
        //Set Menu pada dropdown status
        cbstatus.addItem(Transaksi.Status.DISETUJUI.name());
        cbstatus.addItem(Transaksi.Status.DIAMBIL.name());
        cbstatus.addItem(Transaksi.Status.DIKEMBALIKAN.name());
        cbstatus.addItem(Transaksi.Status.DIBATALKAN.name());
        cbstatus.addItem(Transaksi.Status.REQUEST.name());
        
        //Set Data Pada Card Item
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/2.png")), "Total Barang", BarangController.getCount(), ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/8.png")), "Total User", UserController.getCount(), ""));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/2.png")), "Total Ketagori", KategoriController.getCount(), ""));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/2.png")), "Total Satuan", SatuanController.getCount(), ""));
        card5.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/2.png")), "Total Transaksi", TransaksiController.getCount(), ""));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupdetailbarang = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbarang = new javax.swing.JTable();
        cbstatus = new javax.swing.JComboBox<>();
        bsimpan = new javax.swing.JButton();
        btutup = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        card1 = new component.Card();
        card2 = new component.Card();
        card3 = new component.Card();
        card4 = new component.Card();
        card5 = new component.Card();

        popupdetailbarang.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Barang yang dipinjam");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("List Barang"));

        tblbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblbarang);

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        btutup.setText("TUTUP");
        btutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btutup, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 564, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(cbstatus)
                    .addComponent(btutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout popupdetailbarangLayout = new javax.swing.GroupLayout(popupdetailbarang.getContentPane());
        popupdetailbarang.getContentPane().setLayout(popupdetailbarangLayout);
        popupdetailbarangLayout.setHorizontalGroup(
            popupdetailbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupdetailbarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(popupdetailbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        popupdetailbarangLayout.setVerticalGroup(
            popupdetailbarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popupdetailbarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi Terbaru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltransaksi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(28, 181, 224));
        card1.setColor2(new java.awt.Color(0, 0, 70));
        jLayeredPane1.add(card1);

        card2.setColor1(new java.awt.Color(28, 181, 224));
        card2.setColor2(new java.awt.Color(0, 0, 70));
        jLayeredPane1.add(card2);

        card3.setColor1(new java.awt.Color(28, 181, 224));
        card3.setColor2(new java.awt.Color(0, 0, 70));
        jLayeredPane1.add(card3);

        card4.setColor1(new java.awt.Color(28, 181, 224));
        card4.setColor2(new java.awt.Color(0, 0, 70));
        jLayeredPane1.add(card4);

        card5.setColor1(new java.awt.Color(28, 181, 224));
        card5.setColor2(new java.awt.Color(0, 0, 70));
        jLayeredPane1.add(card5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltransaksiMouseClicked
        int row = tbltransaksi.getSelectedRow();
        id = tbltransaksi.getValueAt(row, 0).toString();
        
        t = list.stream()
                .filter(x -> id.equals(x.getIdTransaksi()))
                .findAny()
                .orElse(null);
        
        //load data detail transaksi ke tabel pop up detail barang
        TabelModelDetailTransaksi model = new TabelModelDetailTransaksi(t.getDetailTransaksis());
        tblbarang.setModel(model);
        cbstatus.setSelectedItem(t.getStatus().name());
        
        //menampilkan pop up detail barang ketika tabel transaksi di klik
        popupdetailbarang.setSize(new Dimension(1080, 720));
        popupdetailbarang.setResizable(false);
        popupdetailbarang.setLocationRelativeTo(null);
        popupdetailbarang.setVisible(true);
    }//GEN-LAST:event_tbltransaksiMouseClicked

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        //Update status transaksi sesuai drop down status yang dipilih
        t.setStatus(Transaksi.Status.valueOf(cbstatus.getSelectedItem().toString()));
        t.setUserOperator(usr);
        TransaksiController.updateStatus(t);
        datatable();
        popupdetailbarang.dispose();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btutupActionPerformed
        //menutup pop up detail transaksi
        popupdetailbarang.setVisible(false);
    }//GEN-LAST:event_btutupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btutup;
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private component.Card card4;
    private component.Card card5;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog popupdetailbarang;
    private javax.swing.JTable tblbarang;
    private javax.swing.JTable tbltransaksi;
    // End of variables declaration//GEN-END:variables

    private void datatable() {
        //refresh table transaksi
        list = TransaksiController.getAll();
        TabelModelTransaksi model = new TabelModelTransaksi(list);
        tbltransaksi.setModel(model);
    }
}
