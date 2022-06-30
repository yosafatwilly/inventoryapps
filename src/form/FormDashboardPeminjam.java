package form;

import datadetailtransaksi.TabelModelDetailTransaksi;
import datatransaksi.TabelModelTransaksi;
import datatransaksi.Transaksi;
import datatransaksi.TransaksiController;
import datauser.User;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import swing.ScrollBarCustom;

public class FormDashboardPeminjam extends javax.swing.JPanel {

    List<Transaksi> list;
    String id;
    Transaksi t;
    User usr;

    public FormDashboardPeminjam(User u) {
        initComponents();
        usr = u;
        datatable();
        
        //Set tebal baris pada tabel
        tbltransaksi.setRowHeight(20);
        tblbarang.setRowHeight(20);
        
        //Set background Table
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupdetailbarang = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("History Peminjaman Saya");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
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
        
        //menampilkan pop up detail barang ketika tabel transaksi di klik
        popupdetailbarang.setSize(new Dimension(1080, 720));
        popupdetailbarang.setResizable(false);
        popupdetailbarang.setLocationRelativeTo(null);
        popupdetailbarang.setVisible(true);
    }//GEN-LAST:event_tbltransaksiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog popupdetailbarang;
    private javax.swing.JTable tblbarang;
    private javax.swing.JTable tbltransaksi;
    // End of variables declaration//GEN-END:variables

    private void datatable() {
        //refresh table transaksi
        list = TransaksiController.getAllByUser(usr.getIdUser());
        TabelModelTransaksi model = new TabelModelTransaksi(list);
        tbltransaksi.setModel(model);
    }
}
