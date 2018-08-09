/*
Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Output: ["eat","oath"]
 */


class Solution {

    List<String> res = new ArrayList<String>();
    public List<String> findWords(char[][] boards, String[] words) {
        for (String str: words) {
            boolean[][] visited = new boolean[boards.length][boards[0].length];
            for (int i = 0; i < boards.length; i++) {
                for (int j = 0; j < boards[0].length; j++) {
                    dfs(str, boards, i, j, 0, visited);
                }
            }
        }
        return res;
    }

    public void dfs(String str, char[][] boards, int i, int j, int pos, boolean[][] visited) {
        if (pos == str.length()) {
            res.add(str);
            return;
        }
        if (i < 0 || i >= boards.length || j < 0 || j >= boards[0].length) return;
        if (!visited[i][j]) return;
        if (boards[i][j] != str.charAt(pos)) return;
        visited[i][j] = true;
        dfs(str, boards, i - 1, j, pos + 1, visited);
        dfs(str, boards, i + 1, j, pos + 1, visited);
        dfs(str, boards, i, j - 1, pos + 1, visited);
        dfs(str, boards, i, j + 1, pos + 1, visited);
    }
}