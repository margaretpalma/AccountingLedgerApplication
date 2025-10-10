package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ConsoleHelper {
    //todo: arraylist
    //todo: parsing for LocalDate/LocalTime
    //todo: scanner
    //todo: methods
            //run(), add deposit, make payment, showLedger, display all, display deposits, display payments
    //todo: "prompt for"
    //todo: scanner

        private static Scanner scanner = new Scanner(System.in);

        public static String promptForString(String prompt){
            System.out.println(prompt + ":");
            return scanner.nextLine();
    }
        public static LocalDate promptForDate(String prompt){
        //todo
        }

        public static LocalTime promptForTime(String prompt){
        //todo
        }
        public static String promptForDescription(String prompt){
        //todo
        }
        public static String promptForVendor(String prompt){
        //todo
        }
        public static String promptForAmount(String prompt){
        //todo
        }
}
