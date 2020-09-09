package problems.GameOf2Stacks;
import java.util.*;
import java.io.*;


public class GameOf2StackSolution {

	public GameOf2StackSolution() {
		// TODO Auto-generated constructor stub
	}
	 static int twoStacks(int x, int[] a, int[] b) {
	        
	        int sum = 0;
	        
	        int step = 0;
	        
	        int i = 0;
	        int j = 0;
	        
	        while(i < a.length && x >= sum + a[i]){
	            sum += a[i++];
	            step++;
	        }
	        
	        while(j < b.length && x >= sum + b[j]){
	            sum += b[j++];
	            step++;
	        }
	        
	        if(j == b.length)
	            return step;
	        
	        int max = step;
	        
	        for(; i > 0; i--){
	            
	            if(j == b.length)
	                    break;
	            
	            sum -= a[i-1];
	            step--;
	            
	            while(j < b.length && sum + b[j] <= x){
	                sum += b[j++];
	                step++;
	            }
	            
	            max = Math.max(step, max);
	        }
	        
	        return max;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int g = Integer.parseInt(scanner.nextLine().trim());

	        for (int gItr = 0; gItr < g; gItr++) {
	            String[] nmx = scanner.nextLine().split(" ");

	            int n = Integer.parseInt(nmx[0].trim());

	            int m = Integer.parseInt(nmx[1].trim());

	            int x = Integer.parseInt(nmx[2].trim());

	            int[] a = new int[n];

	            String[] aItems = scanner.nextLine().split(" ");

	            for (int aItr = 0; aItr < n; aItr++) {
	                int aItem = Integer.parseInt(aItems[aItr].trim());
	                a[aItr] = aItem;
	            }

	            int[] b = new int[m];

	            String[] bItems = scanner.nextLine().split(" ");

	            for (int bItr = 0; bItr < m; bItr++) {
	                int bItem = Integer.parseInt(bItems[bItr].trim());
	                b[bItr] = bItem;
	            }

	            int result = twoStacks(x, a, b);

	            bufferedWriter.write(String.valueOf(result));
	            bufferedWriter.newLine();
	        }

	        bufferedWriter.close();
	    }
}
