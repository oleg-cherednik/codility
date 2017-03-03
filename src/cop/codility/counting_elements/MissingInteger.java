package cop.codility.counting_elements;

import java.util.Set;
import java.util.TreeSet;

/**
 * <h1>MissingInteger</h1>
 * <i>Find the minimal positive integer not occurring in a given sequence.</i>
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.
 * <p/>
 * For example, given:
 * <pre>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 6
 * A[3] = 4
 * A[4] = 1
 * A[5] = 2
 * </pre>
 * the function should return 5.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 13.10.2015
 */
public class MissingInteger {
    public static int solution(int[] A) {
        int min = 1;
        Set<Integer> numbers = new TreeSet<>();

        for (int val : A) {
            numbers.add(val);

            if (val == min)
                do {
                    min++;
                } while (numbers.contains(min));
        }

        return min;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 1, 3, 6, 4, 1, 2 }));
    }
}

