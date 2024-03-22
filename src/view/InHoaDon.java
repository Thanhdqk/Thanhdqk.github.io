
package view;

import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
public class InHoaDon {
    public static void print(String message) {
        try {
            //Xác định máy in mặc định
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            //Tạo công việc in
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            //Chuẩn bị dữ liệu in
            byte[] data = message.getBytes();
            // Tạo một đối tượng Doc từ dữ liệu in và kiểu dữ liệu
            Doc doc = new SimpleDoc(data, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
            //gửi công việc in đến máy in
            printJob.print(doc, null);
        } catch (PrintException e) {
            e.printStackTrace();
        }
    }
}
