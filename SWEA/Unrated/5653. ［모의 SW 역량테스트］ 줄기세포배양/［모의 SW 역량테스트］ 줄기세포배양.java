import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Solution {
	static int n, m, k;
	static int[][] map;
	
	static class Cell implements Comparable<Cell>{
		int r, c, origin, time, status;
		
		Cell(int r, int c, int time) {
			this.c = c;
			this.r = r;
			this.origin = time;
			this.time = time;
			this.status = 1;
		}
		
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.origin, o.origin)*-1; // 원본 로직 유지하되 origin으로 비교
		}
	
	}
	
	static PriorityQueue<Cell> pq;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n + 360][m + 360];
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < m; j++) {
					int r = (n+k)/2 + i;
					int c = (m+k)/2 + j;
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] != 0) {
						pq.offer(new Cell(r, c ,map[r][c]));
					}
				}
			}
			
			for (int i = 1; i <= k; i++) {
				check();
			}
			
			System.out.println("#" + tc + " " + pq.size());
		}
		
	}
	private static void bfs(Cell cur) {
		
		for (int i = 0; i < 4; i++) {
			int nr = cur.r + dr[i];
			int nc = cur.c + dc[i];
					
			if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] != 0) { // map[nr][nc] == -1 제거
				continue;
			}
					
			map[nr][nc] = cur.origin;
			pq.offer(new Cell(nr, nc, cur.origin));
		}
	}
	//pq에 있는 줄기세포를 돌면서 계산
	private static void check() {
		PriorityQueue<Cell> q = new PriorityQueue<>();
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			
			Cell cur = pq.poll();
			
			cur.time -= 1;
			
			q.offer(cur);
		}
		
		int size2 = q.size();
		for (int i = 0; i < size2; i++) {
			Cell tmp = q.poll();
			if(tmp.status == 0 && tmp.time == tmp.origin-1) {
				bfs(tmp);
			}
			
			if(tmp.time == 0 && tmp.status == 1) {
				tmp.status -= 1;
				tmp.time = tmp.origin;
			}
			else if(tmp.time == 0 && tmp.status == 0) {
				tmp.status -= 1;
				continue;
			}
			
			pq.offer(tmp);
		}
		
		
	}
}