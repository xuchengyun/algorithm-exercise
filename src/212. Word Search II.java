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

class Solution {

    public List<String> findWords(char[][] boards, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = boards.length;
        int n= boards[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(boards, root, res, i, j);
            }
        }
    }

    public void dfs(char[][] boards, TrieNode node, List<String> res, int i, int j) {
        if (i < 0 || i > boards.length || j < 0 || j > boards[0].length) return;
        char c = boards[i][j];
        int k = c - 'a';
        if (c == '#' || node.children[k] == null) return;
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        node = node.children[k];
        boards[i][j] = '#' //visited
        dfs(boards, node, res, i + 1, j);
        dfs(boards, node, res, i - 1, j);
        dfs(boards, node, res, i, j - 1);
        dfs(boards, node, res, i, j + 1);
        boards[j][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curNode = root;
            char[] cArray = word.toCharArray();
            for (char c : cArray) {
                int k = c - 'a';
                if (curNode.children[k] == null) {
                    curNode.children[k] = new TrieNode();
                }
                curNode  = curNode.children[k];
            }
            curNode.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}