package lab01.lab01Ex1234;

import javax.swing.JOptionPane;

public class Ex1234{
    public static void ex1(){
        System.out.println("Xin chao \t cac ban.");
        System.out.println("Hello \t World.");
    }

    public static void ex2(){
        JOptionPane.showMessageDialog(null, "Hello \t World. How are you?");
    }

    public static void ex3(){
        String result;
        result = JOptionPane.showInputDialog("Please enter your name");
        JOptionPane.showMessageDialog(null, "Hello \t"+result+". How are you?");
    }

    public static void ex4(){
        String strNum1, strNum2, strNoti;
        strNoti = "You have just entered ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number", JOptionPane.INFORMATION_MESSAGE );
        strNoti+=strNum1+" and ";

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number", JOptionPane.INFORMATION_MESSAGE );
        strNoti+=strNum2;

        JOptionPane.showMessageDialog(null, strNoti, "Show to numbers", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        ex1();
        ex2();
        ex3();
        ex4();
        System.exit(1);
    }
}