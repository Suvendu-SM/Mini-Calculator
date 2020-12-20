import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Calculator extends Frame implements ActionListener {

    Button B0, B1, B2, B3, B4, B5, B6, B7, B8, B9, Cancel, Addition, Substraction, Multiplication, Division, Result;
    TextField t, t2;
    int index = 0;
    String string = "";
    StringBuffer tString;
    StringBuffer nString = new StringBuffer();
    double result = 0;
    String truncateString;
    String[] Array = new String[1000];
    FileWriter cFilefilewWriter;
    BufferedWriter cFileBufferedWriter;

    Calculator() {
        setSize(353, 460);
        setResizable(false);
        setVisible(true);
        setBackground(Color.YELLOW);
        setFont(new Font("sadfags", Font.BOLD, 30));
        setTitle("Mini Calculator");
        setLayout(null);
        init();
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);
        B9.addActionListener(this);
        B0.addActionListener(this);
        Cancel.addActionListener(this);
        Addition.addActionListener(this);
        Substraction.addActionListener(this);
        Multiplication.addActionListener(this);
        Division.addActionListener(this);
        Result.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == B1) {
                nString.append("1");
                t.setText(nString.toString());
                t2.setText("");
                string += "1";
            } else if (e.getSource() == B2) {
                nString.append("2");
                t.setText(nString.toString());
                t2.setText("");
                string += "2";
            } else if (e.getSource() == B3) {
                nString.append("3");
                t.setText(nString.toString());
                t2.setText("");
                string += "3";
            } else if (e.getSource() == B4) {
                nString.append("4");
                t.setText(nString.toString());
                t2.setText("");
                string += "4";
            } else if (e.getSource() == B5) {
                nString.append("5");
                t.setText(nString.toString());
                t2.setText("");
                string += "5";
            } else if (e.getSource() == B6) {
                nString.append("6");
                t.setText(nString.toString());
                t2.setText("");
                string += "6";
            } else if (e.getSource() == B7) {
                nString.append("7");
                t.setText(nString.toString());
                t2.setText("");
                string += "7";
            } else if (e.getSource() == B8) {
                nString.append("8");
                t.setText(nString.toString());
                t2.setText("");
                string += "8";
            } else if (e.getSource() == B9) {
                nString.append("9");
                t.setText(nString.toString());
                t2.setText("");
                string += "9";
            } else if (e.getSource() == B0) {
                nString.append("0");
                t.setText(nString.toString());
                t2.setText("");
                string += "0";
            } else if (e.getSource() == Addition) {
                if ((!nString.toString().isEmpty()) && string != "-") {
                    if (nString.charAt(nString.length() - 1) == '+' || nString.charAt(nString.length() - 1) == '-'
                            || nString.charAt(nString.length() - 1) == 'x'
                            || nString.charAt(nString.length() - 1) == '/') {
                        nString.deleteCharAt(nString.length() - 1);
                        index--;
                        Array[index] = "+";
                    } else {
                        Array[index] = string;
                        Array[++index] = "+";
                    }
                    if (index > 1 && Array[index - 2] == "x") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) * Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "+";
                    } else if (index > 1 && Array[index - 2] == "/") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) / Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "+";
                    }
                    t.setText(nString.append("+").toString());
                    string = "";
                    index++;
                } else if (!nString.toString().isEmpty()) {
                    string = "";
                    nString.deleteCharAt(0);
                    t.setText(nString.toString());
                }
            } else if (e.getSource() == Substraction) {
                if (nString.toString().isEmpty()) {
                    t.setText(nString.append("-").toString());
                    t2.setText("");
                    string = "-";
                } else if (string != "-") {
                    if (nString.charAt(nString.length() - 1) == '+' || nString.charAt(nString.length() - 1) == '-'
                            || nString.charAt(nString.length() - 1) == 'x'
                            || nString.charAt(nString.length() - 1) == '/') {
                        nString.deleteCharAt(nString.length() - 1);
                        index--;
                        Array[index] = "-";
                    } else {
                        Array[index] = string;
                        Array[++index] = "-";
                    }
                    t.setText(nString.append("-").toString());
                    if (index > 1 && Array[index - 2] == "x") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) * Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "-";
                    } else if (index > 1 && Array[index - 2] == "/") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) / Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "-";
                    }
                    string = "";
                    index++;
                }
            } else if (e.getSource() == Multiplication) {
                if ((!nString.toString().isEmpty()) && string != "-") {
                    if (nString.charAt(nString.length() - 1) == '+' || nString.charAt(nString.length() - 1) == '-'
                            || nString.charAt(nString.length() - 1) == 'x'
                            || nString.charAt(nString.length() - 1) == '/') {
                        nString.deleteCharAt(nString.length() - 1);
                        index--;
                        Array[index] = "x";
                    } else {
                        Array[index] = string;
                        Array[++index] = "x";
                    }
                    t.setText(nString.append("x").toString());
                    if (index > 1 && Array[index - 2] == "x") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) * Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "x";
                    } else if (index > 1 && Array[index - 2] == "/") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) / Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "x";
                    }
                    string = "";
                    index++;
                } else if (!nString.toString().isEmpty()) {
                    string = "";
                    nString.deleteCharAt(0);
                    t.setText(nString.toString());
                }
            } else if (e.getSource() == Division) {
                if ((!nString.toString().isEmpty()) && string != "-") {
                    if (nString.charAt(nString.length() - 1) == '+' || nString.charAt(nString.length() - 1) == '-'
                            || nString.charAt(nString.length() - 1) == 'x'
                            || nString.charAt(nString.length() - 1) == '/') {
                        nString.deleteCharAt(nString.length() - 1);
                        index--;
                        Array[index] = "/";
                    } else {
                        Array[index] = string;
                        Array[++index] = "/";
                    }
                    t.setText(nString.append("/").toString());
                    if (index > 1 && Array[index - 2] == "x") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) * Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "/";
                    } else if (index > 1 && Array[index - 2] == "/") {
                        Array[index - 3] = Double
                                .toString(Double.parseDouble(Array[index - 3]) / Double.parseDouble(Array[index - 1]));
                        index -= 2;
                        Array[index] = "/";
                    }
                    string = "";
                    index++;
                } else if (!nString.toString().isEmpty()) {
                    string = "";
                    nString.deleteCharAt(0);
                    t.setText(nString.toString());
                }
            } else if (e.getSource() == Cancel) {
                t.setText("");
                t2.setText("");
                string = "";
                nString.delete(0, nString.length());
                result = 0;
                index = 0;
            } else if (e.getSource() == Result && nString.length() > 0) {
                if (nString.charAt(nString.length() - 1) == '+' || nString.charAt(nString.length() - 1) == '-'
                        || nString.charAt(nString.length() - 1) == 'x' || nString.charAt(nString.length() - 1) == '/') {
                    nString.deleteCharAt(nString.length() - 1);
                    t.setText(nString.toString());
                    index -= 2;
                    if (index == 0 && (!Array[index].equals(""))) {
                        result = Double.parseDouble(Array[index]);
                    }
                } else {
                    Array[index] = string;
                }
                if (index > 1 && Array[index - 1] == "x") {
                    Array[index - 2] = Double
                            .toString(Double.parseDouble(Array[index - 2]) * Double.parseDouble(Array[index]));
                    result = Double.parseDouble(Array[index - 2]);
                    index -= 2;
                } else if (index > 1 && Array[index - 1] == "/") {
                    Array[index - 2] = Double
                            .toString(Double.parseDouble(Array[index - 2]) / Double.parseDouble(Array[index]));
                    result = Double.parseDouble(Array[index - 2]);
                    index -= 2;
                }
                for (int i = 0; i <= index; i++) {
                    if (Array[i].equals("+")) {
                        result = Double.parseDouble(Array[i - 1]) + Double.parseDouble(Array[i + 1]);
                        Array[i + 1] = Double.toString(result);

                    } else if (Array[i].equals("-")) {
                        result = Double.parseDouble(Array[i - 1]) - Double.parseDouble(Array[i + 1]);
                        Array[i + 1] = Double.toString(result);
                    }
                }
                if ((Double.toString(result).length() - 2) == (Double.toString(result).indexOf('.'))
                        && (Double.toString(result).charAt(Double.toString(result).length() - 1)) == '0') {
                    if (nString.toString().length() == 1) {
                        tString = new StringBuffer(Double.toString(Double.parseDouble(Array[index])));
                        tString.delete(Double.toString(Double.parseDouble(Array[index])).length() - 2,
                                Double.toString(Double.parseDouble(Array[index])).length());
                        truncateString = tString.toString();
                    } else if (nString.toString().length() == 2 && Double.parseDouble(Array[index]) < 1) {
                        tString = new StringBuffer(Double.toString(Double.parseDouble(Array[index])));
                        tString.delete(Double.toString(Double.parseDouble(Array[index])).length() - 2,
                                Double.toString(Double.parseDouble(Array[index])).length());
                        truncateString = tString.toString();
                    } else {
                        tString = new StringBuffer(Double.toString(result));
                        tString.delete(Double.toString(result).length() - 2, Double.toString(result).length());
                        truncateString = tString.toString();
                    }
                    if (index == -2)
                        t2.setText("");
                    else if (truncateString.equals("Infinity") || truncateString.equals("-Infinity")
                            || truncateString.equals("NaN"))
                        t2.setText("Error");
                    else
                        t2.setText(truncateString);
                } else {
                    truncateString = Double.toString(result);
                    if (truncateString.equals("Infinity") || truncateString.equals("-Infinity")
                            || truncateString.equals("NaN"))
                        t2.setText("Error");
                    else
                        t2.setText(truncateString);
                }
                System.out.println(nString.toString());
                if (truncateString.equals("Infinity") || truncateString.equals("NaN")
                        || truncateString.equals("-Infinity")) {
                    truncateString = "Error";
                    System.out.println("Ans: " + truncateString);
                } else if (nString.toString().length() > 0)
                    System.out.println("Ans: " + truncateString);

                /*
                 * File
                 */
                try {
                    cFilefilewWriter = new FileWriter("D:\\cFile.txt", true);
                    cFileBufferedWriter = new BufferedWriter(cFilefilewWriter);
                    if (nString.length() > 0) {
                        cFileBufferedWriter.write(nString.toString());
                        cFileBufferedWriter.newLine();
                        cFileBufferedWriter.write("Ans: " + truncateString);
                        cFileBufferedWriter.newLine();
                        cFileBufferedWriter.newLine();
                    }
                    cFileBufferedWriter.flush();
                    cFileBufferedWriter.close();

                } catch (Exception ex) {

                }
                System.out.println();
                index = 0;
                string = "";
                truncateString = "";
                nString.delete(0, nString.length());
                result = 0;
            }
        } catch (ArithmeticException ex) {
            t2.setText("Error");
        } catch (StringIndexOutOfBoundsException ex) {
            t2.setText("Field is empty");
        } catch (Exception ex) {
            t2.setText(ex.getMessage());
        }
    }

    public void init() {
        t = new TextField();
        t2 = new TextField();
        B1 = new Button("1");
        B2 = new Button("2");
        B3 = new Button("3");
        B4 = new Button("4");
        B5 = new Button("5");
        B6 = new Button("6");
        B7 = new Button("7");
        B8 = new Button("8");
        B9 = new Button("9");
        B0 = new Button("0");
        Cancel = new Button("C");
        Addition = new Button("+");
        Substraction = new Button("-");
        Multiplication = new Button("x");
        Division = new Button("/");
        Result = new Button("=");
        t.setBackground(Color.lightGray);
        t.setBounds(5, 30, 345, 150);
        t2.setBounds(5, 175, 345, 70);
        t2.setBackground(Color.lightGray);
        B1.setBounds(15, 270, 70, 40);
        B2.setBounds(100, 270, 70, 40);
        B3.setBounds(185, 270, 70, 40);
        Addition.setBounds(270, 270, 70, 40);
        B4.setBounds(15, 315, 70, 40);
        B5.setBounds(100, 315, 70, 40);
        B6.setBounds(185, 315, 70, 40);
        Substraction.setBounds(270, 315, 70, 40);
        B7.setBounds(15, 360, 70, 40);
        B8.setBounds(100, 360, 70, 40);
        B9.setBounds(185, 360, 70, 40);
        Multiplication.setBounds(270, 360, 70, 40);
        Cancel.setBounds(15, 405, 70, 40);
        B0.setBounds(100, 405, 70, 40);
        Division.setBounds(185, 405, 70, 40);
        Result.setBounds(270, 405, 70, 40);
        B1.setForeground(Color.RED);
        B2.setForeground(Color.RED);
        B3.setForeground(Color.RED);
        B4.setForeground(Color.RED);
        B5.setForeground(Color.RED);
        B6.setForeground(Color.RED);
        B7.setForeground(Color.RED);
        B8.setForeground(Color.RED);
        B9.setForeground(Color.RED);
        B0.setForeground(Color.RED);
        Addition.setForeground(Color.RED);
        Substraction.setForeground(Color.RED);
        Multiplication.setForeground(Color.RED);
        Division.setForeground(Color.RED);
        Cancel.setForeground(Color.RED);
        Result.setForeground(Color.GREEN);
        add(t);
        add(t2);
        add(B1);
        add(B2);
        add(B3);
        add(B4);
        add(B5);
        add(B6);
        add(B7);
        add(B8);
        add(B9);
        add(B0);
        add(Cancel);
        add(Addition);
        add(Substraction);
        add(Multiplication);
        add(Division);
        add(Result);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("                 History                  ");
        System.out.println("------------------------------------------");
        System.out.println();
        File f = new File("D:\\cFile.txt");
        if (!f.exists())
            f.createNewFile();
        FileReader cFilefileReader = new FileReader("D:\\cFile.txt");
        BufferedReader cFilebufferReader = new BufferedReader(cFilefileReader);
        String line = cFilebufferReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = cFilebufferReader.readLine();
        }
        cFilebufferReader.close();
        new Calculator();
    }
}