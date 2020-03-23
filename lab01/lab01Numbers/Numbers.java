package lab01Numbers;

import javax.swing.JOptionPane;

public class Numbers {
    public double firstNum;
    public double secondNum;
    
    public Numbers(double first, double second){
        this.firstNum = first;
        this.secondNum = second;
    }

    public double sumVal() {
        return this.firstNum+this.secondNum;
    }

    public double productVal(){
        return this.firstNum*this.secondNum;
    }

    public double differenceVal() {
        return this.firstNum-this.secondNum;
    } 

    public double qoutientVal() {
        return this.firstNum/this.secondNum;
    }
    public static void main(String[] args){
        String strNum1, strNum2, strNoti;
        strNoti = "You have just entered ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number", JOptionPane.INFORMATION_MESSAGE );
        strNoti+=strNum1+" and ";

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number", JOptionPane.INFORMATION_MESSAGE );
        strNoti+=strNum2;

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        Numbers result = new Numbers(num1, num2);
        JOptionPane.showMessageDialog(null, strNoti, "Show to numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, Double.toString(result.sumVal()), "Sum: ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, Double.toString(result.differenceVal()), "Difference: ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,  Double.toString(result.productVal()),"Product: ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,  Double.toString(result.qoutientVal()),"Quotient: ", JOptionPane.INFORMATION_MESSAGE);

        System.exit(1);
    }

    
}