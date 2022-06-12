package ConvertToObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertToObject <V,K> {
    static String [] informToObject;
    static List<User> users = new ArrayList<User>();

    //    Method of reading the stream to string
    public static StringBuilder readToConvert(){
        StringBuilder convertToObject = new StringBuilder();
        try(BufferedReader fileForConvertToObject = new BufferedReader(new FileReader("C:\\Users\\grafm\\IdeaProjects\\unit10\\src\\resources\\file1.txt"))) {
        String line = fileForConvertToObject.readLine();
        while (line != null){
            convertToObject.append(line).append(" ");
            line = fileForConvertToObject.readLine();
        }
        }catch (IOException e){
            System.err.println(e.getMessage());

        }

        return convertToObject;
    }

    public List<User> convert(){
        informToObject = readToConvert().toString().split(" ");
        for (int i = 2; i < informToObject.length; i+= 2) {
            User<V, K> newUser = new User(informToObject[i], informToObject[i + 1], informToObject[0].toString(), informToObject[1].toString());
            users.add(newUser);
        }
        return users;
    }

    public void writeToConvert(){
        File userjson = new File("C:\\Users\\grafm\\IdeaProjects\\unit10\\src\\resources\\user.json");
        try(FileWriter writer = new FileWriter(userjson)) {
            writer.write(convert().toString());
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
 class User <V,K>{
    private V value;
    private K key;

    String nameColon1;
    String nameColon2;

     public User(V value, K key, String nameColon1, String nameColon2) {
         this.value = value;
         this.key = key;
         this.nameColon1 = nameColon1;
         this.nameColon2 = nameColon2;
     }

     @Override
     public String toString() {
         return "\n{ \n" + "\"" + nameColon1 + "\" : " + "\"" + value + "\"" + "\n" +
                  "\"" + nameColon2 + "\"" +": " + key +
                 "\n} \n";
     }
 }
