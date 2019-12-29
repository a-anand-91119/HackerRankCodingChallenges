import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
	static int pageCount(int n, int p) {
		/*
		 * Write your code here.
		 */
		
		/**
		 * No Of Pages From The Front is P / 2
		 */
		int pageCountFront = p / 2;
		/**
		 * No Of Pages From The Rear
		 * If N is Odd
		 * 		If p is Even
		 * 		(n - p) / 2
		 * 
		 * 		If p is Odd
		 * 		(n - p) / 2
		 * 
		 * If N is Even
		 * 		If p is Even
		 * 		(n - p) / 2
		 * 
		 * 		If p is Odd
		 * 		(n - p) / 2 + 1
		 */
		int pageCountRear = 0;
		if(n % 2 == 0 && p % 2 != 0)
			pageCountRear = (n - p) / 2 + 1;
		else
			pageCountRear = (n - p) / 2;

		if (pageCountRear < pageCountFront)
			return pageCountRear;
		else
			return pageCountFront;

	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);
        
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
