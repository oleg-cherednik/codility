package cop.codility.counting_elements;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>FrogRiverOne</h1>
 * <i>Find the earliest time when a frog can jump to the other side of a river.</i>
 * <p/>
 * A small frog wants to get to the other side of a river. The frog is currently located at position 0, and wants to get to position X. Leaves fall
 * from a tree onto the surface of the river.<br>
 * You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one
 * leaf falls at time K, measured in seconds.<br>
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every
 * position across the river from 1 to X. You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not
 * change their positions once they fall in the river.
 * <p/>
 * For example, you are given integer X = 5 and array A such that:
 * <pre>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * </pre>
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int X, int[] A); }
 * </pre>
 * that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other
 * side of the river.<br>
 * If the frog is never able to jump to the other side of the river, the function should return ?1.
 * <p/>
 * For example, given X = 5 and array A such that:
 * <pre>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * </pre>
 * the function should return 6, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N and X are integers within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [1..X].</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 13.10.2015
 */
public class FrogRiverOne {
    public static int solution(int X, int[] A) {
        Set<Integer> positions = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            positions.add(A[i]);

            if (positions.size() == X)
                return i;
        }

        return -1;
    }

    public static void main(String... args) {
        System.out.println(solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
        System.out.println(solution(3, new int[] { 1, 3, 1, 3, 2, 1, 3 }));
    }
}

