package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
}


