package old.other;

import kotlin.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or old.other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
public class NestedListWeightSum {
    public int depthSumRecursive(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int sum = 0;
        for(NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                sum += (ni.getInteger() * depth);
            } else {
                sum += helper(ni.getList(), depth+1);
            }
        }
        return sum;
    }

    public int depthSumIterative(List<NestedInteger> nestedList) {
        int sum = 0;
        LinkedList<Pair<NestedInteger, Integer>> queue = new LinkedList<>();
        for(NestedInteger ni: nestedList) {
            queue.add(new Pair<>(ni, 1));
        }

        while (!queue.isEmpty()) {
            Pair<NestedInteger, Integer> p = queue.poll();
            if (p.getFirst().isInteger()) {
                sum += (p.getFirst().getInteger() * p.getSecond());
            } else {
                for (NestedInteger ni: p.getFirst().getList()) {
                    queue.add(new Pair<>(ni, p.getSecond()+1));
                }
            }
        }

        return sum;
    }
}

