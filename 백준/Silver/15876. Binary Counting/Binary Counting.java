import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			
			sb.append(Integer.toBinaryString(i));
			
			if(sb.length() >= n) {
				
				System.out.print(sb.charAt(k - 1) + " ");
				sb.delete(0, n);
				cnt++;
			}
			
			if(cnt == 5) {
				break;
			}
			
			i++;
		}
		
	}

}
