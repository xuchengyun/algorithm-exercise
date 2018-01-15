/*
increase pointer
if current character is 1
pointer plus 2
if current character is 0
pointer plus 1
check whether pointer equals len - 1
*/
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length, i = 0;
        while (i < len - 1) {
            if (bits[i] == 0) {
                i += 1;
            } else {
                i +=2 ;
            }
        }
        return i == len - 1;
    }
}