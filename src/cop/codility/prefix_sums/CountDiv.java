package cop.codility.prefix_sums;

/**
 * <h1>CountDiv</h1>
 * <i>Compute number of integers divisible by k in range [a..b].</i>
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int A, int B, int K); }
 * </pre>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.: { i : A <= i <= B, i
 * <b>mod</b> K = 0 }.
 * <p/>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11],
 * namely 6, 8 and 10.<br>
 * Assume that:
 * <ul>
 * <li>A and B are integers within the range [0..2,000,000,000];</li>
 * <li>K is an integer within the range [1..2,000,000,000];</li>
 * <li>A <= B.</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(1);</li>
 * <li>expected worst-case space complexity is O(1).</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 15.10.2015
 */
public class CountDiv {
    public static int solution(int A, int B, int K) {
        int i = A;

        while (i < B && i % K != 0) {
            i++;
        }

        return i % K == 0 ? 1 + (int) Math.floor((B - i) / K) : 0;
    }

    public static void main(String... args) {
        System.out.println(solution(6, 11, 2));
        System.out.println(solution(1, 1, 11));
        System.out.println(solution(11, 14, 2));
    }
}

