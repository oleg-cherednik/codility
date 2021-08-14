/**
 * <h1>CountFactors</h1>
 * <i>Count factors of given number n.</i>
 * </p>
 * A positive integer D is a <i>factor</i> of a positive integer N if there exists an integer M such that N = D * M.
 * </p>
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 * </p>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int N); }
 * </pre>
 * that, given a positive integer N, returns the number of its factors.
 * </p>
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of
 * 24.
 * </p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..2,147,483,647].</li>
 * </ul>
 * </p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(sqrt(N));</li>
 * <li>expected worst-case space complexity is O(1).</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 19.03.2017
 */
public class CountFactors {

    public static int solution(int N) {
        int res = 0;
        double sqrt = Math.sqrt(N);

        for (int i = 1; i <= (int)sqrt; i++)
            if (N % i == 0)
                res += 2;

        if (sqrt == (int)sqrt)
            res--;

        return res;
    }

    public static void main(String... args) {
        System.out.println(solution(16)); // 5
        System.out.println(solution(36)); // 9
        System.out.println(solution(24)); // 8
    }

}
