package array.simplepointers;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /*
    LeetCode – Insert Interval
    Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     */
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start)
                result.add(interval);
            else if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.start <= newInterval.end || interval.end <= newInterval.start)
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
        }
        result.add(newInterval);
        return result;
    }
}
