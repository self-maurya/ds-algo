package array.simplepointers;

import java.util.ArrayList;

public class MyCalenderII {
    /*
    LeetCode – My Calendar II (Java)

    Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.

    Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open
    interval [start, end), the range of real numbers x such that start <= x < end. A triple booking happens when three
    events have some non-empty intersection (ie., there is some time that is common to all 3 events.) For each call to
    the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a
    triple booking. Otherwise, return false and do not add the event to the calendar. Your class will be called like
    this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     */

    ArrayList<int[]> single = null;
    ArrayList<int[]> overlap = null;

    public MyCalenderII() {
        single = new ArrayList<>();
        overlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] itv : overlap) {
            if (itv[0] < end && start < itv[1])
                return false;
        }

        for (int[] itv : single) {
            if (itv[0] < end && start < itv[1])
                overlap.add(new int[]{Math.max(start, itv[0]), Math.min(end, itv[1])});
        }

        single.add(new int[]{start, end});
        return false;
    }
}
