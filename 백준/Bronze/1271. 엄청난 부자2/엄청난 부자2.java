import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 두 개의 매우 큰 정수를 입력 받음
        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());

        // 몫과 나머지 계산
        BigInteger quotient = A.divide(B);   // A / B
        BigInteger remainder = A.remainder(B); // A % B

        // 결과 출력
        System.out.println(quotient);
        System.out.println(remainder);
    }
}