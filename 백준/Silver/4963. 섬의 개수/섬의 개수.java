import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			map =  new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < w; j++) {
					 map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < h; i++) {				
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	static void dfs(int r, int c) {
		
		if(map[r][c] == 0 || visited[r][c] == true) {
			return;
		}
		
		
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1) {
				visited[r][c] = true;
				dfs(nr, nc);
			}
		}
	}

}
