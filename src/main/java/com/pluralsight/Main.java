//importing java tools
package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

    //declared as a class level variable, accessible through whole project (launchMenu, launchLedger, customSearch)
    //can modify shared list of transactions
    public static ArrayList<Transactions> transactions = new ArrayList<>();

    public static void main(String[] args) {
        transactions = getTransactionsFromFile(); //loading transactions from file
        launchMenu(); // launching main menu
    }

    //main menu
    public static void launchMenu() {
        while (true) {

            //display customized main menu
            System.out.println(ConsoleHelper.BG_VODKA + ConsoleHelper.TAUPE +
                    "\n╔══════════════════════════════╗\n" +
                    "║          MAIN MENU           ║\n" +
                    "╚══════════════════════════════╝\n" +
                    ConsoleHelper.RESET);

            System.out.println(ConsoleHelper.DOLPHIN + "D)" + ConsoleHelper.RESET + " Add Deposit");
            System.out.println(ConsoleHelper.DOLPHIN + "P)" + ConsoleHelper.RESET + " Make a Payment");
            System.out.println(ConsoleHelper.DOLPHIN + "L)" + ConsoleHelper.RESET + " Ledger");
            System.out.println(ConsoleHelper.PINK + "X)" + ConsoleHelper.RESET + " Exit Program");


            //prompting user input
            //variable stores as "choice"
            //calls method promptForString coming from ConsoleHelper
            String choice = ConsoleHelper.promptForString("****Choose From Menu****");



            //starts switch statement - user picks a choice (.toUpperCase lets user use D or d without breaking)
            switch (choice.toUpperCase()) {
                case "D":
                    System.out.println("****Add Deposit****");

                    //prompts for parts of transaction
                    LocalDate date = ConsoleHelper.promptForDate("Enter Date |yyyy-mm-dd|");
                    LocalTime time = ConsoleHelper.promptForTime("Enter Time |hh:mm:ss");
                    String description = ConsoleHelper.promptForString("Enter Description");
                    String vendor = ConsoleHelper.promptForString("Enter Vendor");
                    Double amount = ConsoleHelper.promptForAmount("Enter Amount");

                    //transaction object - this is what adds the input to csv file
                    Transactions deposit = new Transactions(date, time, description, vendor, amount);
                    transactions.add(deposit);

                    //SAVES to csv file
                    saveTransactionsToFile(deposit);

                    System.out.println(date + "|" + time + "|" + description + "|" + vendor + "|$" + amount);
                    //confirmation of deposit added
                    System.out.println(ConsoleHelper.PINK + "****Deposit Added****" + ConsoleHelper.RESET);
                    break;

                case "P":
                    System.out.println("****Make A Payment****");
                    LocalDate paymentDate = ConsoleHelper.promptForDate("Enter Date |yyyy-mm-dd|");
                    LocalTime paymentTime = ConsoleHelper.promptForTime("Enter Time |hh:mm:ss");
                    String paymentDescription = ConsoleHelper.promptForString("Enter Description");
                    String paymentVendor = ConsoleHelper.promptForString("Enter Vendor");
                    Double paymentAmount = ConsoleHelper.promptForAmount("Enter Amount");

                    //converts payment to negative
                    paymentAmount = -Math.abs(paymentAmount);

                    //transaction object, saves the transactions to the file
                    Transactions payment = new Transactions(paymentDate, paymentTime, paymentDescription, paymentVendor, paymentAmount);
                    transactions.add(payment);
                    saveTransactionsToFile(payment);

                    System.out.println(paymentDate + "|" + paymentTime + "|" + paymentDescription + "|" + paymentVendor + "|$" + paymentAmount);
                    System.out.println(ConsoleHelper.PINK + "-- Payment Complete --" + ConsoleHelper.RESET);
                    break;

                //launches ledger submenu
                case "L":
                    launchLedger();
                    break;

                //exits program
                case "X":
                    System.out.println("Exiting Program");
                    return;

                default:
                    System.out.println("Invalid command");
            }
        }
    }

    // ledger method
    public static void launchLedger() {

            //while - loops to show each part of the menu until you press H(return to stop looping)
        while (true) {
            System.out.println(ConsoleHelper.BG_PINK + ConsoleHelper.TAUPE +
                    "\n╔══════════════════════════╗\n" +
                    "║        LEDGER MENU       ║\n" +
                    "╚══════════════════════════╝\n" +
                    ConsoleHelper.RESET);
            System.out.println(ConsoleHelper.DOLPHIN + "A)" + ConsoleHelper.RESET + " All Entries");
            System.out.println(ConsoleHelper.DOLPHIN + "D)" + ConsoleHelper.RESET + " Only Deposits");
            System.out.println(ConsoleHelper.DOLPHIN + "P)" + ConsoleHelper.RESET + " Only Payments");
            System.out.println(ConsoleHelper.DOLPHIN + "R)" + ConsoleHelper.RESET + " Reports Menu");
            System.out.println(ConsoleHelper.TAUPE + "H)" + ConsoleHelper.RESET + " Home Menu");

            //prompts for user input
            String choice = ConsoleHelper.promptForString("---- Choose From Menu -----");

            //.toUpperCase() lets user do A or a
            switch (choice.toUpperCase()) {
                case "A":


                    System.out.println("--- All Entries ---");
                    //header row before all entries
                    System.out.println("Date       | Time     | Description                        | Vendor              |   Amount");
                    System.out.println("----------------------------------------------------------------------------------------------");

                    //loops transactions
                    //did this backwards originally, had to fix for earliest transactions first
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);
                        System.out.println(t);
                    }
                    break;


                case "D":

                    //deposits only
                    //loop goes through every transaction in list
                    //prints if amount is greater than zero (positive)
                    System.out.println("---Deposits---");
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);
                        if (t.getAmount() > 0) {
                            System.out.println(t);
                        }
                    }
                    break;

                case "P":

                    System.out.println("---Payments---");
                    //payments only
                    //loop goes through transactions in list
                    //i--
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);
                        if (t.getAmount() < 0) {
                            System.out.println(t);
                        }
                    }
                    break;

                case "R":
                    //launches reports submenu
                    launchReportsMenu();

                case "H":
                    System.out.println(ConsoleHelper.TAUPE + "--- Returning To Main Menu ---" + ConsoleHelper.RESET);
                    return;

                default:
                    System.out.println(ConsoleHelper.BG_VODKA + ConsoleHelper.TAUPE + "Invalid Option" + ConsoleHelper.RESET);
            }
        }
    }

    //reports menu launch
    public static void launchReportsMenu() {

        while (true) {
            System.out.println(ConsoleHelper.BG_TAUPE + ConsoleHelper.VODKA +
                    "\n╔══════════════════════════╗\n" +
                    "║       REPORTS MENU       ║\n" +
                    "╚══════════════════════════╝\n" +
                    ConsoleHelper.RESET);

            //display menu options
            System.out.println(ConsoleHelper.DOLPHIN + "1)" + ConsoleHelper.RESET + " Month To Date");
            System.out.println(ConsoleHelper.DOLPHIN + "2)" + ConsoleHelper.RESET + " Previous Month");
            System.out.println(ConsoleHelper.DOLPHIN + "3)" + ConsoleHelper.RESET + " Year To Date");
            System.out.println(ConsoleHelper.DOLPHIN + "4)" + ConsoleHelper.RESET + " Previous Year");
            System.out.println(ConsoleHelper.DOLPHIN + "5)" + ConsoleHelper.RESET + " Search By Vendor");
            System.out.println(ConsoleHelper.PINK + "6)" + ConsoleHelper.RESET + " Custom Search");
            System.out.println(ConsoleHelper.TAUPE + "0)" + ConsoleHelper.RESET + " Return to Ledger Menu");

            //prompts for user input
            String choice = ConsoleHelper.promptForString("---- Choose From Menu -----");

            //user choices
            switch (choice) {
                case "1": {
                    System.out.println("------Month To Date------");

                    //used for comparing transactions
                    LocalDate today = LocalDate.now();

                    //for loop to sort newest first
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);

                    //only includes from the current month and year
                        if (t.getDate().getMonth() == today.getMonth() && t.getDate().getYear() == today.getYear()) {
                            System.out.println(t);
                        }
                    }
                }
                break;
                case "2": {
                    System.out.println("------Previous Month------");
                    LocalDate today = LocalDate.now();
                    //subracts one month from from todays date
                    LocalDate previousMonth = today.minusMonths(1);

                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);
                        LocalDate date = t.getDate();

                        //condition to check transactions from previous month of current year
                        //previousMonth.getYear - year of previous month
                        //previousMonth.getMonth - previous month
                        if (date.getYear() == previousMonth.getYear() && date.getMonth() == previousMonth.getMonth()) {
                            System.out.println(t.getDate() + "|$" + t.getAmount());
                        }
                    }
                    //todo
                    break;
                }

                case "3": {
                    System.out.println("------Year To Date------");
                    LocalDate today = LocalDate.now();
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);

                        //transactions from current year
                        if (t.getDate().getYear() == today.getYear()) {
                            System.out.println(t.getDate() + "|$" + t.getAmount());
                        }
                    }

                    //todo
                    break;
                }
                case "4": {
                    System.out.println("------Previous Year-------");
                    int previousYear = LocalDate.now().getYear() - 1;
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);

                        //transactions for previous year
                        if (t.getDate().getYear() == previousYear) {
                            System.out.println(t.getDate() + "|$" + t.getAmount());
                        }
                    }

                }
                break;

                case "5":
                    String vendorName = ConsoleHelper.promptForString("Vendor Name: ");
                    System.out.println("Results for | " + vendorName);
                    for (int i = transactions.size() - 1; i >= 0; i--) {
                        Transactions t = transactions.get(i);

                        //vendor name, can be capital or not, still works
                        if (t.getVendor().equalsIgnoreCase(vendorName)) {
                            System.out.println(t.getDate() + "|$" + t.getAmount());
                        }
                    }
                    break;

                case "6":

                    //custom search submenu
                    customSearch();
                    break;

                case "0":
                    System.out.println("---Returning To Main Menu---");
                    return;
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        }
    }


    public static ArrayList<Transactions> getTransactionsFromFile() {

        //creates an empty list - stores the transactions after reading from CSV file
        ArrayList<Transactions> transactions = new ArrayList<>();

        //bufferedReader package reads text
        //FileReader passed into consturctor
        try (BufferedReader br = new BufferedReader(new FileReader("transactions.csv"))) {
            String lineFromString;
            while ((lineFromString = br.readLine()) != null) {
                try {
                    // Skip blank lines
                    if (lineFromString.trim().isEmpty()) continue;

                    String[] parts = lineFromString.split("\\|");


                    //ISO 8601 Standard for date
                    LocalDate date = LocalDate.parse(parts[0].trim());
                    LocalTime time = LocalTime.parse(parts[1].trim());
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    double amount = Double.parseDouble(parts[4].trim());

                    Transactions t = new Transactions(date, time, description, vendor, amount);
                    transactions.add(t);

                    // debugging option
                    //shows files before menu
                    // System.out.println(t.getDate() + "|" + t.getTime() + "|"
                    //        + "|" + t.getVendor() + "|$" + t.getAmount());

                } catch (Exception e) {
                    System.out.println("Error parsing line: '" + lineFromString + " - " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("transaction.csv not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
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
            System.out.println("Error | Cannot Save |" + e.getMessage());
        }
    }

    //custom search
    public static void customSearch() {
        System.out.println("---Custom Search---");

        String startDateInput = ConsoleHelper.promptForString("Start Date (yyyy-mm-dd) |Press Enter To Skip|");
        String endDateInput = ConsoleHelper.promptForString("End Date (yyyy-mm-dd) |Press Enter To Skip|");
        String descriptionInput = ConsoleHelper.promptForString("Description | Optional |Press Enter To Skip|");
        String vendorInput = ConsoleHelper.promptForString("Vendor | Optional |Press Enter To Skip|");
        String amountInput = ConsoleHelper.promptForString("Exact Amount |Press Enter To Skip|");


        LocalDate startDate = null;
        LocalDate endDate = null;
        Double amount = null;

        //date provided
        try {
            if (!startDateInput.isEmpty()) startDate = LocalDate.parse(startDateInput);
            if (!endDateInput.isEmpty()) endDate = LocalDate.parse(endDateInput);
            if (!amountInput.isEmpty()) amount = Double.parseDouble(amountInput);
        } catch (Exception e) {
            System.out.println("Invalid input format.");
            return;
        }

        System.out.println("Search Results");
        ArrayList<Transactions> matches = new ArrayList<Transactions>();
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transactions t = transactions.get(i);

            if (startDate != null && t.getDate().isBefore(startDate)) continue;
            if (endDate != null && t.getDate().isAfter(endDate)) continue;
            if (amount != null && t.getAmount() != amount) continue;

            matches.add(t);
        }

        if (matches.isEmpty()) {
            System.out.println("No Transactions Available.");
        } else {
            for (Transactions t : matches) {
                System.out.println(t);
            }
        }
    }
}

//todo: newest entries first
//todo: REPORTS MENU
//todo:1) month to date
//todo:2) previous month
//todo:3) year to date
//todo:4) previous year
//todo:5) search by vendor - vendor name, display entries
//todo:6) back - back to ledger page
//todo complete case 1