/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
 
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import models.DB_Connection;

/**
 *
 * @author erika
 */
public class Profile extends javax.swing.JFrame {

    private int id;
    private Connection connection;
    private ResultSet resultSet;
    
    /**
     * Creates new form Profile
     */
    public Profile(int id) {
        setResizable(false);
        setTitle("Perfil");     
        this.id = id; 
        initComponents();
        
        try {
            connection = DB_Connection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.profile_info();
        this.mostrarDatos();
       // this.MostrarFoto();
    }
    /**
     * Creates new form Profile
     */
    
  private void profile_info(){
        try {
        String query = "SELECT u.first_name, u.last_name, COUNT(c.contact_id) AS friends\n" +
        "FROM Users u\n" +
        "LEFT JOIN Contacts c ON u.user_id = c.user_id\n" +
        "WHERE u.user_id = ? \n" +
        "GROUP BY u.user_id, u.first_name, u.last_name;"
       ;
        PreparedStatement statement = this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, id); // Asignar el ID de usuario al primer parámetro

        this.resultSet = statement.executeQuery();            
        } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     


   
    private void mostrarDatos() {
     
    try {
        if (resultSet.next()) { 
            
       
        String UserName = this.resultSet.getString("first_name");
         String UserLast = this.resultSet.getString("last_name");
         String friendsCount = this.resultSet.getString("friends");
         
       this.tf_name.setText(UserName+" "+UserLast);
         this.tf_countfriends.setText(friendsCount ); 
      
          
         
            
        } else {
            this.tf_countfriends.setText("No se encontraron amigos"); 
            this.tf_name.setText("No se encontraron datos de perfil");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jMenu5 = new javax.swing.JMenu();
        pnl_bar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_friends = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_createPost = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_Cover = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_CoverEdit = new javax.swing.JButton();
        btn_EditProfile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_ProfileImg = new javax.swing.JLabel();
        btn_Friends = new javax.swing.JButton();
        btn_Post = new javax.swing.JButton();
        tf_countfriends = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\erika\\OneDrive\\Documentos\\NetBeansProjects\\repositorioclonado\\Pruebaimages\\src\\main\\java\\img\\logo4-64.png")); // NOI18N

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
        btn_friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_friendsActionPerformed(evt);
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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lbl_Cover.setBackground(new java.awt.Color(255, 204, 255));
        lbl_Cover.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));

        btn_CoverEdit.setBackground(new java.awt.Color(249, 128, 170));
        btn_CoverEdit.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_CoverEdit.setText("Cambiar foto de portada");
        btn_CoverEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CoverEditActionPerformed(evt);
            }
        });

        btn_EditProfile.setBackground(new java.awt.Color(249, 128, 170));
        btn_EditProfile.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_EditProfile.setText("Editar perfil");
        btn_EditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditProfileActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl_ProfileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_ProfileImg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_Friends.setBackground(new java.awt.Color(255, 153, 204));
        btn_Friends.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Friends.setText("Amigos");
        btn_Friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FriendsActionPerformed(evt);
            }
        });

        btn_Post.setBackground(new java.awt.Color(255, 153, 204));
        btn_Post.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Post.setText("Publicaciones");
        btn_Post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PostActionPerformed(evt);
            }
        });

        tf_countfriends.setEditable(false);
        tf_countfriends.setBackground(new java.awt.Color(51, 51, 51));
        tf_countfriends.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tf_countfriends.setForeground(new java.awt.Color(255, 0, 153));
        tf_countfriends.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_countfriends.setBorder(null);
        tf_countfriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_countfriendsActionPerformed(evt);
            }
        });

        tf_name.setEditable(false);
        tf_name.setBackground(new java.awt.Color(51, 51, 51));
        tf_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tf_name.setForeground(new java.awt.Color(255, 0, 153));
        tf_name.setBorder(null);

        jLabel1.setForeground(new java.awt.Color(255, 102, 204));
        jLabel1.setText("amigos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Cover, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_Post)
                                    .addGap(37, 37, 37)
                                    .addComponent(btn_Friends)
                                    .addGap(422, 422, 422))))
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tf_countfriends, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_CoverEdit)
                            .addComponent(btn_EditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(190, 190, 190))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_Cover, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_countfriends, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_EditProfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_CoverEdit)))
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Friends)
                    .addComponent(btn_Post))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pnl_barLayout = new javax.swing.GroupLayout(pnl_bar);
        pnl_bar.setLayout(pnl_barLayout);
        pnl_barLayout.setHorizontalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addGap(123, 123, 123)
                .addComponent(btn_friends)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_createPost)
                .addGap(174, 174, 174)
                .addComponent(btn_home)
                .addGap(87, 87, 87))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_createPost)
                            .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_search)
                                .addComponent(btn_friends)
                                .addGroup(pnl_barLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_home)))
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_FriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FriendsActionPerformed
      /* Friends_View Friends_View= new Friends_View(id);
      Friends_View.setVisible(true);
        this.setVisible(false);
        */
    }//GEN-LAST:event_btn_FriendsActionPerformed

    private void btn_CoverEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CoverEditActionPerformed
        CreatePost_View createPost = new CreatePost_View(id);
        createPost.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_btn_CoverEditActionPerformed

    private void btn_PostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PostActionPerformed
  
    }//GEN-LAST:event_btn_PostActionPerformed

    private void btn_EditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditProfileActionPerformed
     Edit_Information Edit_Information= new Edit_Information(id);
      Edit_Information.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_EditProfileActionPerformed

    private void btn_createPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createPostActionPerformed
        CreatePost_View createPost = new CreatePost_View(id);
        createPost.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_createPostActionPerformed

    private void tf_countfriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_countfriendsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_countfriendsActionPerformed

    private void btn_friendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_friendsActionPerformed
        Friends amigo = new Friends(id);
        amigo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_friendsActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
         Home Home = new Home(id);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            int id_aux = 1234;

                new Profile(id_aux).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CoverEdit;
    private javax.swing.JButton btn_EditProfile;
    private javax.swing.JButton btn_Friends;
    private javax.swing.JButton btn_Post;
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Cover;
    public static javax.swing.JLabel lbl_ProfileImg;
    private javax.swing.JPanel pnl_bar;
    private javax.swing.JTextField tf_countfriends;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
