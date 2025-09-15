import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<String> deck1 = new ArrayDeque<>();
			ArrayDeque<String> deck2 = new ArrayDeque();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				if(n%2== 0 && i < n/2) {
					deck1.offer(st.nextToken());
				}
				else if(n%2== 1 && i <= n/2) {
					deck1.offer(st.nextToken());
				}
				else {
					deck2.offer(st.nextToken());
				}
			}
			
			System.out.print("#" + tc +" ");
			
			for (int i = 0; i < n; i++) {
				if(i%2 == 0) {
					System.out.print(deck1.poll() +" ");
				}
				else {
					System.out.print(deck2.poll() + " ");
				}
			}
			System.out.println();
		}
		
	}

}
