import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
    	String[] inputArray = s.split(":");
    	if(inputArray[2].endsWith("PM") && !inputArray[0].equals("12")) {
    		inputArray[0] = String.valueOf(Integer.parseInt(inputArray[0]) + 12);
    		
    	}else if(inputArray[2].endsWith("AM") && inputArray[0].equals("12")){
    		inputArray[0] = "00";
    	}
    	
    	inputArray[2] = inputArray[2].substring(0, inputArray[2].length() - 2);
    	
    	return inputArray[0] + ":" + inputArray[1] + ":" + inputArray[2];
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);
       // bw.write(result);
       // bw.newLine();

       // bw.close();
    }
}
