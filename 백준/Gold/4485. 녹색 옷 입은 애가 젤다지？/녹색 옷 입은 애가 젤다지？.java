import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int r, c, cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        
        while(true) {
            n = Integer.parseInt(br.readLine());
            
            if(n == 0) {
                break;
            }
            
            idx++;
            map = new int[n][n];
            dist = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE; 
                }
            }

            int result = dijkstra();
            System.out.println("Problem " + idx + ": " + result);
        }
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[0][0] = map[0][0];
        pq.offer(new Node(0, 0, map[0][0]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.r == n-1 && cur.c == n-1) {
                return cur.cost;
            }
            
            if(cur.cost > dist[cur.r][cur.c]) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    int newCost = cur.cost + map[nr][nc];
                    
                    if(newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.offer(new Node(nr, nc, newCost));
                    }
                }
            }
        }
        
        return dist[n-1][n-1];
    }
}