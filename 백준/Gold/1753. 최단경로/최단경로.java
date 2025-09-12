import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		Node[] map = new Node[v+1];
		int[] dist = new int[v+1];
		boolean[] visited = new boolean[v+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from] = new Node(to, weight, map[from]);
		}
		
		dist[start] = 0;
		
		for (int i = 1; i <= v; i++) {
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;
			
			for (int j = 1; j <= v; j++) {
				if(!visited[j] && dist[j] < minD) {
					minIdx = j;
					minD = dist[j];
				}
			}
			
			if(minIdx == -1) {
				break;
			}
			visited[minIdx] = true;
			
			for (Node temp = map[minIdx]; temp != null; temp = temp.next) {
				if(!visited[temp.to] && minD+temp.weight < dist[temp.to]) {
					dist[temp.to] =  minD+temp.weight;
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
		}
	}
}
