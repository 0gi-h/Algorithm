import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[] op = new int[4];
	static int[] sel = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		recursive(1, arr.get(0));
		
		System.out.println(max);
		System.out.println(min);

	}

	private static void recursive(int idx, int num) {
		if(idx == arr.size()) {
			
			max = Math.max(max, num);
			min = Math.min(min, num);
			
			return;
		}
		
		
			if(sel[0] < op[0]) {
				sel[0] += 1;
				recursive(idx+1, num + arr.get(idx));
				sel[0] -= 1;
			}
			if(sel[1] < op[1]) {
				sel[1] += 1;
				recursive(idx+1, num - arr.get(idx));
				sel[1] -= 1;
			}
			if(sel[2] < op[2]) {
				sel[2] += 1;
				recursive(idx+1, num * arr.get(idx));
				sel[2] -= 1;
			}
			if(sel[3] < op[3]) {
				sel[3] += 1;
				recursive(idx+1, num / arr.get(idx));
				sel[3] -= 1;
			}

		
		
		
	}

}
