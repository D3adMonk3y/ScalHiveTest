package Test1;

import java.util.*;
import java.util.regex.Pattern;

public class Test1 {

    public static void main(String[] args) {
        //An empty string where we will store the received data and which we will subsequently process
        String string;

        //use the scanner to get a string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        string = scanner.nextLine();

        //split original string to array of each character
        String[] eachLetterString = string.toLowerCase().split("");

        //create a regular expression
        String regex = "^[a-z]{1}$";
        Pattern pattern = Pattern.compile(regex);

        // compare each character if it from english alphabet or not, and if it does add to stringbuilder onlyEnglishLetters object
        StringBuilder onlyEnglishLetters = new StringBuilder();
        for (String anEachLetterString : eachLetterString) {
            if (pattern.matcher(anEachLetterString).matches()) {
                onlyEnglishLetters.append(anEachLetterString);
            }
        }

        //convert a stringbuilder to charArray
        char[] letters = onlyEnglishLetters.toString().toCharArray();

        // create a HashMap to store pair of character and its frequency of occurrence
        Map<Character, Integer> resultMap = new HashMap<>();

        //fill up HashMap
        for (char letter : letters) {
            // if character already in the map increase it frequency
            if (resultMap.containsKey(letter)) {
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
