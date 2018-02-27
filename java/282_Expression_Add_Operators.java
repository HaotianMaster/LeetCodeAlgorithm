class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        addHelper(res, "", num, target, 0, 0, 0);
        return res;
    }
    public void addHelper(List<String> res, String path, String num, int target, int pos, long currsum, long multi) {
        if (pos == num.length() && target == currsum) {
            res.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long curr = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                addHelper(res, path+curr, num, target, i+1, currsum + curr, multi + curr);
            }
            else {
                addHelper(res, path + "+" + curr, num, target, i+1, currsum + curr, curr);
                addHelper(res, path + "-" + curr, num, target, i+1, currsum - curr, -curr);
                addHelper(res, path + "*" + curr, num, target, i+1, currsum - multi + multi * curr, multi * curr);
            }
        }
    }
}