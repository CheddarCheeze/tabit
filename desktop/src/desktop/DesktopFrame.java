
package desktop;
import java.awt.Image;
import java.io.File;

import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Nicolas Nunez
 */
public class DesktopFrame extends javax.swing.JFrame {
    String args[] = {};
    public static boolean needTableList = true;
    public static TableList tables;    
    DataHandler databit;
    @SuppressWarnings("compatibility:-4952383735578523799")
    private static final long serialVersionUID = 1L;
    private String pathtoBackground = "C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\losaltoslogo\\600-375-wide.png";
    ImageIcon img = new ImageIcon("C:\\Users\\Nicolas Nunez\\Desktop\\tabit\\desktop\\src\\desktop\\logo.png");
    private ImageIcon loginIcon = new ImageIcon(pathtoBackground);

    @SuppressWarnings("oracle.jdeveloper.java.field-not-serializable")
    /** Creates new form DesktopFrame */
    public DesktopFrame() throws SQLException{
        databit = new DataHandler();
        initComponents();
        this.setLocationRelativeTo(getRootPane());
        setIconImage(img.getImage());
        this.loginLabel.setIcon(loginIcon);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        signInButton = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        signInPasswordLabel = new javax.swing.JLabel();
        signInUserNameLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        PicturePanel = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setBackground(new java.awt.Color(204, 255, 51));
        jSplitPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSplitPane1.setDividerLocation(40);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        signInButton.setBackground(new java.awt.Color(255, 255, 255));
        signInButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signInButton.setText("Sign In!");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        signInPasswordLabel.setBackground(new java.awt.Color(0, 0, 0));
        signInPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signInPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        signInPasswordLabel.setText("Password:");

        signInUserNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        signInUserNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signInUserNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        signInUserNameLabel.setText("User ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signInUserNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signInPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signInButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(signInUserNameLabel)
                    .addComponent(signInPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signInButton))
                .addContainerGap())
        );

        jSplitPane1.setTopComponent(jPanel1);

        PicturePanel.setBackground(new java.awt.Color(0, 0, 0));

        loginLabel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PicturePanelLayout = new javax.swing.GroupLayout(PicturePanel);
        PicturePanel.setLayout(PicturePanelLayout);
        PicturePanelLayout.setHorizontalGroup(
            PicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        PicturePanelLayout.setVerticalGroup(
            PicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(PicturePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }//GEN-END:initComponents

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Sign in button pressed!");
        System.out.println(this.username.getText());
        System.out.println(this.password.getText());
        
        boolean authentification = false;
        try {
            authentification = Authenticate(username.getText(), password.getText());
        } catch (SQLException e) {
        }
        if(authentification){
                System.out.println("Open the manager Profile");
            }
            else{
                System.out.println("Open dialog to indicate that the password or username do not match");   
            }
    }//GEN-LAST:event_signInButtonActionPerformed
    
    private boolean Authenticate(String u, String p) throws SQLException{
            String toMatch = "";
            toMatch = databit.getLoginData(Integer.parseInt(u));
            boolean temp = false;
            if(!toMatch.isEmpty()){
                if (toMatch.matches(p))
                    temp = true;
            }
            return temp;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if(needTableList == true){
//            TableList t = new TableList();
            tables = new TableList();
            needTableList = false;
        }
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
            java.util.logging.Logger.getLogger(DesktopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DesktopFrame().setVisible(true);
                } catch (SQLException e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PicturePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel signInPasswordLabel;
    private javax.swing.JLabel signInUserNameLabel;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
