import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    // Complete the dayOfProgrammer function below.
	static String dayOfProgrammer(int year) {

		int day = 13;

		if (year < 1918 && year % 4 == 0) {
			day = 12;
		} else if (year > 1918 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
			day = 12;
		} else if (year == 1918) {
			day = 26;
		}
		return day + ".09." + year;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
