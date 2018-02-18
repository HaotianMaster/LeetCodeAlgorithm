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
        double ans = 1;
        double current_product = x;
        if (n < 0) {
            ans *= 1/x;
            n = -(n+1);
            current_product = 1/x;
        }                
        for (int power = n; power > 0; power /= 2) {
            if ((power % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}