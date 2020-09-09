package problems.DownToZero;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Node {
    int depth;
    int value;
    public Node(int value, int depth){
        this.value = value;
        this.depth = depth;
    }
}

public class Solution {

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(Node root) {
        /*
         * Write your code here.
         */
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(root);
        int min = 100001;
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if(current.value <= 4){
                if (current.value == 4){
                    min = current.depth + 3;
                    return min;
                }
                min = current.depth+current.value;
                return min;
            }
                Node toAdd1 = new Node(current.value-1, current.depth+1);
                queue.add(toAdd1);
                for(int i = 2; i<=Math.sqrt(current.value); i++){
                    if(current.value%i==0){
                        Node toAdd = new Node(current.value/i, current.depth+1);
                        queue.add(toAdd);
                    }
                }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            Node root = new Node(n, 0);
            int result = downToZero(root);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
