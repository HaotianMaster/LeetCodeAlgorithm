class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted_indexes = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) {
            sorted_indexes.add(new int[]{indexes[i], i});
        }
        Comparator<int[]> mComparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0]; 
            }
        };
        Collections.sort(sorted_indexes, mComparator);
        for (int[] curr : sorted_indexes) {
            int idx = curr[0], pos = curr[1];
            String s = sources[pos], t = targets[pos];
            if (idx + s.length() > S.length()) continue;
            if (S.substring(idx, idx + s.length()).equals(s)) {
                S = S.substring(0, idx) + t + S.substring(idx + s.length());
            }
        }
        return S;
    }
}