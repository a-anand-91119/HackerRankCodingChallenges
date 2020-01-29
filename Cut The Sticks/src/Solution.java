import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    	List<Integer> returnList = new ArrayList<Integer>();
    	int noOfSticks = arr.length;
    	int shortest = 0;
    	int newIndex = 0;
    	int i = 0;
    	Arrays.sort(arr);
    	int newShortest = arr[0];

    	while(true){
    		returnList.add(noOfSticks);
    		shortest = newShortest;
    		newShortest = Integer.MAX_VALUE;
    		i = newIndex;
    		for(;i< arr.length; i++){
    			arr[i] = arr[i] - shortest;
    			
    			if(arr[i] == 0){
    				noOfSticks--;
    				newIndex = i;
    			}
    			if(arr[i] == shortest && newShortest > shortest)
    				newShortest = shortest;
    			
    			if((arr[i] > 0 && arr[i] != shortest && arr[i] < newShortest) /*|| noOfSticks == 1*/)
    				newShortest = arr[i];
    		}
    		if(noOfSticks <= 0)
    			break;
    	}
    	
    	return returnList.stream().mapToInt(x->x).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
               // bufferedWriter.write("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
