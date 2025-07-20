import java.util.*;

class ex1948{

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode("");
        }

        public void insert(List<String> words) {
            TrieNode node = root;
            for (String word : words) {
                if (!node.children.containsKey(word)) {
                    TrieNode child = new TrieNode(word);
                    child.parent = node; // Set parent
                    node.children.put(word, child);
                }
                node = node.children.get(word);
            }
        }
    }

    class TrieNode {
        String str;
        HashMap<String, TrieNode> children;
        TrieNode parent; // Add parent reference
        boolean deleted; // Flag to mark if the node is deleted

        public TrieNode(String str) {
            this.str = str;
            this.children = new HashMap<>();
            this.parent = null;
            this.deleted = false; // Initialize deleted as false
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (List<String> path : paths) {
            trie.insert(path);
        }
        HashMap<String,List<TrieNode>> map = new HashMap<>();
        serialize(trie.root, map);
        Set<TrieNode> toDelete = new HashSet<>();
        for (List<TrieNode> nodes : map.values()) {
            if (nodes.size() > 1) {
                for (TrieNode node : nodes) markDeleted(node, toDelete);
            }
        }
        prune(trie.root, toDelete);
        collectPaths(trie.root, new ArrayList<>(), result);
        return result;
    }

    private void collectPaths(TrieNode node, List<String> path,
                              List<List<String>> result) {
        for (TrieNode child : node.children.values()) {
            path.add(child.str);                  // add this folder to path
            result.add(new ArrayList<>(path));   // record this path
            collectPaths(child, path, result);   // recurse
            path.remove(path.size() - 1);        // backtrack
        }
    }

    private void markDeleted(TrieNode node, Set<TrieNode> toDelete) {
        toDelete.add(node);
        for (TrieNode child : node.children.values()) markDeleted(child, toDelete);
    }

    private void prune(TrieNode node, Set<TrieNode> toDelete) {
        List<String> keysToRemove = new ArrayList<>();
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (toDelete.contains(child)) {
                keysToRemove.add(entry.getKey());
            } else {
                prune(child, toDelete);
            }
        }
        for (String key : keysToRemove) {
            node.children.remove(key);
        }
    }

    private String serialize(TrieNode node, Map<String, List<TrieNode>> map) {
        if (node.children.isEmpty()) return "";
        List<String> serials = new ArrayList<>();
        for (TrieNode child : node.children.values())
            serials.add(child.str + "(" + serialize(child, map) + ")");
        Collections.sort(serials);
        String serial = String.join("", serials);
        map.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }


    public static void main(String[] args) {
        ex1948 obj = new ex1948();
        List<List<String>> paths = new ArrayList<>(Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("d"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("d", "a")
        ));
        List<List<String>> result = obj.deleteDuplicateFolder(paths);
        System.out.println(result);
    }

}