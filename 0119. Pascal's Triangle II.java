class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            
            for (int j = 0; j < result.size() - 1; j++) {
                int val = result.get(j) + result.get(j+1);
                list.add(val);
            }
            
            list.add(1);
            
            result = list;
        }
        
        return result;
    }
}
