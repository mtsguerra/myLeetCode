// LeetCode Problem 208: Implement Trie (Prefix Tree)

public class ex0208 {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode crr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (crr.children[index] == null) {
                    crr.children[index] = new TrieNode();
                }
                crr = crr.children[index];
            }
            crr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode crr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (crr.children[index] == null) return false;
                crr = crr.children[index];
            }
            return crr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode crr = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (crr.children[index] == null) return false;
                crr = crr.children[index];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String word = "apple";
        String prefix = "app";
        ex0208 obj = new ex0208();
        ex0208.Trie trie = obj.new Trie();
        trie.insert(word);
        boolean param_2 = trie.search(word);
        boolean param_3 = trie.startsWith(prefix);
        System.out.println("Search for '" + word + "': " + param_2);
        System.out.println("Starts with '" + prefix + "': " + param_3);
    }
}