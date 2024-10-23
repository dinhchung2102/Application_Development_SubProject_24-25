package entity;

public class KhuyenMai {
    private int maKM;
    private String tenKM;
    private double donHangToiThieu;
    private double giamGia;
    private String moTa;

    // Constructors
    public KhuyenMai() {}

    public KhuyenMai(int maKM, String tenKM, double donHangToiThieu, double giamGia, String moTa) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.donHangToiThieu = donHangToiThieu;
        this.giamGia = giamGia;
        this.moTa = moTa;
    }

    // Getters and Setters
    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public double getDonHangToiThieu() {
        return donHangToiThieu;
    }

    public void setDonHangToiThieu(double donHangToiThieu) {
        this.donHangToiThieu = donHangToiThieu;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
