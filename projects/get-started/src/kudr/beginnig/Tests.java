package kudr.beginnig;

import java.io.*;
import java.lang.Math;
public class Tests {
    public static String sumFromFile() {
        //Initialize return string of tests
        String outputStr = "\n\tTests for sumFromFile Task\n";

        //Create array of data
        final int cols = 3;
        final int rows = 5;
        int[][] lines = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            //Try initialize INPUT.TXT with random data
            try (FileWriter inputWriter = new FileWriter("./tasks/sumFromFile/INPUT.TXT")) {
                inputWriter.write((int) (Math.random() * 1000000) + " " + (int) (Math.random() * 1000000));
                inputWriter.flush();
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }

            //Test sumFromFile()
            kudr.beginnig.Tasks.sumFromFile();

            //Try read INPUT.TXT
            try (FileReader inputReader = new FileReader("./tasks/sumFromFile/INPUT.TXT")) {
                int iCh;
                String iNumbs = "";
                while ((iCh = inputReader.read()) != -1) {
                    iNumbs += (char) iCh;
                }
                //Try read OUTPUT.TXT
                try (FileReader outputReader = new FileReader("./tasks/sumFromFile/OUTPUT.TXT")) {
                    int oCh;
                    String oNumbs = "";
                    while ((oCh = outputReader.read()) != -1) {
                        oNumbs += (char) oCh;
                    }
                    try {
                        //Try parse data from INPUT.TXT and OUTPUT.TXT and place them to array
                        lines[0][row] = Integer.parseInt(iNumbs.substring(0, iNumbs.indexOf(' ')));
                        lines[1][row] = Integer.parseInt(iNumbs.substring(iNumbs.indexOf(' ') + 1));
                        lines[2][row] = Integer.parseInt(oNumbs);
                    } catch (NumberFormatException numEx) {
                        System.out.println(numEx.getMessage());
                    }
                } catch (IOException ioEx) {
                    System.out.println(ioEx.getMessage());
                }
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }

            //Add line of data to return string
            outputStr += lines[0][row] + " + " + lines[1][row] + " is equal " + lines[2][row] + ";\n";
        }
        return  outputStr;
    }
    public static String guessGame() {

    }
}
