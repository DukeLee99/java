package problems.ShortestPathWithGrid;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class ShortestPathWithGridSolutions {

	public ShortestPathWithGridSolutions() {
		// TODO Auto-generated constructor stub
	}
	
	static int path[][], visited[][];
    static Queue <Node> move = new LinkedList<Node>();
    static int n;

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)    {

        n = grid.length;
        path = new int[n][n];
        visited = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j) == '.')
                    path[i][j] = 10000;
                else path[i][j] = -1;
            }
        }

        Node start = new Node(startX, startY);
        move.add(start);
        path[startX][startY] = 0;
        while(!move.isEmpty()){
            Node current = move.remove();
            if(visited[current.x][current.y] == 0){
                visited[current.x][current.y] = 1;
                moveGenerator(current);
            }
        }

        return path[goalX][goalY];

    }

    public static void moveGenerator(Node p){

        int x = p.x;
        int y = p.y;
        int value = path[x][y];
        for(int i=x; i<n && path[i][y]!=-1;i++){
            addStep(i,y,value);
            move.add(new Node(i,y));
        }
        for(int i=x; i>=0 && path[i][y]!=-1;i--){
            addStep(i,y,value);
            move.add(new Node(i,y));
        }
        for(int i=y; i<n && path[x][i]!=-1;i++){
            addStep(x,i,value);
            move.add(new Node(x,i));
        }
        for(int i=y; i>=0 && path[x][i]!=-1;i--){
            addStep(x,i,value);
            move.add(new Node(x,i));
        }
    }

    public static void addStep(int x, int y, int value){

        if(path[x][y] > value+1)
            path[x][y] = value+1;
    }   

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
