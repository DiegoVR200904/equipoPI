/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/
package views;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String query = "SELECT DISTINCT p.post_text, p.post_type, i.image_data, v.video_data " +
                   "FROM Posts p " +
                   "LEFT JOIN Images i ON p.post_id = i.post_id " +
                   "LEFT JOIN Videos v ON p.post_id = v.post_id " +
                   "LEFT JOIN Contacts c ON p.user_id = c.contact_user_id " +
                   "WHERE p.user_id = ? OR c.user_id = ?";
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

    private void mostrarDatos() {
        try {
            String texto = this.resultSet.getString("post_text");
            //String video = resultSet.getInt("edad");
            this.ta_text.setText(texto);
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
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_friends = new javax.swing.JButton();
        btn_videos = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_createPost = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        lbl_image1 = new javax.swing.JLabel();
        if_video = new javax.swing.JInternalFrame();
        btn_previous = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_text = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        pnl_bar.setBackground(new java.awt.Color(27, 27, 27));
        pnl_bar.setForeground(new java.awt.Color(27, 27, 27));

        tf_search.setBackground(new java.awt.Color(102, 102, 102));
        tf_search.setFont(new java.awt.Font("Garuda", 0, 14)); // NOI18N
        tf_search.setForeground(new java.awt.Color(249, 128, 170));
        tf_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 128, 170)));

        btn_search.setBackground(new java.awt.Color(27, 27, 27));
        btn_search.setBorder(null);

        btn_friends.setBackground(new java.awt.Color(27, 27, 27));
        btn_friends.setBorder(null);

        btn_videos.setBackground(new java.awt.Color(27, 27, 27));
        btn_videos.setBorder(null);

        btn_home.setBackground(new java.awt.Color(27, 27, 27));
        btn_home.setBorder(null);

        btn_createPost.setBackground(new java.awt.Color(27, 27, 27));
        btn_createPost.setIcon(new javax.swing.ImageIcon("C:\\Users\\salva\\OneDrive\\Documentos\\NetBeansProjects\\spookbook\\src\\main\\java\\img\\agregar-publicacion.png")); // NOI18N
        btn_createPost.setBorder(null);
        btn_createPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_barLayout = new javax.swing.GroupLayout(pnl_bar);
        pnl_bar.setLayout(pnl_barLayout);
        pnl_barLayout.setHorizontalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_home)
                .addGap(18, 18, 18)
                .addComponent(btn_friends)
                .addGap(18, 18, 18)
                .addComponent(btn_videos)
                .addGap(86, 86, 86))
            .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barLayout.createSequentialGroup()
                    .addContainerGap(975, Short.MAX_VALUE)
                    .addComponent(btn_createPost)
                    .addGap(112, 112, 112)))
        );
        pnl_barLayout.setVerticalGroup(
            pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(pnl_barLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_search)
                    .addComponent(btn_home)
                    .addComponent(btn_videos)
                    .addComponent(btn_friends))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_barLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(btn_createPost)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        lbl_title.setFont(new java.awt.Font("Manjari", 1, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Publicaciones");

        lbl_image1.setForeground(new java.awt.Color(255, 102, 153));
        lbl_image1.setText("imagen");

        if_video.setVisible(true);

        javax.swing.GroupLayout if_videoLayout = new javax.swing.GroupLayout(if_video.getContentPane());
        if_video.getContentPane().setLayout(if_videoLayout);
        if_videoLayout.setHorizontalGroup(
            if_videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        if_videoLayout.setVerticalGroup(
            if_videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        btn_previous.setBackground(new java.awt.Color(51, 51, 51));
        btn_previous.setBorder(null);
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(51, 51, 51));
        btn_next.setBorder(null);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        ta_text.setColumns(20);
        ta_text.setRows(5);
        jScrollPane1.setViewportView(ta_text);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(463, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(462, 462, 462))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_previous)
                        .addGap(128, 128, 128)
                        .addComponent(btn_next))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(if_video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(if_video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_previous))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_next)))
                        .addGap(87, 87, 87))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JButton btn_createPost;
    private javax.swing.JButton btn_friends;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_videos;
    private javax.swing.JInternalFrame if_video;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_bar;
    private javax.swing.JTextArea ta_text;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables
}
