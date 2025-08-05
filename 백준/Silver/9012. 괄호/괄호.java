import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		for (int i = 0; i < n; i++)
		{
			String s = sc.next();
			
			for(int j = 0; j <s.length(); j++)
			{
				if (s.charAt(j) == '(')
				{
					sum += 1;
				}
				else if (s.charAt(j) == ')')
				{
					sum -= 1;
					if (sum < 0)
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
			
			
			if (sum == 0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			sum = 0;
		}

	}
}
