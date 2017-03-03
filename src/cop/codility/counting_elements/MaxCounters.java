package cop.codility.counting_elements;

import java.util.Arrays;

/**
 * <h1>MaxCounters</h1>
 * <i>Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current
 * maximum.</i>
 * <p/>
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <ul>
 * <li><i>increase(X)</i> - counter X is increased by 1,</li>
 * <li><i>max counter</i> - all counters are set to the maximum value of any counter.</li>
 * </ul>
 * A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
 * <ul>
 * <li>if A[K] = X, such that 1 <= X <= N, then operation K is increase(X),</li>
 * <li>if A[K] = N + 1 then operation K is max counter.</li>
 * </ul>
 * For example, given integer N = 5 and array A such that:
 * <pre>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * </pre>
 * the values of the counters after each consecutive operation will be:
 * <pre>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * </pre>
 * The goal is to calculate the value of every counter after all operations.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int[] solution(int N, int[] A); }
 * </pre>
 * that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of
 * the counters.<br>
 * The sequence should be returned as an array of integers
 * <p/>
 * For example, given:
 * <pre>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * </pre>
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N and M are integers within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [1..N + 1].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N+M);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 13.10.2015
 */
public class MaxCounters {
    public static int[] solution(int N, int[] A) {
        int max = 0;
        int min = 0;
        int[] counters = new int[N];

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1)
                min = max;
            else {
                counters[A[i] - 1] = (min > 0 && counters[A[i] - 1] < min ? min : counters[A[i] - 1]) + 1;
                max = Math.max(max, counters[A[i] - 1]);
            }
        }

        for (int i = 0; i < N; i++)
            if (counters[i] < min)
                counters[i] = min;

        return counters;
    }

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
    }
}

