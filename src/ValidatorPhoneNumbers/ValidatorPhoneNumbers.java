package ValidatorPhoneNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorPhoneNumbers {
    String inputPhoneNumber = readPhoneNumbers().toString();
    String[] numbers;
//    Method of reading the stream to string
    public static StringBuilder readPhoneNumbers(){
        StringBuilder phoneNumbers = new StringBuilder();
    try( BufferedReader readPhoneNumbers = new BufferedReader(new FileReader("C:\\Users\\grafm\\IdeaProjects\\unit10\\src\\resources\\file.txt"))) {
        String line = readPhoneNumbers.readLine();
        while (line != null ){
            phoneNumbers.append(line).append(" ");
            line = readPhoneNumbers.readLine();
        }
    }catch ( IOException e){
        System.err.println(e.getMessage());
    }
    return phoneNumbers;
    }
//    Method of validations phone numbers
    public String validator(){
        StringBuilder buffer = new StringBuilder();
        String regex = "\\d{3}-\\d{3}-\\d{4}";
        String regex1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(inputPhoneNumber);
        Matcher matcher1 = pattern1.matcher(inputPhoneNumber);
       while (matcher.find()) {
               buffer.append(inputPhoneNumber.substring(matcher.start(), matcher.end())).append("\n");
        }
        while (matcher1.find()) {
            buffer.append(inputPhoneNumber.substring(matcher1.start(), matcher1.end())).append("\n");
        }
        return buffer.toString();
    }
}
