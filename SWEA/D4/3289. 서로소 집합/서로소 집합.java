import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int n; //원소 개수 관리
	static int[] parents;
	
	private static void make() {
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i; //make set : 자신을 자신의 부모로 초기화(자신이 곧 루트, 대표자가 됨)
			
		}
	}
	
	private static int find(int a) { //a가 속한 집합(집합의 대표자) 찾기
		if (parents[a] == a) {
			return a;
		}
		//return find(parents[a]); Path 압축 전
		return parents[a] = find(parents[a]); //Path 압축 후
	}
	
	private static boolean union(int a, int b) { //a, b가 속한 집합을 합치기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false; //이미 같은 집합이므로 합치기 불가!
		}
		
		parents[bRoot] = aRoot;
		return true; //합치기 성공
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			int m = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			
			make();
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(type == 0) {
					find(x);
					find(y);
					union(x, y);
				}
				else if(type == 1) {
					if(find(x) == find(y)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}

				}
			}
			
			System.out.println("#" + i + " " + sb);
		}
		
	}

}
