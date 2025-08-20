import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<Integer>[] arr;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int t = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			max = 0;
			
			arr = new ArrayList[101];
			
			for(int j = 1; j < 101; j++) {
				arr[j] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n/2; j++) {
				arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			
			bfs(start);
			
			System.out.println("#" + i + " " + max);
		}
		
	}

	private static void bfs(int idx) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[101];
		q.offer(idx);
		v[idx] = true;
		ArrayList<Integer> last = new ArrayList<>();
		
		 while (!q.isEmpty()) {
		        int levelSize = q.size();
		        last = new ArrayList<>();  // 매 레벨마다 초기화

		        for (int i = 0; i < levelSize; i++) {
		            int current = q.poll();
		            last.add(current);

		            for (int next : arr[current]) {
		                if (!v[next]) {
		                    v[next] = true;
		                    q.offer(next);
		                }
		            }
		        }
		    }

		    // 마지막 레벨에서 가장 큰 값 찾기

		    for (int num : last) {
		        max = Math.max(max, num);
		    }
		}

}
