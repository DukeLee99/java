package lab01FirstDegreeSys;

import javax.swing.JOptionPane;

public class FirstDegreeSys{
    public double A1;
    public double B1;
    public double C1;
    public double A2;
    public double B2;
    public double C2;


    public FirstDegreeSys(double firstDegA1, double firstDegB1, double freeDegC1, double firstDegA2, double firstDegB2, double freeDegC2){
        this.A1 = firstDegA1;
        this.B1 = firstDegB1;
        this.A2 = firstDegA2;
        this.B2 = firstDegB2;
        this.C1 = freeDegC1;
        this.C2 = freeDegC2;
    }



    public String Solve(){
        String result;
        double D, Dx, Dy;
        D = A1*B2-A2*B1;
        Dx=C1*B2-C2*B1;
        Dy=A1*C2-A2*C1;
        if(D==0) if(Dx==0 && Dy==0) return result = "Equation has infinite solution";
            else return result = "Equation has no solution";
        else {
            result = "X="+Double.toString(Dx/D)+"\nY="+Double.toString(Dy/D);
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
        String A1, A2, B1, B2, C1, C2, strNoti;
        strNoti = "You have just entered ";

        do {A1 = JOptionPane.showInputDialog(null, "Please input coefficient A1.x", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(A1));
        do {B1 = JOptionPane.showInputDialog(null, "Please input coefficient B1.y", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(B1));
        do {C1 = JOptionPane.showInputDialog(null, "Please input coefficient C1", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(C1));

        do {A2 = JOptionPane.showInputDialog(null, "Please input coefficient A2.x", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(A2));
        do {B2 = JOptionPane.showInputDialog(null, "Please input coefficient B2.y", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(B2));
        do {C2 = JOptionPane.showInputDialog(null, "Please input coefficient C2", JOptionPane.INFORMATION_MESSAGE );}
        while(!checkParam(C2));

        strNoti+=A1+" "+B1+" "+C1+" "+A2+" "+B2+" "+C2+".";

        JOptionPane.showMessageDialog(null, strNoti, "Input numbers", JOptionPane.INFORMATION_MESSAGE);
        
        double A1x = Double.parseDouble(A1);
        double B1y = Double.parseDouble(B1);
        double C11 = Double.parseDouble(C1);
        double A2x = Double.parseDouble(A2);
        double B2y = Double.parseDouble(B2);
        double C22 = Double.parseDouble(C2);

        FirstDegreeSys result = new FirstDegreeSys(A1x, B1y, C11, A2x, B2y, C22);
        JOptionPane.showMessageDialog(null, result.Solve(), "Solutions", JOptionPane.INFORMATION_MESSAGE);
        System.exit(1);
    }
}