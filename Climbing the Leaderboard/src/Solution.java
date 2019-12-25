import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	int[] aliceRanks = new int[alice.length];
    	int previous = scores[0];
    	int aliceIndex = alice.length -1;
    	int currentRank = 1;
    	
    	for(int i =0;i<scores.length;i++) {
    		if(aliceIndex < 0)
    			return aliceRanks;
    		
    		if(previous != scores[i]) {
    			previous = scores[i];
    			currentRank++;
    		}
    		
     		if(alice[aliceIndex] >= scores[i]) {
    			aliceRanks[aliceIndex] = currentRank;
    			aliceIndex --;
    			i = i -1 < -1 ? -1 : i-1;
    		} 
    	}
    	if(aliceRanks[aliceIndex] == 0) {
    		final int rank = ++currentRank;
    		final int index = aliceIndex;
    		Arrays.setAll(aliceRanks, i -> {if(i<=index) return rank; return aliceRanks[i];});
    	}
    	
    	return aliceRanks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
