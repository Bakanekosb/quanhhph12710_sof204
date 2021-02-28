/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.helper;

import com.edusys.model.NhanVien;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dell
 */
public class ShareHelper {

  
    public static final Image APP_ICON;

    static {
        // Tải biểu tượng ứng dụng
        String file = "/com/edusys/icon/fpt.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }
//    Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static NhanVien USER = null;

    public static boolean OPENING = false;

    public static boolean saveLogo(File file) {
        File dir = new File("logos");
        // Tạo thư mục nếu chưa tồn tại
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {            
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

   
    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static ImageIcon resizeImage(JLabel lbl_img, String fileName) throws IOException {
        BufferedImage image = ImageIO.read(new File("logos", fileName));
        if (image != null) {
            Image dimg = image.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH); 
            return new ImageIcon(dimg);
        }
        return null;
    }
   
    public static void logoff() {
        ShareHelper.USER = null;
    }
    
    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
}
