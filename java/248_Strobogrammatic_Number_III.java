//Runtime: 160ms
class Solution {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            if (i % 2 == 0) {
                helper(low, high, "", i);
            }
            else {
                helper(low, high, "0", i);
                helper(low, high, "1", i);
                helper(low, high, "8", i);
            }
        }
        return res;
    }
    public void helper(String low, String high, String curr, int len) {
        if (curr.length() == len) {
            if (Long.valueOf(curr) < Long.valueOf(low) || Long.valueOf(curr) > Long.valueOf(high)) {
                return;
            }
            res++;
            return;
        }
        if (curr.length() + 2 < len) {
            helper(low, high, "0" + curr + "0", len);
        }
        helper(low, high, "1" + curr + "1", len);
        helper(low, high, "6" + curr + "9", len);
        helper(low, high, "9" + curr + "6", len);
        helper(low, high, "8" + curr + "8", len);
    }
}

//60ms
class Solution {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            if (i % 2 == 0) {
                helper(low, high, "", i);
            }
            else {
                helper(low, high, "0", i);
                helper(low, high, "1", i);
                helper(low, high, "8", i);
            }
        }
        return res;
    }
    public void helper(String low, String high, String curr, int len) {
        if (curr.length() == len) {
            if ((curr.length() == low.length() && curr.compareTo(low) < 0) || (curr.length() == high.length() && curr.compareTo(high) > 0)) {
                return;
            }
            res++;
            return;
        }
        if (curr.length() + 2 < len) {
            helper(low, high, "0" + curr + "0", len);
        }
        helper(low, high, "1" + curr + "1", len);
        helper(low, high, "6" + curr + "9", len);
        helper(low, high, "9" + curr + "6", len);
        helper(low, high, "8" + curr + "8", len);
    }
}


//Runtime: 85ms...
class Solution {
    public int strobogrammaticInRange(String low, String high){
        int res = 0;
        List<String> list = new ArrayList<String>();
        for (int i = low.length(); i <= high.length(); i++){
            list.addAll(helper(i, i));
        }
        for (String num : list){
            if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) continue;
                res++;
        }
        return res;
    }

    public List<String> helper(int curr_len, int len) {
        if (curr_len == 0) return new ArrayList<String>(Arrays.asList(""));
        if (curr_len == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> res = new ArrayList<>();
        List<String> list = helper(curr_len - 2, len);
        for (int i = 0; i < list.size(); i++) {
            if (curr_len < len) res.add("0" + list.get(i) + "0");
            res.add("1" + list.get(i) + "1");
            res.add("6" + list.get(i) + "9");
            res.add("9" + list.get(i) + "6");
            res.add("8" + list.get(i) + "8");
        }
        return res;
    }
}