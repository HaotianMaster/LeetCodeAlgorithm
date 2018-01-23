class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // First base case; if user requests zero rows, they get zero rows.
        if (numRows==0) return result;
        
        // Second base case; first row is always [1].
        result.add(new ArrayList<>());
        result.get(0).add(1);
        int currRows = 1;
        while (currRows<numRows) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = result.get(currRows-1);
            curr.add(1);
            for (int i=0; i<prev.size()-1;i++) {
                curr.add(prev.get(i)+prev.get(i+1));
            }
            curr.add(1);
            result.add(curr);
            currRows++;
        }
        return result;
    }
}
