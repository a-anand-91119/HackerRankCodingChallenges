import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
    	int reverse = 0;
    	int count = 0;
    	for(int start=  i; start <= j;start++){
    		reverse = getReverse(start);
    		if(Math.abs(reverse - start) % k == 0)
    			count++;
    	}
    	return count;
    }

    private static int getReverse(int start) {
    	int reverse = 0;
    	int digit = 0;
    	do{
    		digit = start %10;
    		reverse = reverse * 10 + digit;
    		start = start / 10;
    	}while(start != 0);
    	
		return reverse;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
