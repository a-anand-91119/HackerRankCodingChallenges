import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

    	if(s.equals(t) && k != 1)
    		return "Yes";
    	
    	int index = 0;
		if (s.length() < t.length()) {
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) != t.charAt(i)){
					index = i;
					break;
				}
			if(index == 0){
				if(k == (t.length() - s.length()) || 
						k > (s.length() + t.length()) ||
						(k - t.length() - s.length()) % 2 == 0)
					return "Yes";
				else
					return "No";
			}
		} else {
			int i = 0;
			for (; i < t.length(); i++)
				if (s.charAt(i) != t.charAt(i)){
					index = i;
					break;
				}
			if(index == 0 && i != 0)
				index = t.length();
		}
		
		int minNoOfSteps = s.length() - index;
		minNoOfSteps += t.length() - index;
		
		if(k >= minNoOfSteps)
			return "Yes";
    	
    	return "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
