
package desktop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @authors Nicolas Nunez, Martin Bruckner
 */

public class Inventory extends javax.swing.JFrame {

    @SuppressWarnings("oracle.jdeveloper.java.unconventional-field-modifier-order")
    final static String FORMAT = "MMM/dd/yyy";
    SimpleDateFormat fmt = new SimpleDateFormat("MMM/dd/yyyy");
    Font bfont = new Font("Verdana", Font.BOLD, 13);
    /** Creates new form Inventory */
    ImageIcon img = new ImageIcon("C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\desktop\\src\\desktop\\logo.png");
    ImageIcon iicon;
    String LosAltosPath = "C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\losaltoslogo\\350-218-wide.png";
    BufferedImage picture;
    DataHandler databit;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int)tk.getScreenSize().getWidth());
    int ySize = ((int)tk.getScreenSize().getHeight())-30;
    String args[] = {};
    public Inventory() throws SQLException, IOException {
        databit = new DataHandler();
        picture = ImageIO.read(new File(LosAltosPath));
        iicon = new ImageIcon(picture);
        initComponents();
        this.RestaurantLogoLabel.setIcon(iicon);
        this.setLocationRelativeTo(getRootPane());
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        RestaurantLogoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabit");
        setBackground(new java.awt.Color(0, 153, 255));
        setIconImage(img.getImage());
        setResizable(false);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        TableColumn column = null;
        for (int i = 0; i < 9; i++) {
            column = jTable1.getColumnModel().getColumn(i);
            if (i == 1) {
                column.setPreferredWidth(200); //sport column is bigger
            }
            else if (i == 0) {
                column.setPreferredWidth(25); //sport column is bigger
            }
            else if (i == 3) {
                column.setPreferredWidth(100); //sport column is bigger
            }
            else if (i == 8) {
                column.setPreferredWidth(150);
            }
            else {
                column.setPreferredWidth(80);
            }
        }

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

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextArea1.setFont(bfont);
        jTextArea1.setForeground(Color.blue);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        jButton4.setBackground(new java.awt.Color(0, 0, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Remove Row");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tabit - Inventory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RestaurantLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(RestaurantLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addRow(new Object[] { null, null, null, null, null, null, null, null });
    }//GEN-LAST:event_jButton1ActionPerformed
//
    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println("Saving Records");
        //Add records to database

        int id, Quant, EmplID, VendorNo;
        float CostUnit, TotalCost, SalePrice;
        String Vendor, ProdName, DateIn;
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
                break;
            } else
                id = Integer.parseInt(o.toString());
            // id = Integer.parseInt(jTable1.getModel().getValueAt(i, 0).toString());

            o = jTable1.getModel().getValueAt(i, 1);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                ProdName = "";
                correct = false;
                break;
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
                break;
            } else
                Quant = Integer.parseInt(o.toString());

            o = jTable1.getModel().getValueAt(i, 3);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                DateIn = "";
                correct = false;
                break;
            } else if (!isDateValid( o.toString())){
                JOptionPane.showMessageDialog(null, "Date Format is: MON/DD/YYYY");
                DateIn = "";
                correct = false;
                break;
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
                break;
            } else
                CostUnit = Float.parseFloat(o.toString());

            o = jTable1.getModel().getValueAt(i, 5);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                TotalCost = -1;
                correct = false;
                break;
            } else
                //TotalCost = Float.parseFloat(o.toString());
                TotalCost = CostUnit * Quant;
                System.out.println(TotalCost);

            o = jTable1.getModel().getValueAt(i, 6);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                SalePrice = -1;
                correct = false;
                break;
            } else
                SalePrice = Float.parseFloat(o.toString());

            o = jTable1.getModel().getValueAt(i, 7);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                EmplID = -1;
                correct = false;
                break;
            } else
                EmplID = Integer.parseInt(o.toString());

            o = jTable1.getModel().getValueAt(i, 8);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                Vendor = "";
                correct = false;
                break;
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
                break;
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:\
        //This is where the code for removing a row will go.
        int row = jTable1.getSelectedRow();
        System.out.print("This is the row that is currently selected: " + row + "\n");
        Object o = jTable1.getModel().getValueAt(row, 0);
        if (o == null){
        ((DefaultTableModel)jTable1.getModel()).removeRow(row);
        }
        else{
            //TextDialog
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this product from the database?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Delete product from the database.
                int id = Integer.parseInt(o.toString());
                System.out.println(id);
                    try {
                        databit.deleteById("Inventory", id);
                    } catch (SQLException e) {
                }
                ((DefaultTableModel)jTable1.getModel()).removeRow(row);        
            }
            else{
                System.out.println("Not confirmed");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Object o;
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = 9;
        System.out.println(row + " " + col);
        o = jTable1.getModel().getValueAt(row, col);
        if( o == null) {
            System.out.println("Doesnt have a value yet");
        }
        else{
        int id = Integer.parseInt(o.toString());
        System.out.println(id);
            try {
                fillTextArea(id);
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ManagerProfile.main(args);
        super.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    void loadInventory(JTable jt, int rows) throws SQLException {
        ResultSet inventory = databit.getInventory();
        int i = 0;
            
        while (inventory.next()) {
            jt.getModel().setValueAt(inventory.getInt(1), i, 0);
            jt.getModel().setValueAt(inventory.getString(2), i, 1);
            jt.getModel().setValueAt(inventory.getInt(3), i, 2);
            jt.getModel().setValueAt(fmt.format(inventory.getDate(4)), i, 3);
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
    
    
    public void fillTextArea(int id) throws SQLException {
        this.jTextArea1.setText(databit.getVendorInfo(id));
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
                } catch (IOException e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RestaurantLogoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
