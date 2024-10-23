package entity;

public class MonAn {
    private int maMon;
    private String tenMon;
    private float giaTien;
    private String moTa;

    public MonAn(int maMon, String tenMon, float giaTien,String moTa) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giaTien = giaTien;
        
        this.moTa = moTa;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

 
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
