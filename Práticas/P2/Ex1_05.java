import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Ex1_05 {
    public static void main(String[] args) {
        
        String filename = "numbers.txt";

        HashMap<String, Integer> dict = parseInputFromFile(filename);

        String[] words = readUserInput();

        printOutput(dict, words);

    }


    public static HashMap<String, Integer> parseInputFromFile(String filename) {

        HashMap<String, Integer> dict = new HashMap<>();

        try {
            File file = new File("numbers.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] splitData = data.split(" - ");
                if (splitData.length != 2) {
                    System.err.println("ERROR: Wrong file input. Exiting...");
                    System.exit(1);
                }
                // File is wrriten in format " int - numberAsSring\n "
                String numberString = splitData[1];
                int numberInt = Integer.parseInt(splitData[0]);
                dict.put(numberString, numberInt);
            }
            reader.close();

        } catch (FileNotFoundException e) {
        System.err.println("An error occurred.");
        System.exit(1);
        }

        if (dict.isEmpty()) {
            System.err.println("ERROR: File read incorrectly OR wrong file format. Exiting...");
            System.exit(1);
        }

        return dict;
    }

    public static String[] readUserInput() {

        Scanner inputScanner = new Scanner(System.in);

        // Considerando que o input é só uma linha:
        String line = inputScanner.nextLine();
        String processedLine = line.replace("-", " ");
        String[] words = processedLine.split(" ");

        inputScanner.close();

        return words;
    }

    public static int[] sumOrMultiply(int wordValue, int nextWordValue, int curentValue) {
        // Operation = 0 -> addition
        // Operation = 1 -> multiplication
        int operation = 0;
        if (wordValue < nextWordValue) {
            curentValue *= nextWordValue;  
            operation = 1;
        } else if (wordValue > nextWordValue) {
            curentValue += nextWordValue;  
        } else {
            System.err.println("EROOR: Can't have 2 equal consecutive values." + "(" + wordValue + "). Exiting...");
            System.exit(1);
        }    

        int[] output = new int[]{curentValue, operation};

        return output;
    }

    public static void printOutput(HashMap<String, Integer> dict, String[] words) {
        // When we start reading the array, there is no previous word yet.
        boolean first = true;
        String word = null;
        String nextWord = null;
        int[] infoArray = new int[2];
        // Start as 1 for multiplication purposes
        int valueToAdd = 1;
        
        for (int idx = 0; idx < words.length - 1; idx++) {
            word = words[idx];
            nextWord = words[idx+1];

            if(first) {
                if (dict.containsKey(word)) {
                    infoArray[0] = dict.get(word);
                    System.out.println(infoArray);
                    first = false;
                }
            }

            if (dict.containsKey(word) && dict.containsKey(nextWord)) {
                int valueWord = dict.get(word);
                int valueNextWord = dict.get(nextWord);
                // If the previous operation was a multiplication:
                if (infoArray[1] == 1) {
                    valueToAdd *= infoArray[0];
                } else {

                }

                infoArray = sumOrMultiply(valueWord, valueNextWord, infoArray[0]);
                int prevOperation = infoArray[1];
                System.out.println(infoArray);
            } else {
                System.out.print(word + " ");
            }
            
        }
        System.out.print(infoArray[0] + ".");
        //Newline
        System.out.println();
    }
}