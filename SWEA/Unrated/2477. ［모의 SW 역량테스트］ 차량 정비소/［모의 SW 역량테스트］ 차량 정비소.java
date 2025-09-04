import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	static int n, m, k, a, b;
	static int[] arr; // 접수
	static int[] arr2; // 정비
	static Customer[] customers;

	static class Customer {
		int num, arriveT, arrNum, arr2Num, nextT, endT;

		public Customer(int num, int arriveT) {
			this.num = num;
			this.arriveT = arriveT;
			this.arrNum = -1;
			this.arr2Num = -1;
			this.nextT = -1;
			this.endT = -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			arr = new int[n + 1];
			arr2 = new int[m + 1];
			customers = new Customer[k + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= k; i++) {
				customers[i] = new Customer(i, Integer.parseInt(st.nextToken()));
			}

			int result = search(1);
			if (result == 0) {
				result = -1;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static int search(int idx) {
		Customer[] atmp = new Customer[n + 1]; // 접수 창구
		Customer[] btmp = new Customer[m + 1]; // 정비 창구

		Queue<Customer> receptionWait = new LinkedList<>();
		PriorityQueue<Customer> repairWait = new PriorityQueue<>((o1, o2) -> {
			if (o1.nextT == o2.nextT) {
				return o1.arrNum - o2.arrNum;
			}
			return o1.nextT - o2.nextT;
		});

		int t = 0;
		int sum = 0;
		int done = 0;

		while (done < k) {


			for (int i = 1; i <= m; i++) {
				if (btmp[i] != null && btmp[i].endT == t) {
					if (btmp[i].arrNum == a && btmp[i].arr2Num == b) {
						sum += btmp[i].num;
					}
					btmp[i] = null;
					done++;
				}
			}


			for (int i = 1; i <= n; i++) {
				if (atmp[i] != null && atmp[i].nextT == t) {
					repairWait.add(atmp[i]);
					atmp[i] = null;
				}
			}


			for (int i = 1; i <= m; i++) {
				if (btmp[i] == null && !repairWait.isEmpty()) {
					Customer c = repairWait.poll();
					c.arr2Num = i;
					c.endT = t + arr2[i];
					btmp[i] = c;
				}
			}


			while (idx <= k && customers[idx].arriveT == t) {
				receptionWait.add(customers[idx]);
				idx++;
			}


			for (int i = 1; i <= n; i++) {
				if (atmp[i] == null && !receptionWait.isEmpty()) {
					Customer c = receptionWait.poll();
					c.arrNum = i;
					c.nextT = t + arr[i];
					atmp[i] = c;
				}
			}

			t++;
		}

		return sum;
	}
}
