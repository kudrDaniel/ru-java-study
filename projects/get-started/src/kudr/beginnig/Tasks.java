package kudr.beginnig;

import java.io.*;

public class Tasks {
    public static void sumFromFile() {
        int num1 = 0;
        int num2 = 0;
        try (FileReader reader = new FileReader("INPUT.TXT")){
            int ch;
            String numbs = "";
            while ((ch = reader.read()) != -1) {
                numbs += (char) ch;
            }
            num1 = Integer.parseInt(numbs.substring(0,numbs.indexOf(' ')));
            num2 = Integer.parseInt(numbs.substring(numbs.indexOf(' ') + 1));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter("OUTPUT.TXT")) {
            writer.write(Integer.toString(num1 + num2));
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
