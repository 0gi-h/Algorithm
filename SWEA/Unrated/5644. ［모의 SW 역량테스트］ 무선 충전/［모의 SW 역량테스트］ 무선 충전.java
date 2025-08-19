import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;
    static int a;
    static int[][] ap;
    static ArrayList<Integer>[] move;
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int[] pA;
    static int[] pB;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new int[10][10];
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            pA = new int[] {0, 0};
            pB = new int[] {9, 9};

            move = new ArrayList[2];
            move[0] = new ArrayList<>();
            move[1] = new ArrayList<>();

            ap = new int[a][4];

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                move[0].add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                move[1].add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 4; k++) {
                    ap[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            draw();
            int result = calc();

            System.out.println("#" + (i+1) + " " + result);
        }
    }

    private static int calc() {
        int tmp = getMaxPowerAtPosition(pA[0], pA[1], pB[0], pB[1]); 

        for(int i = 0; i < m; i++) {
            pA[0] += dr[move[0].get(i)];
            pA[1] += dc[move[0].get(i)];

            pB[0] += dr[move[1].get(i)];
            pB[1] += dc[move[1].get(i)];

            tmp += getMaxPowerAtPosition(pA[0], pA[1], pB[0], pB[1]);
        }

        return tmp;
    }
    
    private static int getMaxPowerAtPosition(int aRow, int aCol, int bRow, int bCol) {
        ArrayList<Integer> apForA = new ArrayList<>();
        ArrayList<Integer> apForB = new ArrayList<>();
        
        for(int i = 0; i < a; i++) {
            int apCol = ap[i][0] - 1; 
            int apRow = ap[i][1] - 1; 
            int range = ap[i][2];
            
            if(Math.abs(aRow - apRow) + Math.abs(aCol - apCol) <= range) {
                apForA.add(i);
            }
            
            if(Math.abs(bRow - apRow) + Math.abs(bCol - apCol) <= range) {
                apForB.add(i);
            }
        }
        
        int maxPower = 0;
        
        if(apForA.isEmpty() && !apForB.isEmpty()) {
            for(int bAP : apForB) {
                maxPower = Math.max(maxPower, ap[bAP][3]);
            }
            return maxPower;
        }
        
        if(!apForA.isEmpty() && apForB.isEmpty()) {
            for(int aAP : apForA) {
                maxPower = Math.max(maxPower, ap[aAP][3]);
            }
            return maxPower;
        }
        
        if(!apForA.isEmpty() && !apForB.isEmpty()) {
            for(int aAP : apForA) {
                for(int bAP : apForB) {
                    int power;
                    if(aAP == bAP) {
                        power = ap[aAP][3];
                    } else {
                        power = ap[aAP][3] + ap[bAP][3];
                    }
                    maxPower = Math.max(maxPower, power);
                }
            }
        }
        
        return maxPower;
    }

    private static void draw() {
        for(int i = 0; i < a; i++) {
            map[ap[i][1]-1][ap[i][0]-1] = ap[i][3];

            int cnt = 0;
            for(int j = ap[i][1]-ap[i][2]; j <= ap[i][1]+ap[i][2]; j++) {

                if(j-1 < 0 || j-1 >= 10) { 
                    continue;
                }

                for(int k = ap[i][0]-cnt; k <= ap[i][0]+cnt; k++) {

                    if(j-1 >= 0 && j-1 < 10 && k-1 >= 0 && k-1 < 10 && map[j-1][k-1] != 0) {

                        map[j-1][k-1] = Math.max(map[j-1][k-1], ap[i][3]); 
                    }
                    else if(j-1 >= 0 && j-1 < 10 && k-1 >= 0 && k-1 < 10 && map[j-1][k-1] == 0) {

                        map[j-1][k-1] = ap[i][3];
                    }
                }
                if(j < ap[i][1]) {
                    cnt++;
                }
                else if(j >= ap[i][1]) {
                    cnt--;
                }
            }
        }

    }

}