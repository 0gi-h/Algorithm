import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] spaces;
	static int blue, white;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		spaces = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				spaces[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		blue = white = 0;
		makeSpace(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void makeSpace(int r, int c, int size) {

		int sum = 0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += spaces[i][j];
			}
		}
		
		if(sum == size * size) {
			++blue;
		}else if(sum == 0) {
			++white;
		}else {
			int newSize = size/2;
			makeSpace(r, c, newSize); 
			makeSpace(r, c+newSize, newSize);
			makeSpace(r+newSize, c, newSize);
			makeSpace(r+newSize, c+newSize, newSize);
		}

	}

}
