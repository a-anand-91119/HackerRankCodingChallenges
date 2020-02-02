import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
	static long getLengthUptoLimit(String s, long n){
    	long occurenceInString = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'a')
				occurenceInString++;
		}
		return occurenceInString;
	}
	
    static long repeatedString(String s, long n) {

    	int stringLength = s.length();
    	long occurenceInString = 0;
    	
		if (stringLength >= n) {
			occurenceInString = getLengthUptoLimit(s, n);
		}else{
			for (int i = 0; i < stringLength; i++) {
				if (s.charAt(i) == 'a')
					occurenceInString++;
			}
			long remainder = n % stringLength;
			long divisor = n / stringLength;
			
			occurenceInString *= divisor;
			if(remainder != 0){
				occurenceInString += getLengthUptoLimit(s, remainder);
			}
		}
    	
    	return occurenceInString;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
