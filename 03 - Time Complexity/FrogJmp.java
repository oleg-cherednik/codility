/**
 * <h1>FrogJmp</h1>
 * <i>Count minimal number of jumps from position X to Y.</i>
 * <p/>
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than
 * or equal to Y. The small frog always jumps a fixed distance, D.<br>
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int X, int Y, int D); }
 * </pre>
 * that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
 * <p/>
 * For example, given:
 * <pre>
 * X = 10
 * Y = 85
 * D = 30
 * </pre>
 * the function should return 3, because the frog will be positioned as follows:
 * <ul>
 * <li>after the first jump, at position 10 + 30 = 40</li>
 * <li>after the second jump, at position 10 + 30 + 30 = 70</li>
 * <li>after the third jump, at position 10 + 30 + 30 + 30 = 100</li>
 * </ul>
 * Assume that:
 * <ul>
 * X, Y and D are integers within the range [1..1,000,000,000];
 * X <= Y.
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(1);</li>
 * <li>expected worst-case space complexity is O(1).</li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 13.10.2015
 */
public class FrogJmp {

    public static int solution(int X, int Y, int D) {
        return (int)Math.ceil((Y - X) / (double)D);
    }

    public static void main(String... args) {
        System.out.println(solution(10, 85, 30));
    }

}

