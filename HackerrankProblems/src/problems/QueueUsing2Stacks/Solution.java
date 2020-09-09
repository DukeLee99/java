package problems.QueueUsing2Stacks;

import java.io.*;
import java.util.*;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int noElements = in.nextInt();
        
        Stack<Integer> inStack = new Stack<>();		//Initialized stack
        Stack<Integer> outStack = new Stack<>();	//Stack to get element
        
        int command;
        for(int i=0; i<noElements; i++) {
        	command = in.nextInt();
        	if(command == 1) {
        		inStack.push(in.nextInt());			//push to Initialize stack
        	}
        	else if(command==2) {
        		if(outStack.isEmpty()) {
        			while(!inStack.isEmpty()) {
        				outStack.push(inStack.pop());	//If outStack empty, push from inStack to outStack to re-arrange elements
        			}
        			outStack.pop();						//pop element from outStack
        		} else {
        			outStack.pop();						//pop element from outStack
        		}
        	}
        	else if(command==3) {
        		if(outStack.isEmpty()) {
        			while(!inStack.isEmpty()) {
        				outStack.push(inStack.pop());	//If outStack empty, push from inStack to outStack to re-arrange elements
        			}
        			System.out.println(outStack.peek());	//pop and print element from outStack
        		} else {
        			System.out.println(outStack.peek());	//pop and print element from outStack
        		}
        	}
        }
        in.close();
    }
}
