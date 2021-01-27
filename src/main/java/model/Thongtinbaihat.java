package model;

import java.util.Date;

public class Thongtinbaihat {
    private String name;
    private String song;
    private Date NgaySinh;
    private double BXH;
    private double DanhGia;

    public Thongtinbaihat(String name, String song, Date NgaySinh, double BXH, double DanhGia) {
        this.name = name;
        this.song = song;
        this.NgaySinh = NgaySinh;
        this.BXH = BXH;
        this.DanhGia = DanhGia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public double getBXH() {
        return BXH;
    }

    public void setDaysOfWork(double BXH) {
        this.BXH = BXH;
    }

    public double getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(double DanhGia) {
        this.DanhGia = DanhGia;
    }

}
