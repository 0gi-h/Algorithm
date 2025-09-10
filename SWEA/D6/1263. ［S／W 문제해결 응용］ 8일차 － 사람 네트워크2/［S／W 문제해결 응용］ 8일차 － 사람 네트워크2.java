import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
	
		StringTokenizer st;
	
		for (int tc = 1; tc <= t; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int result = 10001;
			
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if(arr[i][j] == 0) {
						arr[i][j] = 10001;
					}
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					if(i == k) continue;
					
					for (int j = 0; j < n; j++) {
						if(j == k || j == i) continue;
						
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
			
			
			for (int i = 0; i < n; i++) {
				int tmp = 0;
				
				for (int j = 0; j < n; j++) {
					if(arr[i][j] < 10001) {
						tmp += arr[i][j];
					}
				}
				
				result = Math.min(result, tmp);
			}
			
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
