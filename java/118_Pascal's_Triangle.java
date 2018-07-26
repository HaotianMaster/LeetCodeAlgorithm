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

// My implementation for hw2
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(); 
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int num = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    list.add(num);
                }
            }
            res.add(list);
        }
        return res;
    }
}





