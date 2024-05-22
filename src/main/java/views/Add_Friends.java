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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
        setTitle("Agregar Amigo");     
        this.id = id; 
        initComponents();
        
        try {
            connection = DB_Connection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrarPrimerRegistro();
        
    }
    
private void mostrarPrimerRegistro() {       
    try {
        String query = "SELECT u.first_name, u.last_name, u.user_id, i.image_data\n" +
        "FROM Users u\n" + "JOIN Images i ON u.profile_image_id = i.image_id\n" +
        "WHERE u.user_id NOT IN (\n" + "    SELECT c.contact_user_id\n" + "    FROM Contacts c\n" +
        "    WHERE c.user_id = ?\n" + ")\n" + "AND u.user_id != ?;";
        
        PreparedStatement statement = this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, id);
        statement.setInt(2, id);

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

    private void mostrarDatos() {  
        try {
            String nombre = this.resultSet.getString("first_name");
            String apellido = this.resultSet.getString("last_name");
            byte[] imagen = this.resultSet.getBytes("image_data");
            this.lbl_name1.setText(nombre);
            this.lbl_last.setText(apellido);
            
            if(imagen != null){
                ImageIcon imageIcon = bytesToImageIcon(imagen);
                        if (imageIcon != null) {
                            Image scaledImage = imageIcon.getImage().getScaledInstance(lbl_picture.getWidth(), lbl_picture.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon scaledIcon = new ImageIcon(scaledImage);
                            this.lbl_picture.setIcon(scaledIcon);
                        } else {
                            System.out.println("no cargo imagen xd");
                        }
            }else{
                this.lbl_picture.setIcon(null);
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
        btn_previous = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        lbl_picture = new javax.swing.JLabel();
        lbl_last = new javax.swing.JLabel();
        lbl_name1 = new javax.swing.JLabel();
        btn_addfriend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/logo4-64.png")); // NOI18N

        btn_friends.setBackground(new java.awt.Color(27, 27, 27));
        btn_friends.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/friends.png")); // NOI18N
        btn_friends.setBorder(null);
        btn_friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_friendsActionPerformed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(27, 27, 27));
        btn_home.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/home.png")); // NOI18N
        btn_home.setBorder(null);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_createPost.setBackground(new java.awt.Color(27, 27, 27));
        btn_createPost.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/agregar-publicacion.png")); // NOI18N
        btn_createPost.setBorder(null);
        btn_createPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createPostActionPerformed(evt);
            }
        });

        btn_Profile.setBackground(new java.awt.Color(27, 27, 27));
        btn_Profile.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/Perfil rosa.png")); // NOI18N
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
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(161, 161, 161)
                .addComponent(btn_friends)
                .addGap(18, 18, 18)
                .addComponent(btn_home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_createPost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Profile)
                .addGap(38, 38, 38))
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Profile)
                            .addComponent(btn_home)
                            .addComponent(btn_createPost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_barLayout.createSequentialGroup()
                        .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_friends)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        lbl_title.setFont(new java.awt.Font("Manjari", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Agrega Amigos");

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

        lbl_picture.setForeground(new java.awt.Color(255, 51, 102));
        lbl_picture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 153)));

        lbl_last.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_last.setForeground(new java.awt.Color(255, 255, 255));
        lbl_last.setText("Apellido");

        lbl_name1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_name1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name1.setText("Nombre");

        btn_addfriend.setBackground(new java.awt.Color(255, 102, 153));
        btn_addfriend.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btn_addfriend.setText("Agregar como amigo");
        btn_addfriend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        btn_addfriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addfriendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btn_previous)
                        .addGap(151, 151, 151)
                        .addComponent(btn_addfriend)
                        .addGap(104, 104, 104)
                        .addComponent(btn_next))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_last, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbl_picture, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_title)
                                .addGap(42, 42, 42)))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_picture, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_last)
                    .addComponent(lbl_name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_next)
                    .addComponent(btn_previous)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_addfriend)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        this.mostrarRegistroAnterior();
    }//GEN-LAST:event_btn_previousActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        this.mostrarRegistroSiguiente();
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_addfriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addfriendActionPerformed
        // TODO add your handling code here:
        String add_friend_query = "INSERT INTO Contacts (user_id, contact_user_id)\n" +
                                "VALUES (?, ?);";
        
        try {
            PreparedStatement statement = connection.prepareStatement(add_friend_query);
            // Supongamos que estos datos vienen de algún lugar en tu aplicación
            int usuarioID = id;
            int contact_id = this.resultSet.getInt("user_id");
            
            statement.setInt(1, usuarioID);
            statement.setInt(2, contact_id);
            
            statement.executeUpdate();
            statement.close();
            //connection.close();

            System.out.println("Comentario insertado correctamente en la base de datos.");
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir al ejecutar la consulta SQL
            e.printStackTrace();
        }
        this.btn_addfriend.setEnabled(false);
    }//GEN-LAST:event_btn_addfriendActionPerformed

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
    private javax.swing.JButton btn_addfriend;
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_last;
    private javax.swing.JLabel lbl_name1;
    private javax.swing.JLabel lbl_picture;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bar;
    // End of variables declaration//GEN-END:variables
}
