package Lab02_exer5;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class Days{ 
   
    private int month;
    private int year;

    public Days(int month, int year){
        this.month = month;
        this.year = year;
    }

    public static boolean check(int month) {
        int maxM = 12;
        int minM = 1;
        if(month<minM||month>maxM) return false;
        return true;
    }

    public int calculate(){
        List<Integer> M30 = Arrays.asList(4, 6, 9, 11);
        List<Integer> M31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        if(M30.contains(this.month)) return this.month=30;
        else if(M31.contains(this.month)) return this.month = 31;
        else{
            if(this.year%100==0)
                if(this.year%400==0) return this.month = 29;
                else return this.month=28;
            else {
                if(this.year%4==0) return this.month = 29;
                else return this.month=28;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("******** CHECK NUMBER OF DAYS IN MONTH ********");
        row = scan.nextInt();
        int month, year;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the year to check: ");
        year = scan.nextInt();
        do{
            System.out.print("Enter month to check: ");
            month = scan.nextInt();
        } while(!check(month));

        Days days = new Days(month, year);
        System.out.println("Number of days in "+month+" in "+year+" is: "+days.calculate());
    }
}