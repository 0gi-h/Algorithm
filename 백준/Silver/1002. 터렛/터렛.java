import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		double box = 0;
		
		for(int i = 0; i < T; i++)
		{
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			box = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1 - y2, 2));
			
			if(x1 == x2 && y1 == y2 && r1 == r2)
			{
				System.out.println(-1);
			}
			else if(box == r1 + r2)
			{
				System.out.println(1);
			}
			else if(box == Math.abs(r1 - r2))
			{
				System.out.println(1);
			}
			else if(Math.abs(r1 - r2) < box && box < Math.abs(r1 + r2))
			{
				System.out.println(2);
			}
			else
			{
				System.out.println(0);
			}
		}
		
		sc.close();
	}
}