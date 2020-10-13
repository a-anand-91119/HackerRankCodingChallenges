import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		bufferedReader.readLine();
		String listData = bufferedReader.readLine();
		List<Integer> list = convertSpaceSeparatedStringToListOfInteger(listData);
		
		int noOfQueries = Integer.parseInt(bufferedReader.readLine());
		
		for(int i=0;i<noOfQueries;i++) {
			String operation = bufferedReader.readLine();
			if(operation.equals("Insert")) {
				String[] command = bufferedReader.readLine().split(" ");
				list.add(Integer.parseInt(command[0]), Integer.parseInt(command[1]));
			}else if(operation.equals("Delete")) {
				int removeIndex = Integer.parseInt(bufferedReader.readLine());
				list.remove(removeIndex);
			}
		}
		
		list.forEach(no->{
			try { bufferedWriter.write(no + " "); } catch (IOException e) {}
		});
		
		bufferedReader.close();
		bufferedWriter.close();
		
    }
    
    public static List<Integer> convertSpaceSeparatedStringToListOfInteger(String listData){
    	List<Integer> returnList = new ArrayList<Integer>();
    	for(String no : listData.split(" ")) {
    		returnList.add(Integer.parseInt(no));
    	}
    	return returnList;
    }
}