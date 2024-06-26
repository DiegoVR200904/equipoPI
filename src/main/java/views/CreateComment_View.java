/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.DB_Connection;

/**
 *
 * @author ghostpatron
 */
public class CreateComment_View extends javax.swing.JFrame {
    private int id_u;
    private int id_p;
    private Connection connection;

    /**
     * Creates new form CreateComment_View
     */
    public CreateComment_View(int id_user, int id_post) {
        initComponents();
        setResizable(false);
        setTitle("Crear Comentario"); 
        this.id_u = id_user;
        this.id_p = id_post;
        
        try {
            connection = DB_Connection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bg = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_comment_text = new javax.swing.JTextArea();
        btn_comment = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_bg.setBackground(new java.awt.Color(51, 51, 51));

        lbl_title.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Crear Comentario");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 153));
        jLabel1.setText("Escribe comentario");

        ta_comment_text.setBackground(new java.awt.Color(102, 102, 102));
        ta_comment_text.setColumns(20);
        ta_comment_text.setForeground(new java.awt.Color(255, 255, 255));
        ta_comment_text.setRows(5);
        ta_comment_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153), 2));
        jScrollPane1.setViewportView(ta_comment_text);

        btn_comment.setBackground(new java.awt.Color(255, 102, 153));
        btn_comment.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btn_comment.setText("Insertar comentario");
        btn_comment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        btn_comment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_commentActionPerformed(evt);
            }
        });

        btn_return.setBackground(new java.awt.Color(255, 102, 153));
        btn_return.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btn_return.setText("Inicio");
        btn_return.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_bgLayout = new javax.swing.GroupLayout(pnl_bg);
        pnl_bg.setLayout(pnl_bgLayout);
        pnl_bgLayout.setHorizontalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(202, 202, 202))
            .addGroup(pnl_bgLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnl_bgLayout.createSequentialGroup()
                            .addComponent(btn_comment)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_return))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnl_bgLayout.setVerticalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bgLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_title)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_comment)
                    .addComponent(btn_return))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_commentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_commentActionPerformed
        // TODO add your handling code here:
        this.showYesNoDialog(); 
    }//GEN-LAST:event_btn_commentActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        // TODO add your handling code here:
        Home Home = new Home(id_u);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_returnActionPerformed

    private void showYesNoDialog() {
        int response = JOptionPane.showConfirmDialog(this, "Seguro que quieras comentar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
                String comment_query = "INSERT INTO Comments(post_id, user_id, text)"
                    + "VALUES(?, ?, ?)";

                try {
                PreparedStatement statement = connection.prepareStatement(comment_query);
                // Supongamos que estos datos vienen de algún lugar en tu aplicación
                int usuarioID = id_u;
                int publicacionID = id_p;
                String text = this.ta_comment_text.getText();

                statement.setInt(1, publicacionID);
                statement.setInt(2, usuarioID);
                statement.setString(3, text);

                statement.executeUpdate();
                statement.close();
                connection.close();

                System.out.println("Comentario insertado correctamente en la base de datos.");
            } catch (SQLException e) {
                // Manejar cualquier excepción que pueda ocurrir al ejecutar la consulta SQL
                e.printStackTrace();
            }
            
            Comments com = new Comments(id_p, id_u);
            com.setVisible(true);
            this.setVisible(false);
        } else if (response == JOptionPane.NO_OPTION) {
            //this.ta_comment_text.setText("");
            this.ta_comment_text.setEnabled(false);
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
            java.util.logging.Logger.getLogger(CreateComment_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateComment_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateComment_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateComment_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int userID = 123;
                int postID = 456;
                new CreateComment_View(userID, postID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_comment;
    private javax.swing.JButton btn_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bg;
    private javax.swing.JTextArea ta_comment_text;
    // End of variables declaration//GEN-END:variables
}
