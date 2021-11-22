import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, sum;
	    ArrayList<Integer> items = new ArrayList<Integer>();

	    Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of value to be added :");
		n = scan.nextInt();
		if(n>1) {
			System.out.println("Enter the n elements :");
			for(int i=0; i<n; i++) {
				int a;
				a = scan.nextInt();
				items.add(i,a);
			}
			sum = 0;
			for(int i=0; i<n; i++) {
				sum = sum + items.get(i);
			}

			System.out.println("The Sum is :"+sum);
		}
		else if(n==1)
			System.out.println("INVALID!!!, Enter atleast two numbers!");
		else
			System.out.println("INVALID!!!, No number entered");
	}
	

}
