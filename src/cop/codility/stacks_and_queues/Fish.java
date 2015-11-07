package cop.codility.stacks_and_queues;

import java.util.Stack;

/**
 * <h1>Fish</h1>
 * <i>N voracious fish are moving along a river. Calculate how many fish are alive.</i><br>
 * <br>
 * You are given two non-empty zero-indexed arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered
 * downstream along the flow of the river.<br>
 * The fish are numbered from 0 to N ? 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a
 * unique position.<br>
 * Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the
 * directions
 * of the fish. It contains only 0s and/or 1s, where:
 * <ul>
 * <li>0 represents a fish flowing upstream,</li>
 * <li>1 represents a fish flowing downstream.</li>
 * </ul>
 * If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one
 * fish can stay alive ? the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and
 * B[Q] = 0, and there are no living fish between them. After they meet:
 * <ul>
 * <li>If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,</li>
 * <li>If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.</li>
 * </ul>
 * We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the
 * number of fish that will stay alive.
 * <p/>
 * For example, consider arrays A and B such that:
 * <pre>
 * A[0] = 4     B[0] = 0
 * A[1] = 3     B[1] = 1
 * A[2] = 2     B[2] = 0
 * A[3] = 1     B[3] = 0
 * A[4] = 5     B[4] = 0
 * </pre>
 * Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets
 * fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, number 0 and 4, never meet and
 * therefore stay alive.
 * <p/>
 * Write a function:
 * <pre>
 * class Solution { public int solution(int[] A, int[] B); }
 * </pre>
 * that, given two non-empty zero-indexed arrays A and B consisting of N integers, returns the number of fish that will stay alive.
 * <p/>
 * For example, given the arrays shown above, the function should return 2, as explained above.
 * <p/>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [1..100,000];</li>
 * <li>each element of array A is an integer within the range [0..1,000,000,000];</li>
 * <li>each element of array B is an integer that can have one of the following values: 0, 1;</li>
 * <li>the elements of A are all distinct.</li>
 * </ul>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).</li>
 * </ul>
 * Elements of input arrays can be modified.
 *
 * @author Oleg Cherednik
 * @since 05.11.2015
 */
public class Fish {
    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1)
                stack.push(A[i]);
            else {
                do {
                    if (stack.isEmpty())
                        total++;
                    else {
                        int prv = stack.pop();

                        if (prv < A[i]) {
                            if (!stack.isEmpty())
                                continue;
                            total++;
                            break;
                        } else {
                            stack.push(prv);
                            break;
                        }
                    }
                } while (!stack.isEmpty());
            }
        }

        return total + stack.size();
    }

    public static void main(String... args) {
        System.out.println(solution(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0, 0 }));
        System.out.println(solution(new int[] { 4, 3, 2, 1, 5 }, new int[] { 1, 0, 1, 1, 1 }));
    }
}
