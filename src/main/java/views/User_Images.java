/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DB_Connection;

/**
 *
 * @author erika
 */
public class User_Images extends javax.swing.JFrame {
private Connection connection;
    private ResultSet resultSet;
    private int id;
    
    public User_Images(int id) {
    try {
        initComponents();
        setResizable(false);
        setTitle("UserImages");
        this.id = id;
        connection = DB_Connection.getConnection();
    } catch (SQLException ex) {
        Logger.getLogger(User_Images.class.getName()).log(Level.SEVERE, null, ex);
    }
    //Metodos
    
    }
public void OrganizarImagen(){
    int countimg=0;
    if(countimg==1){
        
    }
    if(countimg==2){
        
    }
    if(countimg==3){
        
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_friends = new javax.swing.JButton();
        btn_videos = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_createPost = new javax.swing.JButton();
        btn_Profile = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_UserImage1 = new javax.swing.JLabel();
        lbl_UserImage3 = new javax.swing.JLabel();
        lbl_UserImage2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        tf_search.setBackground(new java.awt.Color(102, 102, 102));
        tf_search.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        tf_search.setForeground(new java.awt.Color(249, 128, 170));
        tf_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 128, 170)));

        btn_search.setBackground(new java.awt.Color(27, 27, 27));
        btn_search.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\2-40.png")); // NOI18N
        btn_search.setBorder(null);

        btn_friends.setBackground(new java.awt.Color(27, 27, 27));
        btn_friends.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\3-40.png")); // NOI18N
        btn_friends.setBorder(null);

        btn_videos.setBackground(new java.awt.Color(27, 27, 27));
        btn_videos.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\5-40.png")); // NOI18N
        btn_videos.setBorder(null);
        btn_videos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_videosActionPerformed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(27, 27, 27));
        btn_home.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\4-40.png")); // NOI18N
        btn_home.setBorder(null);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_createPost.setBackground(new java.awt.Color(27, 27, 27));
        btn_createPost.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\equipoPI\\src\\main\\java\\img\\agregar-publicacion.png")); // NOI18N
        btn_createPost.setBorder(null);
        btn_createPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createPostActionPerformed(evt);
            }
        });

        btn_Profile.setBackground(new java.awt.Color(51, 51, 51));
        btn_Profile.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\previous-50.png")); // NOI18N
        btn_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProfileActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 51, 153));

        lbl_UserImage1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 204), 1, true));

        lbl_UserImage3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 204), 1, true));

        lbl_UserImage2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 204), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbl_UserImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lbl_UserImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lbl_UserImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_UserImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_UserImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_UserImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout pnl_barLayout = new javax.swing.GroupLayout(pnl_bar);
        pnl_bar.setLayout(pnl_barLayout);
        pnl_barLayout.setHorizontalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addGap(76, 76, 76)
                .addComponent(btn_videos)
                .addGap(88, 88, 88)
                .addComponent(btn_friends)
                .addGap(105, 105, 105)
                .addComponent(btn_createPost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_home)
                .addGap(52, 52, 52)
                .addComponent(btn_Profile)
                .addGap(25, 25, 25))
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_search)
                            .addComponent(btn_Profile)
                            .addComponent(btn_videos)
                            .addComponent(btn_friends)
                            .addComponent(btn_createPost)
                            .addComponent(btn_home))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createPostActionPerformed
        CreatePost_View createPost = new CreatePost_View(id);
        createPost.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_createPostActionPerformed

    private void btn_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProfileActionPerformed
        Profile Profile = new Profile(id);
        Profile.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btn_ProfileActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
         Home Home = new Home(id);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_videosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_videosActionPerformed
        /* Videos_View Videos_View = new Videos_View(id);
        Videos_View.setVisible(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_btn_videosActionPerformed

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
            java.util.logging.Logger.getLogger(User_Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Images.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int id_aux = 123;
                new Home(id_aux).setVisible(true);
              // new Profile(id_aux).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Profile;
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_videos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_UserImage1;
    private javax.swing.JLabel lbl_UserImage2;
    private javax.swing.JLabel lbl_UserImage3;
    private javax.swing.JPanel pnl_bar;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
