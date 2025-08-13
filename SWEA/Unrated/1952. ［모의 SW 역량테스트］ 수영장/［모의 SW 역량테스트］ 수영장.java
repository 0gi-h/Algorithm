import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] fees;
	static int[] plan;
	static int sum;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			fees = new int[4];
			plan = new int[12];
			sum = 0;
            min = Integer.MAX_VALUE;
			
			for(int j = 0; j < 4; j++) {
				fees[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 12; j++) {
				plan[j] = Integer.parseInt(st.nextToken());
			}
			
			
			check(0);
			
            min = Math.min(min, fees[3]);
            
			System.out.println("#" + (i+1) + " " + min);
		}

	}
	
	public static void check(int idx) {
		
		if(idx >= plan.length) {
			
			min = Math.min(sum, min);
			
			//check(idx+1, fee+1);
			
			return;
		}
		
		if(plan[idx] != 0) {
			sum += plan[idx] * fees[0];
			check(idx+1);
			sum -= plan[idx] * fees[0];
			
			
			sum += fees[1];
			check(idx+1);
			sum -= fees[1];
			

			sum += fees[2];
			check(idx+3);
			sum -= fees[2];
		}
		else {
			check(idx+1);
		}
	
		
	}

}
