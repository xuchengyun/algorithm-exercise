class Solution {
    // // categoried by sorting array
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> res = new ArrayList<>();
    //     if (strs == null || strs.length == 0) return res;
    //     HashMap<String, List<String>> map = new HashMap<>();
    //     for (String str : strs) {
    //         char[] ch = str.toCharArray();
    //         Arrays.sort(ch);
    //         String s = new String(ch);
    //         if (map.containsKey(s)) {
    //             map.get(s).add(str);
    //         } else {
    //             List<String> temp = new ArrayList<>();
    //             temp.add(str);
    //             map.put(s, temp);
    //         }
    //     }
    //     return new ArrayList<>(map.values());
    // }
    
    // categoried by counting 
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            String s = "";
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            }
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}