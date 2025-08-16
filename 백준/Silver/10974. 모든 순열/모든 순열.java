import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] arr;
	static int[] sel;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sel = new int[n];
		v = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}

		recursive(0);
	}

	private static void recursive(int idx) {
		if(idx == arr.length) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < n; i++) {
				sb.append(sel[i] + " ");
			}
			
			System.out.println(sb);
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!v[i]) {
				
				v[i] = true;
				sel[idx] = arr[i];
				recursive(idx+1);
				v[i] = false;
			}
		}
		
		
	}

}
