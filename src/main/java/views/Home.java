/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/
package views;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import models.DB_Connection;
/**
*
* @author ghostpatron
*/
public class Home extends javax.swing.JFrame {
    private Connection connection;
    private ResultSet resultSet;
    private int id;
 
    public Home(int id) {
        initComponents();
        setResizable(false);
        setTitle("Inicio");     
        this.id = id; 
        try {
            connection = DB_Connection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrarPrimerRegistro();
       
    }
    
private void mostrarPrimerRegistro() {       
    try {
            String query = "SELECT DISTINCT \n" +
            "    p.post_id, \n" +
            "    p.post_text, \n" +
            "    p.post_type, \n" +
            "    i.image_data, \n" +
            "    v.video_data,\n" +
            "    COALESCE(SUM(r.likes), 0) AS Likes,\n" +
            "    COALESCE(SUM(r.laughs), 0) AS Laughs,\n" +
            "    COALESCE(SUM(r.loves), 0) AS Loves\n" +
            "FROM \n" +
            "    Posts p\n" +
            "LEFT JOIN \n" +
            "    Images i ON p.post_id = i.post_id \n" +
            "LEFT JOIN \n" +
            "    Videos v ON p.post_id = v.post_id \n" +
            "LEFT JOIN \n" +
            "    Contacts c ON p.user_id = c.contact_user_id \n" +
            "LEFT JOIN \n" +
            "    Reactions r ON p.post_id = r.post_id\n" +
            "WHERE \n" +
            "    p.user_id = ? OR c.user_id = ?\n" +
            "GROUP BY \n" +
            "    p.post_id, p.post_text, p.post_type, i.image_data, v.video_data;";
        
        PreparedStatement statement = this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, id); // Asignar el ID de usuario al primer parámetro
        statement.setInt(2, id); // Asignar el ID de usuario al segundo parámetro

        this.resultSet = statement.executeQuery();            
    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void mostrarRegistroAnterior() {
    try {
        if (this.resultSet != null && !this.resultSet.isBeforeFirst()) {
            this.resultSet.previous();
            mostrarDatos();
        }
    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void mostrarRegistroSiguiente() {
    try {
        if (this.resultSet != null && this.resultSet.next()) {
            mostrarDatos();
        }
    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private static ImageIcon bytesToImageIcon(byte[] multimedia) {
        try {
            // Convert bytes to BufferedImage
            ByteArrayInputStream bis = new ByteArrayInputStream(multimedia);
            BufferedImage bImage = ImageIO.read(bis);

            // Convert BufferedImage to ImageIcon
            return new ImageIcon(bImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void mostrarDatos() {  
        try {
            String texto = this.resultSet.getString("post_text");
            String postype = this.resultSet.getString("post_type");
            String likes = this.resultSet.getString("Likes");
            String laughs = this.resultSet.getString("Laughs");
            String loves = this.resultSet.getString("Loves");
            switch(postype){
                case "text":
                    this.lbl_text.setText(texto);
                    this.lbl_image.setIcon(null);
                    break;
                case "image":
                    this.lbl_text.setText(texto);
                    byte[] imagen = this.resultSet.getBytes("image_data");
                    ImageIcon imageIcon = bytesToImageIcon(imagen);
                        if (imageIcon != null) {
                            Image scaledImage = imageIcon.getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon scaledIcon = new ImageIcon(scaledImage);
                            this.lbl_image.setIcon(scaledIcon);
                        } else {
                            System.out.println("no cargo imagen xd");
                            //this.ta_text.setText("Failed to load image");
                    }
                    break;
                case "video":
                    break;
                default:
                    break;   
            }
            this.lbl_like_count.setText(likes);
            this.lbl_love_count.setText(loves);
            this.lbl_laughs_count.setText(laughs);
            
            //String video = resultSet.getInt("edad");
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

        jPanel1 = new javax.swing.JPanel();
        pnl_bar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_friends = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_createPost = new javax.swing.JButton();
        btn_Profile = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        lbl_text = new javax.swing.JLabel();
        btn_previous = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        btn_like = new javax.swing.JButton();
        btn_love = new javax.swing.JButton();
        btn_laugh = new javax.swing.JButton();
        btn_comments = new javax.swing.JButton();
        lbl_like_count = new javax.swing.JLabel();
        lbl_love_count = new javax.swing.JLabel();
        lbl_laughs_count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        btn_friends.setBackground(new java.awt.Color(27, 27, 27));
        btn_friends.setBorder(null);
        btn_friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_friendsActionPerformed(evt);
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
                        .addGap(271, 271, 271)
                        .addComponent(btn_friends)
                        .addGap(29, 29, 29)
                        .addComponent(btn_home)
                        .addGap(65, 65, 65)
                        .addComponent(btn_createPost)
                        .addGap(54, 54, 54)
                        .addComponent(btn_Profile, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_friends)
                            .addComponent(btn_home)
                            .addComponent(btn_Profile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addComponent(btn_createPost, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        lbl_title.setFont(new java.awt.Font("Manjari", 1, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Publicaciones");

        lbl_text.setForeground(new java.awt.Color(255, 102, 153));
        lbl_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));

        btn_previous.setBackground(new java.awt.Color(51, 51, 51));
        btn_previous.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/previous-50.png")); // NOI18N
        btn_previous.setBorder(null);
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(51, 51, 51));
        btn_next.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/next-50.png")); // NOI18N
        btn_next.setBorder(null);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        lbl_image.setForeground(new java.awt.Color(255, 51, 102));
        lbl_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 153)));

        btn_like.setBackground(new java.awt.Color(51, 51, 51));
        btn_like.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/Like rosa.png")); // NOI18N
        btn_like.setBorder(null);
        btn_like.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_likeActionPerformed(evt);
            }
        });

        btn_love.setBackground(new java.awt.Color(51, 51, 51));
        btn_love.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/Corazon rosa.png")); // NOI18N
        btn_love.setBorder(null);
        btn_love.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loveActionPerformed(evt);
            }
        });

        btn_laugh.setBackground(new java.awt.Color(51, 51, 51));
        btn_laugh.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/Risa rosa.png")); // NOI18N
        btn_laugh.setBorder(null);
        btn_laugh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laughActionPerformed(evt);
            }
        });

        btn_comments.setBackground(new java.awt.Color(51, 51, 51));
        btn_comments.setBorder(null);
        btn_comments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_commentsActionPerformed(evt);
            }
        });

        lbl_like_count.setForeground(new java.awt.Color(255, 255, 255));
        lbl_like_count.setText("likes");

        lbl_love_count.setForeground(new java.awt.Color(255, 255, 255));
        lbl_love_count.setText("loves");

        lbl_laughs_count.setForeground(new java.awt.Color(255, 255, 255));
        lbl_laughs_count.setText("loves");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_image, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_previous)
                                .addGap(101, 101, 101)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_like_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_like, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_love, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_love_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_laugh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_laughs_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_comments)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_next)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_text, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_next)
                    .addComponent(btn_previous)
                    .addComponent(btn_love)
                    .addComponent(btn_laugh)
                    .addComponent(btn_comments)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_like)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_like_count)
                            .addComponent(lbl_love_count)
                            .addComponent(lbl_laughs_count))))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        // TODO add your handling code here:
        this.mostrarRegistroAnterior();
    }//GEN-LAST:event_btn_previousActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        this.mostrarRegistroSiguiente();
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_createPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createPostActionPerformed
        CreatePost_View createPost = new CreatePost_View(id);
        createPost.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_createPostActionPerformed

    private void btn_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProfileActionPerformed
        Profile  Profile = new Profile(id);
        Profile.setVisible(true);
        this.setVisible(false);      
    }//GEN-LAST:event_btn_ProfileActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        Home Home = new Home(id);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_friendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_friendsActionPerformed
        Friends amigo = new Friends(id);
        amigo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_friendsActionPerformed

    private void btn_likeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_likeActionPerformed
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
        Home casa = new Home(id);
        casa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_likeActionPerformed

    private void btn_loveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loveActionPerformed
        try {
            int id_post = this.resultSet.getInt("post_id");
            
            String reaction_query = "UPDATE Reactions \n"
                    + "SET loves = loves + 1 \n"
                    + "WHERE post_id = ?";
            
            PreparedStatement statement = connection.prepareStatement(reaction_query);
            statement.setInt(1, id_post);
            statement.executeUpdate();
            statement.close();
            //connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        Home casa = new Home(id);
        casa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_loveActionPerformed

    private void btn_laughActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laughActionPerformed
       try {
            int id_post = this.resultSet.getInt("post_id");
            
            String reaction_query = "UPDATE Reactions \n"
                    + "SET laughs = laughs + 1 \n"
                    + "WHERE post_id = ?";
            
            PreparedStatement statement = connection.prepareStatement(reaction_query);
            statement.setInt(1, id_post);
            statement.executeUpdate();
            statement.close();
            //connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        Home casa = new Home(id);
        casa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_laughActionPerformed

    int Regresa_ID_Post(){
        int id_post = -1;
        try {
            id_post = this.resultSet.getInt("post_id");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_post;
    }
    
    private void btn_commentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_commentsActionPerformed
        // TODO add your handling code here:
        Comments com = new Comments(this.Regresa_ID_Post(), id);
        com.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_commentsActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                int userID = 123;
                new Home(userID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Profile;
    private javax.swing.JButton btn_comments;
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_laugh;
    private javax.swing.JButton btn_like;
    private javax.swing.JButton btn_love;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_laughs_count;
    private javax.swing.JLabel lbl_like_count;
    private javax.swing.JLabel lbl_love_count;
    private javax.swing.JLabel lbl_text;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bar;
    // End of variables declaration//GEN-END:variables
}
