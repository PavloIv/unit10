import ConvertToObject.ConvertToObject;
import Counter.Counter;
import ValidatorPhoneNumbers.ValidatorPhoneNumbers;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        ValidatorPhoneNumbers first = new ValidatorPhoneNumbers();
        System.out.println(first.validator());
        Counter newCounter = new Counter();
        System.out.println(newCounter.sortedCounter());
        ConvertToObject newConvert = new ConvertToObject();
        newConvert.writeToConvert();
    }
}
