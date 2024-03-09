/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import javax.swing.JOptionPane;
import models.ConexionLogin;

/**
 *
 * @author ghostpatron
 */
public class NewUser_View extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public NewUser_View() {
        initComponents();
        setResizable(false);
        setTitle("Crea Nuevo Usuario");          
    }
    
    /*
    private void realizarConsulta() {
        
        try{
            Connection connection = DB_Connection.getConnection();

            //Consulta
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Cerrar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fondo = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        pf_pass = new javax.swing.JPasswordField();
        lbl_icon = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();
        lbl_4 = new javax.swing.JLabel();
        tf_firstname = new javax.swing.JTextField();
        lbl_5 = new javax.swing.JLabel();
        tf_lastname = new javax.swing.JTextField();
        lbl_birthdate = new javax.swing.JLabel();
        tf_birthdate = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(700,800);

        pnl_fondo.setBackground(new java.awt.Color(51, 51, 51));

        lbl_1.setFont(new java.awt.Font("Garuda", 1, 24)); // NOI18N
        lbl_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_1.setText("Crea un nuevo usuario");

        lbl_2.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        lbl_2.setForeground(new java.awt.Color(249, 128, 170));
        lbl_2.setText("Correo:");

        lbl_3.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        lbl_3.setForeground(new java.awt.Color(249, 128, 170));
        lbl_3.setText("Password:");

        tf_email.setToolTipText("");
        tf_email.setPreferredSize(new java.awt.Dimension(50, 20));
        tf_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_emailActionPerformed(evt);
            }
        });

        pf_pass.setPreferredSize(new java.awt.Dimension(50, 20));
        pf_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passActionPerformed(evt);
            }
        });

        lbl_icon.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/SpookBookClone/img/logo3-150.png")); // NOI18N

        btn_register.setBackground(new java.awt.Color(249, 128, 170));
        btn_register.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btn_register.setForeground(new java.awt.Color(51, 51, 51));
        btn_register.setText("Registrate");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        lbl_4.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        lbl_4.setForeground(new java.awt.Color(249, 128, 170));
        lbl_4.setText("Nombre:");

        tf_firstname.setToolTipText("");
        tf_firstname.setPreferredSize(new java.awt.Dimension(50, 20));
        tf_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_firstnameActionPerformed(evt);
            }
        });

        lbl_5.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        lbl_5.setForeground(new java.awt.Color(249, 128, 170));
        lbl_5.setText("Apellido:");

        tf_lastname.setToolTipText("");
        tf_lastname.setPreferredSize(new java.awt.Dimension(50, 20));
        tf_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_lastnameActionPerformed(evt);
            }
        });

        lbl_birthdate.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        lbl_birthdate.setForeground(new java.awt.Color(249, 128, 170));
        lbl_birthdate.setText("Fecha:");

        tf_birthdate.setToolTipText("");
        tf_birthdate.setPreferredSize(new java.awt.Dimension(50, 20));
        tf_birthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_birthdateActionPerformed(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(249, 128, 170));
        btn_login.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(51, 51, 51));
        btn_login.setText("Inicia Sesion");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_fondoLayout = new javax.swing.GroupLayout(pnl_fondo);
        pnl_fondo.setLayout(pnl_fondoLayout);
        pnl_fondoLayout.setHorizontalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                        .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_3)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                                    .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_4)
                                        .addComponent(tf_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_5)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                                    .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnl_fondoLayout.createSequentialGroup()
                                            .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                                            .addComponent(lbl_2)
                                            .addGap(212, 212, 212)))
                                    .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_birthdate)
                                        .addComponent(tf_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(pf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                                .addComponent(btn_register)
                                .addGap(94, 94, 94)
                                .addComponent(btn_login)
                                .addGap(59, 59, 59)))
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                        .addComponent(lbl_1)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fondoLayout.createSequentialGroup()
                        .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))))
        );
        pnl_fondoLayout.setVerticalGroup(
            pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fondoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_1)
                .addGap(23, 23, 23)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_4)
                    .addComponent(lbl_5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_2)
                    .addComponent(lbl_birthdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(lbl_3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnl_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_register)
                    .addComponent(btn_login))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailActionPerformed

    private void pf_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_passActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        // TODO add your handling code here:
        tf_birthdate.setEnabled(false);
        tf_email.setEnabled(false);
        tf_firstname.setEnabled(false);
        tf_lastname.setEnabled(false);
        pf_pass.setEnabled(false);
        btn_register.setEnabled(false);
    }//GEN-LAST:event_btn_registerActionPerformed

    private void tf_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_firstnameActionPerformed

    private void tf_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_lastnameActionPerformed

    private void tf_birthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_birthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_birthdateActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        Login_View login = new Login_View();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(NewUser_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_birthdate;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JPasswordField pf_pass;
    private javax.swing.JPanel pnl_fondo;
    private javax.swing.JTextField tf_birthdate;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_firstname;
    private javax.swing.JTextField tf_lastname;
    // End of variables declaration//GEN-END:variables
}
