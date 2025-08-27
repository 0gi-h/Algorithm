import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] arr;
    static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] sel;
    static boolean[] v;  // 방문 배열 초기화 추가
    static String max = "";  // String으로 변경 (큰 수 처리)
    static String min = "";  // String으로 변경 (큰 수 처리)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[k];
        sel = new int[k+1];
        v = new boolean[10];  // 방문 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++) {
            char c = st.nextToken().charAt(0);
            arr[i] = c;  // ASCII 값으로 저장 ('<' = 60, '>' = 62)
        }

        recursive(0, 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void recursive(int idx, int pick) {

        // 부등호 조건 검사 (pick이 2 이상일 때)
        if(pick > 1) {
            if(arr[pick-2] == 60 && sel[pick-2] > sel[pick-1]) {  // '<'인데 왼쪽이 더 큰 경우
                return;
            }
            else if(arr[pick-2] == 62 && sel[pick-2] < sel[pick-1]) {  // '>'인데 왼쪽이 더 작은 경우
                return;
            }
        }

        // k+1개의 숫자를 모두 선택한 경우
        if(pick == k+1) {
            StringBuilder sb = new StringBuilder();

            for (int i : sel) {
                sb.append(String.valueOf(i));
            }
            String str = sb.toString();

            // 첫 번째 결과이거나 더 큰 값인 경우 max 업데이트
            if(max.equals("") || str.compareTo(max) > 0) {
                max = str;
            }
            // 첫 번째 결과이거나 더 작은 값인 경우 min 업데이트
            if(min.equals("") || str.compareTo(min) < 0) {
                min = str;
            }

            return;
        }

        // 모든 숫자를 검토했지만 아직 k+1개를 선택하지 못한 경우
        if(idx == 10) {  // 0~9 모든 숫자를 검토한 경우
            return;
        }

        // 현재 숫자(num[idx])가 사용되지 않은 경우에만 선택
        if(!v[idx]) {
            v[idx] = true;  // 방문 표시
            sel[pick] = num[idx];
            recursive(0, pick+1);  // 다음 위치를 위해 idx를 0으로 리셋
            v[idx] = false;  // 백트래킹
        }
        
        // 현재 숫자를 선택하지 않고 다음 숫자로 이동
        recursive(idx+1, pick);
    }
}