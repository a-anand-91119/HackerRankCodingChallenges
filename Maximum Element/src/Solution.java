import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<Integer> storageStack = new Stack<Integer>();
        List<Integer> returnList = new ArrayList<Integer>();
        int element;
        Integer largest = Integer.MIN_VALUE;
        int poppedElement;
        for(String operation : operations){
            switch(operation.charAt(0)){
                case '1':
                    element = Integer.parseInt(operation.substring(2));
                    if(element > largest) largest = element;
                    storageStack.push(largest);
                    break;
                case '2':
                    storageStack.pop();
                    largest = storageStack.isEmpty() ? 
                        Integer.MIN_VALUE : storageStack.peek();
                    break;
                case '3':
                    returnList.add(storageStack.peek());
                    break;
            }
        }
        return returnList;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
