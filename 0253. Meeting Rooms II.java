class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0; 
        }    
            
        int min = 0; int max = 0; 
        for(int i=0; i<intervals.length; i++) { 
            min = Math.min(min, intervals[i][0]); 
            max = Math.max(max, intervals[i][1]); 
        } 
           
        int[] count = new int[max-min+1]; 
        for(int i=0; i<intervals.length; i++){ 
            count[intervals[i][0]]++; 
            count[intervals[i][1]]--; 
        } 
        
        int maxroom = Integer.MIN_VALUE; 
        int num = 0; 
        for(int i=0; i<count.length; i++){ 
            num += count[i]; 
            maxroom = Math.max(maxroom, num); 
        } 
        return maxroom; 
    }
}
