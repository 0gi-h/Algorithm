import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int m = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[2][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			
		}
		
		int temp = 0;
		
		recursive(0, temp);
		System.out.println(m);
	}

	private static void recursive(int idx, int temp) {
	
		if(idx <= n) {
			m = Math.max(m,  temp);
		}
		if(idx > n) {
			return;
		}
		
		for(int i = idx; i < n; i++ ) {
			temp += arr[1][i];
			recursive(i+arr[0][i], temp);
			temp -= arr[1][i];
		}
		
	}

}
