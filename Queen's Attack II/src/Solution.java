import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacle) {

    	int noOfPossibleAttacks = 0;
		int horizontalLeftAttack = Integer.MAX_VALUE;
		int horizontalRightAttack = Integer.MAX_VALUE;
		int verticalTopAttack = Integer.MAX_VALUE;
		int verticalBottomAttack = Integer.MAX_VALUE;
		int leftDiagonalTopAttack = Integer.MAX_VALUE;
		int leftDiagonalBottomAttack = Integer.MAX_VALUE;
		int rightDiagonalTopAttack = Integer.MAX_VALUE;
		int rightDiagonalBottomAttack = Integer.MAX_VALUE;
    	
    	boolean isObstacleHorizontalLeft = false;
    	boolean isObstacleHorizontalRight = false;
    	boolean isObstacleVerticalTop = false;
    	boolean isObstacleVerticalBottom = false;
    	boolean isObstacleLeftDiagonalTop = false;
    	boolean isObstacleLeftDiagonalBottom = false;
    	boolean isObstacleRightDiagonalTop = false;
    	boolean isObstacleRightDiagonalBottom = false;

    	// handle case without obstacles
    	int tempAttack = 0;
    	for(int i =0;i<obstacle.length;i++) {
    		if(obstacle[i][0] == r_q) { //obstacle horizontal to queen
    			
				tempAttack = Math.abs(obstacle[i][1] - c_q) - 1;

    			// check whether obstacle is to the left or right of the queen
    			if(obstacle[i][1] < c_q) {
    				isObstacleHorizontalLeft = true;
    				if(horizontalLeftAttack > tempAttack)
    					horizontalLeftAttack = tempAttack;
    			}else {
    				isObstacleHorizontalRight = true;
    				if(horizontalRightAttack > tempAttack)
    					horizontalRightAttack = tempAttack;
    			}
    			
    		}else if(obstacle[i][1] == c_q) { // obstacle vertical to queen
    			
				tempAttack = Math.abs(obstacle[i][0] - r_q) - 1;

    			// check whether obstacle is above or below the queen
    			if(obstacle[i][0] < r_q) {
    				isObstacleVerticalBottom = true;
    				if(verticalBottomAttack > tempAttack)
    					verticalBottomAttack = tempAttack;
    			}else {
    				isObstacleVerticalTop = true;
    				if(verticalTopAttack > tempAttack)
    					verticalTopAttack = tempAttack;
    			}
			
    		} else if (obstacle[i][0] + obstacle[i][1] == r_q + c_q) { // check whether obstacle lies in left (primary)
																	   // diagonal of the queen
				tempAttack = Math.abs(obstacle[i][0] - r_q) - 1;
				
    			// check whether obstacle lies above or below the queen in the diagonal
    			if(obstacle[i][0] > r_q) {
					isObstacleLeftDiagonalTop = true;
					if(leftDiagonalTopAttack > tempAttack)
						leftDiagonalTopAttack = tempAttack;
    			}else {
					isObstacleLeftDiagonalBottom = true;
					if(leftDiagonalBottomAttack > tempAttack)
						leftDiagonalBottomAttack = tempAttack;
    			}

    		}else if(obstacle[i][0] - obstacle[i][1] == r_q - c_q) { // check whether obstacle lies in right (secondary) diagonal of the queen
    			
    			tempAttack = Math.abs(obstacle[i][0] - r_q) - 1;
    			
    			// check whether obstacle lies above or below the queen in the diagonal
    			if(obstacle[i][0] > r_q) {
    				isObstacleRightDiagonalTop = true;
    				if(rightDiagonalTopAttack > tempAttack)
    					rightDiagonalTopAttack = tempAttack;
    			}else {
    				isObstacleRightDiagonalBottom = true;
    				if(rightDiagonalBottomAttack > tempAttack)
    					rightDiagonalBottomAttack = tempAttack;
    			}
    		}
    	}
    	
    	if(!isObstacleHorizontalLeft) // no obstacle to the left of the queen
    		noOfPossibleAttacks += c_q - 1;
    	else
    		noOfPossibleAttacks += horizontalLeftAttack;
    	
    	if(!isObstacleHorizontalRight) // no obstacle to the right of the queen
    		noOfPossibleAttacks += Math.abs(n - c_q);
    	else
    		noOfPossibleAttacks += horizontalRightAttack;
    	
    	if(!isObstacleVerticalTop) // no obstacle above the queen
    		noOfPossibleAttacks += Math.abs(n - r_q);
    	else
    		noOfPossibleAttacks += verticalTopAttack;
    	
    	if(!isObstacleVerticalBottom) // no obstacle below the queen
    		noOfPossibleAttacks += r_q -1;
    	else
    		noOfPossibleAttacks += verticalBottomAttack;
    	
    	if(!isObstacleLeftDiagonalTop) { // no obstacle above queen in left diagonal
    		if(r_q + c_q < n + 1)
    			noOfPossibleAttacks += c_q -1;
    		else
    			noOfPossibleAttacks += n - r_q;
    	}else
    		noOfPossibleAttacks += leftDiagonalTopAttack;
    	
    	if(!isObstacleLeftDiagonalBottom) { // no obstacle below queen in the left diagonal
    		if(r_q + c_q <= n + 1)
    			noOfPossibleAttacks += r_q - 1;
    		else
    			noOfPossibleAttacks += n - c_q;
    	}else
    		noOfPossibleAttacks += leftDiagonalBottomAttack;
    	
    	if(!isObstacleRightDiagonalTop) { // no obstacle above queen in right diagonal
    		if(r_q <= c_q)
    			noOfPossibleAttacks += n - c_q;
    		else
    			noOfPossibleAttacks += n - r_q;
    	}else
    		noOfPossibleAttacks += rightDiagonalTopAttack;
    	
    	if(!isObstacleRightDiagonalBottom) { // no obstavle below queen in right diagonal
    		if(r_q <= c_q)
    			noOfPossibleAttacks += r_q - 1;
    		else
    			noOfPossibleAttacks += c_q - 1;
    	}else
    		noOfPossibleAttacks += rightDiagonalBottomAttack;
    	
    	return noOfPossibleAttacks;

    }


	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }
		
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
