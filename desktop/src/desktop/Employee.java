
package desktop;

import java.awt.Font;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;

import java.util.Date;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Dimension;

import oracle.net.aso.c;


/**
 *
 * @author Nicolas Nunez
 *
 */
public class Employee extends javax.swing.JFrame {

    /** Creates new form Employee */
    SimpleDateFormat fmt = new SimpleDateFormat("MMM/dd/yyyy");
    Font bfont = new Font("Verdana", Font.BOLD, 13);
    ImageIcon img = new ImageIcon("C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\desktop\\src\\desktop\\logo.png");
    BufferedImage picture, restLogo;
    File file;
    ImageIcon iicon, restIcon;
    String filepath = "C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\EmployeePictures\\";
    String logopath = "C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\losaltoslogo\\300-187-wide.png";
    String picturepath;
    DataHandler databit;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int)tk.getScreenSize().getWidth());
    int ySize = ((int)tk.getScreenSize().getHeight())-30;
    String args[] = {};
    public Employee() throws SQLException, IOException {
        restLogo = ImageIO.read(new File(logopath));
        restIcon = new ImageIcon(restLogo);
        databit = new DataHandler();
        initComponents();
        this.RestaurantLogoLabel.setIcon(restIcon);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        PicturePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        LabelContainingPicture = new javax.swing.JLabel();
        PictureLabel = new javax.swing.JLabel();
        InformationLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ModifyTable = new javax.swing.JTable();
        ModifyLabel = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        AddEmployee = new javax.swing.JButton();
        DeleteEmployee = new javax.swing.JButton();
        AddtoDB = new javax.swing.JButton();
        RestaurantLogoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabit");
        setBackground(new java.awt.Color(0, 153, 153));
        setIconImage(img.getImage());

        PicturePanel.setBackground(new java.awt.Color(255, 255, 255));
        PicturePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelContainingPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelContainingPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PicturePanelLayout = new javax.swing.GroupLayout(PicturePanel);
        PicturePanel.setLayout(PicturePanelLayout);
        PicturePanelLayout.setHorizontalGroup(
            PicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PicturePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PicturePanelLayout.setVerticalGroup(
            PicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PicturePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PictureLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        InformationLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        InformationLabel.setText("Employee Information");

        ModifyTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ModifyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Last Name", "FirstName", "Date of Birth", "Position", "Salary", "PhoneNo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ModifyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifyTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ModifyTable);
        ModifyTable.getColumnModel().getColumn(0).setResizable(false);
        ModifyTable.getColumnModel().getColumn(0).setPreferredWidth(4);
        ModifyTable.getColumnModel().getColumn(0).setHeaderValue("Id");
        ModifyTable.getColumnModel().getColumn(1).setHeaderValue("Last Name");
        ModifyTable.getColumnModel().getColumn(2).setHeaderValue("FirstName");
        ModifyTable.getColumnModel().getColumn(3).setHeaderValue("Date of Birth");
        ModifyTable.getColumnModel().getColumn(4).setHeaderValue("Position");
        ModifyTable.getColumnModel().getColumn(5).setResizable(false);
        ModifyTable.getColumnModel().getColumn(5).setHeaderValue("Salary");
        ModifyTable.getColumnModel().getColumn(6).setHeaderValue("PhoneNo");
        DefaultTableModel dtm = (DefaultTableModel) ModifyTable.getModel();
        int rows = 0;
        System.out.println(rows);
        try {
            System.out.println(rows);
            rows = databit.getRows("Employee");
            System.out.println("It executed");
        }catch (SQLException e) {}
        System.out.println("# of rows " + rows);
        int rowsInTable = ModifyTable.getRowCount();
        while(rowsInTable < rows){
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null});
            rowsInTable++;
        }
        try{
            loadInventory(ModifyTable, rows);
        }catch(SQLException e) { }

        ModifyLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ModifyLabel.setText("Modify Employee Information");

        Exit.setBackground(new java.awt.Color(0, 0, 153));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("Back");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        AddEmployee.setBackground(new java.awt.Color(0, 0, 153));
        AddEmployee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddEmployee.setForeground(new java.awt.Color(255, 255, 255));
        AddEmployee.setText("New Employee");
        AddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmployeeActionPerformed(evt);
            }
        });

        DeleteEmployee.setBackground(new java.awt.Color(0, 0, 153));
        DeleteEmployee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteEmployee.setForeground(new java.awt.Color(255, 255, 255));
        DeleteEmployee.setText("Delete Employee");
        DeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployeeActionPerformed(evt);
            }
        });

        AddtoDB.setBackground(new java.awt.Color(0, 0, 153));
        AddtoDB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddtoDB.setForeground(new java.awt.Color(255, 255, 255));
        AddtoDB.setText("Save");
        AddtoDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddtoDBActionPerformed(evt);
            }
        });

        InfoTextArea.setEditable(false);
        InfoTextArea.setColumns(20);
        InfoTextArea.setLineWrap(true);
        InfoTextArea.setRows(5);
        InfoTextArea.setFont(bfont);
        InfoTextArea.setForeground(Color.blue);
        InfoTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane1.setViewportView(InfoTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(ModifyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(AddtoDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PicturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 50, Short.MAX_VALUE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(RestaurantLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PictureLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModifyLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(PicturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(RestaurantLogoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(DeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddtoDB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void ModifyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifyTableMouseClicked
        // TODO add your handling code here:
        Object o;
        int row = ModifyTable.rowAtPoint(evt.getPoint());
        int col = 0;
        o = ModifyTable.getModel().getValueAt(row, col);
        if( o == null) {
            System.out.println("Doesnt have a value yet");
        }
        else{
        int id = Integer.parseInt(o.toString());
        System.out.println(id);
            try {
                fillPictureLabel(id);
                fillInfoTextArea(id);
                loadPicturePanel(id);
            } catch (SQLException e) {} catch (IOException e) {
            }
        }
    }//GEN-LAST:event_ModifyTableMouseClicked

    private void AddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmployeeActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) ModifyTable.getModel();
        dtm.addRow(new Object[] { null, null, null, null, null, null, null, null });
        int row = ModifyTable.getSelectedRow();
        System.out.println(row);
    }//GEN-LAST:event_AddEmployeeActionPerformed

    private void DeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployeeActionPerformed
        // TODO add your handling code here:
        int row = ModifyTable.getSelectedRow();
        System.out.print("This is the row that is currently selected: " + row + "\n");
        Object o = ModifyTable.getModel().getValueAt(row, 0);
        if (o == null){
        ((DefaultTableModel)ModifyTable.getModel()).removeRow(row);
        }
        else{
            //TextDialog
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this employee from the database?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Delete product from the database.
                int id = Integer.parseInt(o.toString());
                System.out.println(id);
                    try {
                        databit.deleteById("Employee", id);
                    } catch (SQLException e) {
                }
                ((DefaultTableModel)ModifyTable.getModel()).removeRow(row);        
            }
            else{
                System.out.println("Not confirmed");
            }
        }
    }//GEN-LAST:event_DeleteEmployeeActionPerformed

    private void AddtoDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddtoDBActionPerformed
        // TODO add your handling code here:
        // this is where INSERTION WILL GET CALLED
        System.out.println("Adding to the Database");
        //Add records to database
        int id = -1;
        double Salary =-1;
        String FirstN="", LastN="", Position="", PhoneNo="", DOB="";
        boolean correct = true;
        int row = ModifyTable.getSelectedRow();
        for (int i = 0; i < ModifyTable.getRowCount(); i++) {
            Object o;
            System.out.println("IM there");
            o = ModifyTable.getModel().getValueAt(i, 0);
            if (o == null) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
                id = -1;
                correct = false;
                continue;
            } else
                id = Integer.parseInt(o.toString());
                o = ModifyTable.getModel().getValueAt(i, 1);
            if (o == null) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
                LastN = "";
                correct = false;
                continue;
            } else {
                LastN = o.toString();
                LastN = LastN.toUpperCase();
            }
            o = ModifyTable.getModel().getValueAt(i, 2);
            if (o == null) {
                //                JOptionPane.showInputDialog(null, "WRONG");
                JOptionPane.showMessageDialog(null, "Fill all fields");
                FirstN = "";
                correct = false;
                continue;
            } else
                FirstN = o.toString();
                FirstN = FirstN.toUpperCase();
            
            o = ModifyTable.getModel().getValueAt(i, 3);
            if (o == null) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
                DOB = "";
                correct = false;
                continue;
            } else if (!isDateValid( o.toString())){
                JOptionPane.showMessageDialog(null, "Date Format is: MON/DD/YYYY");
                DOB = "";
                correct = false;
                continue;
            }
                else{
                DOB = o.toString();
            }


            o = ModifyTable.getModel().getValueAt(i, 4);
            if (o == null) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
                Position = "";
                correct = false;
                continue;
            } else
                Position = o.toString();
                Position = Position.toUpperCase();
            
            o = ModifyTable.getModel().getValueAt(i, 5);
            if (o == null) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
                Salary = -1;
                correct = false;
                continue;
            } else
                //TotalCost = Float.parseFloat(o.toString());
                Salary = Double.parseDouble(o.toString());

            o = ModifyTable.getModel().getValueAt(i, 6);
            if (o == null) {
                JOptionPane.showMessageDialog(null, "Fill all fields");
                PhoneNo = "";
                correct = false;
                continue;
            } else
                PhoneNo = o.toString();
            
            if(correct ==true){
                try {
                    if (!databit.findKey("employee", id))
                        try {
                            databit.addNewEmployee(id, LastN, FirstN, DOB, Position, Salary, PhoneNo);
                        } catch (SQLException e) {
                        }
                    else
                        try {
                            databit.updateEmployee(id, LastN, FirstN, DOB, Position, Salary, PhoneNo);
                        } catch (SQLException e) {
                        }
                } catch (SQLException e) {
                }
            }
        }
       
        
    }//GEN-LAST:event_AddtoDBActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        ManagerProfile.main(args);
        super.dispose();
    }//GEN-LAST:event_ExitActionPerformed
   
    public static boolean isDateValid(String date) 
    {
            try {
                DateFormat df = new SimpleDateFormat(Inventory.FORMAT);
                df.setLenient(false);
               Date d= df.parse(date);
                System.out.println(d);
                return true;
            } catch (ParseException e) {
                return false;
            }
    }
    
    public void fillInfoTextArea(int id) throws SQLException {
        System.out.println("Executing!!!");
        this.InfoTextArea.setText(databit.getEmployeeInfo(id));
    }
    
    public void loadPicturePanel(int id) throws SQLException, IOException {
        if(databit.getEmployeePicture(id) == null){
            System.out.println("Picture path is not in DB");
            this.LabelContainingPicture.setIcon(null);
        }
        else{
            picturepath = this.filepath + databit.getEmployeePicture(id);
            System.out.println(picturepath);
            picture = ImageIO.read(new File(picturepath));
            iicon = new ImageIcon(picture);
            this.LabelContainingPicture.setIcon(iicon);
        }
        throw new IOException("There is something wrong");
    }
    
    public void fillPictureLabel(int id) throws SQLException{
        this.PictureLabel.setText(databit.getEmployeeName(id));
    }
    
    void loadInventory(JTable jt, int rows) throws SQLException {
        ResultSet inventory = databit.getAllEmployees();
        int i = 0;
            
        while (inventory.next()) {
            jt.getModel().setValueAt(inventory.getInt(1), i, 0);
            jt.getModel().setValueAt(inventory.getString(2), i, 1);
            jt.getModel().setValueAt(inventory.getString(3), i, 2);
            jt.getModel().setValueAt(fmt.format(inventory.getDate(4)), i, 3);
            jt.getModel().setValueAt(inventory.getString(5), i, 4);
            jt.getModel().setValueAt(inventory.getDouble(6), i, 5);
            jt.getModel().setValueAt(inventory.getString(7), i, 6);
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new Employee().setVisible(true);
                }
                    catch(SQLException e){} catch (IOException e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEmployee;
    private javax.swing.JButton AddtoDB;
    private javax.swing.JButton DeleteEmployee;
    private javax.swing.JButton Exit;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JLabel InformationLabel;
    private javax.swing.JLabel LabelContainingPicture;
    private javax.swing.JLabel ModifyLabel;
    private javax.swing.JTable ModifyTable;
    private javax.swing.JLabel PictureLabel;
    private javax.swing.JPanel PicturePanel;
    private javax.swing.JLabel RestaurantLogoLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
