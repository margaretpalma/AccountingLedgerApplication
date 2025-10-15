package com.pluralsight;
//import local date, local time
import java.time.LocalDate;
import java.time.LocalTime;

//variables for transactions
public class Transactions {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//formatting
    @Override
    public String toString() {
        String formattedTime = String.format("%02d:%02d:%02d",
                time.getHour(), time.getMinute(), time.getSecond());

        return String.format(
                "%-10s | %-8s | %-35s | %-20s | %8.2f",
                date.toString(),
                formattedTime,
                description,
                vendor,
                amount
        );
    }


}


//todo: exception catching
//todo: add toString for displaying transactions
//todo: table header