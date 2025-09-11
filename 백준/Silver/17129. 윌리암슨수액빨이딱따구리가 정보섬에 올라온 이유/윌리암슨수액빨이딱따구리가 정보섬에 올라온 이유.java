import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int n;
	static int m;
	
	static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Point start = null;
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] tokens = br.readLine().split(""); 
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(tokens[j]);
				
				if(map[i][j] == 2) {
					start = new Point(i, j);
				}
			}
		}


		bfs(start);

		
		
		String result = min == Integer.MAX_VALUE ? "NIE" : "TAK";
		
		if(result.equals("NIE")) {
			System.out.println(result);	
		}
		else {
			System.out.println(result);
			System.out.println(min);
		}
		
	}

	private static void bfs(Point start) {
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		boolean[][] v = new boolean[n][m];
		q.offer(start);
		v[start.r][start.c] = true;
		int cnt = 0;

		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			for (int s = 0; s < size; s++) {
				Point cur = q.poll();
				if(map[cur.r][cur.c] > 2) {
					min = cnt-1;
					return;
				}

				
				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= m || v[nr][nc] || map[nr][nc] == 1) {
						continue;
					}
					
					v[nr][nc] = true;

					q.offer(new Point(nr, nc));
				}
				
			}

			
		}
		
		
	}

}
