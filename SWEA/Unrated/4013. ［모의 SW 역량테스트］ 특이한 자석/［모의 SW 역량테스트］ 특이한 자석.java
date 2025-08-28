import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr = new int[4][8]; 
	static ArrayList<Integer>[] turn;
	static int a;
	static int b;
	static int c;
	static int d;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());

		 for (int tc = 1; tc <= t ; tc++) {
			int k = Integer.parseInt(br.readLine());
			int result = 0;
			
			turn = new ArrayList[k];
			for (int i = 0; i < turn.length; i++) {
				turn[i] = new ArrayList<>();
			}
			
			//자석 정보
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
					for (int j = 0; j < 8; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}
			}
			
			//회전 정보
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				turn[i].add(Integer.parseInt(st.nextToken()));
				turn[i].add(Integer.parseInt(st.nextToken()));
			}
			
			// 초기화 추가
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			
			// 각 회전을 개별적으로 처리
			for (int i = 0; i < turn.length; i++) {
				turnOne(i);
			}
			
			for (int i = 0; i < 4; i++) {
				if(i == 0 && arr[i][a] == 1) {
					result += 1;
				}
				else if(i == 1 && arr[i][b] == 1) {
					result += 2;
				}
				else if(i == 2 && arr[i][c] == 1) {
					result += 4;
				}
				else if(i == 3 && arr[i][d] == 1) {
					result += 8;
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void turnOne(int idx) {
		int gearNum = turn[idx].get(0);
		int direction = turn[idx].get(1);
		
		boolean[] willRotate = new boolean[4];
		int[] rotateDirection = new int[4];
		
		// 회전할 기어와 방향 결정
		willRotate[gearNum-1] = true;
		rotateDirection[gearNum-1] = direction;
		
		// 오른쪽으로 전파 체크
		for (int i = gearNum-1; i < 3; i++) {
			int currentRight = getCurrentRight(i);
			int nextLeft = getCurrentLeft(i+1);
			
			if (arr[i][currentRight] != arr[i+1][nextLeft]) {
				willRotate[i+1] = true;
				rotateDirection[i+1] = -rotateDirection[i];
			} else {
				break;
			}
		}
		
		// 왼쪽으로 전파 체크
		for (int i = gearNum-1; i > 0; i--) {
			int currentLeft = getCurrentLeft(i);
			int prevRight = getCurrentRight(i-1);
			
			if (arr[i][currentLeft] != arr[i-1][prevRight]) {
				willRotate[i-1] = true;
				rotateDirection[i-1] = -rotateDirection[i];
			} else {
				break;
			}
		}
		
		// 실제 회전 실행
		for (int i = 0; i < 4; i++) {
			if (willRotate[i]) {
				if (i == 0) {
					a -= rotateDirection[i];
					a = make(a);
				} else if (i == 1) {
					b -= rotateDirection[i];
					b = make(b);
				} else if (i == 2) {
					c -= rotateDirection[i];
					c = make(c);
				} else if (i == 3) {
					d -= rotateDirection[i];
					d = make(d);
				}
			}
		}
	}
	
	private static int getCurrentRight(int gearIdx) {
		if (gearIdx == 0) return make(a + 2);
		else if (gearIdx == 1) return make(b + 2);
		else if (gearIdx == 2) return make(c + 2);
		else return make(d + 2);
	}
	
	private static int getCurrentLeft(int gearIdx) {
		if (gearIdx == 0) return make(a - 2);
		else if (gearIdx == 1) return make(b - 2);
		else if (gearIdx == 2) return make(c - 2);
		else return make(d - 2);
	}

	private static int make(int idx) {
		while(idx < 0) {
			idx += 8;
		}
		while(idx >= 8) {
			idx -= 8;
		}
		return idx;
	}
}