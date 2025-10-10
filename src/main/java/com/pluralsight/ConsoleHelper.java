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
            System.out.println(prompt + ": ");
            return scanner.nextLine();
    }
        public static LocalDate promptForDate(String prompt){
            while(true){
                try{
                    System.out.println(prompt);
                    String input =  scanner.nextLine();
                    return  LocalDate.parse(input);
                } catch (Exception e) {
                    System.out.println("Invalid Date Format. Valid date format: yyyy-mm-dd");
                }
            }
        }

        public static LocalTime promptForTime(String prompt){
        //todo
            while(true){
                try{
                    System.out.println(prompt);
                    String input = scanner.nextLine();
                    return LocalTime.parse(input);
                } catch (Exception e) {
                    System.out.println("Invalid Time Format. Valid time format: hh-mm-ss");
                }
            }
        }
        public static String promptForDescription(String prompt){
        //todo
            System.out.println(prompt);
            return scanner.nextLine();
        }
        public static String promptForVendor(String prompt){
        //todo
            System.out.println(prompt);
            return scanner.nextLine();
        }
        public static double promptForAmount(String prompt){
        //todo
            System.out.println(prompt);
            double result = scanner.nextDouble();
            scanner.nextLine();
            return result;
        }

}
