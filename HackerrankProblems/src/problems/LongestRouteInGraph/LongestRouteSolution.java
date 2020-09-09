package problems.LongestRouteInGraph;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class LongestRouteSolution {

	public LongestRouteSolution() {
		// TODO Auto-generated constructor stub
	}
	
	private static HashMap<Integer, ArrayList<Integer>> graph;  
    private static int curCount;            

    static int[] componentsInGraph(int[][] gb) {
        graph = buildGraph(gb);    
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        int shortest = Integer.MAX_VALUE;
        int longest = 0;

    
        for(Integer i : graph.keySet()){        
            if(visited.get(i) == null){         
            curCount = 0;                   
            DFSSearch(i, visited);          
            longest = Math.max(curCount, longest);  
            shortest = Math.min(curCount, shortest);
        }
    }

        int[] ans = {shortest, longest};
        return ans;
    }

    private static void DFSSearch(int curVal, HashMap<Integer, Boolean> visited){
        visited.put(curVal, true);
        curCount++;            
        for(Integer i : graph.get(curVal)){ 
            if(visited.get(i) == null) {  
                    DFSSearch(i, visited);    
            }
        }
    }
    private static HashMap<Integer, ArrayList<Integer>> buildGraph(int[][] gb){
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    for(int[] edge : gb){
        int e0 = edge[0];
        int e1 = edge[1];

        if(graph.get(e0) == null){
            graph.put(e0, new ArrayList<Integer>());
        }
        if(graph.get(e1) == null){
            graph.put(e1, new ArrayList<Integer>());
        }

        graph.get(e0).add(e1);
        graph.get(e1).add(e0);
    }

    return graph;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

}
