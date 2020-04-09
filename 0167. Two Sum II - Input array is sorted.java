class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            }
        }
        
        return result;
    }
}
