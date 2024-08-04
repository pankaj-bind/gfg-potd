class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
        // Create a list of meetings
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }
        
        // Sort meetings by their end time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));
        
        int count = 0;
        int lastEndTime = -1;
        
        // Iterate through the meetings and select the ones that do not overlap
        for (Meeting meeting : meetings) {
            if (meeting.start > lastEndTime) {
                count++;
                lastEndTime = meeting.end;
            }
        }
        
        return count;
    }

    // Helper class to represent a meeting
    static class Meeting {
        int start;
        int end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
