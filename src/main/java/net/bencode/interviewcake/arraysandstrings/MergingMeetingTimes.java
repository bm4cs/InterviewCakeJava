package net.bencode.interviewcake.arraysandstrings;

import java.util.*;
import java.util.stream.Collectors;

// Edge cases:
// * are meetings on the same day?
// * one meeting ends, and another starts on same time slot
//

public class MergingMeetingTimes {

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        return mergeMeetingsLinearTime(meetings);
//        return mergeMeetingsBruteForceInQuadraticTime(meetings);
    }


    // O(n) attempt
    private static List<Meeting> mergeMeetingsLinearTime(List<Meeting> meetings) {

        // 48 30min slots in one day
        int[] timeslots = new int[48];
        Arrays.fill(timeslots, 0);

        // keep journal of time slots
        // 0 = no meetings
        // 1 = in meeting
        // 2 = end of meeting
        for (Meeting m : meetings) {
            for (int i = m.getStartTime(); i <= m.getEndTime(); i++) {

                if (i == m.getEndTime() && timeslots[i] != 1) {
                    timeslots[i] = 2;
                }
                else {
                    timeslots[i] = 1;
                }
            }
        }

        // generate list of meetings from time slot journal
        List<Meeting> mergedMeetings = new ArrayList<>();
        boolean foundMeeting = false;
        int startTime = -1, endTime = -1;

        for (int i = 0; i < timeslots.length; i++) {

            if (timeslots[i] == 1 && !foundMeeting) {
                foundMeeting = true;
                startTime = i;
            }

            if (timeslots[i] == 2 && foundMeeting) {
                endTime = i;
                mergedMeetings.add(new Meeting(startTime, endTime));
                foundMeeting = false;
                startTime = endTime = -1;
            }
        }

        return mergedMeetings;
    }


    private static List<Meeting> mergeMeetingsInNLogarithmicTime(List<Meeting> meetings) {

        // yes my brute force sucks O(n^2)
        // how can I do it in just one sweep...
        // well comparison is currently a pain, due to all teh meetings being in random order
        // merge sort first? O(logn)
        // then merge the overlapping meetings together? O(n)
        // overall = O(nlogn) which is not O(n), but better

        //TODO: implement this

        return null;
    }



    // O(n^2) time - poor
    private static List<Meeting> mergeMeetingsBruteForceInQuadraticTime(List<Meeting> meetings) {
        int latestEndTime = 0;

        for (Meeting meetingA : meetings) {

            for (Meeting meetingB : meetings) {

                if (meetingA.equals(meetingB)) {
                    continue;
                }

                // merge candidate?
                if (meetingA.getStartTime() <= meetingB.getStartTime() &&
                        meetingA.getEndTime() >= meetingB.getStartTime()) {

                    latestEndTime = Math.max(meetingA.getEndTime(), meetingB.getEndTime());
                    meetingA.setEndTime(latestEndTime);
                    meetingB.setStartTime(-1);
                    meetingB.setEndTime(-1);
                }
            }
        }

        return meetings.stream().filter(m -> m.getStartTime() != -1).collect(Collectors.toList());
    }
}
