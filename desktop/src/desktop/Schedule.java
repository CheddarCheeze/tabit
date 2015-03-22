
package desktop;

import java.awt.Font;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martinbruckner
 */
public class Schedule extends javax.swing.JFrame{    
    @SuppressWarnings("compatibility:8515289491683898573")
    private static final long serialVersionUID = -160035917128169035L;
    
    DataHandler databit;
    /** Creates new form Schedule */
    public Schedule() throws SQLException{
        databit = new DataHandler();
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
        Date date = new Date();
        Date datetemp = new Date();
        int days = date.getDate();
        datetemp.setDate(days+ 7);
        int currentday = date.getDay();

        datetemp.setDate(days+ 7);
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        String dateTempString = new SimpleDateFormat("dd/MM/yyyy").format(datetemp);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int rows = 0;
        try {
            rows = databit.getRows("Schedule");

        }catch (SQLException e) {}
        //System.out.println("# of rows " + rows);
        int rowsInTable = jTable1.getRowCount();
        while(rowsInTable < rows){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null});
            rowsInTable++;
        }
        try{
            loadSchedule(jTable1, rows);
        }catch(SQLException e) { }

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Employee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Back");

        jLabel1.setText("Schedule from: " + dateString + " to : " + dateTempString);
        jLabel1.setFont(new Font("", Font.BOLD, 18));
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Save Records");
        //Add records to database
        try{
            databit.deleteInfoDatabase("Schedule");
        }catch(SQLException e){}
        String name, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        for (int i=0; i<jTable1.getRowCount(); i++){
           name = (String)jTable1.getModel().getValueAt(i, 0);
           Monday = (String)jTable1.getModel().getValueAt(i, 1);
            Tuesday = (String)jTable1.getModel().getValueAt(i, 2);
            Wednesday = (String)jTable1.getModel().getValueAt(i, 3);
            Thursday = (String)jTable1.getModel().getValueAt(i, 4);
            Friday = (String)jTable1.getModel().getValueAt(i, 5);
            Saturday = (String)jTable1.getModel().getValueAt(i, 6);
            Sunday = (String)jTable1.getModel().getValueAt(i, 7);
//            System.out.println(name + " " +  Monday + " " + Tuesday + " " + Wednesday + " " + Thursday + " " + Friday + " " + Saturday + " " + Sunday);
            if(name != null){
            try {
                    databit.addSchedule(name, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday);
                } catch (SQLException e) {
                }
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addRow(new Object[]{null, null, null, null, null, null, null, null});
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel1ComponentResized
        // TODO add your handling code here:
        //QUIT
    }//GEN-LAST:event_jLabel1ComponentResized
    
    void loadSchedule(JTable jt, int rows) throws SQLException{
        ResultSet schedule = databit.getSchedule();
        int i = 0;
        while(schedule.next()){
            jt.getModel().setValueAt(schedule.getString(1),i ,0);
            jt.getModel().setValueAt(schedule.getString(2),i ,1);
            jt.getModel().setValueAt(schedule.getString(3),i ,2);
            jt.getModel().setValueAt(schedule.getString(4),i ,3);
            jt.getModel().setValueAt(schedule.getString(5),i ,4);
            jt.getModel().setValueAt(schedule.getString(6),i ,5);
            jt.getModel().setValueAt(schedule.getString(7),i ,6);
            jt.getModel().setValueAt(schedule.getString(8),i ,7);
            i++;
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
        //System.out.println(Schedule.date.toString());
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    new Schedule().setVisible(true);
                } catch (SQLException e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
