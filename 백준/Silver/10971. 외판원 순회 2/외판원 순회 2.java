import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] map;
	static boolean[] v;
	static int n;
	static int result = Integer.MAX_VALUE;
	static int tmp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		
		
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= n; j++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 1; i <= n; i++) {
			v = new boolean[n+1];
			v[i] = true;
			recursive(i, 0, 0, i);
		}
		
		System.out.println(result);
	
	}

	static void recursive(int start, int dis, int cnt, int x) {
		if(cnt == n-1) {
			if(map[start].get(x-1) > 0) {
				result = Math.min(result,  dis + map[start].get(x-1));
			}
			return;
		}
        for (int i = 1; i <= n; i++) {
            if (!v[i] && map[start].get(i-1) > 0) {
                v[i] = true;
                recursive(i, dis + map[start].get(i-1), cnt + 1, x);
                v[i] = false;
            }
        }
	}

}
