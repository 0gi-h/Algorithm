import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] s;
	static int n = 6;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				break;
			}
			
			s = new int[k];
			sel = new int[n];
			
			for(int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			recursive(0, 0);
			System.out.println();
		}
	}

	private static void recursive(int idx, int p) {
		
		if(p == n) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < n; i++) {
				sb.append(sel[i] + " ");
			}

			System.out.println(sb);
			return;
		}
		
		if(idx == s.length) {
			
			return;
		}
		
		sel[p] = s[idx];
		recursive(idx+1, p+1);
		recursive(idx+1, p);
	}

}
