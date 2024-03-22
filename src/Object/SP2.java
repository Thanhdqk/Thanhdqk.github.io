/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author phong
 */
public class SP2 {

    private String name;
    private String gia;
    private String ImgUrl;
    private int soluong;
    private  String maSp;

    public SP2(String name, String gia, String ImgUrl, int soluong, String maSp) {
        this.name = name;
        this.gia = gia;
        this.ImgUrl = ImgUrl;
        this.soluong = soluong;
        this.maSp = maSp;
    }

    public String getName() {
        return name;
    }

    public String getGia() {
        return gia;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

 

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void String(String gia) {
        this.gia = gia;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }

    public SP2() {
    }

    public Object[] totableRow(int rowNum) {
        return new Object[]{this,rowNum,name, gia, ImgUrl, soluong};
    }
}
