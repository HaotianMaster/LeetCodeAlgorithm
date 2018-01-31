class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        //00, 11, 69, 96, 88
        String candidate = "00, 11, 69, 96, 88";
        for (int i=0, j=num.length()-1; i<=j; i++, j--) {
            CharSequence curr = num.charAt(i) + "" + num.charAt(j);
            if (!candidate.contains(curr)) return false;
        }
        return true;
    }
}