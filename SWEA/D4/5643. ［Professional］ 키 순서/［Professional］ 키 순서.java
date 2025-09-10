import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			int m = Integer.parseInt(br.readLine().trim());
			int cnt = 0;
			int[][] arr = new int[n+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] =  10001;
				}
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a] = 1;
				
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					if(i == k) continue;
					
					for (int j = 1; j <= n; j++) {
						if(j == k || i == k) continue;
						
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
			
			int[] tmp = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if((arr[i][j] > 0 && arr[i][j] < 10001) || (arr[j][i] > 0 && arr[j][i] < 10001)) {
						tmp[i]++;
					}
				}
				if(tmp[i] == n-1) {
					cnt++;
				}
			}
			
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
