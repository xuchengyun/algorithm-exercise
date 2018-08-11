import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuchengyun on 8/8/18.
 */
public class Test{



    public List<String> findWords(char[][] boards, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
//        for (TrieNode t :root.children) {
//            System.out.println(t);
//        }
        int m = boards.length;
        int n = boards[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(boards, root, res, i, j);
            }
        }
        return res;
    }

    public void dfs(char[][] boards, TrieNode node, List<String> res, int i, int j) {
        if (i < 0 || i >= boards.length || j < 0 || j >= boards[0].length) return;
        char c = boards[i][j];
        int k = c - 'a';
        if (c == '#' || node.children[k] == null) return;
        node = node.children[k];
        boards[i][j] = '#'; //visited
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        dfs(boards, node, res, i + 1, j);
        dfs(boards, node, res, i - 1, j);
        dfs(boards, node, res, i, j - 1);
        dfs(boards, node, res, i, j + 1);
        boards[i][j] = c;
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

        public static void main(String[] args) {
            char[][] boards = new char[][] {{'o','a','a','n'}, {'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
            String[] words = new String[] {"oath","pea","eat","rain"};
            Test t = new Test();
            for (String s : t.findWords(boards, words)) {
                System.out.println(s);
            }
        }
}
