import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] arr;
	static int n;
	static int cnt;
	static int max;
	static int mr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());
		 
		 for(int i = 0; i < t; i++) {
			 
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
//			cnt = 0;
			max = 0;
			mr = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					cnt = 1;
					
					recursive(j, k);
					
					if(cnt > max) {
						max = cnt;
						mr = arr[j][k];
					}
					else if(cnt == max && mr > arr[j][k]) {
						mr = arr[j][k];
					}
					
				}
			}
			

			System.out.println("#" + (i+1) + " " + mr + " " + max);
						
		 }
	}

	private static void recursive(int r, int c) {

		
		
		for(int i = 0; i < 4; i ++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && arr[r][c] - arr[nr][nc] == -1) {
				cnt++;
				recursive(nr, nc);
			}
		}
	}

}