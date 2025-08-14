import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        if (i == 0) {
            System.out.println(-1);
            return;
        }

        int j = n - 1;
        while (arr[i - 1] >= arr[j]) j--;

        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;

        for (int a = i, b = n - 1; a < b; a++, b--) {
            tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num).append(' ');
        System.out.println(sb);
    }
}