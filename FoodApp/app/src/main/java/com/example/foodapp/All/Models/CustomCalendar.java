package com.example.foodapp.All.Models;

public class CustomCalendar {

    String date,day,month,year;
    public CustomCalendar(String date, String day,String month,String year)
    {
        this.date = date;
        this.month=month;
        this.year=year;
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
