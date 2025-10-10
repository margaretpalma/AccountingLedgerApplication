package com.pluralsight;

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
                    System.out.println("Deposit");
                    break;
                case "P":
                    System.out.println("Payment");
                    break;
                case "L":
                    System.out.println("Ledger");
                    break;
                case "X":
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid command");
            }

        }
    }

}







//D) Add Deposit P)Make Payment(Debit) L)Ledger X)exit



//todo: call console ledger
//todo: bufferedReader, fileReader

//todo: switch statement
//todo: exception catching
//todo: return transactions

//todo: display of menus, menu within menu