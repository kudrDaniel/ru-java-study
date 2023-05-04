package kudr.beginnig;

import java.io.*;

public class Tasks {
    static String inputName = "INPUT.TXT";
    static String outputName = "OUTPUT.TXT";
    static String tasksPath = "./tasks/";
    public static void sumFromFile() {
        String funcPath = "sumFromFile/";
        int num1 = 0;
        int num2 = 0;
        try (FileReader reader = new FileReader(tasksPath + funcPath + inputName)){
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
        try (FileWriter writer = new FileWriter(tasksPath + funcPath + outputName)) {
            writer.write(Integer.toString(num1 + num2));
            writer.flush();
        }
        catch (IOException ioEx){
            System.out.println(ioEx.getMessage());
        }
    }
    public static void guessGame() {
        String funcPath = "guessGame/";
        int guessedNumb = 0;
        try (FileReader reader = new FileReader(tasksPath + funcPath + inputName)) {
            int ch;
            String strNumb = "";
            while ((ch = reader.read()) != -1) {
                strNumb += (char) ch;
            }
            try {
                guessedNumb = Integer.parseInt(strNumb);
                if (guessedNumb == 9) guessedNumb = 99;
                else guessedNumb = guessedNumb * 100 + 90 + 9 - guessedNumb;
            }
            catch (NumberFormatException numEx) {
                System.out.println(numEx.getMessage());
            }

        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        try (FileWriter writer = new FileWriter(tasksPath + funcPath + outputName)) {
            writer.write(Integer.toString(guessedNumb));
            writer.flush();
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    public static void arithmetic() {
        String funcPath = "arithmetic/";
        int [] numbers = new int[3];
        try (FileReader reader = new FileReader(tasksPath + funcPath + inputName)) {
            int ch;
            String numbs = "";
            while ((ch = reader.read()) != -1) {
                numbs += (char) ch;
            }
            String[] tmpNumbs = numbs.split(" ");
            try {
                numbers[0] = Integer.parseInt(tmpNumbs[0]);
                numbers[1] = Integer.parseInt(tmpNumbs[1]);
                numbers[2] = Integer.parseInt(tmpNumbs[2]);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        try (FileWriter writer = new FileWriter(tasksPath + funcPath + outputName)) {
            writer.write(numbers[0] * numbers[1] == numbers[2] ? "YES" : "NO");
            writer.flush();
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    public static void payment() {
        String funcPath = "payment/";
        int[] numbs = new int[3];
        try (FileReader reader = new FileReader(tasksPath + funcPath + inputName)) {
            int ch;
            StringBuilder readStr = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                readStr.append((char) ch);
            }
            String[] tmpStr = readStr.toString().split(" ");
            try {
                for (int i = 0; i < numbs.length; i++) numbs[i] = Integer.parseInt(tmpStr[i]);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        boolean sorted = false;
        while (!sorted) {
            for (int i = 0; i < numbs.length; i++) {
                if (i + 1 == numbs.length) continue;
                if (numbs[i] > numbs[i + 1]) {
                    numbs[i] += numbs[i + 1];
                    numbs[i + 1] = numbs[i] - numbs[i + 1];
                    numbs[i] -= numbs[i + 1];
                    sorted = false;
                    continue;
                }
                sorted = true;
            }
        }
        try (FileWriter writer = new FileWriter(tasksPath + funcPath + outputName)) {
            writer.write(Integer.toString(numbs[numbs.length - 1] - numbs[0]));
            writer.flush();
        }
        catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
}