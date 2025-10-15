package com.pluralsight;
//import local date, local time
import java.time.LocalDate;
import java.time.LocalTime;

//variables for transactions
public class Transactions {
    private LocalDate date;         //transaction date
    private LocalTime time;         //transaction time
    private String description;     //transaction description
    private String vendor;          //transaction vendor
    private double amount;          //transaction amount (positive or negative)

//constructor
    public Transactions(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
//getters and setters for the variables


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    //toString method formats for easier reading in ledger or reports
    //replacing the default method over in main

    @Override
    public String toString() {
        String formattedTime = String.format("%02d:%02d:%02d",
                time.getHour(), time.getMinute(), time.getSecond());

    //table formatting
        return String.format(
                "%-10s | %-8s | %-35s | %-20s | %8.2f", date.toString(), formattedTime,
                description,
                vendor,
                amount
        );
    }


}


//todo: exception catching
//todo: add toString for displaying transactions
//todo: table header