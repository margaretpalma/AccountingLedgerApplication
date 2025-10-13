package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    public static ArrayList<Transactions> transactions = new ArrayList<>();

    public static void main(String[] args) {
        transactions = getTransactionsFromFile(); //transactions from file
        launchMenu(); // launch main menu
    }

    //main menu
    public static void launchMenu() {
        while (true) {
            System.out.println("\nD) Add Deposit\nP) Make a Payment\nL) Ledger\nX) Exit program");
            String choice = ConsoleHelper.promptForString("Choose from menu").toUpperCase();

            switch (choice) {
                case "D":
                    System.out.println("-- Add Deposit --");
                    LocalDate date = ConsoleHelper.promptForDate("Enter Date |yyyy-mm-dd|");
                    LocalTime time = ConsoleHelper.promptForTime("Enter Time |hh:mm:ss");
                    String description = ConsoleHelper.promptForString("Enter Description");
                    String vendor = ConsoleHelper.promptForVendor("Enter Vendor");
                    Double amount = ConsoleHelper.promptForAmount("Enter Amount");

                    Transactions deposit = new Transactions(date, time, description, vendor, amount);
                    transactions.add(deposit);
                    saveTransactionsToFile(deposit);

                    System.out.println(date + "|" + time + "|" + description + "|" + vendor + "|$" + amount);
                    System.out.println("-- Deposit Added --");
                    break;

                case "P":
                    System.out.println("-- Make A Payment --");
                    LocalDate paymentDate = ConsoleHelper.promptForDate("Enter Date |yyyy-mm-dd|");
                    LocalTime paymentTime = ConsoleHelper.promptForTime("Enter Time |hh:mm:ss");
                    String paymentDescription = ConsoleHelper.promptForString("Enter Description");
                    String paymentVendor = ConsoleHelper.promptForVendor("Enter Vendor");
                    Double paymentAmount = ConsoleHelper.promptForAmount("Enter Amount");

                    //payment = negative
                    paymentAmount = -Math.abs(paymentAmount);

                    Transactions payment = new Transactions(paymentDate, paymentTime, paymentDescription, paymentVendor, paymentAmount);
                    transactions.add(payment);
                    saveTransactionsToFile(payment);

                    System.out.println(paymentDate + "|" + paymentTime + "|" + paymentDescription + "|" + paymentVendor + "|$" + paymentAmount);
                    System.out.println("-- Payment Complete --");
                    break;

                    //launches ledger menu
                case "L":
                    launchLedger();
                    break;

                case "X":
                    System.out.println("Exiting Program");
                    return;

                default:
                    System.out.println("Invalid command");
            }
        }
    }

    // ledger menu
    public static void launchLedger() {
        while (true) {
            System.out.println("\n--- Ledger Menu ---");
            System.out.println("A) All Entries");
            System.out.println("D) Only Deposits");
            System.out.println("P) Only Payments");
            System.out.println("R) Reports Menu");
            System.out.println("H) Home Menu");

            String choice = ConsoleHelper.promptForString("---Choose An Option---").toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("--- All Entries ---");
                    //todo: newest entries first
                    for (Transactions t : transactions) {
                        System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));
                    }
                    break;

                case "D":
                    //todo : newest entires first
                    System.out.println("--- Deposits ---");
                    for (Transactions t : transactions) {
                        if (t.getAmount() > 0) {
                            System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                    + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));

                        }
                    }
                    break;

                case "P":
                    ///todo: newest entries first
                    System.out.println("--- Payments ---");
                    for (Transactions t : transactions) {
                        if (t.getAmount() < 0) {
                            System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                    + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));
                        }
                    }
                    break;

                case "R":
                    launchReportsMenu();
                //todo: REPORTS MENU
                        //todo:1) month to date
                        //todo:2) previous month
                        //todo:3) year to date
                        //todo:4) previous year
                        //todo:5) search by vendor - vendor name, display entries
                        //todo:6) back - back to ledger page
                case "H":
                    System.out.println("--- Returning To Main Menu ---");
                    return;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    // load transactions
    //arraylist
    //file reader/buffered reader

    //reports menu launch
    public static void launchReportsMenu(){
        while(true) {
            System.out.println("\n---Reports Menu---");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
            System.out.println("0) Return to Ledger Menu");

            String choice = ConsoleHelper.promptForString("---- Choose From Menu -----");




            //todo: print newest entries first


            switch(choice) {
                case "1": {
                    System.out.println("------Month To Date------");
                    //todo complete case 1
                    LocalDate today = LocalDate.now();
                    for (Transactions t : transactions) {
                        if (t.getDate().getMonth() == today.getMonth() && t.getDate().getYear() == today.getYear()) {
                            System.out.println(t.getDate() + "|" + t.getDescription() + "|" + "|$" + t.getAmount());
                        }
                    }
                }
                break;
                case "2": {
                    System.out.println("------Previous Month------");
                    LocalDate today = LocalDate.now();
                    LocalDate previousMonth = today.minusMonths(1);

                    for (Transactions t : transactions) {
                        LocalDate date = t.getDate();
                        if (date.getYear() == previousMonth.getYear() && date.getMonth() == previousMonth.getMonth()) {
                        }
                    }
                    //todo
                    break;
                }

                case "3": {
                    System.out.println("------Year To Date------");
                    LocalDate today = LocalDate.now();
                    for (Transactions t : transactions) {
                        if (t.getDate().getYear() == today.getYear()) {
                            System.out.println(t.getDate() + "|" + t.getDescription() + "|" + "$|" + t.getAmount());
                        }
                    }

                    //todo
                    break;
                }
                case "4": {
                    System.out.println("------Previous Year-------");
                    int previousYear = LocalDate.now().getYear() - 1;   //year - 1
                    LocalDate today = LocalDate.now();
                    for(Transactions t : transactions) {
                        if (t.getDate().getYear() == previousYear) {
                            System.out.println(t.getDate() + "|" + t.getDescription() + "|" + "$|" + t.getAmount());
                        }
                    }

                }
                    break;

                case "5":
                    String vendorName = ConsoleHelper.promptForString("Vendor Name: ");
                    System.out.println("Results for: " + vendorName);
                    for (Transactions t : transactions) {
                        if(t.getVendor().equalsIgnoreCase(vendorName)) {
                            System.out.println(t.getDate() + "|" + t.getDescription() + "|$" + t.getAmount());
                        }
                    }
                    //todo
                    break;

                case "0":
                    System.out.println("---Returning To Ledger Menu---");
                    return;
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        }
    }


    public static ArrayList<Transactions> getTransactionsFromFile() {
        ArrayList<Transactions> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("transactions.csv"))) {
            String lineFromString;
            while ((lineFromString = br.readLine()) != null) {
                try {
                    // Skip blank lines
                    if(lineFromString.trim().isEmpty()) continue;

                    String[] parts = lineFromString.split("\\|");

                    LocalDate date = LocalDate.parse(parts[0].trim());
                    LocalTime time = LocalTime.parse(parts[1].trim());
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    double amount = Double.parseDouble(parts[4].trim());

                    Transactions t = new Transactions(date, time, description, vendor, amount);
                    transactions.add(t);

                    // debugging option
                    //shows files before menu
                    //System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                    //        + "|" + t.getVendor() + "|$" + t.getAmount());

                } catch (Exception e) {
                    System.out.println("Error parsing line: '" + lineFromString + "' -> " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("transaction.csv not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return transactions;
    }

    // save transactions
    public static void saveTransactionsToFile(Transactions t) {

        try (FileWriter fileWriter = new FileWriter("transactions.csv", true)) {
            String line = String.format("%s|%s|%s|%s|%.2f%n",
                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());

            fileWriter.write(line);

        } catch (Exception e) {
            System.out.println("Error, Cannot Save " + e.getMessage());
        }
    }






}

