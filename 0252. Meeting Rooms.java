class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        int[] pre = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < pre[1]) {
                return false;
            } else {
                pre = intervals[i];
            }
        }
        
        return true;
    }
}
