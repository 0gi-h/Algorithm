import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	
	static ArrayList<Integer>[] list;
	static boolean[] sel;
	static int kcal_limit; 
    static int sum;
    static int kcal;
    static int temp;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            kcal_limit = Integer.parseInt(st.nextToken());
            int result = 0;
            int max = 0;
            temp = 0;
            
            list = new ArrayList[num];
            sel = new boolean[num];
  
            
            for(int i = 0; i < num; i++) {
            	st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
               list[i] = new ArrayList<>();
               list[i].add(n);
               list[i].add(m);
            }
            
            
            sum = 0;
            kcal = 0;
            
            recursive(0);
            
            result = Math.max(max, temp);

            System.out.println("#" + test_case + " " + result);
        }
	}
	
	private static void recursive(int idx) {
		
		//basis part
		if(idx == list.length) {
			if(kcal <= kcal_limit) {
				temp = Math.max(temp,  sum);
			}
			return;
		}
		
		if(kcal > kcal_limit) {
			return;
		}
		
		temp = Math.max(temp,  sum);
		
		//inductive part
		//선택하는 경우
		sel[idx] = true;
		sum += list[idx].get(0);
		kcal += list[idx].get(1);
		recursive(idx+1);
		sum -= list[idx].get(0);
		kcal -= list[idx].get(1);
		//선택하지 않는 경우
		sel[idx] = false;
		recursive(idx+1);
		
	}
}
