import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	static String[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			map = new String[4][4];
			set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken();
					
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					StringBuilder sb = new StringBuilder();
					dfs(i, j, sb);
				}
				
			}

			System.out.println("#" + tc + " " + set.size());
		}
		
		
	}

	private static void dfs(int r, int c, StringBuilder sb) {
		if(sb.length() >= 7) {
			String tmp = sb.toString();
			set.add(tmp);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < 4 && nc < 4 && sb.length() <= 7) {
				dfs(nr, nc, sb.append(map[nr][nc]));
				sb.deleteCharAt(sb.length()-1);
			}
					
		}
		
	}

}
