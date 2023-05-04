package kudr.beginnig;

import java.io.*;

public class Tasks {
    public static void sumFromFile() {
        int num1 = 0;
        int num2 = 0;
        try (FileReader reader = new FileReader("./tasks/sumFromFile/INPUT.TXT")){
            int ch;
            String numbs = "";
            while ((ch = reader.read()) != -1) {
                numbs += (char) ch;
            }
            try {
                num1 = Integer.parseInt(numbs.substring(0, numbs.indexOf(' ')));
                num2 = Integer.parseInt(numbs.substring(numbs.indexOf(' ') + 1));
            }
            catch (NumberFormatException numEx) {
                System.out.println(numEx.getMessage());
            }
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        try (FileWriter writer = new FileWriter("./tasks/sumFromFile/OUTPUT.TXT")) {
            writer.write(Integer.toString(num1 + num2));
            writer.flush();
        }
        catch (IOException ioEx){
            System.out.println(ioEx.getMessage());
        }
    }
    public  static  void guessGame() {
        int guessedNumb = 0;
        try (FileReader reader = new FileReader("./tasks/guessGame/INPUT.TXT")) {
            int ch;
            String strNumb = "";
            while ((ch = reader.read()) != -1) {
                strNumb += (char) ch;
            }
            try {
                guessedNumb = Integer.parseInt(strNumb);
                guessedNumb = guessedNumb * 100 + 90 + 9 - guessedNumb;
            }
            catch (NumberFormatException numEx) {
                System.out.println(numEx.getMessage());
            }

        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        try (FileWriter writer = new FileWriter("./tasks/guessGame/OUTPUT.TXT")) {
            writer.write(Integer.toString(guessedNumb));
            writer.flush();
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
}
