package old.simplepointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /*
    LeetCode – Merge Intervals
    Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
     */
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparing((Interval i) -> i.start));
        List<Interval> result = new ArrayList<>();
        Interval t = intervals.get(0);

        for(Interval i: intervals) {
            if (i.start <= t.end)
                t.end = Math.max(i.end, t.end);
            else {
                result.add(t);
                t = i;
            }
        }
        result.add(t);
        return result;
    }
}
