import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static boolean[][] v;
	static Node start;
	static Node end;
	
    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			v = new boolean[n][n];
			
			for(int j = 0; j < n ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 0; j < 2 ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				Node point = new Node(x, y);
				
				if(j == 0) {
					start = point;	
				}
				else if(j == 1) {
					end = point;
				}
				
			}
			
			
			int result = bfs();
			
			System.out.println("#" + i + " " + result);
		}
		
	}

	private static int bfs() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(start);
		v[start.r][start.c] = true; 
		int sec = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int step = 0; step < size; step++) {
				Node curr = q.poll();
				if(curr.r == end.r && curr.c == end.c) {
					return sec;
				}
				
				for(int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || v[nr][nc] ) {
	                    continue;
	                }

	                if(map[nr][nc] == 1) {
	                    continue;
	                }
	                
	                v[curr.r][curr.c] = true;
	                
	                if(map[nr][nc] == 2 && sec%3!=2) {
	                	q.offer(new Node(curr.r, curr.c));
	                }

	                else {
	                    q.offer(new Node(nr, nc));
	                }
				}
			}
			sec++;
		}
		return -1;
	}

}
