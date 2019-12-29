import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	int noOfPairs = 0;
    	Map<Integer, Integer> noOfSocks = new HashMap<Integer, Integer>();
    	for(int i = 0;i<n;i++) {
    		Integer socksCount = noOfSocks.get(ar[i]);
    		if(socksCount == null)
    			noOfSocks.put(ar[i], 1);
    		else {
    			noOfSocks.put(ar[i], socksCount + 1);
    		}
    	}
    	
    	for(Entry<Integer, Integer> entry : noOfSocks.entrySet()) {
    		noOfPairs += entry.getValue() / 2;
    	}
    	return noOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
