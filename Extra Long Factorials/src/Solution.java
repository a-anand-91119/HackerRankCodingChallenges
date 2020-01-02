import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
		BigInteger factorial = new BigInteger(n + "");
		for(int i = n - 1;i>0;i--) {
			factorial = factorial.multiply(new BigInteger(i+""));
		}
		System.out.println(factorial.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
