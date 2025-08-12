import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n;
	static int tmp = 0;
	static int tmp2 = 0;
	static int[] sel;
	static int[] nsel;
	static int[] num;
	static boolean[] v;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		num = new int[n];
		sel = new int[n/2];
		nsel = new int[n/2];
		v = new boolean[n];


		for(int i = 0; i < n; i++) {
			num[i] = i+1;
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n ;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(0, 0);
		
		System.out.println(min);
	}

	private static void recursive(int idx, int k) {
		if(k == n/2) {
			tmp = 0;
			tmp2 = 0;
			calc();
			return;
		}
		
		if(idx == arr.length) {
			return;
		}
		
		sel[k] = num[idx];
		v[idx] = true;
		recursive(idx+1, k+1);
		v[idx] = false;
		recursive(idx+1, k);
		
	}

	private static void calc() {
		int idx = 0;
		for(int i = 0; i < n; i++) {
			if(!v[i]) {
				nsel[idx] = i+1;
				idx++;
			} 
		}
		
		for(int i = 0; i < sel.length - 1; i++) {
			for(int j = i+1; j < sel.length; j++) {
				tmp += arr[sel[i]-1][sel[j]-1];
				tmp += arr[sel[j]-1][sel[i]-1];
				
				tmp2 += arr[nsel[i]-1][nsel[j]-1];
				tmp2 += arr[nsel[j]-1][nsel[i]-1];
			}
		}
		
		
		min = Math.min(min, Math.abs(tmp-tmp2));
	}
}