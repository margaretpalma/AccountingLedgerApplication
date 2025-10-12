package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.*;


public class Main {
    public static ArrayList<Transactions> transactions = new ArrayList<>();

    public static void main(String[] args) {
        transactions = getTransactionsFromFile();           //existing transactions
        launchMenu();                                       //launching menu

    }

    //main menu
    public static void launchMenu() {
        while (true) {

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

                    Transactions deposit = new Transactions(date, time, description, vendor, amount);
                    transactions.add(deposit);
                    saveTransactionsToFile(deposit);


                    System.out.println(date + "|" + time + "|" + description + "|" + vendor + "|$" + amount);
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

                    Transactions payment = new Transactions(paymentDate, paymentTime, paymentDescription, paymentVendor, paymentAmount);
                    transactions.add(payment);
                    saveTransactionsToFile(payment);

                    System.out.println(paymentDate + "|" + paymentTime + "|" + paymentDescription + "|" + paymentVendor + "|$" + paymentAmount);
                    System.out.println("-- Payment Complete --");
                    break;

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

    //ledger menu
    //todo: Reports Menu
    public static void launchLedger() {
        //todo: ledger menu
        while (true) {
            //todo: test home screen first
            System.out.println("\n---Ledger Menu---");
            System.out.println("A) All Entries");
            System.out.println("D) Only Deposits");
            System.out.println("P) Only Payments");
            //Space for Reports Menu
            System.out.println("H) Home Menu");
            String choice = ConsoleHelper.promptForString("---Choose An Option---").toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("---All Entries---");
                    for (Transactions t : transactions) {
                        System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));
                    }
                    break;

                case "D":
                    System.out.println("---Deposits---");
                    for (Transactions t : transactions) {
                        if (t.getAmount() > 0) {            //money coming in ++
                            System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                    + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));
                        }
                    }
                    break;

                case "P":
                    System.out.println("---Payments---");
                    for (Transactions t : transactions) {
                        if (t.getAmount() < 0) {                          //money going out --
                            System.out.println(t.getDate() + "|" + t.getTime() + "|" + t.getDescription()
                                    + "|" + t.getVendor() + "|$" + String.format("%.2f", t.getAmount()));
                        }
                    }
                    break;

                case "H":
                    System.out.println("---Returning To Main Menu---");
                    return;

                default:
                    System.out.println("Invalid Option");
            }
            if(choice.equalsIgnoreCase("H")){
                break;
            }
        }
    }

    //file reading
    public static ArrayList<Transactions> getTransactionsFromFile(){
        ArrayList<Transactions> transactions = new ArrayList<Transactions>();
            try {
                FileReader fr = new FileReader("transactions.csv");
                BufferedReader br = new BufferedReader(fr);

                String lineFromString;

                while ((lineFromString = br.readLine()) != null) {
                    String[] parts = lineFromString.split("\\|");

                    //parse
                    LocalDate date = LocalDate.parse(parts[0]);
                    LocalTime time = LocalTime.parse(parts[1]);
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);

                    //object
                    Transactions t = new Transactions(date, time, description, vendor, amount);
                    transactions.add(t);
                }
                //close bufferedReader
                br.close();
            } //catch exception
            catch(Exception e){
                System.out.println("Error reading file.");
            }
            return transactions ;
            }
        }
    //save transactions
    public static void saveTransactionsToFile(Transactions transactions){
            try (FileWriter fileWriter = new FileWriter("transactions.csv", true)) {
                String line = String.format("%s|%s|%s|%s|%.2f%n");
                transactions.getDate();
                transactions.getTime();
                transactions.getDescription();
                transactions.getVendor();
                transactions.getAmount();
                fileWriter.write(line);
            } catch (Exception e);
             System.out.println("Error, Cannot Save " + e.getMessage());
    }
    }









//D) Add Deposit P)Make Payment(Debit) L)Ledger X)exit
//todo: call console ledger
//todo: bufferedReader, fileReader
//todo: switch statement
//todo: return transactions
//todo: display of menus, menu within menu