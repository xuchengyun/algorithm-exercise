// Using two hashmaps
// 1. the length of words are the same
// 
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // corner case 
        if (words == null || s == null) return new ArrayList<>();
        
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int wordsLength = words.length;
        int wordLength = words[0].length(); // all the words have the same length
        // traverse the string, until it cannot contain the last combination
        for (int i = 0; i <= s.length() - wordsLength * wordLength; i++) {
            // copy can be modified
            HashMap<String, Integer> copy = new HashMap<>(map);
            // local variable
            int m = i;
            int k = wordsLength;
            while (k > 0) {
                String str = s.substring(m, m + wordLength);
                if (!copy.containsKey(str) || copy.get(str) == 0) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                m += wordLength;
                k--;
            }
            
            if (k == 0) {
                res.add(i);
            }
        }
        return res;
    }
}