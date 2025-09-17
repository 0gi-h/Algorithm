import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int to, weight;
		Node next;
		
		Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		int no, total;
		
		Vertex(int no, int total) {
			this.no = no;
			this.total = total;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.total, o.total);
		}
	}
	
	static Node[] map;
	static int[][] dist;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		map = new Node[n+1];
		dist = new int[3][n+1];
		
		int result = -1;
		
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist[i], 200000000);
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from] = new Node(to, weight, map[from]);
			map[to] = new Node(from, weight, map[to]);
		}
		
		st = new StringTokenizer(br.readLine());
		dist[1][0] = Integer.parseInt(st.nextToken());
		dist[2][0] = Integer.parseInt(st.nextToken());
		dist[0][0] = 1;
		

		
		for (int i = 0; i < 3; i++) {
			
			dijk(n, i, dist[i][0]);
		}

		int temp = -1;


		int path1 = dist[0][dist[1][0]] + dist[1][dist[2][0]] + dist[2][n];
        int path2 = dist[0][dist[2][0]] + dist[2][dist[1][0]] + dist[1][n];
		
        result = Math.min(path1, path2);
        System.out.println(result >= 200000000 ? -1 : result);
	}

	private static void dijk(int n, int idx, int start) {
		// TODO Auto-generated method stub
		PriorityQueue<Vertex>pq = new PriorityQueue<>();
		v = new boolean[n+1];
		dist[idx][start] = 0;
		pq.offer(new Vertex(start, dist[idx][start]));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if(v[cur.no]) continue;
			v[cur.no] = true;
			
			for (Node temp = map[cur.no]; temp != null ; temp = temp.next) {
				if(!v[temp.to] && dist[idx][temp.to] > cur.total + temp.weight) {
					dist[idx][temp.to] = cur.total + temp.weight;
					pq.offer(new Vertex(temp.to, dist[idx][temp.to]));
				}
			}
			
		}
	}

}

