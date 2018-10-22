/*
DFS first
 */

class Solution {
    // this method is a little bit slow
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        // used to remove duplicates
        Set<String> visited = new HashSet<>();


        // so smart!!! if we meet a valid, we just need to check until queue is empty
        boolean flag = false;

        while (!q.isEmpty()) {
            s = q.poll();
            if (isValid(s)) {
                res.add(s);
                flag = true;
            }

            if (flag == true) continue;


            for (int i = 0; i < s.length(); i++) {
                // we only remove left para of right para
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    q.add(t);
                    visited.add(t);
                }

            }
        }
        return res;
    }

    public boolean isValid(String s) {
        // Using cnt to implement this method
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cnt < 0) return false;
            if (s.charAt(i) == '(') cnt++;
            if (s.charAt(i) == ')') cnt--;
        }
        return cnt == 0;
    }



}

class Solution {
    // cnt1 extra left param
    // cnt2 extra right param
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
        int cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt1++;
            }
            if (c == ')') {
                cnt2++;
            }
            if (cnt1 > cnt2) {
                cnt1 -= cnt2;
                cnt2 = 0;
            } else {
                cnt2 -= cnt1;
                cnt1 = 0;
            }
        }
        helper (cnt1, cnt2, res, s);
    }

    public void helper(int cnt1, int cnt2, List<String> res, String s) {
        if (cnt1 == 0 && cnt2 == 0) {
            res.add(s);
            return;
        }

        for (int i = 0; i < res.length(); i++) {
            if (cnt1 > 0 && s.charAt(i) == '(') {
                helper(cnt1 - 1, cnt2, res, s.substring(0, i) + s.substring(i + 1));
            }

            if (cnt2 > 0 && s.charAt(i) == ')') {
                helper(cnt1, cnt2 - 1, res, substring(0, i) + s.substring(i + 1));
            }
        }
    }
}