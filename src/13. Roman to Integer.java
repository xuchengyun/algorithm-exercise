// Using map to store data
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int len = s.length();
        int res = 0, pre = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (value <= pre) {
                res += value;
            } else {
                res += value - 2 * pre;
            }
            pre = value;
        }
        return res;
    }
}