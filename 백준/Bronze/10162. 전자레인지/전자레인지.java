import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int box = 0;
		int A = 0, B = 0, C = 0;
		
		for(int i = 0; i <= N / 300; i++)
		{
			for(int j = 0; j <= N / 60; j++ )
			{
				for(int k =0; k <= N / 10; k++)
				{
					if(N == 300*i + 60*j + 10*k) 
					{
						if(box == 0)
						{
							box = i + j + k;
							
						}
						box = box > (i + j + k) ? (i + j + k) : box;
						A = i;
						B = j;
						C = k;
					}
				}
			}
		}
		if(box == 0)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(A+" "+B+" "+C);
		}
	}
}