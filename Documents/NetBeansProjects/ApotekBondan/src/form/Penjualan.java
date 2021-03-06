/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Penjualan extends javax.swing.JFrame {
private String KodeObat;
DefaultComboBoxModel model;




public String getKodeObat(){
    return KodeObat;
}
public void setKodeObbat(String KodeObat){
    this.KodeObat=KodeObat;
}
    /**
     * Creates new form Penjualan
     */
    public Penjualan() {
        initComponents();
        tampilkandata();
        setModel();
        cmbObat.setModel(model);
    }
    
    
    
    public Connection conn;
    public void koneksi() throws SQLException {
        try {
            conn=null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotek", "root", "");

        } catch (ClassNotFoundException ex) {
           System.out.println(ex);
        } catch (SQLException e) {
           System.out.println(e);
        } catch (Exception es) {
            System.out.println(es);
        }

    }
    
    
    
    public void tampilkandata() {
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("No Faktur");
        tabelmapel.addColumn("Tanggal Jual");    
         tabelmapel.addColumn("Kode Obat");
         tabelmapel.addColumn("Nama Obat");
        tabelmapel.addColumn("Harga");       
        tabelmapel.addColumn("Jumlah");
        
        
        try {
            koneksi();
            String sql = "select penjualan.noFakturJual, penjualan.tglTransaksi, obat.kodeObat, obat.namaObat, penjualan.harga, penjualan.qty from penjualan join obat on penjualan.kodeObat=obat.KodeObat";
            Statement stat = conn.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                tabelmapel.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),
                res.getString(4),res.getString(5),res.getString(6)});
            }
           jTable1.setModel(tabelmapel);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txFaktur = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dtTgl = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cmbObat = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txCari = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apotek Bondan");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Data Penjualan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(201, 201, 201))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data"));

        jLabel2.setText("No Faktur");

        jLabel3.setText("Nama Obat");

        jLabel4.setText("Jumlah");

        jLabel5.setText("Tanggal Jual");

        jLabel6.setText("Harga");

        jButton1.setText("Simpan");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Home");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        cmbObat.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbObatPopupMenuWillBecomeVisible(evt);
            }
        });
        cmbObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbObatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txFaktur)
                    .addComponent(txJumlah)
                    .addComponent(cmbObat, 0, 140, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dtTgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Faktur", "Kode Obat", "Jumlah", "Tanggal Jual", "Harga", "Title 6"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Pencarian : ");

        txCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCariActionPerformed(evt);
            }
        });

        jButton4.setText("Refresh");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(714, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    try {
        
            dtTgl.setDateFormatString("yyyy-MM-dd");
    String d1  = ((JTextField)dtTgl.getDateEditor().getUiComponent()).getText();
            Connection konek=Koneksi.Koneksi.getKoneksi();
            String query="insert into penjualan values(?, ?, ?, ?, ?)";
            PreparedStatement state=konek.prepareStatement(query);
            state.setString(1, txFaktur.getText());
            state.setString(2, d1);
             state.setString(3, this.getKodeObat());
            state.setString(4, txHarga.getText());
            state.setString(5, txJumlah.getText());
           
            state.executeUpdate();
            System.out.println("Data disimpan");
            state.close();
            tampilkandata();
        } catch (SQLException ex) {
            System.out.println(ex);
            if((txFaktur.getText()==null)||
                    (txJumlah.getText().length()==0)||
                    (txHarga.getText().length()==0)){
                JOptionPane.showMessageDialog(null, "Kolom Harus Diisi Semua", "Warning!!", JOptionPane.WARNING_MESSAGE);
                
            }else{
            JOptionPane.showMessageDialog(null, "Data Sudah Ada", "Warning!!", JOptionPane.ERROR_MESSAGE);
            }
        }finally{
            txFaktur.setText("");
            txJumlah.setText("");
            dtTgl.setDate(null);
            txHarga.setText("");
         
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void cmbObatPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbObatPopupMenuWillBecomeVisible
    cmbObat.removeAllItems();
       Statement statement=null;
       ResultSet resultSet=null;
       
       try{ 
          statement = Koneksi.DatabaseHelper.getConnection().createStatement();
	    resultSet = statement.executeQuery("select kodeObat from obat");
	    while (resultSet.next()) {
		String obat = resultSet.getString("kodeObat");
		cmbObat.addItem(obat);
	    }
	} catch (SQLException ex) {
            System.out.println(ex);
	} finally {
	    try {
		if (resultSet != null) {
		    resultSet.close();
		}
	    } catch (SQLException ex) {
                System.out.println(ex);
	    }
	    try {
		if (statement != null) {
		    statement.close();
		}
	    } catch (SQLException ex) {
                System.out.println(ex);
	    }
	}
    }//GEN-LAST:event_cmbObatPopupMenuWillBecomeVisible

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       MainForm main=new MainForm();
       main.setVisible(true);
       
       Penjualan jual=new Penjualan();
       setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void cmbObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbObatActionPerformed
      if(cmbObat.getSelectedItem()!=null){
          try {
              String query="select kodeObat,hargaJual from obat where namaObat=?";
              PreparedStatement state=Koneksi.Koneksi.getKoneksi().prepareStatement(query);
              state.setString(1, cmbObat.getSelectedItem().toString());
              ResultSet res=state.executeQuery();
              while(res.next()){
                  this.setKodeObbat(res.getString(1));
                  this.txHarga.setText(res.getString(2));
              }
          } catch (SQLException ex) {
              
          }
      }
    }//GEN-LAST:event_cmbObatActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try {
        Connection konek=Koneksi.Koneksi.getKoneksi();
        String query="delete from penjualan where noFakturJual=?";
        PreparedStatement state=konek.prepareStatement(query);
        state.setString(1, txFaktur.getText());
        state.executeUpdate();
        
        System.out.println("Data dihapus");
        tampilkandata();
        state.close();
    } catch (SQLException ex) {
      System.out.println(ex);
    }finally{
        txFaktur.setText("");
            txJumlah.setText("");
            txHarga.setText("");
            dtTgl.setDate(null);
            
    }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          try {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
int row = jTable1.rowAtPoint(evt.getPoint());

String a = jTable1.getValueAt(row, 0).toString();
Date b = dateFormat.parse((String)jTable1.getValueAt(jTable1.getSelectedRow(), 1));
String c = jTable1.getValueAt(row, 4).toString();
String d = jTable1.getValueAt(row, 5).toString();




txFaktur.setText(String.valueOf(a));
dtTgl.setDate(b);
txHarga.setText(String.valueOf(c));
txJumlah.setText(String.valueOf(d));


} catch (Exception e) {
    System.out.println(e);
}
    }//GEN-LAST:event_jTable1MouseClicked

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
    DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("No Faktur");
        tabelmapel.addColumn("Tanggal Jual");    
         tabelmapel.addColumn("Kode Obat");
          tabelmapel.addColumn("Nama Obat");
        tabelmapel.addColumn("Harga");       
        tabelmapel.addColumn("Jumlah");
        
        try{
koneksi();
String sql = "Select penjualan.noFakturJual, penjualan.tglTransaksi, obat.kodeObat, "
        + "obat.namaObat, penjualan.harga, penjualan.qty  "
        + "from penjualan "
        + "join obat "
        + "on penjualan.kodeObat=obat.kodeObat "
        + "where penjualan.noFakturJual like '%" + txCari.getText() + "%'" 
        + "or penjualan.tglTransaksi like '%" + txCari.getText() + "%'"
        + "or obat.kodeObat like '%" + txCari.getText() + "%'"
        + "or obat.namaObat like '%" + txCari.getText() + "%'";
Statement stat = conn.createStatement();
ResultSet rs = stat.executeQuery(sql);
while (rs.next()) {
tabelmapel.addRow(new Object[]{
rs.getString(1),
rs.getString(2),
rs.getString(3),
rs.getString(4),
rs.getString(5),
rs.getString(6),

        
});
}
jTable1.setModel(tabelmapel);

}catch (Exception e){
    System.out.println(e);
}
    }//GEN-LAST:event_txCariActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
    tampilkandata();
    }//GEN-LAST:event_jButton4MouseClicked

    
    private int cekStok(){
        int stok=0;
        String query="select qty from obat where kodeObat='"+getKodeObat()+"'";
        try{
            Statement state=Koneksi.Koneksi.getKoneksi().createStatement();
            ResultSet res=state.executeQuery(query);
            while(res.next()){
                stok=Integer.parseInt(res.getString(1));
            }
        }catch(Exception x){
            System.out.println(x);
        }
        return stok;
    }
    
    public void setModel(){
        try{
            PreparedStatement state=Koneksi.Koneksi.getKoneksi().prepareStatement("select namaObat from Obat");
            ResultSet res=state.executeQuery();
            model=new DefaultComboBoxModel();
            while(res.next()){
                model.addElement(res.getString(1));
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbObat;
    private com.toedter.calendar.JDateChooser dtTgl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txCari;
    private javax.swing.JTextField txFaktur;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txJumlah;
    // End of variables declaration//GEN-END:variables
}
