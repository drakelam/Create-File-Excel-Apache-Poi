package model;

import java.util.Date;

public class Employee {
    private String name;
    private String song;
    private Date dateOfBirth;
    private double daysOfWork;
    private double salaryPerDay;

    public Employee(String name, String song, Date dateOfBirth, double daysOfWork, double salaryPerDay) {
        this.name = name;
        this.song = song;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
