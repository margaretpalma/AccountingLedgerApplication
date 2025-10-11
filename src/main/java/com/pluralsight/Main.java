package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Transactions> transactions = new ArrayList<>();
    public static void main(String[] args) {
        //todo: arraylist
        //todo: menu loop
        launchMenu();
    }

    public static void launchMenu() {
        while (true){
            System.out.println("\nD) Add Deposit\nP) Make a Payment\nL) Ledger\nX) Exit program");
            String choice = ConsoleHelper.promptForString("Choose from menu").toUpperCase();

            switch (choice) {
                case "D":
                    System.out.println("-- Add Deposit--");
                    LocalDate date = ConsoleHelper.promptForDate("Enter Date |yyyy-mm-dd|");
                    LocalTime time = ConsoleHelper.promptForTime("Enter Time |hh:mm:ss");
                    String description = ConsoleHelper.promptForString("Enter Description");
                    String vendor = ConsoleHelper.promptForVendor("Enter Vendor");
                    Double amount = ConsoleHelper.promptForAmount("Enter Amount");
                    transactions.add(new Transactions(date, time, description,vendor, amount));
                    System.out.println(date + "|" + time + "|" + description +"|"+ vendor +"|$"+ amount);
                    System.out.println("--Deposit Added--");

                    break;
                case "P":
                    System.out.println("-- Make A Payment--");
                    LocalDate paymentDate = ConsoleHelper.promptForDate("Enter Date |yyyy-mm-dd|");
                    LocalTime paymentTime = ConsoleHelper.promptForTime("Enter Time |hh:mm:ss");
                    String paymentDescription = ConsoleHelper.promptForString("Enter Description");
                    String paymentVendor = ConsoleHelper.promptForVendor("Enter Vendor");
                    Double paymentAmount = ConsoleHelper.promptForAmount("Enter Amount");

                    //payment = negative
                    paymentAmount = -Math.abs(paymentAmount);
                    transactions.add(new Transactions(paymentDate,paymentTime,paymentDescription, paymentVendor,paymentAmount));
                    System.out.println(paymentDate + "|" + paymentTime + "|" + paymentDescription + "|" + paymentVendor + "|$" + paymentAmount );
                    System.out.println("--Payment Complete--");


                    break;
                case "L":
                    //todo: ledger menu
                    while (true){
                        //todo: test home screen first
                        System.out.println("\n---Ledger Menu---");
                        System.out.println("A) All Entries");
                        System.out.println("D) Only Deposits");
                        System.out.println("P) Only Payments");
                        String choice = ConsoleHelper.promptForString("---Choose An Option---").toUpperCase();

                        switch(choice) {
                            case "A":
                                for(Transactions t : transactions) {
                                    System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                            + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));
                                }
                                break;

                                }
                        }

                    }
                    break;
                case "X":
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid command");
            }

        }









//D) Add Deposit P)Make Payment(Debit) L)Ledger X)exit
//todo: call console ledger
//todo: bufferedReader, fileReader
//todo: switch statement
//todo: return transactions
//todo: display of menus, menu within menu