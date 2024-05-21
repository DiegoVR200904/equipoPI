/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DB_Connection;

/**
 *
 * @author erika
 */
public class Add_Friends extends javax.swing.JFrame {
    private int id;
    private Connection connection;
    private ResultSet resultSet;
    
  
    public Add_Friends(int id) {
         setResizable(false);
        setTitle("Perfil");     
        this.id = id; 
        initComponents();
        
        try {
            connection = DB_Connection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    private void mostrarPrimerRegistro() {       
    try {
        String query = "SELECT u.first_name, u.last_name, u.user_id, i.image_data\n" +
        "FROM Users u\n" + "JOIN Images i ON u.profile_image_id = i.image_id\n" +
        "WHERE u.user_id NOT IN (\n" + "    SELECT c.contact_user_id\n" + "    FROM Contacts c\n" +
        "    WHERE c.user_id = ?\n" + ")\n" + "AND u.user_id != ?;";
        
        PreparedStatement statement = this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, id); // Asignar el ID de usuario al primer parámetro

        this.resultSet = statement.executeQuery();            
    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_bar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        btn_friends = new javax.swing.JButton();
        btn_videos = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_createPost = new javax.swing.JButton();
        btn_Profile = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        btn_previous = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        lbl_picture = new javax.swing.JLabel();
        btn_add_friend = new javax.swing.JButton();
        lbl_last = new javax.swing.JLabel();
        lbl_name1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        btn_search.setBackground(new java.awt.Color(27, 27, 27));
        btn_search.setBorder(null);

        btn_friends.setBackground(new java.awt.Color(27, 27, 27));
        btn_friends.setBorder(null);
        btn_friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_friendsActionPerformed(evt);
            }
        });

        btn_videos.setBackground(new java.awt.Color(27, 27, 27));
        btn_videos.setBorder(null);
        btn_videos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_videosActionPerformed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(27, 27, 27));
        btn_home.setBorder(null);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_createPost.setBackground(new java.awt.Color(27, 27, 27));
        btn_createPost.setBorder(null);
        btn_createPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createPostActionPerformed(evt);
            }
        });

        btn_Profile.setBackground(new java.awt.Color(27, 27, 27));
        btn_Profile.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\5-40.png")); // NOI18N
        btn_Profile.setBorder(null);
        btn_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_barLayout = new javax.swing.GroupLayout(pnl_bar);
        pnl_bar.setLayout(pnl_barLayout);
        pnl_barLayout.setHorizontalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btn_search)
                        .addGap(65, 65, 65)
                        .addComponent(btn_videos)
                        .addGap(18, 18, 18)
                        .addComponent(btn_friends)
                        .addGap(18, 18, 18)
                        .addComponent(btn_home)
                        .addGap(18, 18, 18)
                        .addComponent(btn_createPost)
                        .addGap(78, 78, 78)
                        .addComponent(btn_Profile)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Profile)
                            .addComponent(btn_friends, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_videos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_createPost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbl_title.setFont(new java.awt.Font("Manjari", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Agrega Amigos");

        btn_previous.setBackground(new java.awt.Color(51, 51, 51));
        btn_previous.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\previous-50.png")); // NOI18N
        btn_previous.setBorder(null);
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(51, 51, 51));
        btn_next.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\next-50.png")); // NOI18N
        btn_next.setBorder(null);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        lbl_picture.setForeground(new java.awt.Color(255, 51, 102));
        lbl_picture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 153)));

        btn_add_friend.setBackground(new java.awt.Color(51, 51, 51));
        btn_add_friend.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\1-64.png")); // NOI18N
        btn_add_friend.setBorder(null);
        btn_add_friend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_friendActionPerformed(evt);
            }
        });

        lbl_last.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_last.setForeground(new java.awt.Color(255, 255, 255));
        lbl_last.setText("Apellido");

        lbl_name1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_name1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name1.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(lbl_title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btn_previous)
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btn_add_friend)
                                .addGap(194, 194, 194)
                                .addComponent(btn_next))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_last, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbl_picture, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_picture, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_last)
                    .addComponent(lbl_name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_next)
                    .addComponent(btn_previous)
                    .addComponent(btn_add_friend))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_friendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_friendsActionPerformed
        /*Friends_View Friends_View = new Friends_View(id);
        Friends_View.setVisible(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_btn_friendsActionPerformed

    private void btn_videosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_videosActionPerformed
        /* Videos_View Videos_View = new Videos_View(id);
        Videos_View.setVisible(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_btn_videosActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        Home Home = new Home(id);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed

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

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        // TODO add your handling code here:
        //this.mostrarRegistroAnterior();
    }//GEN-LAST:event_btn_previousActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        //this.mostrarRegistroSiguiente();
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_add_friendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_friendActionPerformed
        // TODO add your handling code here:
        try {
            int id_post = this.resultSet.getInt("post_id");

            String reaction_query = "UPDATE Reactions \n"
            + "SET likes = likes + 1 \n"
            + "WHERE post_id = ?";

            PreparedStatement statement = connection.prepareStatement(reaction_query);
            statement.setInt(1, id_post);
            statement.executeUpdate();
            statement.close();
            //connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_add_friendActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int id_aux = 1234;
                new Add_Friends(id_aux).setVisible(true);
            }
        });
           
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Profile;
    private javax.swing.JButton btn_add_friend;
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_videos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_last;
    private javax.swing.JLabel lbl_name1;
    private javax.swing.JLabel lbl_picture;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bar;
    // End of variables declaration//GEN-END:variables
}
