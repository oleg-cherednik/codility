package cop.codility.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>OddOccurrencesInArray</h1>
 * <i>Find value that occurs in odd number of elements.</i>
 * <p/>
 * A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can
 * be paired with another element that has the same value, except for one element that is left unpaired.
 * <p/>
 * For example, in array A such that:
 * <pre>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * </pre>
 * <ul>
 * <li>the elements at indexes 0 and 2 have value 9,</li>
 * <li>the elements at indexes 1 and 3 have value 3,</li>
 * <li>the elements at indexes 4 and 6 have value 9,</li>
 * <li>the element at index 5 has value 7 and is unpaired.</li>
 * </ul>
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * </pre>
 * the function should return 7, as explained in the example above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an odd integer within the range [1..1,000,000];</li>
 * <li>each element of array A is an integer within the range [1..1,000,000,000];</li>
 * <li>all but one of the values in A occur an even number of times.</li>
 * </ul>
 * <p/>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * <li>Elements of input arrays can be modified.</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.03.2017
 */
public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int val : A)
            if (!set.remove(val))
                set.add(val);

        return set.iterator().next();
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));    // 7
    }
}
