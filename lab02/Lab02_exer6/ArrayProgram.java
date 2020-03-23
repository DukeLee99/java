package lab02.Lab02_exer6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayProgram {
    private int[] arr;

    public ArrayProgram(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public int sumArr() {
        int i, sum=0;
        for(i=0; i<this.arr.length; ++i){
            sum+=this.arr[i];
        }
        return sum;
    }

    public double avgArr() {
        int sum = this.sumArr();
        double avg = sum/this.arr.length;
        return avg;
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortArr(int[] a, int left,  int right) {
        if(right <= left) {
	        return;
	    }
	    
	    int start = left;
	    int end = right;
	    int i = left;
	    int pivot = a[left];
	    
	    while(i <= end) {
	        if(a[i] < pivot) {
	            swap(a, i, start);
	            i++;
	            start++;
	        } else if(a[i] > pivot) {
	            swap(a, i, end);
	            end--;
	        } else {
	            i++;
	        }
	    }
	    
	    sortArr(a, left, start-1);
	    sortArr(a, end+1, right);
        return;
    }

    public static void printArr(int[] a) {
        for(int i=0; i<a.length; i++) System.out.print(a[i]+" ");
        System.out.print("\n");
    }
    public static void main(String[] args){
        System.out.println("******* ARRAY PROGRAM ********");
        Scanner scan = new Scanner(System.in);

        int n;
        System.out.println("Enter the number of elements");
        n = scan.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter number: ");
        for(int i =0; i<n; i++) arr[i] = scan.nextInt();

        System.out.println("Array after sort: ");
        sortArr(arr, 0, arr.length-1);
        printArr(arr);
        
        ArrayProgram numArr = new ArrayProgram(arr);
        System.out.println("Sum of elements: "+numArr.sumArr());
        System.out.println("Average value: "+numArr.avgArr());

        System.exit(1);
    }
}