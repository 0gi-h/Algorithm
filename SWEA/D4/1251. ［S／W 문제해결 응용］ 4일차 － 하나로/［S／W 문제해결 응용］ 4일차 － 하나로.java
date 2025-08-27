import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Solution {
	static int n;
	
	static class Vertex implements Comparable<Vertex>{
		int e;
		double w;
		
		Vertex(int e, double w) {
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Double.compare(this.w, o.w);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			double result = 0;
			ArrayList<Integer>[] arr = new ArrayList[n];
			
			for(int  i = 0; i < n; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int  i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int  j = 0; j < n; j++) {
					arr[j].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			double e = Double.parseDouble(br.readLine());
			
			double[] dist = new double[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			boolean[] v = new boolean[n];
			
			dist[0] = 0;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0));
			
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				
				if(v[cur.e]) continue;
				v[cur.e] = true;
				
				// 현재 선택된 노드(cur.e)에서 아직 방문하지 않은 모든 노드로의 거리 업데이트
				for (int i = 0; i < n; i++) {
					if(!v[i]) {
						// 현재 노드(cur.e)에서 노드 i까지의 거리 계산
						double weight = Math.sqrt(Math.pow(arr[cur.e].get(0) - arr[i].get(0), 2) + Math.pow(arr[cur.e].get(1) - arr[i].get(1), 2));
						
						// 더 짧은 거리를 발견하면 업데이트
						if(weight < dist[i]) {
							dist[i] = weight;
							pq.offer(new Vertex(i, weight));
						}
					}
				}
			}
			
			for (double d : dist) {
				result += Math.pow(d, 2) * e;
			}
			
			 System.out.println("#" + tc + " " + Math.round(result));
		}
	
		
	}
}