import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the squares function below.
	static int squares(int a, int b) {
		int count = 0;
		boolean firstSquare = false;
		int square = 0;
		int squareRoot = 0;
		for (int i = a; i <= b; i++) {
			if (!firstSquare) {
				double sq = Math.sqrt(i);
				if (sq - Math.floor(sq) == 0) {
					count++;
					square = i;
					squareRoot = (int) sq;
					firstSquare = true;
				}
			} else {
				square = square + squareRoot + squareRoot + 1;
				squareRoot = (int) Math.sqrt(square);
				if (square <= b)
					count++;
				i = square;
			}

		}
		return count;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
