import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] arr;
	static boolean[] vr;
	static boolean[] vc;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			arr = new int[9][9];
			vr = new boolean[9];
			vc = new boolean[9];
			
			for(int j = 0; j < 9; j++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int k = 0; k < 9; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			check(i);

		}
		
	}
	
	public static void check(int idx) {
	    // 행 검사
	    for (int j = 0; j < 9; j++) {
	        boolean[] vr = new boolean[9];
	        for (int k = 0; k < 9; k++) {
	            if (!vr[arr[j][k] - 1]) {
	                vr[arr[j][k] - 1] = true;
	            } else {
	                System.out.println("#" + (idx + 1) + " 0");
	                return;
	            }
	        }
	    }

	    // 열 검사
	    for (int j = 0; j < 9; j++) {
	        boolean[] vc = new boolean[9];
	        for (int k = 0; k < 9; k++) {
	            if (!vc[arr[k][j] - 1]) {
	                vc[arr[k][j] - 1] = true;
	            } else {
	                System.out.println("#" + (idx + 1) + " 0");
	                return;
	            }
	        }
	    }

	    // 3x3 박스 검사
	    for (int row = 0; row < 9; row += 3) {
	        for (int col = 0; col < 9; col += 3) {
	            boolean[] check = new boolean[9];
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    int val = arr[row + i][col + j];
	                    if (!check[val - 1]) {
	                        check[val - 1] = true;
	                    } else {
	                        System.out.println("#" + (idx + 1) + " 0");
	                        return;
	                    }
	                }
	            }
	        }
	    }

	    System.out.println("#" + (idx + 1) + " 1");
	}

	
}
