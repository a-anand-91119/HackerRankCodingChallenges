import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int[][][] lookup = {
		{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
        {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
        {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
        {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
        {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
        {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
        {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
	};
	
    // Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		int changeValue = Integer.MAX_VALUE;
		int tempCost = 0;
		for (int i = 0; i < lookup.length; i++) {
			tempCost = computeCost(s, lookup[i]);

			if (tempCost < changeValue)
				changeValue = tempCost;
		}

		return changeValue;
	}

	private static int computeCost(int[][] input, int[][] reference) {
		int cost = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if(input[i][j] != reference[i][j])
					cost += Math.abs(input[i][j] - reference[i][j]);
			}
		}
		return cost;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);
		
		 bufferedWriter.write(String.valueOf(result));
		 bufferedWriter.newLine();

		 bufferedWriter.close();

		scanner.close();
	}
}
