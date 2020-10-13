import java.util.*;

class Solution {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			System.out.println(isValid(input));
		}

	}

	private static boolean isValid(String input) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < input.length(); i++) {
			
			if (stack.isEmpty()) {
				if (isForwardBracket(input.charAt(i)))
					stack.push(input.charAt(i));
				else
					return false;
			} else if (stack.peek().equals(oppositeBracket(input.charAt(i)))) {
				stack.pop();
			} else {
				if(isForwardBracket(input.charAt(i)))
					stack.push(input.charAt(i));
				else
					return false;
			}
			
		}
		return stack.isEmpty();
	}

	private static boolean isForwardBracket(char c) {
		return c == '{' || c == '(' || c == '[';
	}

	private static char oppositeBracket(char c) {
		if (c == '}')
			return '{';
		if (c == '{')
			return '}';
		if (c == ']')
			return '[';
		if (c == '[')
			return ']';
		if (c == '(')
			return ')';
		if (c == ')')
			return '(';
		return ' ';
	}
}