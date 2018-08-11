/*
1. sign(+, -)
2. overflow
3. = 0 eg. 3/5
4. normal case
*/

class Solution {
    public int divide(int dividend, int divisor) {
        // consider sign first
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            // reverse the sign
            sign = -1;
        }
        
        // consider overflow
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        // edge cases
        if (ldividend < ldivisor) {
            return 0;
        }    
        long lres = ldivide(ldividend, ldivisor);    
        
        int res = 0;
        // consider overflow
        if (lres > Integer.MAX_VALUE) {
            res = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = (int)lres * sign;
        }
        return res;
    }
    
    public long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        // Find the largest multiple so that (divisor * multiple <= dividend), 
        // For log(n) time complexity. Think binary search 
        long sum = ldivisor;
        long multiple = 1;
        while (sum * 2 <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}