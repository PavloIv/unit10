package Counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counter {
    int maxCount;
    //    Method of reading the stream to string
    public static StringBuilder readWords() {
        StringBuilder words = new StringBuilder();
        try (BufferedReader readWord = new BufferedReader(new FileReader("C:\\Users\\grafm\\IdeaProjects\\unit10\\src\\resources\\words.txt"))) {
            String line = readWord.readLine();
            while (line != null) {
                words.append(line).append(" ");
                line = readWord.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return words;
    }
    //      Method of counting words in the text
    public String counter() {
        String[] wordsTOCount;
        int maxCount = 0;
        StringBuilder result = new StringBuilder();
        wordsTOCount = readWords().toString().split(" ");
        for (int i = 0; i < wordsTOCount.length; i++) {

            if (wordsTOCount[i] != null) {
                int count = 0;
                String buffer = wordsTOCount[i];
                for (int j = 0; j < wordsTOCount.length; j++)
                    if (buffer.equals(wordsTOCount[j])) {
                        count++;
                        wordsTOCount[j] = null;
                    }
                result.append(buffer).append(" ").append(count).append("\n");
                if (count > maxCount){
                    maxCount = count;
                }
            }
        }
        this.maxCount = maxCount;
        return result.toString();
    }
    //      Method for sorted result
    public String sortedCounter() {
        String[] arrayForSorted;
        StringBuilder sortedResult = new StringBuilder();
        arrayForSorted = counter().split("\n");
        for (Integer i = maxCount; i >= 1; i--) {
            for (int j = 0; j < arrayForSorted.length; j++) {
                if (arrayForSorted[j].contains(i.toString())) {
                    sortedResult.append(arrayForSorted[j]).append("\n");
                }
            }
        }
        return sortedResult.toString();
    }
}
