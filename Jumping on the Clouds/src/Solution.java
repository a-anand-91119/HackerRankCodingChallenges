import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		return getToFinalCloud(c, 0, 0);
	}
	
	static int getToFinalCloud(int[]c, int currentIndex, int noOfJumpsSoFar) {
		if(currentIndex == c.length)
			return noOfJumpsSoFar;
		
		if(currentIndex == c.length - 2 || currentIndex == c.length - 3)
			return noOfJumpsSoFar + 1;
		
		if(c[currentIndex + 2] == 1)
			return getToFinalCloud(c, currentIndex + 1, noOfJumpsSoFar + 1);
		
		return getToFinalCloud(c, currentIndex + 2, noOfJumpsSoFar + 1);
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
