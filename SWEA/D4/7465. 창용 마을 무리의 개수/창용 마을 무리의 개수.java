import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int[] parents;
	
	private static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) {
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			HashSet<Integer> set = new HashSet<>();
			int m = Integer.parseInt(st.nextToken());
			
			make();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				if(st.countTokens() < 2) {
					continue;
				}
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x, y);
			}
			
			for (int i = 1; i <= n; i++) {
				set.add(find(i));
			}
			
			System.out.println("#" + tc + " " + set.size());
		}

	}

}
