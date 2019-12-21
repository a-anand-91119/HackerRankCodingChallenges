import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int sum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int tempSum = getSingleHourGlassSum(arr, i, j);
				if(tempSum > sum)
					sum = tempSum;
			}
		}
    	return sum;
    }

	private static int getSingleHourGlassSum(int[][] arr, int i, int j) {
		if (i + 2 >= arr.length || j + 2 >= arr.length)
			return Integer.MIN_VALUE;
		int sum = 0;
		sum += arr[i][j];
		sum += arr[i][j + 1];
		sum += arr[i][j + 2];
		sum += arr[i + 1][j + 1];
		sum += arr[i + 2][j];
		sum += arr[i + 2][j + 1];
		sum += arr[i + 2][j + 2];
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
