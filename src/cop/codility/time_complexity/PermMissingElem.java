package cop.codility.time_complexity;

/**
 * <h1>PermMissingElem</h1>
 * <i>Find the missing element in a given permutation.</i>
 * <p/>
 * A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that
 * exactly one element is missing.<br>
 * Your goal is to find that missing element.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a zero-indexed array A, returns the value of the missing element.
 * <p/>
 * For example, given array A such that:
 * <pre>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * </pre>
 * the function should return 4, as it is the missing element.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..100,000];</li>
 * <li>the elements of A are all distinct;</li>
 * <li>each element of array A is an integer within the range [1..(N+1)].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 13.10.2015
 */
public class PermMissingElem {
    public static int solution(int[] A) {
        int[] count = new int[A.length + 1];

        for(int val : A)
            count[val - 1]++;

        for(int i = 0; i < count.length; i++)
            if(count[i] == 0)
                return i + 1;

        return -1;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 2, 3, 1, 5 }));
    }
}

