/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author phong
 */
public class SP1 {

    private String maSP;
    private String name;
    private float gia;
    private String ImgUrl;

    public SP1(String maSP, String name, float gia, String ImgUrl) {
        this.maSP = maSP;
        this.name = name;
        this.gia = gia;
        this.ImgUrl = ImgUrl;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }

    public SP1() {
    }

    public String getMaSP() {
        return maSP;
    }

    public String getName() {
        return name;
    }

    public float getGia() {
        return gia;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

}
