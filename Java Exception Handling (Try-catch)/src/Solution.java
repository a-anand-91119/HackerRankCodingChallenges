import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		try {
			String one = bufferedReader.readLine();
			String two = bufferedReader.readLine();
			
			if(one.contains(".") || two.contains("."))
				throw new InputMismatchException();

			int noOne = Integer.parseInt(one);
			int noTwo = Integer.parseInt(two);

			if (noTwo <= 0)
				throw new IllegalArgumentException();
			
			bufferedWriter.write(String.valueOf(noOne/noTwo));
			
		} catch (NumberFormatException | InputMismatchException e) {
			bufferedWriter.write("java.util.InputMismatchException");
		} catch (IllegalArgumentException e) {
			bufferedWriter.write("java.lang.ArithmeticException: / by zero");
		} finally {
			bufferedReader.close();
			bufferedWriter.close();
		}
		
	}
}