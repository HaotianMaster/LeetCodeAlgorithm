// Recursion
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double result = 0.0;
        //Convert negative n to positive first.
        //-(n/2) is used to handle corner case of n=Integer.MIN_VALUE;
        //if n=Integer.MIN_VALUE, -n still equals to Integer.MIN_VALUE.
        if (n < 0) result = myPow(x, -(n/2));
        else result = myPow(x, n/2);
        if (n % 2 == 0) {           
            result = result*result;
        }
        else {
            result = x*result*result;
        }      
        if (n < 0) return 1/result;
        return result;
    }
}
// Iteration
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        
        double res = 1.0;
        double curr_product = x;
        
        if (n < 0) {
            n = -(n + 1);
            res = 1 / x; // n+1 to handle corner case of n=Integer.MIN_VALUE;
            curr_product = 1 / x;
        }
        
        for (int power = n; power > 0; power = power / 2) {
            if (power % 2 == 1) { // if n is odd
                res = res * curr_product;
            }
            curr_product *= curr_product;
        }
        return res;
    }
}