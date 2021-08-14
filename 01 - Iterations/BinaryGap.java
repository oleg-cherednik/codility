/**
 * <h1>BinaryGap</h1>
 * <i>Find longest sequence of zeros in binary representation of an integer</i>
 * <p/>
 * A <i>binary gap</i> within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * <p/>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length
 * 1. The number 15 has binary representation 1111 and has no binary gaps.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int N); }
 * </pre>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * <p/>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of
 * length 5.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..2,147,483,647].</li>
 * </ul>
 * <p/>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(log(N));</li>
 * <li>expected worst-case space complexity is O(1).</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 03.03.2017
 */
public class BinaryGap {

    public static int solution(int N) {
        int max = 0;
        int cur = 0;

        for (char ch : Integer.toBinaryString(N).toCharArray()) {
            if (ch == '0')
                cur++;
            else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }

        return max;
    }

    public static void main(String... args) {
        System.out.println(solution(9));    // 2
        System.out.println(solution(529));  // 4
        System.out.println(solution(20));   // 1
        System.out.println(solution(15));   // 0
        System.out.println(solution(1041)); // 5
    }

}
