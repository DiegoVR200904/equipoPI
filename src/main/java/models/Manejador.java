package models;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Manejador {

    public static byte[] leerImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(selectedFile);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                String extension = getFileExtension(selectedFile);
                ImageIO.write(image, extension, outputStream);
                return outputStream.toByteArray();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    private static String getFileExtension(File file) {
        String extension = "";
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
            extension = fileName.substring(dotIndex + 1);
        }
        return extension;
    }
    
    
    public static ImageIcon bytesToImageIcon(byte[] multimedia) {
        try {
            // Convert bytes to BufferedImage
            ByteArrayInputStream bis = new ByteArrayInputStream(multimedia);
            BufferedImage bImage = ImageIO.read(bis);
             // Redimensionar la imagen a 50x50
            Image resizedImage = bImage.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            // Convertir la imagen redimensionada a ImageIcon
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }}
/*
    public static Icon ImagePortada(byte[] imageData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Icon ImageProfile(byte[] imageData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
*/

