package interviewcake.arraysandstrings;

import net.bencode.interviewcake.arraysandstrings.Meeting;
import net.bencode.interviewcake.arraysandstrings.MergingMeetingTimes;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MergingMeetingTimesTests {

    @Test
    public void GivenAListOfScrambledMeetingsWhenMergedThenASmallerListWithZeroOverlapsIsReturned() {

        var meetings = List.of(new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10));
        var mergedMeetings = MergingMeetingTimes.mergeRanges(meetings);
        Assert.assertEquals(3, mergedMeetings.size());

        // first meeting 0, 1
        Assert.assertEquals(0, mergedMeetings.get(0).getStartTime());
        Assert.assertEquals(1, mergedMeetings.get(0).getEndTime());

        // second meeting 3, 8
        Assert.assertEquals(3, mergedMeetings.get(1).getStartTime());
        Assert.assertEquals(8, mergedMeetings.get(1).getEndTime());

        // third meeting 9, 12
        Assert.assertEquals(9, mergedMeetings.get(2).getStartTime());
        Assert.assertEquals(12, mergedMeetings.get(2).getEndTime());

    }
}
