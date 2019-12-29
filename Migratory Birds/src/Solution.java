import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
    	int birdId = arr.get(0);
    	int maxCount = 1;
    	Map<Integer, Integer> frequency = new HashMap<>();
    	for(Integer bird : arr) {
    		Integer count = frequency.get(bird);
    		if(count == null) {
    			frequency.put(bird, 1);
    		}else {
    			count++;
    			
    			if(count > maxCount || (count == maxCount && bird < birdId)) {
    				maxCount = count;
    				birdId = bird;
    			}
    			
				frequency.put(bird, count);
    		}
    	}
    	return birdId;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);
        System.out.println(result);
       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

        bufferedReader.close();
      // bufferedWriter.close();
    }
}
