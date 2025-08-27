import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int v;
	static int e;

	static class Edge implements Comparable<Edge>{
		int e, w;
		
		Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static ArrayList<Edge>[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			long result = 0;
			
			edges = new ArrayList[v+1];
			
			for (int i = 0; i < v+1; i++) {
				edges[i] = new ArrayList<>();
			}

			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edges[start].add(new Edge(end, weight));
				edges[end].add(new Edge(start, weight));
			}
			
			
			int[] dist = new int[v+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			boolean[] visited = new boolean[v+1];
			
			dist[1] = 0;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(1, 0));
			
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();

				if(visited[cur.e]) continue;

				visited[cur.e] = true;
				result += cur.w;
				
				// 현재 노드와 인접한 모든 노드들을 확인
				for (Edge next : edges[cur.e]) {
					// 아직 방문하지 않은 노드이고, 더 작은 가중치로 갈 수 있다면
					if (!visited[next.e] && next.w < dist[next.e]) {
						dist[next.e] = next.w;
						pq.offer(new Edge(next.e, next.w));
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
