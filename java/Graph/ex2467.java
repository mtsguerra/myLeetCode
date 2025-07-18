import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ex2467 {
    /**
     * Calculates the most profitable path in a tree where
     * on player start at the root and the other at bob while
     * they traverse simultaneously
     * @param edges array of the tree connections
     * @param bob starting position of Bob
     * @param amount array of the values in each node
     * @return Maximum possible score achievable
     */
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i=0;i<amount.length;i++){
            tree.add(new ArrayList<>());
        }
        /**
         * creates the graph
         */
        for (int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]); // Add this line
        }

        Stack<Integer> pathBob = new Stack<>();
        findPath(tree, 0, bob, -1, pathBob);
        int[] bobDistances = new int[edges.length+1];
        Arrays.fill(bobDistances, -1);
        int i=0;
        // after finding bobs path it fills an array with the number of seconds to go into that node
        while (!pathBob.isEmpty()){
            bobDistances[pathBob.pop()] = i++;
        }

        int initialAmount = (bob==0) ? amount[0] / 2 : amount[0];
        // starts dist as 1 because initial amount is already starting as amount[0] and not 0
        return findScores(tree, 0, -1, initialAmount, 1, bobDistances, Integer.MIN_VALUE, amount);
    }

    /**
     * Uses DFS to find the path from the root to the bobs start node
     * @param tree graph of the tree
     * @param node keeps track of the current node
     * @param target bobs position
     * @param parent last node visited
     * @param pathBob stack to store the current path
     * @return the correct path
     */
    private boolean findPath(List<List<Integer>> tree, int node,
    int target, int parent, Stack<Integer> pathBob){
        pathBob.push(node);
        if (node == target) return true;
        // takes in account all the possible children from the node
        for (int child : tree.get(node)){
            if (child != parent){
                // takes the child as the new node and the node as the new parent
                if (findPath(tree, child, target, node, pathBob)){
                    return true;
                }
            }
        }
        pathBob.pop();
        return false;
    }

    /**
     * Find the possible scores and return the max
     * @param tree graph of the tree
     * @param node keeps track of the current node
     * @param parent last node visited
     * @param currentScore current score in this path
     * @param dist number of seconds spent
     * @param bobDistances array that stores the seconds spent on bobs side until a certain node
     * @param highestScore stores the highest score until
     * @param amounts array that keeps the values of the nodes
     * @return the highest score achievable
     */
    private int findScores (List<List<Integer>> tree, int node, int parent,
    int currentScore, int dist, int[] bobDistances,
    int highestScore, int[] amounts){
        // starts the current as a leaf
        boolean isLeaf = true;
        for (int child : tree.get(node)){
            if (child != parent){
                // means there's at least one child to that node
                isLeaf = false;
                // creates an int so it can be manipulated it without changing the original score
                int next = currentScore;
                // bob doesn't go that way or the current spent seconds is inferior to bobs
                if (bobDistances[child] == -1 || dist < bobDistances[child]){
                    next+=amounts[child];
                }
                // both get to that node at the same time
                else if (dist == bobDistances[child]){
                    next+=amounts[child] / 2;
                }
                highestScore = Math.max(highestScore, findScores(tree, child, node, next, dist+1, bobDistances, highestScore, amounts));
            }
        }
        return isLeaf ? currentScore : highestScore;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        int bob = 3;
        int[] amount = {-2,4,2,-4,6};
        ex2467 myo = new ex2467();
        System.out.println(myo.mostProfitablePath(edges, bob, amount));
    }
}