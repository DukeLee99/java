package Lab02_exer4;

import java.util.Scanner;

public class Triangle {
    private int degree;

    public Triangle(int degree){
        this.degree=degree;
    }

    public void draw(){
        int j;
        for(int i=1; i<this.degree; i++){
            for(j=0; j<this.degree-i; j++) System.out.print(" ");
            for(j=0; j<2*i-1; j++) System.out.print("*");
            System.out.print("\n");
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("***** TRIANGLE DRAWING ********");
        row = scan.nextInt();
        int degree;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the degree of the triangle: ");
        degree = scan.nextInt();
        Triangle tri = new Triangle(degree);
        tri.draw();

        System.exit(1);
    }
}