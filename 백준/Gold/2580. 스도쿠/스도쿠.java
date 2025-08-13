import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
    }

    static void solve(int row, int col) {
        if (col == 9) {
            solve(row + 1, 0);
            return;
        }

        if (row == 9) {
            printBoard();
            System.exit(0); 
        }

        if (board[row][col] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(row, col, num)) {
                    board[row][col] = num;
                    solve(row, col + 1);
                    board[row][col] = 0; // backtrack
                }
            }
        } else {
            solve(row, col + 1);
        }
    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        int nr = (row / 3) * 3;
        int nc = (col / 3) * 3;
        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
