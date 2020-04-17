class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort by ascending starting point
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        List<int[]> list = new ArrayList<>();
        int[] pre = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            if(i > 0 && intervals[i][0] <= pre[1]) {
                int s = pre[0];
                int e = Math.max(intervals[i][1], pre[1]);
                pre = new int[]{s, e};
            } else {
                list.add(pre);
                pre = intervals[i];
            }
        }
        list.add(pre);
        
        // convert the list to Array as expected.
        int[][]result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];

        }
        
        return result;
    }
}
