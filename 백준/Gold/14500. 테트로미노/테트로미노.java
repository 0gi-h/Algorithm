import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		v = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 위치에서 DFS + 'ㅗ' 체크
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				v[i][j] = true;
				search(i, j, 0, map[i][j]);
				v[i][j] = false;
				check(i, j); // 'ㅗ' 모양 처리
			}
		}
		
		System.out.println(result);
	}

	private static void search(int sr, int sc, int idx, int tmp) {
		if(idx == 3) {
			result = Math.max(result, tmp);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < n && nc < m && !v[nr][nc]) {
				v[nr][nc] = true;
				search(nr, nc, idx+1, tmp+map[nr][nc]);
				v[nr][nc] = false;
			}
		}
		
	}

	private static void check(int r, int c) {
		int[][][] shapes = {
				// ㅗ
				{{0, 0}, {0, -1}, {0, 1}, {-1, 0}},
				// ㅜ
				{{0, 0}, {0, -1}, {0, 1}, {1, 0}},
				// ㅓ
				{{0, 0}, {-1, 0}, {1, 0}, {0, -1}},
				// ㅏ
				{{0, 0}, {-1, 0}, {1, 0}, {0, 1}}
			};

		for (int[][] shape : shapes) {
			int sum = 0;
			boolean isValid = true;
			for (int[] d : shape) {
				int nr = r + d[0];
				int nc = c + d[1];
				if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
					sum += map[nr][nc];
				} else {
					isValid = false;
					break;
				}
			}
			if (isValid) {
				result = Math.max(result, sum);
			}
		}
	}
}
