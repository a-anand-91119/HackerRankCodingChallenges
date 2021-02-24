import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		System.out.println(
				solution(new int[] { 14, 27, 1, 4, 2, 50, 3, 1 }, new int[] { 2, 4, -4, 3, 1, 1, 14, 27, 50 }));

		System.out.println();
		System.out.println();
		System.out.println();

		long startTime = System.nanoTime();
		System.out.println(solution(new int[] { 3, 1, 4, 1 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		startTime = System.nanoTime();
		System.out.println(solution(new int[] { 3, 1, 4, 1, 5, 9 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		startTime = System.nanoTime();
		System.out.println(solution(new int[] { 1, 5, 9, 4, 6, 7, 9, 9, 9 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		startTime = System.nanoTime();
		System.out.println(solution(new int[] { 3, 1, 4, 1, 5, 9, 4, 6, 7 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));

		startTime = System.nanoTime();
		System.out.println(solution2(new int[] { 3, 1, 4, 1 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		startTime = System.nanoTime();
		System.out.println(solution2(new int[] { 3, 1, 4, 1, 5, 9 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		startTime = System.nanoTime();
		System.out.println(solution2(new int[] {1, 5, 9, 4, 6, 7, 9, 9, 9 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		startTime = System.nanoTime();
		System.out.println(solution2(new int[] { 3, 1, 4, 1, 5, 9, 4, 6, 7 }));
		System.out.println("Elapsed: " + (System.nanoTime() - startTime));
		
	}

	public static int solution(int[] x, int[] y) {
		// Your code here

		long nanotime = System.nanoTime();
		boolean contains = false;
		if (x.length > y.length) {
			for (int i = 0; i < x.length; i++) {
				contains = false;
				for (int j = 0; j < y.length; j++) {
					if (x[i] == y[j]) {
						contains = true;
						break;
					}
				}
				if (!contains) {
					System.out.println("Time = " + (System.nanoTime() - nanotime));
					return x[i];
				}
			}
		} else {
			for (int i = 0; i < y.length; i++) {
				contains = false;
				for (int j = 0; j < x.length; j++) {
					if (y[i] == x[j]) {
						contains = true;
						break;
					}
				}
				if (!contains) {
					System.out.println("Time = " + (System.nanoTime() - nanotime));
					return y[i];
				}
			}
		}
		return 0;
	}

	public static int solution(int[] l) {
		int returnVal = 0;

		for (int i = l.length; i > 0; i--) {
			int processed = process(l, i, 0, new ArrayList<>());
			if (processed > returnVal)
				returnVal = processed;
			if (returnVal > 0)
				break;
		}

		return returnVal;
	}

	public static int process(int[] l, int length, int currentNumber, List<Integer> used) {
		if (length == 0) {
			if (currentNumber % 3 == 0)
				return currentNumber;
			else
				return 0;
		} else {
			int val = 0;
			for (int i = 0; i < l.length; i++) {
				if (used.contains(i))
					continue;
				used.add(i);
				int val1 = process(l, length - 1, currentNumber * 10 + l[i], used);
				used.remove((Object) i);
				if (val1 > val)
					val = val1;
			}
			return val;
		}

	}

	private static int solution2(int[] l) {
		List<Integer> zeroList = new ArrayList<>();
		List<Integer> oneList = new ArrayList<>();
		List<Integer> twoList = new ArrayList<>();
		List<Integer> resultList = new ArrayList<>();
		
		for(int i = 0;i<l.length;i++) 
			if(l[i] % 3 == 0)
				zeroList.add(l[i]);
			else if(l[i] % 3 == 1)
				oneList.add(l[i]);
			else
				twoList.add(l[i]);
		
		
		if(oneList.size() == twoList.size()) {
			// add all elements
			resultList = Arrays.stream(l).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		}else if(oneList.size() > twoList.size()) {
			resultList = getNewList(oneList.size(), twoList.size(), zeroList, oneList, twoList);
		}else {
			resultList = getNewList(twoList.size(), oneList.size(), zeroList, oneList, twoList);
		}
		if(resultList.size() == 0)
			return 0;
		int returnno = 0;
		for(int i=0;i<resultList.size();i++)
			returnno = returnno * 10 + resultList.get(i);
		return returnno;
	}

	private static List<Integer> getNewList(int size, int size2, List<Integer> zeroList, List<Integer> oneList, List<Integer> twoList) {
		if(size2 == 0)
			size = 3 * (size / 3);
		else {
			int extra = ( size - size2 ) % 3;
			if(extra == 2) {
				size2 -= 1;
			}else if(extra == 1)
				size -= 1;
		}
		if(size == 0 && size2 == 0)
			return zeroList;
		
		if(size != 0) {
			oneList.stream().sorted(Collections.reverseOrder()).limit(size);
			zeroList.addAll(oneList);
		}
		
		if(size2 != 0) {
			twoList.stream().sorted(Collections.reverseOrder()).limit(size);
			zeroList.addAll(twoList);
		}
		
		return zeroList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}

}
