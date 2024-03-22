
package Util;
import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogHelper {
    //hiển thị thông báo
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Quản Lý Hóa Đơn", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    //hiển thị thông báo và yêu cầu xác nhận Yes/No
    public static boolean confirm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message, "Quản Lý Hóa Đơn", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    //hiển thị thông báo yêu cầu nhập dữ liệu
    public static String prompt(Component parent, String message){
        return JOptionPane.showInputDialog(parent, message, "Quản Lý Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);
    }
}
