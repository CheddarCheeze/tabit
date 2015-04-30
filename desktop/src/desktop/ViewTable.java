
package desktop;

import java.sql.SQLException;

import java.util.ArrayList;

/**
 * The purpose is to diplay information about a selected Table Object to the user
 * @author Brandon Foster
 */
public class ViewTable extends javax.swing.JFrame {
    public static String[] strings = new String[10000]; // string to store table items in list
    public static String[] args = {};
    public static String tableNum;
    public static DataHandler databit;
    public static int serverNum = -1;
    public static String serverName = "";
    public static ArrayList<Item> itemsOrdered;
    public static String totalCost = "";
    
    /** Creates new form ViewTable */
    public ViewTable() throws SQLException {
        databit = new DataHandler();
        this.setLocationRelativeTo(null);
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
        itemsList = new javax.swing.JList();
        tableNumberLable = new javax.swing.JLabel();
        severLable = new javax.swing.JLabel();
        totalLable = new javax.swing.JLabel();
        removeItemButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        itemsList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(itemsList);

        tableNumberLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tableNumberLable.setText("Table " + tableNum);

        severLable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        severLable.setText("Server: " + serverName);

        totalLable.setText(totalCost);

        removeItemButton.setText("Remove");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(removeItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(totalLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(severLable, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableNumberLable, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(tableNumberLable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(severLable, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ManagerProfile.main(args);
        super.dispose();
    }//GEN-LAST:event_backButtonActionPerformed
    
    /**
     * @param args the command line arguments
     * args[0] contains the table number for this table
     */
    public static void main(String args[]) {
        tableNum = args[0];
        int tNum =  Integer.parseInt(tableNum);

        try {
            Table t = new Table();
            t = TableList.getTableByNumber(tNum);
            serverNum = t.getEmployeeNumber();
            //itemsOrdered = t.getItemsOrdered();
            totalCost = (t.totalCostOrder()).toString();
        } catch (SQLException e) {}

        try{
            serverName = databit.getEmployeeName(serverNum);
        }catch(SQLException e){}
        
        //Set all the items into the JList
        for(int i = 0; i < itemsOrdered.size(); i++){
            strings[i] = (itemsOrdered.get(i)).toString();
        }


        /* TESTING 
         * Create a table object with items ordered, insert into JList
        Table table1;
        serverName = "This Guy";
        try {
            table1 = new Table(1, 1);
            table1.addItem(new Item("Taco", 1, 3, 1.35));
            table1.addItem(new Item("Quesadilla", 2, 3, 4.35));
            table1.addItem(new Item("Torta", 3, 3, 5.35));
            table1.addItem(new Item("Gordita", 4, 3, 2.35));
            table1.printOrderTable();
            System.out.println(table1.totalCostOrder());
            
            itemsOrdered = table1.getItemsOrdered();
            //Items Ordered working?
            for(int i = 0; i < itemsOrdered.size(); i++){
                System.out.print(itemsOrdered.get(i).toString());
            }
            for(int i = 0; i < itemsOrdered.size(); i++){
                strings[i] = (itemsOrdered.get(i)).toString();
            }
            totalCost = (table1.totalCostOrder()).toString();
        } catch (SQLException e) {
        }
        */

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
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewTable().setVisible(true);
                } catch (SQLException e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JList itemsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JLabel severLable;
    private javax.swing.JLabel tableNumberLable;
    private javax.swing.JLabel totalLable;
    // End of variables declaration//GEN-END:variables

}
