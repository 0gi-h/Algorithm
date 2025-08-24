import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int islandNum = 2;
    static int[][] bridge;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new boolean[n][m];

        HashSet<Integer>[] row = new HashSet[n];
        HashSet<Integer>[] col = new HashSet[m];

        for (int i = 0; i < n; i++) row[i] = new HashSet<>();
        for (int i = 0; i < m; i++) col[i] = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    dfs(i, j, islandNum);
                    islandNum++;
                }
            }
        }

 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 1) {
                    row[i].add(map[i][j]);
                    col[j].add(map[i][j]);
                }
            }
        }


        bridge = new int[islandNum][islandNum];
        for (int i = 0; i < islandNum; i++) {
            Arrays.fill(bridge[i], Integer.MAX_VALUE);
        }

        
        for (int i = 0; i < n; i++) {
            if (row[i].size() < 2) continue;

            int from = 0;
            int len = 0;

            for (int j = 0; j < m; j++) {
                if (map[i][j] > 1) {
                    if (from != 0 && from != map[i][j] && len >= 2) {
                        int to = map[i][j];
                        bridge[from][to] = Math.min(bridge[from][to], len);
                        bridge[to][from] = bridge[from][to];
                    }
                    from = map[i][j];
                    len = 0;
                } else if (from != 0) {
                    len++;
                }
            }
        }

 
        for (int j = 0; j < m; j++) {
            if (col[j].size() < 2) continue;

            int from = 0;
            int len = 0;

            for (int i = 0; i < n; i++) {
                if (map[i][j] > 1) {
                    if (from != 0 && from != map[i][j] && len >= 2) {
                        int to = map[i][j];
                        bridge[from][to] = Math.min(bridge[from][to], len);
                        bridge[to][from] = bridge[from][to];
                    }
                    from = map[i][j];
                    len = 0;
                } else if (from != 0) {
                    len++;
                }
            }
        }

 
        boolean[] visited = new boolean[islandNum];
        int total = 0;
        int connected = 0;

      
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        visited[2] = true;
        connected++;
        for (int i = 2; i < islandNum; i++) {
            if (bridge[2][i] != Integer.MAX_VALUE) {
                pq.offer(new int[]{i, bridge[2][i]});
            }
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int to = now[0], cost = now[1];

            if (visited[to]) continue;

            visited[to] = true;
            total += cost;
            connected++;

            for (int i = 2; i < islandNum; i++) {
                if (!visited[i] && bridge[to][i] != Integer.MAX_VALUE) {
                    pq.offer(new int[]{i, bridge[to][i]});
                }
            }
        }

        if (connected == islandNum - 2) {
            System.out.println(total);
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(int r, int c, int cnt) {
        map[r][c] = cnt;
        v[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 1 && !v[nr][nc]) {
                dfs(nr, nc, cnt);
            }
        }
    }
}
