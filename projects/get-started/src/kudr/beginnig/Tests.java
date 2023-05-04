package kudr.beginnig;

import java.io.*;
import java.lang.Math;
public class Tests {
    static String inputName = "INPUT.TXT";
    static String outputName = "OUTPUT.TXT";
    static String tasksPath = "./tasks/";
    public static String sumFromFile() {
        String funcPath = "sumFromFile/";
        //Initialize return string of tests
        String outputStr = "\tTests for sumFromFile func\n";

        //Create array of data
        final int cols = 3;
        final int rows = 5;
        int[][] lines = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            //Try to initialize INPUT.TXT with random data
            try (FileWriter inputWriter = new FileWriter(tasksPath + funcPath + inputName)) {
                inputWriter.write((int) (Math.random() * 1000000) + " " + (int) (Math.random() * 1000000));
                inputWriter.flush();
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }

            //Test sumFromFile()
            kudr.beginnig.Tasks.sumFromFile();

            //Try read INPUT.TXT
            try (FileReader inputReader = new FileReader(tasksPath + funcPath + inputName)) {
                int iCh;
                String iNumbs = "";
                while ((iCh = inputReader.read()) != -1) {
                    iNumbs += (char) iCh;
                }
                //Try read OUTPUT.TXT
                try (FileReader outputReader = new FileReader(tasksPath + funcPath + outputName)) {
                    int oCh;
                    String oNumb = "";
                    while ((oCh = outputReader.read()) != -1) {
                        oNumb += (char) oCh;
                    }
                    try {
                        //Try parse data from INPUT.TXT and OUTPUT.TXT and place them to array
                        lines[0][row] = Integer.parseInt(iNumbs.substring(0, iNumbs.indexOf(' ')));
                        lines[1][row] = Integer.parseInt(iNumbs.substring(iNumbs.indexOf(' ') + 1));
                        lines[2][row] = Integer.parseInt(oNumb);
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
        String funcPath = "guessGame/";
        //Initialize return string of tests
        String outputStr = "\tTests for guessGame func\n";

        //Create array of data
        final int cols = 2;
        final int rows = 5;
        int[][] lines = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            //Try to initialize INPUT.TXT with random data
            try (FileWriter inputWriter = new FileWriter(tasksPath + funcPath + inputName)) {
                inputWriter.write((int) (Math.random() * 9 + 1) + "");
                inputWriter.flush();
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }

            //Test sumFromFile()
            kudr.beginnig.Tasks.guessGame();

            //Try read INPUT.TXT
            try (FileReader inputReader = new FileReader(tasksPath + funcPath + inputName)) {
                int iCh;
                String iNumb = "";
                while ((iCh = inputReader.read()) != -1) {
                    iNumb += (char) iCh;
                }
                //Try read OUTPUT.TXT
                try (FileReader outputReader = new FileReader(tasksPath + funcPath + outputName)) {
                    int oCh;
                    String oNumb = "";
                    while ((oCh = outputReader.read()) != -1) {
                        oNumb += (char) oCh;
                    }
                    try {
                        //Try parse data from INPUT.TXT and OUTPUT.TXT and place them to array
                        lines[0][row] = Integer.parseInt(iNumb);
                        lines[1][row] = Integer.parseInt(oNumb);
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
            outputStr += "by known " + lines[0][row] + " guessed is " + lines[1][row] + ";\n";
        }
        return outputStr;
    }
    public static String arithmetic() {
        String funcPath = "arithmetic/";
        //Initialize return string of tests
        String outputStr = "\tTests for arithmetic func\n";

        //Create array of data
        final int cols = 3;
        final int rows = 5;
        int[][] lines = new int[cols][rows];
        String[] results = new String[rows];
        for (int row = 0; row < rows; row++) {
            //Try to initialize INPUT.TXT with random data
            try (FileWriter inputWriter = new FileWriter(tasksPath + funcPath + inputName)) {
                inputWriter.write((int) (Math.random() * 99 + 1) + " " + (int) (Math.random() * 99 + 1) + " " + (int) (Math.random() * 9999 + 1));
                inputWriter.flush();
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }

            //Test sumFromFile()
            kudr.beginnig.Tasks.arithmetic();

            //Try read INPUT.TXT
            try (FileReader inputReader = new FileReader(tasksPath + funcPath + inputName)) {
                int iCh;
                String iNumbs = "";
                while ((iCh = inputReader.read()) != -1) {
                    iNumbs += (char) iCh;
                }
                String[] tmpNumbs = iNumbs.split(" ");
                //Try read OUTPUT.TXT
                try (FileReader outputReader = new FileReader(tasksPath + funcPath + outputName)) {
                    int oCh;
                    String oAns = "";
                    while ((oCh = outputReader.read()) != -1) {
                        oAns += (char) oCh;
                    }
                    try {
                        //Try parse data from INPUT.TXT and OUTPUT.TXT and place them to array
                        lines[0][row] = Integer.parseInt(tmpNumbs[0]);
                        lines[1][row] = Integer.parseInt(tmpNumbs[1]);
                        lines[2][row] = Integer.parseInt(tmpNumbs[2]);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    //Add line of data to return string
                    outputStr += lines[0][row] * lines[1][row] == lines[2][row] ? oAns.equals("YES") ? lines[0][row] + " * " + lines[1][row] + " is equals " + lines[2][row] + " | " + oAns + "\n" : "Error\n": oAns.equals("NO") ? lines[0][row] + " * " + lines[1][row] + " is not equals " + lines[2][row] + " | " + oAns + "\n" : "Error\n";
                }
                catch (IOException ioEx) {
                    System.out.println(ioEx.getMessage());
                }
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }
        }
        return outputStr;
    }
    public static String payment() {
        String funcPath = "payment/";
        //Initialize return string of tests
        String outputStr = "\tTests for arithmetic func\n";

        //Create array of data
        final int cols = 4;
        final int rows = 5;
        int[][] lines = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            //Try to initialize INPUT.TXT with random data
            try (FileWriter inputWriter = new FileWriter(tasksPath + funcPath + inputName)) {
                inputWriter.write((int) (Math.random() * 9999 + 1) + " " + (int) (Math.random() * 9999 + 1) + " " + (int) (Math.random() * 9999 + 1));
                inputWriter.flush();
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }

            //Test sumFromFile()
            kudr.beginnig.Tasks.payment();

            //Try read INPUT.TXT
            try (FileReader inputReader = new FileReader(tasksPath + funcPath + inputName)) {
                int iCh;
                String iNumbs = "";
                while ((iCh = inputReader.read()) != -1) {
                    iNumbs += (char) iCh;
                }
                String[] tmpNumbs = iNumbs.split(" ");
                //Try read OUTPUT.TXT
                try (FileReader outputReader = new FileReader(tasksPath + funcPath + outputName)) {
                    int oCh;
                    String oAns = "";
                    while ((oCh = outputReader.read()) != -1) {
                        oAns += (char) oCh;
                    }
                    try {
                        //Try parse data from INPUT.TXT and OUTPUT.TXT and place them to array
                        lines[0][row] = Integer.parseInt(tmpNumbs[0]);
                        lines[1][row] = Integer.parseInt(tmpNumbs[1]);
                        lines[2][row] = Integer.parseInt(tmpNumbs[2]);
                        lines[3][row] = Integer.parseInt(oAns);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    //Add line of data to return string
                    outputStr += "Diff between min and max payment in \"" + lines[0][row] + " " + lines[1][row] + " " + + lines[2][row] + "\" is " + lines[3][row] + "\n";
                }
                catch (IOException ioEx) {
                    System.out.println(ioEx.getMessage());
                }
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }
        }
        return outputStr;
    }
}