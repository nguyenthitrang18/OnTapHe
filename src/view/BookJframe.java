/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Book;
import service.BookService;

/**
 *
 * @author ADMIN
 */
public class BookJframe extends javax.swing.JFrame {
    private List<Book> lstb;
    private BookService service;
    private DefaultTableModel model;
    /**
     * Creates new form BookJframe
     */
    public BookJframe() {
        initComponents();
        tblSP.setDefaultEditor(Object.class, null); // khong cho phep chinh trong bang
        setLocationRelativeTo(null);
        service = new BookService();
        lstb = service.ListSrv();
        model = (DefaultTableModel) tblSP.getModel();
        setColum();
        
    }
    
    private void setColum(){
        model.setColumnCount(0);
        model.addColumn("Danh mục");
        model.addColumn("Mã SP");
        model.addColumn("Tên SP");
        model.addColumn("Giá");
        model.addColumn("Số lượng");
    }
    
    private void LoadTable(){
        model.setRowCount(0);
        for (Book x : lstb) {
            Object row[] = new Object[]{
                x.getMadanhmuc()== 1 ? "Tieu thuyet" :x.getMadanhmuc()== 2 ? "Trinh Tham" : "Co tich",
                x.getMasp(),
                x.getTensp(),
                x.getGia(),
                x.getSoluong()
            };
            model.addRow(row);
        }
    }
//    boolean check(String txt,int kieuCheck){
//        if (kieuCheck == 1) {
//            Pattern pattern = Pattern.compile("[-]*\\d+");
//            Matcher matcher = pattern.matcher(txt);
//            return matcher.matches();
//        }
//            Pattern pattern = Pattern.compile("[-]*\\d+");
//            Matcher matcher = pattern.matcher(txt);
//            return matcher.matches();
//    }
    private boolean checkma(){
        for (int i = 0; i < lstb.size(); i++) {
            if (lstb.get(i).getMasp().equals(txtma.getText())) {
                return false;
            }
        }
        return true;
    }
    
    private Book getForm(){
        String danhmuc = cbcDM.getSelectedItem().toString();
        String masp = txtma.getText();
        String tensp = txtten.getText();
        String giaStr = txtgia.getText();
        String slgStr = txtsoluong.getText();
        
        if (txtma.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không để trống");
            return null;
        }
        else if (txtten.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không để trống");
            return null;
        }
        else if (txtgia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm không để trống");
            return null;
        }
        else if (txtsoluong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không để trống");
            return null;
        }else if (!checkma()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại");
            return null;
        }
        
        long giaL = 0;
        try {
            giaL = Long.parseLong(giaStr);
        if (giaL <= 0) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm phải lớn hơn 0");
            return null;
        }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá sản phẩm phải là số nguyên");
            return null;
        }
        BigDecimal gia = BigDecimal.valueOf(giaL);
        
        
        int slgL = -1;
        try {
            slgL = Integer.parseInt(slgStr);
        if (slgL <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0");
            return null;
        }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải là số nguyên");
            return null;
        }
        
        Book book = new Book();
        book.setMasp(masp);
        book.setTensp(tensp);
        book.setGia(gia);
        book.setSoluong(slgL);
        book.setMadanhmuc(danhmuc);
        return book;
    }
    
    private Book getFormUpdate(){
        String danhmuc = cbcDM.getSelectedItem().toString();
        String masp = txtma.getText();
        String tensp = txtten.getText();
        String giaStr = txtgia.getText();
        String slgStr = txtsoluong.getText();
        
        if (txtma.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không để trống");
            return null;
        }
        else if (txtten.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không để trống");
            return null;
        }
        else if (txtgia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm không để trống");
            return null;
        }
        else if (txtsoluong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không để trống");
            return null;
        }
        
        long giaL = 0;
        try {
            giaL = Long.parseLong(giaStr);
        if (giaL <= 0) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm phải lớn hơn 0");
            return null;
        }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Giá sản phẩm phải là số nguyên");
            return null;
        }
        BigDecimal gia = BigDecimal.valueOf(giaL);
        
        
        int slgL = -1;
        try {
            slgL = Integer.parseInt(slgStr);
        if (slgL <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0");
            return null;
        }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải là số nguyên");
            return null;
        }
        
        Book book = new Book();
        book.setMasp(masp);
        book.setTensp(tensp);
        book.setGia(gia);
        book.setSoluong(slgL);
        book.setMadanhmuc(Integer.parseInt(danhmuc));
        return book;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtgia = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        cbcDM = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        btnhienthi = new javax.swing.JButton();
        btnthoat = new javax.swing.JButton();
        tnxoa = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MÃ");

        jLabel2.setText("TÊN");

        jLabel3.setText("GIÁ");

        jLabel4.setText("SỐ LƯỢNG");

        jLabel5.setText("DANH MỤC");

        jLabel6.setText("QUẢN LÝ SÁCH");

        cbcDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tieu thuyet", "Trinh Tham", "Co tich" }));

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        btnhienthi.setText("HIỂN THỊ");
        btnhienthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhienthiActionPerformed(evt);
            }
        });

        btnthoat.setText("THOÁT");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        tnxoa.setText("XÓA");
        tnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnxoaActionPerformed(evt);
            }
        });

        btnTimkiem.setText("TÌM KIẾM");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnsua.setText("SỬA");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtma, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(txtten)
                                    .addComponent(txtgia)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnhienthi)
                                .addGap(18, 18, 18)
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(btnsua)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnTimkiem)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtsoluong))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbcDM, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tnxoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnthoat))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbcDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnhienthi)
                    .addComponent(btnsua)
                    .addComponent(btnThem)
                    .addComponent(tnxoa)
                    .addComponent(btnthoat))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimkiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhienthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhienthiActionPerformed
        // TODO add your handling code here:
        LoadTable();
    }//GEN-LAST:event_btnhienthiActionPerformed

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
    System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_btnthoatActionPerformed

    private void tnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnxoaActionPerformed
        // TODO add your handling code here:
        boolean check = service.deleteSrv(txtma.getText());
        if (check) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            lstb = service.ListSrv();
            LoadTable();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_tnxoaActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
        int row = tblSP.getSelectedRow();
        
        String madm = tblSP.getValueAt(row, 0).toString();
        String masp = tblSP.getValueAt(row, 1).toString();
        String ten = tblSP.getValueAt(row, 2).toString();
        String gia = tblSP.getValueAt(row, 3).toString();
        String slg = tblSP.getValueAt(row, 4).toString();
        
        txtma.setText(masp);
        txtten.setText(ten);
        txtgia.setText(gia);
        cbcDM.setSelectedIndex(madm.equals("Tieu thuyet") ? 0: madm.equals("Trinh Tham") ? 1 : 2);
        txtsoluong.setText(slg);
    }//GEN-LAST:event_tblSPMouseClicked

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        Book b = service.findName(txtTimKiem.getText().trim());
        if (b != null) {
            txtma.setText(b.getMasp().toString());
            txtten.setText(b.getTensp().toString());
            txtgia.setText(b.getGia().toString());
            txtsoluong.setText(b.getSoluong().toString());
            cbcDM.setSelectedItem(b.getMadanhmuc().toString());
            JOptionPane.showMessageDialog(this, "Tìm thấy thông tin sản phẩm");
            return;
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin");

    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        boolean check = service.insertSrv(getForm());
        if (check) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            lstb = service.ListSrv();
            LoadTable();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        boolean check = service.updateSrv(txtma.getText(),getFormUpdate());
        if (check) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            lstb = service.ListSrv();
            LoadTable();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

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
            java.util.logging.Logger.getLogger(BookJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnhienthi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthoat;
    private javax.swing.JComboBox<String> cbcDM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSP;
    private javax.swing.JButton tnxoa;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
