import java.util.*;

class ex2322{

    class Node {
        int to;
        public Node(int to) {
            this.to = to;
        }
    }

    public int minimumScore(int[] nums, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Node> [] graph = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Node(edge[1]));
            graph[edge[1]].add(new Node(edge[0]));
        }
        int[] xor = new int[nums.length];
        int[] in = new int[nums.length];
        int[] out = new int[nums.length];
        int[] time = new int[1];
        dfs(xor, in, out, graph, nums, 0,-1, time);

        int lowestScore = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {

                int[] edge1 = edges[i];
                int[] edge2 = edges[j];

                int a = (in[edge1[0]] > in[edge1[1]]) ? edge1[0] : edge1[1];
                int b = (in[edge2[0]] > in[edge2[1]]) ? edge2[0] : edge2[1];

                boolean isParentEd1 = isAncestor(in, out, a, b);
                boolean isParentEd2 = isAncestor(in, out, b, a);

                int xor1 = xor[0];
                int xor2 = xor[a];
                int xor3 = xor[b];
                if (isParentEd1) {
                    xor1 ^= xor2;
                    xor2 ^= xor3;
                }
                else if (isParentEd2) {
                    xor1 ^= xor3;
                    xor3 ^= xor2;
                }
                else {
                    xor1 ^= xor2 ^ xor3;
                }
                int biggest = Math.max(Math.max(xor1, xor2), xor3);
                int smallest = Math.min(Math.min(xor1, xor2), xor3);
                int score = biggest - smallest;
                lowestScore = Math.min(lowestScore, score);
            }
        }
        return lowestScore;
    }

    boolean isAncestor(int[] in, int[] out, int parent, int child) {
        return in[parent] <= in[child] && out[parent] >= out[child];
    }

    private void dfs (int[] xor, int[] in, int[] out, List<Node>[] graph,
                      int[] nums, int node,
                      int parent, int[] time) {
        in[node] = time[0]++;
        xor[node] = nums[node];
        for (Node child : graph[node]) {
            if (child.to != parent){
                dfs(xor, in, out, graph, nums, child.to, node, time);
                xor[node] ^= xor[child.to];
            }
        }
        out[node] = time[0]++;
    }

    /*
    public int minimumScore(int[] nums, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Node> [] graph = new ArrayList[nums.length];
        int[] level = new int[nums.length];
        Arrays.fill(level, Integer.MAX_VALUE);
        level[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Node(edge[1]));
            graph[edge[1]].add(new Node(edge[0]));
        }
        // BFS to find the level of each node
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Node child : graph[node]) {
                if (level[child.to] == Integer.MAX_VALUE) {
                    level[child.to] = level[node] + 1;
                    q.add(child.to);
                }
            }
        }
        HashMap<Integer, List<Integer>> nodesPerLevel = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nodesPerLevel.computeIfAbsent(level[i], k -> new ArrayList<>()).add(i);
        }

        HashMap<Integer, HashSet<Integer>> subTrees = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            subTrees.put(i,new HashSet<>());
        }
        Set<Integer> visited = new HashSet<>();
        for (List<Integer> temp : nodesPerLevel.values()) {
            for (int node : temp) {
                Queue<Integer> queue  = new LinkedList<>();
                visited.add(node);
                Set<Integer> visitedCp = new HashSet<>(visited);
                queue.add(node);
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (Node child : graph[current]) {
                        if (!visitedCp.contains(child.to)) {
                            subTrees.get(node).add(child.to);
                            queue.add(child.to);
                            visitedCp.add(child.to);
                        }
                    }
                }
            }
        }
        HashMap<Integer, Integer> nodesXOR = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nodesXOR.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int child : subTrees.get(i)) {
                nodesXOR.put(i, nodesXOR.get(i) ^ nums[child]);
            }
        }

        int lowestScore = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                int[] edge1 = edges[i];
                int[] edge2 = edges[j];
                boolean isParentEd1 = false;
                boolean isParentEd2 = false;
                int xor1 = nodesXOR.get(0);
                int xor2Parent = level[edge1[0]] > level[edge1[1]] ?
                        edge1[0] : edge1[1];
                int xor3Parent = level[edge2[0]] > level[edge2[1]] ?
                        edge2[0] : edge2[1];
                if (subTrees.get(xor2Parent).contains(xor3Parent)) isParentEd1 = true;
                if (subTrees.get(xor3Parent).contains(xor2Parent)) isParentEd2 = true;
                int xor2 = nodesXOR.get(xor2Parent);
                int xor3 = nodesXOR.get(xor3Parent);
                if (isParentEd1) {
                    xor1 ^= xor2;
                    xor2 ^= xor3;
                }
                else if (isParentEd2) {
                    xor1 ^= xor3;
                    xor3 ^= xor2;
                }
                else {
                    xor1 ^= xor2 ^ xor3;
                }
                int biggest = Math.max(Math.max(xor1, xor2), xor3);
                int smallest = Math.min(Math.min(xor1, xor2), xor3);
                int score = biggest - smallest;
                lowestScore = Math.min(lowestScore, score);
            }
        }
        return lowestScore;
    }*/

    public static void main(String[] args) {
        ex2322 solution = new ex2322();
        int[] nums = {9,14,2,1};
        int[][] edges = {{2,3},{3,0},{3,1}};
        int result = solution.minimumScore(nums, edges);
        System.out.println("Minimum Score: " + result);
    }
}