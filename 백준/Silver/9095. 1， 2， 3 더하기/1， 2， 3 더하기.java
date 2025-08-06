import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr = {1, 2, 3};
	static int[] sel = new int[3]; 
	static int cnt = 0;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < t; i++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			int temp = 0;
			
			recursive(temp);
			System.out.println(cnt);
		}
	}
	
	static void recursive(int temp) {
		
		if(temp == n) {
			cnt++;
			//System.out.println(temp);
			return;
		}
		
		if(temp > n) {
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			temp += arr[i];
			recursive(temp);
			temp -= arr[i];
			
		}

	}

}
