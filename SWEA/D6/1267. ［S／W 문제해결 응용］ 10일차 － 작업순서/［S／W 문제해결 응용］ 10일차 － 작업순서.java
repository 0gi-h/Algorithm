import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {
	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + to + ", next=" + next + "]";
		}
	}
	static int V,E;
	static Node[] adjList;
	static int[] inDegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new Node[V+1];
			inDegree = new int[V+1]; 
			
			st = new StringTokenizer(in.readLine());
			
			for (int i = 0; i < E; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to,adjList[from]);
				++inDegree[to]; 
			}
			ArrayList<Integer> orderList = topologySort();
			if(orderList.size()==V) { 
				StringBuilder sb = new StringBuilder();
				for (int o : orderList) {
					sb.append(o).append(" ");
				}
				System.out.println("#" + tc + " " + sb);
			}else { 
				System.out.println("cycle");
			}

		}
	}
	private static ArrayList<Integer> topologySort() { 
		ArrayList<Integer> orderList = new ArrayList<>(); 
		Queue<Integer> queue = new ArrayDeque<Integer>(); 
		for (int i=1; i <=V; ++i) { 
			if(inDegree[i]==0) queue.offer(i);
		}
		 
		while(!queue.isEmpty()) {
			
						int cur = queue.poll();
						orderList.add(cur); 
						
						for(Node temp=adjList[cur]; temp != null; temp=temp.next) { 

							if(--inDegree[temp.to]==0) queue.offer(temp.to);
						}
					}
		
		return orderList;
	}
}