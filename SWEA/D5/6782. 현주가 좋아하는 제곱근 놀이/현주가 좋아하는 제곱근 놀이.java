import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int cnt;
	static int c;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			long n = Long.parseLong(br.readLine());
			
			cnt = 0;
			c = 0;
			
			check(n, cnt, i);
		}
	}

	private static void check(long n, int cnt, int idx) {
		
        while (n != 2) {
            long sqrt = (long) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                n = sqrt;
                cnt++;
                
            } else {
                long next = (sqrt + 1) * (sqrt + 1);
                cnt += (int)(next - n);
                n = next;
            }
        }
		
		System.out.println("#" + (idx + 1) + " " + cnt);
	}
}