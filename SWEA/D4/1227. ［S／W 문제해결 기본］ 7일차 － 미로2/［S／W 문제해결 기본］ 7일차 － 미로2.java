import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}	
	}
	
	static Point start;
	static Point end;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			map = new int[100][100];
			v = new boolean[100][100];
			
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				
				for(int j = 0; j < 100; j++) {
					int tmp = s.charAt(j) - '0';
					map[i][j] = tmp;
					
					if(tmp == 2) {
						start = new Point(i, j);
					}
					else if(tmp == 3) {
						end = new Point(i, j);
					}
				}
			}
			result = 0;
			dfs(start);
			
			System.out.println("#" + tc + " " + result);
			
		}	
	}

	private static void dfs(Point p) {
		
		if(p.r == end.r && p.c == end.c) {
			result = 1;
			return;
		}
		
		v[p.r][p.c] = true;
		
		
		for(int i = 0 ; i < 4; i++) {
			int nr = p.r + dr[i];
			int nc = p.c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= 100 || nc >= 100) {
				continue;
			}
			
			if(map[nr][nc] == 0 || map[nr][nc] == 3) {
				if(!v[nr][nc]) {
					dfs(new Point(nr, nc));
				}
			}
		}
	}
	
}
