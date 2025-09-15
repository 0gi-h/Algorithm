import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int to, time;
		Node next;
		public Node(int to, int time, Node next) {
			super();
			this.to = to;
			this.time = time;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no, tTime;

		public Vertex(int no, int tTime) {
			super();
			this.no = no;
			this.tTime = tTime;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.tTime, o.tTime);
		}
	}
	
	static Node[] map;
	static int[] dist;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		//-------여기에 해결 코드를 작성하세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		map = new Node[n+1];
		dist = new int[n+1];
		v = new boolean[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
		
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			map[from] = new Node(to, time, map[from]);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Vertex(start, dist[start]));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if(v[cur.no]) continue;
			v[cur.no] = true;
			
			if(cur.no == end) {
				break;
			}
			
			for (Node temp = map[cur.no]; temp != null; temp = temp.next) {
				if(!v[temp.to] && dist[temp.to] > cur.tTime + temp.time) {
					dist[temp.to] = cur.tTime + temp.time;
					pq.offer(new Vertex(temp.to, dist[temp.to]));
				}
			}
			
		}
		
		System.out.println(dist[end]);
	}

}
