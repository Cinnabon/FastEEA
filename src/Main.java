import java.util.Scanner;

public class Main {

	public static void printLine(int x, int y, int r, int q, int i)
	{	System.out.println("Iteration "+i+": ");
		System.out.print("x = "+x+", ");
		System.out.print("y = "+y+", ");
		System.out.print("r = "+r+", ");
		System.out.print("q = "+q+"\n");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x,y,r,q;
		int r_prev, r_prev2;
		int x_prev, x_prev2;
		int y_prev, y_prev2;
		int iteration = 1;
		
		//TODO: handle type mismatch exception
		System.out.print("Enter a: ");
		int a = in.nextInt();
		System.out.print("Enter b: ");
		int b = in.nextInt();
		
		//TODO: optimize on case a==b
		
		if (b>a)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		
		x = 1; y = 0; r = a; q = 0;
		printLine(x,y,r,q,iteration);
		iteration++;
		x = 0; y = 1; r = b; q = 0;
		printLine(x,y,r,q,iteration);
		iteration++;
		
		r_prev = b;
		r_prev2 = a;
		x_prev = 0;
		x_prev2 = 1;
		y_prev = 1;
		y_prev2 = 0;
		
		while (r!=0)
		{
			q = r_prev2/r_prev; //implied ceil
			x = x_prev2 - q*x_prev;
			y = y_prev2 - q*y_prev;
			r = r_prev2 - q*r_prev;
			printLine(x,y,r,q,iteration);
			r_prev2 = r_prev; 
			r_prev = r;
			x_prev2 = x_prev; 
			x_prev = x;
			y_prev2 = y_prev; 
			y_prev = y;
			iteration++;
		}
		System.out.println("\nSo, the GCD is "+r_prev2);
	}
}
