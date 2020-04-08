class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        
        return maxProfit;
    }
}
