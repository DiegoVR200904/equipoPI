package views;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import models.Manejador;
import models.DB_Connection;
/**
 *
 * @author salva
 */
public class CreatePost_View extends javax.swing.JFrame {

    /**
     * Creates new form CreatePost_View
     */
    private Connection connection;
    private byte[] imagenBytes;
    private int id;
    
    public CreatePost_View(int id) {
        initComponents();
        setResizable(false);
        setTitle("Crear Post"); 
        this.id = id; 
        try {
            connection = DB_Connection.getConnection();
            
            String sql = "SELECT image_data FROM Images WHERE image_id = (SELECT profile_image_id FROM Users WHERE user_id = ?)";
        
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                    // Obtener la imagen de perfil como un array de bytes
                    byte[] imageData = resultSet.getBytes("image_data");
                     CLabel.setIcon(Manejador.bytesToImageIcon(imageData));
                }
            
            
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
        CLabel = new circle.label.Label_User_icon();
        btnImage = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        txtComent = new javax.swing.JTextArea();
        Tittle = new javax.swing.JLabel();
        btnCreate_Publication = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        CLabel.setBackground(new java.awt.Color(255, 255, 255));
        CLabel.setText("");

        btnImage.setBackground(new java.awt.Color(255, 51, 102));
        btnImage.setForeground(new java.awt.Color(255, 255, 255));
        btnImage.setText("Imagen/Foto");
        btnImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        txtComent.setColumns(20);
        txtComent.setForeground(new java.awt.Color(153, 153, 153));
        txtComent.setRows(5);
        txtComent.setText("Añade un Comentario...\n");
        scroll.setViewportView(txtComent);

        Tittle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Tittle.setForeground(new java.awt.Color(255, 255, 255));
        Tittle.setText("Crear Publicacion");

        btnCreate_Publication.setBackground(new java.awt.Color(255, 51, 102));
        btnCreate_Publication.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate_Publication.setText("Publicar");
        btnCreate_Publication.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnCreate_Publication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate_PublicationActionPerformed(evt);
            }
        });

        btn_home.setText("Inicio");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addComponent(btnCreate_Publication, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(btn_home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(CLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tittle)
                            .addGap(171, 171, 171))
                        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnCreate_Publication)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(btn_home)
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tittle, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                    .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        imagenBytes = Manejador.leerImagen();
    }//GEN-LAST:event_btnImageActionPerformed

    private void btnCreate_PublicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate_PublicationActionPerformed
        String query = "INSERT INTO Posts(user_id,post_text,post_type) VALUES (?, ?, ?)"
                + "DECLARE @id_principal INT;\n" 
                + "SET @id_principal = SCOPE_IDENTITY();\n"
                + "INSERT INTO Images(post_id, image_data)\n" 
                + "VALUES (@id_principal,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            // Supongamos que estos datos vienen de algún lugar en tu aplicación
            int usuarioId = id;
            String contenido = txtComent.getText();
            String type = "image";
            byte[] multimedia = imagenBytes;

            if(multimedia == null){
                type = "text";
            }
            
            statement.setInt(1, usuarioId);
            statement.setString(2, contenido);
            statement.setString(3, type);
            statement.setBytes(4, multimedia);
            
            statement.executeUpdate();
            statement.close();
            connection.close();

            System.out.println("Publicación insertada correctamente en la base de datos.");
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir al ejecutar la consulta SQL
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCreate_PublicationActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
        Home inicio = new Home(id);
        inicio.setVisible(true);
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
            java.util.logging.Logger.getLogger(CreatePost_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePost_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePost_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePost_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int userID = 123;
                new CreatePost_View(userID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private circle.label.Label_User_icon CLabel;
    private javax.swing.JLabel Tittle;
    private javax.swing.JButton btnCreate_Publication;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btn_home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea txtComent;
    // End of variables declaration//GEN-END:variables
}
