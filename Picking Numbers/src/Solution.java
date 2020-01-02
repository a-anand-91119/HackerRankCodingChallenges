import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

   public static int pickingNumbers(List<Integer> listOfNumbers) {
    // Write your code here
        int maxNumber = Integer.MIN_VALUE;
        Map<Integer,Integer> frequencyMap = new TreeMap<Integer, Integer>();
        
        for(Integer number : listOfNumbers){
            Integer mapData = frequencyMap.get(number);
            mapData = mapData == null ? 1 : mapData + 1;
            frequencyMap.put(number, mapData);
        }
        
        int previousValue = Integer.MIN_VALUE;
        int previousKey = Integer.MIN_VALUE;
        int tempMax = 0;
        for(Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            if(previousValue != Integer.MIN_VALUE ){
            	if(Math.abs((previousKey - entry.getKey())) <= 1)
            		tempMax = previousValue + entry.getValue();
            	else
            		tempMax = entry.getValue();
                if(tempMax >= maxNumber)
                    maxNumber = tempMax;
            }                
            previousValue = entry.getValue();
            previousKey = entry.getKey();
        }
        
        if(frequencyMap.size() == 1)
        	maxNumber = previousValue;
        
        return maxNumber;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
