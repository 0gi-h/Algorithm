import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class G {
		int r, c;

		public G(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static ArrayList<G> arr;
	static G[] sel;
	static int n;
	static long totalX, totalY;
	static long min;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int tc = 1; tc <= t; tc++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new ArrayList<>();
			totalX = 0;
			totalY = 0;
			min = Long.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				arr.add(new G(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				totalX += arr.get(i).r;
				totalY += arr.get(i).c;
			}
			
			sel = new G[n/2];
			recursive(0, 0);
			
			
			
			
			System.out.println("#" + tc + " " + min);
		}

	}


	private static void recursive(int idx, int k) {
		if(k == n/2) {
			min = Math.min(min, cal());
			return;
		}
		
		if(idx == arr.size()) {
			return;
		}
		

		
		sel[k] = arr.get(idx);
		recursive(idx+1, k+1);
		recursive(idx+1, k);
	}


	private static long cal() {
	    long selX = 0;
	    long selY = 0;

	    for (int i = 0; i < n/2; i++) {
	        selX += sel[i].r;
	        selY += sel[i].c;
	    }

	    long otherX = totalX - selX;
	    long otherY = totalY - selY;

	    long diffX = selX - otherX;
	    long diffY = selY - otherY;

	    return diffX * diffX + diffY * diffY;
	}

}
