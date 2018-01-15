public class titleToNumber {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            res = res * 26 + (tmp - 'A' + 1);
        }
        
        return res;
    }
}
