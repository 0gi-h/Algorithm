import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static ArrayDeque<Integer> result;
	static ArrayList<Integer> check;
	static int cnt = 0;
	static int temp = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		result = new ArrayDeque<>();
		check = new ArrayList<>();
		check.add(1);
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		invite(1);
		
		System.out.println(cnt);
	}
	
	static void invite(int idx) {
		
		if(idx == 1) {
			for(int i = 0; i < list[idx].size(); i++) {
				if(!check.contains(list[idx].get(i))) {
					cnt++;
					check.add(list[idx].get(i));
					result.add(list[idx].get(i));
				}
			}
		}

		else if(idx > 1) {
			for(int i = 0; i < list[idx].size(); i++) {
				if(!check.contains(list[idx].get(i))) {
					cnt++;
					check.add(list[idx].get(i));
				}
			}
		}
		
		for(int i = 0; i < result.size(); i++) {
			int tmp = result.poll();
			invite(tmp);
		}
	}
}
