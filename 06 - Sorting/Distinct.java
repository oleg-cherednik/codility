/**
 * <h1>Distinct</h1>
 * <i>Compute number of distinct values in an array.</i>
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A); }
 * </pre>
 * that, given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..100,000];</li>
 * <li>each element of array A is an integer within the range [-1,000,000..1,000,000].</li>
 * </ul>
 * <p/>
 * For example, given array A consisting of six elements such that:
 * <pre>
 * A[0] = 2     A[1] = 1    A[2] = 1
 * A[3] = 2     A[4] = 3    A[5] = 1
 * </pre>
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1,2 and 3.
 * <p/>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N*log(N));</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 04.11.2015
 */
public class Distinct {

    public static int solution(int[] A) {
        boolean[] arr = new boolean[2 * 1_000_000 + 1];
        int res = 0;

        for (int a : A) {
            int i = a + 1_000_000;

            if (!arr[i]) {
                arr[a + 1_000_000] = true;
                res++;
            }
        }

        return res;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 2, 1, 1, 2, 3, 1 }));   // 3
    }

}

