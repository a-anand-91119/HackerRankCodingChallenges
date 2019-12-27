import java.util.Scanner;

public class Solution {

    // Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int size = arr.length;
		int noOfPositives = 0;
		int noOfNegatives = 0;
		int noOfZeroes = 0;

		for (int i = 0; i < size; i++) {
			if (arr[i] < 0)
				noOfNegatives++;
			else if (arr[i] > 0)
				noOfPositives++;
			else
				noOfZeroes++;
		}

		System.out.println(noOfPositives / (double)size);
		System.out.println(noOfNegatives / (double)size);
		System.out.println(noOfZeroes / (double)size);
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
