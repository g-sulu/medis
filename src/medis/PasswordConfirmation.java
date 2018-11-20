/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medis;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author GOKUL
 */
public class PasswordConfirmation extends javax.swing.JFrame {

    Connection con =null;
    PreparedStatement pst = null;
    public static String tName,user;
    
    /**
     * Creates new form PasswordConfirmation
     */
    public PasswordConfirmation(String tabName,String userId) {
        initComponents();
        tName = tabName;
        user = userId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new javax.swing.JPanel();
        passwordLabel1 = new javax.swing.JLabel();
        password1 = new javax.swing.JTextField();
        passwordLabel2 = new javax.swing.JLabel();
        password2 = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        BGLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backPanel.setLayout(null);

        passwordLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel1.setText("New Password");
        backPanel.add(passwordLabel1);
        passwordLabel1.setBounds(70, 100, 130, 40);
        backPanel.add(password1);
        password1.setBounds(290, 100, 210, 30);

        passwordLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel2.setText("Confirm New Password");
        backPanel.add(passwordLabel2);
        passwordLabel2.setBounds(70, 150, 150, 40);
        backPanel.add(password2);
        password2.setBounds(290, 150, 210, 30);

        submitBtn.setText("SUBMIT");
        submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        backPanel.add(submitBtn);
        submitBtn.setBounds(190, 250, 90, 23);

        cancelBtn.setText("CANCEL");
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        backPanel.add(cancelBtn);
        cancelBtn.setBounds(330, 250, 90, 23);

        BGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medis/icons/dialo_background.jpg"))); // NOI18N
        backPanel.add(BGLabel);
        BGLabel.setBounds(0, 0, 630, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        String query="";
        switch (tName) {
            case "admin":
                query = "update admin set adminPswd =? where adminID =?";
                break;
            case "doctor":
                query = "update doctor set docPswd =? where docID =?";
                break;
            case "patient":
                query = "update patient set patPswd =? where patID =?";
                break;
            case "pharmacy":
                query = "update pharmacy set phrmstPswd =? where phrmstID =?";
                break;
            default:
                break;
        }
        String pswd = password1.getText();
        String pass = password2.getText();
        if(pswd != null && pass != null && pswd.equals(pass) || !pswd.equals("") || pass != ""){
            try{
                con = my_sql_connect.connectdb();
                pst = con.prepareStatement(query);
                pst.executeUpdate();
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exception : "+e);
            }    
        }
        else{
            JOptionPane.showMessageDialog(null, "Enter valid password.");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PasswordConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordConfirmation(tName, user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGLabel;
    private javax.swing.JPanel backPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField password1;
    private javax.swing.JTextField password2;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}