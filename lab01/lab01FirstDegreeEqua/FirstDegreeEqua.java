package lab01FirstDegreeEqua;

import javax.swing.JOptionPane;

public class FirstDegreeEqua{
    public double firstDeg;
    public double freeDeg;

    public FirstDegreeEqua(double firstDeg, double freeDeg){
        this.firstDeg = firstDeg;
        this.freeDeg = freeDeg;
    }

    public String Solve(){
        String result;
        if(firstDeg==0) if(freeDeg==0) return result = "Equation has infinite solution";
            else return result = "Equation has no solution";
        else {
            result = Double.toString(-freeDeg/firstDeg);
            return result;
        }
    }
    public static boolean checkParam(String in){
        try{
            if("".equals(in)) {
                JOptionPane.showMessageDialog(null, "input must be filled", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            Double.parseDouble(in);
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "input must be a number", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String strNum1, strNum2, strNoti;
        strNoti = "You have just entered ";

        do {strNum1 = JOptionPane.showInputDialog(null, "Please input coefficient A.x", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(strNum1));
        strNoti+=strNum1+" and ";
        do {strNum2 = JOptionPane.showInputDialog(null, "Please input coefficient B", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(strNum2));
        strNoti+=strNum2;

        JOptionPane.showMessageDialog(null, strNoti, "Input numbers", JOptionPane.INFORMATION_MESSAGE);
        
        double firstDeg = Double.parseDouble(strNum1);
        double freeDeg = Double.parseDouble(strNum2);

        FirstDegreeEqua result = new FirstDegreeEqua(firstDeg, freeDeg);
        JOptionPane.showMessageDialog(null, result.Solve(), "Solutions", JOptionPane.INFORMATION_MESSAGE);
        System.exit(1);
    }

}