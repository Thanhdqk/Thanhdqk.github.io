package Util;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class XImage {
    
    /**
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     */
    public static Image getAppIcon(){
        String curr = System.getProperty("user.dir");
        String icon = curr + File.separator + "icon";
        String file = icon;
        return new ImageIcon(XImage.class.getResource(file)).getImage();
    }
    
    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */   
public static boolean saveLogo(File file){
    //File dir = new File("src\\main\\Resources\\Icon");
    String curr = System.getProperty("user.dir");
    String icon = curr + File.separator + "icon";
    File dir = new File("/icon/");
    // Tạo thư mục nếu chưa tồn tại
    if(!dir.exists()){
        dir.mkdirs();
    }
    File newFile = new File(dir, file.getName());
    try {
    // Copy vào thư mục logos (đè nếu đã tồn tại)
    Path source = Paths.get(file.getAbsolutePath());
    Path destination = Paths.get(newFile.getAbsolutePath());
    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    return true;
    }
    catch (Exception ex) {
    return false;
    }
 }
    /**
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @return ảnh đọc được
     */   
    public static ImageIcon read(String fileName){
        String curr = System.getProperty("user.dir");
        String icon = curr + File.separator + "icon";
        File path = new File(icon, fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}