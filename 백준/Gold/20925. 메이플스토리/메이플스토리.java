import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] dungeon = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dungeon[i][0] =  Integer.parseInt(st.nextToken());
			dungeon[i][1] =  Integer.parseInt(st.nextToken());
		}
		
		int[][] move = new int[n][n];
		
		for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		int[][] dp = new int[t+1][n];
		
		for(int i = 1; i<=t; i++){
            for(int j = 0; j<n; j++){
                if(dp[i-1][j] >= dungeon[j][0]) {
                	dp[i][j] = dp[i-1][j] + dungeon[j][1];
                }
                for(int k = 0; k<n; k++){
                    int prev = i - move[k][j]; 
                    if(j == k || prev<0) {
                    	continue; 
                    }
                
                    if(dp[prev][k] >= dungeon[j][0]) {
                    	dp[i][j] = Math.max(dp[prev][k], dp[i][j]);
                    }
                }
            }
        }


        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(max, dp[t][i]);
        }

        System.out.println(max);
	}

}
