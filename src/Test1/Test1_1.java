package Test1;

import java.util.*;

public class Test1_1 {

    public static void main(String[] args) {
        //An string where we will store the received data and which we will subsequently process
        String string;

        //A String that contains every letter of english alphabet
        String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";

        //use the scanner to get a string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        string = scanner.nextLine();

        //convert a given string to charArray
        char[] letters = string.toLowerCase().toCharArray();

        // create a HashMap to store pair of character and its frequency of occurrence
        Map<Character, Integer> resultMap = new HashMap<>();

        //fill up HashMap
        for (char letter : letters) {

            //check if character belongs to english alphabet
            if (englishAlphabet.contains(letter + ""))
                if (resultMap.containsKey(letter)) {

                    // if character already in the map increase it frequency
                    resultMap.replace(letter, resultMap.get(letter) + 1);
                } else {

                    // if map don't contains character add new pair to map, adn set it frequency of occurrence to 1
                    resultMap.put(letter, 1);
                }
        }

        // Print frequency of occurrence of each character of English alphabet in given string
        System.out.println("\nNumbers of each letter:");
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + ";");
        }

    }
}
