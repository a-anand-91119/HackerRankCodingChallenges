import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int noOfPrisoners, int noOfSweets, int startingChair) {
    	if(noOfSweets > noOfPrisoners)
    		noOfSweets = noOfSweets % noOfPrisoners;
    	
    	
    	int chair = noOfSweets + startingChair;
    	chair = chair - 1;
    	
    	return chair % noOfPrisoners == 0 ? noOfPrisoners : chair % noOfPrisoners;
    }


	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);
            
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
