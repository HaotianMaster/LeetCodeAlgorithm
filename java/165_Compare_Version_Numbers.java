class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            int curr1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int curr2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (curr1 < curr2) return -1;
            if (curr1 > curr2) return 1;
            i++;
        }
        return 0;
    }
}