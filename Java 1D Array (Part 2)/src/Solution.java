import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
    	return isSolvable(leap, game, 0);
    }
    
    public static boolean isSolvable(int leap, int[] game, int pos) {
    	if(pos < 0 || game[pos] == 1)
    		return false;
    	
    	if(pos == game.length - 1 || pos + leap >= game.length) {
    		return true;
    	}
		game[pos] = 1;

    	return isSolvable(leap, game, pos + leap) || isSolvable(leap, game, pos + 1) || isSolvable(leap, game, pos - 1);
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}