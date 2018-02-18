import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        System.out.println(s);
        int i = 0; int j = s.length()-1;
        System.out.println(i);
        System.out.println(j);
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
    int x = 0;
	Solution sol = new Solution();
	sol.isPalindrome(x);        
    }
    public static void main(String[] args) {
    
    }
}



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String[] crosswordPuzzle(String[] crossword, String hints) {
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] crossword = new String[10];
        for(int crossword_i = 0; crossword_i < 10; crossword_i++){
            crossword[crossword_i] = in.next();
        }
        String hints = in.next();
        String[] result = crosswordPuzzle(crossword, hints);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}