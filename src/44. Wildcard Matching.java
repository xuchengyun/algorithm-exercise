/*
so called greedy algorithm, traverse the array one time
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int scur = 0, pcur = 0;
        int star = -1, match = 0;
        while (scur < s.length()) {
            if (pcur < p.length() && (s.charAt(scur) == p.charAt(pcur) || p.charAt(pcur) == '?')) {
                scur++;
                pcur++;
            } else if (pcur < p.length() && p.charAt(pcur) == '*') {
                star = pcur;
                match = scur;
                pcur++;
            } else if (star != -1){
                pcur = star + 1;
                match++;
                scur = match;
            } else {
                return false;
            }
        }
        
        while (pcur < p.length() && p.charAt(pcur) == '*') {
            pcur++;
        }
        
        return pcur == p.length();
    }
}