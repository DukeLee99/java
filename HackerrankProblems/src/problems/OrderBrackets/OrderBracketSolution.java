package problems.OrderBrackets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class OrderBracketSolution {

	public OrderBracketSolution() {
		// TODO Auto-generated constructor stub
	}
	
	static char[] open = {'(', '[', '{'};
    static char[] close = {')',']','}'};

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        String yes = "YES";
        String no = "NO";
        char[] sArray = s.toCharArray();
        Stack<Character> order = new Stack<>();
        int length = s.length();
        char bracket;
        char pair;
        for (int i = 0; i<length; i++){
            bracket = sArray[i];
            if(bracket == open[0]||bracket==open[1]||bracket==open[2])
                order.push(bracket);
            if(bracket==close[0]){
                if (order.empty()||order.pop()!=open[0]) return no;
            }
            if(bracket==close[1]){
                if (order.empty()||order.pop()!=open[1]) return no;
            }
            if(bracket==close[2]){
                if (order.empty()||order.pop()!=open[2]) return no;
            }
        }
        return order.empty() ? yes : no;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
