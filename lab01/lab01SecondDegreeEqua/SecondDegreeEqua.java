package lab01SecondDegreeEqua;

import javax.swing.JOptionPane;

public class SecondDegreeEqua{
    public double secondDeg;
    public double firstDeg;
    public double freeDeg;

    public SecondDegreeEqua(double secondDeg, double firstDeg, double freeDeg){
        this.secondDeg = secondDeg;
        this.firstDeg = firstDeg;
        this.freeDeg = freeDeg;
    }

    public String Solve(){
        String result;
        double delta = firstDeg*firstDeg-4*secondDeg*freeDeg;
        if(delta==0) return result = "X1 = X2= "+Double.toString(-firstDeg/2*secondDeg);
            else if(delta<0) return result = "Equation has no solution";
        else {
            result = "X1 = "+Double.toString((-firstDeg-Math.sqrt(delta))/2*secondDeg)+"\nX2 = "+Double.toString((-firstDeg+Math.sqrt(delta))/2*secondDeg);
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
    public static boolean checkZero(String in){
        if("0".equals(in)){
            JOptionPane.showMessageDialog(null, "Input must be different from 0", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String A, B, C, strNoti;
        strNoti = "You have just entered ";

        do {A = JOptionPane.showInputDialog(null, "Please input coefficient A.x.x", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(A)||!checkZero(A));
        
        do {B = JOptionPane.showInputDialog(null, "Please input coefficient B.x", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(B));

        do {C = JOptionPane.showInputDialog(null, "Please input coefficient C", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(C));
        strNoti+=A+" "+B+" "+C;

        JOptionPane.showMessageDialog(null, strNoti, "Input numbers", JOptionPane.INFORMATION_MESSAGE);
        
        double secondDeg = Double.parseDouble(A);
        double firstDeg = Double.parseDouble(B);
        double freeDeg = Double.parseDouble(C);

        SecondDegreeEqua result = new SecondDegreeEqua(secondDeg, firstDeg, freeDeg);
        JOptionPane.showMessageDialog(null, result.Solve(), "Solutions", JOptionPane.INFORMATION_MESSAGE);

    }

}