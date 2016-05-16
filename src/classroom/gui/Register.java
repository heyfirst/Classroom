/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.gui;

import classroom.database.ConnectionDB;
import classroom.modal.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 *
 * @author Flukebregas
 */
public class Register extends javax.swing.JFrame {

    private String user;

    private String pass;

    private String name;

    private String position;

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        nameTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JTextField();
        usernameTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setPreferredSize(new java.awt.Dimension(510, 545));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setMnemonic('1');
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setMnemonic('2');
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });
        getContentPane().add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 152, -1));

        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });
        getContentPane().add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 152, -1));

        usernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFActionPerformed(evt);
            }
        });
        getContentPane().add(usernameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 152, -1));

        jButton1.setBackground(new Color(0,0,0,0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classroom/gui/deco/reg.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        jButton2.setBackground(new Color(0,0,0,0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classroom/gui/deco/back.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(107, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 120, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classroom/gui/deco/Regi.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 460, 510));

        setSize(new java.awt.Dimension(459, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        this.position = "TEACHER";
        this.jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        this.position = "STUDENT";
        this.jRadioButton1.setSelected(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:     

        try {
            if (this.usernameTF.getText().equalsIgnoreCase("") || this.passwordTF.getText().equalsIgnoreCase("")
                    || this.nameTF.getText().equalsIgnoreCase("") || this.buttonGroup1.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Regis not success");

            } else {
                String position = "";
                int getSelect = this.buttonGroup1.getSelection().getMnemonic();
                if (getSelect == 49) {
                    position = "TEACHER";
                } else if (getSelect == 50) {
                    position = "STUDENT";
                }

                Connection conn = ConnectionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement("insert into classroom.person (user,pass,name,position) values(?,?,?,?)");
                ps.setString(1, this.usernameTF.getText());
                ps.setString(2, this.passwordTF.getText());
                ps.setString(3, this.nameTF.getText());
                ps.setString(4, position);

                ps.executeUpdate();
                conn.close();
                
                JOptionPane.showMessageDialog(null, "Regis Success");
                Classroom hm = new Classroom();
                hm.setVisible(true);
                this.dispose();
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Classroom cr = new Classroom();
        cr.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTFActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
