import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int r;
	static int[][] map;
	static int[][] copy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		copy = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				copy[i][j] = tmp;
			}
		}
		
		turn();
		
	}

	private static void turn() {

		for (int i = 0; i < r; i++) {
			int idx = 0;
			
			for (int j = 0; j < Math.min(n, m) / 2 ; j++, idx++) {
				
				for (int k = m-1-idx; k >= 1+idx; k--) {
					copy[j][k-1] = map[j][k];
				}
				
				for (int k = 0+idx; k < n-1-idx; k++) {
					copy[k+1][j] = map[k][j];
				}
	
				for (int k = 0+idx; k < m-1-idx; k++) {
					copy[n-j-1][k+1] = map[n-j-1][k];
				}
	
				for (int k = n-1-idx; k >= 1+idx; k--) {
					copy[k-1][m-j-1] = map[k][m-j-1];
				}
			}
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[0].length; k++) {
					map[j][k] = copy[j][k];
				}
			}
			

		}
		
		for (int j = 0; j < map.length; j++) {
			for (int k = 0; k < map[0].length; k++) {
				System.out.print(map[j][k] + " ");
			}
			System.out.println();
		}
		
	}

}
