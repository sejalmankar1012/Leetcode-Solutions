class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // Add 1 at the beginning of each row
            row.add(1);
            
            // Calculate values for the current row
            for (int j = 1; j < i; j++) {
                List<Integer> previousRow = triangle.get(i-1);
                int num = previousRow.get(j-1) + previousRow.get(j);
                row.add(num);
            }
            
            // Add 1 at the end of each row
            if (i > 0) {
                row.add(1);
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }
}
