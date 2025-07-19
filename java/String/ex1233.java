import java.util.*;

public class ex1233 {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            // 26 for 'a' to 'z' and 1 for '/' (to handle folder structure)
            this.children = new TrieNode[27];
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index;
                if (ch == '/') index = 26;
                else index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean subfolder(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = (ch == '/') ? 26 : ch - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
                if (node.isEnd && i < word.length()-1 && word.charAt(i+1)=='/') return true;
            }
            return false;
        }
    }

    /**
     * Given a list of folders, this method removes subfolders.
     * It sorts the folders and uses a Trie to check if a folder is a
     * subfolder of any previously added folder.
     *
     * Time Complexity: O(n * m log n), where n is the number of folders and
     * m is the average length of the folder names.
     * Space Complexity: O(n * m), where n is the number of folders and
     *
     * @param folder an array of folder paths
     * @return a list of folder paths with subfolders removed
     */
    public List<String> removeSubfolders(String[] folder) {
        ArrayList<String> result = new ArrayList<>();
        Trie trie = new Trie();
        Arrays.sort(folder);
        for (String f : folder) {
            if (!trie.subfolder(f)) {
                result.add(f);
                trie.insert(f);
            }
        }
        return result;
    }


    /*public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(f);
            }
        }
        return result;
    }

    public List<String> removeSubfolders(String[] folder) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            boolean isSubfolder = false;
            String temp = "";
            String[] parts = f.split("/");
            for (int i=1; i<parts.length-1; i++) {
                temp += "/" + parts[i];
                if (set.contains(temp)) {
                    isSubfolder = true;
                    break;
                }
            }
            if (!isSubfolder) {
                set.add(f);
                result.add(f);
            }
        }
        return result;
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (folder[i] == null) {
                continue; // Skip already processed folders
            }
            String f = folder[i];
            result.add(f);
            for (int j=i+1; j<folder.length; j++) {
                String f2 = folder[j];
                if (f2.startsWith(f+"/")) {
                    folder[j] = null;
                }
            }
        }
        return result;
    }*/

    public static void main(String[] args) {
        ex1233 solution = new ex1233();
        String[] folders = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> result = solution.removeSubfolders(folders);
        System.out.println(result);
    }
}