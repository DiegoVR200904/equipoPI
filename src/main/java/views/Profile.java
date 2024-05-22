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
import javax.swing.ImageIcon;
import models.DB_Connection;
import models.Manejador;

/**
 *
 * @author erika
 */
public class Profile extends javax.swing.JFrame {

    private int id;
    private Connection connection;
    private ResultSet resultSet;
    private byte[] imagenBytes;
    
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
    }
    /**
     * Creates new form Profile
     */
    
  private void profile_info(){
        try {
        String query = "SELECT u.first_name, u.profile_image_id, u.cover_image_id, u.last_name, COUNT(c.contact_id) AS friends\n" +
        "FROM Users u\n" +
        "LEFT JOIN Contacts c ON u.user_id = c.user_id\n" +
        "WHERE u.user_id = ? \n" +
        "GROUP BY u.user_id, u.first_name, u.last_name;\n " + 
        "SELECT i1.image_data AS profile_image_data, i2.image_data AS cover_image_data\n" +
        "FROM Users u\n" +
        "LEFT JOIN Images i1 ON u.profile_image_id = i1.image_id\n" +
        "LEFT JOIN Images i2 ON u.cover_image_id = i2.image_id\n" +
        "WHERE u.user_id = ?;";
        
        PreparedStatement statement = this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setInt(1, id); // Asignar el ID de usuario al primer parámetro
        statement.setInt(2, id);
        
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
        byte[] imagen_cover = this.resultSet.getBytes("profile_image_data");
        byte[] imagen_profile = this.resultSet.getBytes("cover_image_data");
        
            ImageIcon imageIcon = bytesToImageIcon(imagen_cover);
                        if (imageIcon != null) {
                            Image scaledImage = imageIcon.getImage().getScaledInstance(lbl_Cover.getWidth(), lbl_Cover.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon scaledIcon = new ImageIcon(scaledImage);
                            this.lbl_Cover.setIcon(scaledIcon);
                        } else {
                            System.out.println("no cargo imagen xd");
                        }
                        
            ImageIcon imageIcon_2 = bytesToImageIcon(imagen_profile);
                        if (imageIcon_2 != null) {
                            Image scaledImage = imageIcon_2.getImage().getScaledInstance(lbl_perfil_imagen.getWidth(), lbl_perfil_imagen.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon scaledIcon = new ImageIcon(scaledImage);
                            this.lbl_perfil_imagen.setIcon(scaledIcon);
                        } else {
                            System.out.println("no cargo imagen xd");
                        }            
        
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
        btn_friends = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_createPost = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_Cover = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_CoverEdit = new javax.swing.JButton();
        btn_EditProfile = new javax.swing.JButton();
        btn_Friends = new javax.swing.JButton();
        tf_countfriends = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_ProfilePicEdit = new javax.swing.JButton();
        lbl_perfil_imagen = new javax.swing.JLabel();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/ghostpatron/NetBeansProjects/equipoPI/src/main/java/img/logo4-64.png")); // NOI18N

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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lbl_Cover.setBackground(new java.awt.Color(255, 204, 255));
        lbl_Cover.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_Cover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));

        jSeparator2.setBackground(new java.awt.Color(255, 102, 153));
        jSeparator2.setForeground(new java.awt.Color(255, 102, 153));

        btn_CoverEdit.setBackground(new java.awt.Color(255, 102, 153));
        btn_CoverEdit.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_CoverEdit.setText("Cambiar foto de portada");
        btn_CoverEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CoverEditActionPerformed(evt);
            }
        });

        btn_EditProfile.setBackground(new java.awt.Color(255, 102, 153));
        btn_EditProfile.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_EditProfile.setText("Editar perfil");
        btn_EditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditProfileActionPerformed(evt);
            }
        });

        btn_Friends.setBackground(new java.awt.Color(255, 102, 153));
        btn_Friends.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Friends.setText("Amigos");
        btn_Friends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FriendsActionPerformed(evt);
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

        jLabel1.setForeground(new java.awt.Color(255, 102, 153));
        jLabel1.setText("amigos");

        btn_ProfilePicEdit.setBackground(new java.awt.Color(255, 102, 153));
        btn_ProfilePicEdit.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_ProfilePicEdit.setText("Cambiar foto de perfil");
        btn_ProfilePicEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProfilePicEditActionPerformed(evt);
            }
        });

        lbl_perfil_imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(tf_countfriends, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_perfil_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_EditProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_CoverEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_ProfilePicEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_Friends))
                                    .addGap(2, 2, 2))))
                        .addComponent(lbl_Cover, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_Cover, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_countfriends, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btn_EditProfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(btn_CoverEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ProfilePicEdit)))
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Friends)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_perfil_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout pnl_barLayout = new javax.swing.GroupLayout(pnl_bar);
        pnl_bar.setLayout(pnl_barLayout);
        pnl_barLayout.setHorizontalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_friends)
                .addGap(18, 18, 18)
                .addComponent(btn_createPost)
                .addGap(18, 18, 18)
                .addComponent(btn_home)
                .addGap(87, 87, 87))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_createPost)
                        .addComponent(btn_home)
                        .addComponent(btn_friends)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_FriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FriendsActionPerformed
        Friends amigo = new Friends(id);
        amigo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_FriendsActionPerformed

    private void insertarProfileImage(int img_id, int user_id){
        String imagen_perfil_query = "UPDATE Users"
                    + "SET profile_image_id = ?"
                    + "WHERE user_id = ?";
        
        try {    
            PreparedStatement statement = connection.prepareStatement(imagen_perfil_query);
            statement.setInt(1, img_id);
            statement.setInt(2, user_id);
            
            statement.executeUpdate();
            statement.close();
            connection.close();
            System.out.println("Se actualizo la imagen de perfil correctamente en la base de datos.");
            
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertarCoverImage(int img_id, int user_id){
        String imagen_perfil_query = "UPDATE Users"
                    + "SET cover_image_id = ?"
                    + "WHERE user_id = ?";
        
        try {    
            PreparedStatement statement = connection.prepareStatement(imagen_perfil_query);
            statement.setInt(1, img_id);
            statement.setInt(2, user_id);
            
            statement.executeUpdate();
            statement.close();
            connection.close();
            System.out.println("Se actualizo la imagen de perfil correctamente en la base de datos.");
            
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    private void btn_CoverEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CoverEditActionPerformed
        imagenBytes = Manejador.leerImagen();
        
        byte[] multimedia = imagenBytes;
        int imageID = 0;
        String image_query = "INSERT INTO Images(image_data) VALUES(?)";
        
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(image_query, Statement.RETURN_GENERATED_KEYS);

                statement.setBytes(1, multimedia);
                statement.executeUpdate();

                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    imageID = generatedKeys.getInt(1);
                }
                connection.commit();
                } catch (SQLException ex) {
                if (connection != null) {
                    try {
                        connection.rollback(); // Rollback the transaction on error
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Close resources
                if (generatedKeys != null) {
                    try {
                        generatedKeys.close();
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
            this.insertarCoverImage(imageID, id);
            this.mostrarDatos();
    }//GEN-LAST:event_btn_CoverEditActionPerformed

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

    private void btn_ProfilePicEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProfilePicEditActionPerformed
        // TODO add your handling code here:
        imagenBytes = Manejador.leerImagen();
        
        byte[] multimedia = imagenBytes;
        int imageID = 0;
        String image_query = "INSERT INTO Images(image_data) VALUES(?)";
        
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(image_query, Statement.RETURN_GENERATED_KEYS);

                statement.setBytes(1, multimedia);
                statement.executeUpdate();

                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    imageID = generatedKeys.getInt(1);
                }
                connection.commit();
                } catch (SQLException ex) {
                if (connection != null) {
                    try {
                        connection.rollback(); // Rollback the transaction on error
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Close resources
                if (generatedKeys != null) {
                    try {
                        generatedKeys.close();
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        Logger.getLogger(NewUser_View.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
            this.insertarProfileImage(imageID, id);
            this.mostrarDatos();
    }//GEN-LAST:event_btn_ProfilePicEditActionPerformed

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
    private javax.swing.JButton btn_ProfilePicEdit;
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Cover;
    private javax.swing.JLabel lbl_perfil_imagen;
    private javax.swing.JPanel pnl_bar;
    private javax.swing.JTextField tf_countfriends;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables
}
