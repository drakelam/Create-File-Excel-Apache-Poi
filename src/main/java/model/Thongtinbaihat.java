package model;

import java.util.Date;

public class Thongtinbaihat {
    private String name;
    private String song;
    private Date NgaySinh;
    private double daysOfWork;
    private double salaryPerDay;

    public Thongtinbaihat(String name, String song, Date time, double daysOfWork, double salaryPerDay) {
        this.name = name;
        this.song = song;
        this.NgaySinh = NgaySinh;
        this.daysOfWork = daysOfWork;
        this.salaryPerDay = salaryPerDay;
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

    public double getDaysOfWork() {
        return daysOfWork;
    }

    public void setDaysOfWork(double daysOfWork) {
        this.daysOfWork = daysOfWork;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

}
