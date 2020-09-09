package problems.PrimePlates;
import java.util.*;
import java.io.*;

public class PrimePlateSolution {

	public PrimePlateSolution() {
		// TODO Auto-generated constructor stub
	}
	static Stack<Integer> data = new Stack<>();
    static Stack<Integer> divisible = new Stack<>();
    static Stack<Integer> non_divisible = new Stack<>();

    static int getPrime(int current_prime){
        boolean isPrime = false;
        int prime = current_prime;
        while(!isPrime){
            prime++;
            isPrime = true;
            if(prime%2==0&&prime>2){
                isPrime = false;
            } else {
                for(int i=2; i<=prime/2; i++){
                    if(prime%i==0){
                        isPrime=false;
                        break;
                    }
                }
            }
        }
        return prime;
    }
    static void printStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    static void output(int q){
        int current_prime=2;
        for(int i=0; i<q; i++){
            non_divisible.clear();
            while(!data.isEmpty()){
                int num = data.pop();
                if(num % current_prime==0) divisible.add(num);
                else non_divisible.add(num);
            }
            printStack(divisible);
            current_prime = getPrime(current_prime);
            data = (Stack<Integer>) non_divisible.clone();
        }
        printStack(non_divisible);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for(int i=0; i<n; i++){
            data.add(scanner.nextInt());
        }
        output(q);
    }

}
