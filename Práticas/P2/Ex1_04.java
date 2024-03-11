import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Ex1_04 {
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

    public static void printOutput(HashMap<String, Integer> dict, String[] words) {

        for (String word : words) {
            if (dict.containsKey(word)) {
                System.out.print(dict.get(word) + " ");
            } else {
                System.out.print(word + " ");
            }
        }
        //Newline
        System.out.println();
    }
}