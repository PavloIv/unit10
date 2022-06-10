package Counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counter {
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

    public String counter() {
        String[] wordsTOCount;
        StringBuilder result = new StringBuilder();
        wordsTOCount = readWords().toString().split(" ");

        for (int i = 0; i < wordsTOCount.length ; i++) {

            if (wordsTOCount[i] != null) {
                int count = 0;
                String buffer = wordsTOCount[i];
                for (int j = 0; j < wordsTOCount.length; j++)
                    if (buffer.equals(wordsTOCount[j])) {
                        count++;
                        wordsTOCount[j] = null;
                    }

                result.append(buffer).append(" ").append(count).append("\n");
            }

        }
        return result.toString();
    }
}
