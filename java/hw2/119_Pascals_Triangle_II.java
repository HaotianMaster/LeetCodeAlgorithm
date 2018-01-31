//The intuitvie solution.
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        List<List<Integer>> results = generate(rowIndex+1);
        return results.get(rowIndex);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    List<Integer> prev = results.get(i-1);
                    int temp = prev.get(j-1)+prev.get(j);
                    list.add(temp);
                }
            }
            results.add(list);
        }
        return results;
    }
}

// O(2K) space solution. 
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        int numRows = rowIndex+1;
        List<Integer> prev = new ArrayList<>();
        prev.add(1);       
        for (int i=1; i<numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                }
                else {
                    curr.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev = curr;
        }
        return prev;
    }
}

// O(K) space solution.
// but I dont know how to come up with this solution by myself.
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<>();
        if (rowIndex < 0) return curr;
        int numRows = rowIndex+1;      
        for (int i=0; i<numRows; i++) {
            curr.add(0, 1);
            for (int j=1; j<curr.size()-1; j++) {
                curr.set(j, curr.get(j)+curr.get(j+1));
            }
        }
        return curr;
    }
}













