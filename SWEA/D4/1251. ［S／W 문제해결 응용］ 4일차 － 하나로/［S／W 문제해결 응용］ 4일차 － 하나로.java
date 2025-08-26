import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;
		
		Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// 10 - 20 : 음수 -> 뒤 값이 크다 : 그럼 그래로 위치(교환 일어나지 않음)
			// 20 - 10 : 양수 -> 앞 값이 크다 : 교환
			//음수 - 양수 : 오버플로우, 음수 - 양수 : 언더플로우
			//return this.weight - o.weight; //아래 코드와 동일한 결과
			return Double.compare(this.weight, o.weight); //가중치 기준 오름차순 정렬 되도록 비교결과 리턴
		}
	}
	
	static ArrayList<Edge> edgeList;
	static int[] parents;
	static int n;
	
	private static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
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
			
			parents = new int[n];
			edgeList = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					int from = i;
					int to = j;
					double weight = Math.sqrt(Math.pow(arr[i].get(0) - arr[j].get(0), 2) + Math.pow(arr[i].get(1) - arr[j].get(1), 2));
					edgeList.add(new Edge(from, to, weight));
				}
			}
			
			Collections.sort(edgeList);
			make();
			
			double result = 0; //최소 신장트리 비용
			int cnt = 0; //처리된 간선 수
			
			for (Edge edge : edgeList) {
				if(!union(edge.from, edge.to)) continue; //union 실패 : 사이클 발생
				result += Math.pow(edge.weight, 2) * e;
				if(++cnt == n-1) break;
			}
			
			System.out.println("#" + tc + " " + Math.round(result));
		}
	

		
	}

}


