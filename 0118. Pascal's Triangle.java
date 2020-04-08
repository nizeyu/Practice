class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        result.add(list0);
        
        if (numRows == 1) {
            return result;
        }
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            
            for (int j = 0; j < result.get(i-1).size() - 1; j++) {
                int val = result.get(i-1).get(j) + result.get(i-1).get(j+1);
                list.add(val);
            }
            
            list.add(1);
            
            result.add(list);
        }
        
        return result;
    }
}
