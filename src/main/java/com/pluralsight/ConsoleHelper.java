//importing java tools
package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ConsoleHelper {
    // Text colors
        public static final String RESET = "\u001B[0m";
        public static final String TAUPE = "\u001B[38;2;129;102;102m";   // Deep Taupe #816666
        public static final String DOLPHIN = "\u001B[38;2;126;156;142m"; // Dolphin Gray #7E9C8E
        public static final String PINK = "\u001B[38;2;255;214;238m";    // Mimi Pink #FFD6EE
        public static final String VODKA = "\u001B[38;2;187;195;240m";   // Vodka #BBC3F0
        // Backgrounds
        public static final String BG_TAUPE = "\u001B[48;2;129;102;102m";
        public static final String BG_VODKA = "\u001B[48;2;187;195;240m";
        public static final String BG_PINK = "\u001B[48;2;255;214;238m";


        // Scanner to read users input
        private static Scanner scanner = new Scanner(System.in);

        //methods used to
        //prompts for the string
        public static String promptForString(String prompt) {
            System.out.println(TAUPE + prompt + " " + RESET);
            return scanner.nextLine();
        }
        //prompts for the date
        public static LocalDate promptForDate(String prompt) {
            while (true) {
                try {
                    System.out.println(DOLPHIN + prompt + " " + RESET);
                    String input = scanner.nextLine();
                    return LocalDate.parse(input);
                } catch (Exception e) {
                    System.out.println(PINK + "Invalid Date Format. Use yyyy-mm-dd." + RESET);
                }
            }
        }
        //prompts for the time
        public static LocalTime promptForTime(String prompt) {
            while (true) {
                try {
                    System.out.println(DOLPHIN + prompt + " " + RESET);
                    String input = scanner.nextLine();
                    return LocalTime.parse(input);
                } catch (Exception e) {
                    System.out.println(PINK + "Invalid Time Format. Use hh:mm:ss." + RESET);
                }
            }

        }
        //gets the # value for amount
        public static double promptForAmount(String prompt) {
            System.out.println(TAUPE + prompt + " " + RESET);
            double result = scanner.nextDouble();
            scanner.nextLine();
            return result;
        }
        //header customization
        public static void printHeader(String title) {
            String border = "╔══════════════════════════════════════╗";
            String footer = "╚══════════════════════════════════════╝";

            System.out.println(BG_VODKA + border);
            System.out.println(BG_VODKA + "║        " + PINK + title + BG_VODKA + "         ║");
            System.out.println(BG_VODKA + footer + RESET);
        }
        //header customization
        public static void printOption(String key, String label) {
            System.out.println(DOLPHIN + key + ")" + RESET + " " + label);
        }
        //header customization
        public static void printDivider() {
            System.out.println(TAUPE + "----------------------------------------" + RESET);
        }
    }
//todo: arraylist
//todo: parsing for LocalDate/LocalTime
//todo: scanner
//todo: methods
//run(), add deposit, make payment, showLedger, display all, display deposits, display payments
//todo: "prompt for"
//todo: scanner