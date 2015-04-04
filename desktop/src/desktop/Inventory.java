
package desktop;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;

/**
 *
 * @authors Martin Bruckner and Nicolas Nunez
 */

public class Inventory extends javax.swing.JFrame {

    @SuppressWarnings("oracle.jdeveloper.java.unconventional-field-modifier-order")
    final static String FORMAT = "yyyy-MM-dd";
    /** Creates new form Inventory */
    List<Image> listex = new ArrayList<>();
    ImageIcon img = new ImageIcon("C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\desktop\\src\\desktop\\tabitIcon.png");
    ImageIcon img2 = new ImageIcon("C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\desktop\\src\\desktop\\logo.png");                   
    DataHandler databit;
    

    public Inventory() throws SQLException {
        databit = new DataHandler();
      
        listex.add(img2.getImage());
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(listex);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "YYYY/MM/DD", null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Quantity", "Date In", "Cost Unit", "Total Cost", "Sale Price", "Empl ID", "Vendor", "Vendor No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Product Name");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Quantity");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Date In");
        jTable1.getColumnModel().getColumn(4).setHeaderValue("Cost Unit");
        jTable1.getColumnModel().getColumn(5).setHeaderValue("Total Cost");
        jTable1.getColumnModel().getColumn(6).setHeaderValue("Sale Price");
        jTable1.getColumnModel().getColumn(7).setHeaderValue("Empl ID");
        jTable1.getColumnModel().getColumn(8).setHeaderValue("Vendor");
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(9).setHeaderValue("Vendor No");
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int rows = 0;
        try {
            rows = databit.getRows("Inventory");

        }catch (SQLException e) {}
        //System.out.println("# of rows " + rows);
        int rowsInTable = jTable1.getRowCount();
        while(rowsInTable < rows){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null});
            rowsInTable++;
        }
        try{
            loadInventory(jTable1, rows);
        }catch(SQLException e) { }

        jButton1.setText("Add Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(439, 439, 439)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
        );

        pack();
    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addRow(new Object[] { null, null, null, null, null, null, null, null });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println("Saving Records");
        //Add records to database

        int id, Quant, EmplID, VendorNo;
        float CostUnit, TotalCost, SalePrice;
        String Vendor, ProdName, DateIn;
        //        try {
        //            databit.deleteInfoDatabase("Inventory");
        //        } catch (SQLException e) {
        //        }
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object o;
            boolean correct = true;
            System.out.println("IM there");
            o = jTable1.getModel().getValueAt(i, 0);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                id = -1;
                correct = false;
                continue;
            } else
                id = Integer.parseInt(o.toString());
            // id = Integer.parseInt(jTable1.getModel().getValueAt(i, 0).toString());

            o = jTable1.getModel().getValueAt(i, 1);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                ProdName = "";
                correct = false;
                continue;
            } else {
                ProdName = o.toString();
                ProdName = ProdName.toUpperCase();
            }
            o = jTable1.getModel().getValueAt(i, 2);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                Quant = -1;
                correct = false;
                continue;
            } else
                Quant = Integer.parseInt(o.toString());

            o = jTable1.getModel().getValueAt(i, 3);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                DateIn = "";
                correct = false;
                continue;
            } else if (!isDateValid( o.toString())){
                JOptionPane.showMessageDialog(null, "Date Format is: YYYY-MM-DD");
                DateIn = "";
                correct = false;
                continue;
            }
                else{
                DateIn = o.toString();
            }


            o = jTable1.getModel().getValueAt(i, 4);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                CostUnit = -1;
                correct = false;
                continue;
            } else
                CostUnit = Float.parseFloat(o.toString());

            o = jTable1.getModel().getValueAt(i, 5);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                TotalCost = -1;
                correct = false;
                continue;
            } else
                TotalCost = Float.parseFloat(o.toString());


            o = jTable1.getModel().getValueAt(i, 6);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                SalePrice = -1;
                correct = false;
                continue;
            } else
                SalePrice = Float.parseFloat(o.toString());

            o = jTable1.getModel().getValueAt(i, 7);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                EmplID = -1;
                correct = false;
                continue;
            } else
                EmplID = Integer.parseInt(o.toString());

            o = jTable1.getModel().getValueAt(i, 8);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                Vendor = "";
                correct = false;
                continue;
            } else {
                Vendor = o.toString();
                Vendor = Vendor.toUpperCase();
            }

            o = jTable1.getModel().getValueAt(i, 9);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                VendorNo = -1;
                correct = false;
                continue;
            } else
                VendorNo = Integer.parseInt(o.toString());


            if (correct == true) {
                try {
                    databit.addInventory(id, ProdName, Quant, DateIn, CostUnit, TotalCost, SalePrice, EmplID, Vendor,
                                         VendorNo);
                } catch (SQLException e) {
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    void loadInventory(JTable jt, int rows) throws SQLException {
        ResultSet inventory = databit.getInventory();
        int i = 0;

        while (inventory.next()) {


            jt.getModel().setValueAt(inventory.getInt(1), i, 0);
            jt.getModel().setValueAt(inventory.getString(2), i, 1);
            jt.getModel().setValueAt(inventory.getInt(3), i, 2);
            jt.getModel().setValueAt(inventory.getDate(4).toString(), i, 3);
            jt.getModel().setValueAt(inventory.getFloat(5), i, 4);
            jt.getModel().setValueAt(inventory.getFloat(6), i, 5);
            jt.getModel().setValueAt(inventory.getFloat(7), i, 6);
            jt.getModel().setValueAt(inventory.getInt(8), i, 7);
            jt.getModel().setValueAt(inventory.getString(9), i, 8);
            jt.getModel().setValueAt(inventory.getInt(10), i, 9);
            i++;
        }
    }
    public static boolean isDateValid(String date) 
    {
            try {
                DateFormat df = new SimpleDateFormat(FORMAT);
                df.setLenient(false);
               Date d= df.parse(date);
                System.out.println(d);
                return true;
            } catch (ParseException e) {
                return false;
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inventory().setVisible(true);
                } catch (SQLException e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
