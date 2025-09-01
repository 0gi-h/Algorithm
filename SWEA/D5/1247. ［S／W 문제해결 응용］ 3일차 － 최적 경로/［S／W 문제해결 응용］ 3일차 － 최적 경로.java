import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static Point[] customers;
    static boolean[] visited;
    static Point home;
    static Point company;
    static int result;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            customers = new Point[n];
            visited = new boolean[n];
            result = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 회사 좌표
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 집 좌표
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                customers[i] = new Point(x, y);
            }

            dfs(company, 0, 0);

            System.out.println("#" + tc + " " + result);
        }
    }


    private static void dfs(Point current, int count, int totalDistance) {
        if (totalDistance >= result) return; 

        if (count == n) {

            totalDistance += Math.abs(current.x - home.x) + Math.abs(current.y - home.y);
            result = Math.min(result, totalDistance);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int dist = Math.abs(current.x - customers[i].x) + Math.abs(current.y - customers[i].y);
                dfs(customers[i], count + 1, totalDistance + dist);
                visited[i] = false;
            }
        }
    }
}