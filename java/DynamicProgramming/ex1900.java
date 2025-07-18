import java.util.*;

public class ex1900 {

    class pos{
        int initialPosition;
        public pos(int initialPosition){
            this.initialPosition = initialPosition;
        }
    }

    /**
     * This method calculates the earliest and latest rounds in which two players
     * (firstPlayer and secondPlayer) can meet in a tournament of n players.
     *
     * Time Complexity: O(n log n) for the priority queue operations
     * Space Complexity: O(n) for the priority queues
     *
     * @param n the number of players in the tournament
     * @param firstPlayer first player
     * @param secondPlayer second player
     * @return an array containing the earliest and latest rounds in which
     * the two players can meet
     */
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] ans = new int[2];
        PriorityQueue<pos> pqMin = new PriorityQueue<>((a,b)->a.initialPosition-b.initialPosition);
        PriorityQueue<pos> pqMax = new PriorityQueue<>((a,b)->b.initialPosition-a.initialPosition);
        for (int i=1;i<=n;i++){
            pqMin.offer(new pos(i));
            pqMax.offer(new pos(i));
        }
        ans[0] = getEarliest(n, firstPlayer, secondPlayer, pqMin, pqMax);
        pqMin.clear();
        pqMax.clear();
        for (int i=1;i<=n;i++){
            pqMin.offer(new pos(i));
            pqMax.offer(new pos(i));
        }
        ans[1] = getLatest(n, firstPlayer, secondPlayer, pqMin, pqMax);
        return ans;
    }

    private int getEarliest(int n, int firstPlayer, int secondPlayer, PriorityQueue<pos> pqMin, PriorityQueue<pos> pqMax) {
        PriorityQueue<pos> tempMin = new PriorityQueue<>((a,b)->a.initialPosition-b.initialPosition);
        PriorityQueue<pos> tempMax = new PriorityQueue<>((a,b)->b.initialPosition-a.initialPosition);
        boolean isEven = n % 2 == 0;
        for (int i=1;i<=n/2;i++){
            int nGames = pqMin.size() / 2;
            for (int j= nGames;j> 0;j--) {
                if (pqMin.isEmpty()) return -1;
                int firstAdversary = pqMin.poll().initialPosition;

                if (pqMax.isEmpty()) return -1;
                int secondAdversary = pqMax.poll().initialPosition;

                if (firstAdversary == firstPlayer && secondAdversary == secondPlayer) return i;

            }
            if (!isEven) {
                if (pqMin.isEmpty()) return -1;
                int firstAdversary = pqMin.poll().initialPosition;
                tempMin.offer(new pos(firstAdversary));
                tempMax.offer(new pos(firstAdversary));
            }
            isEven = !isEven;
            pqMin = new PriorityQueue<>(tempMin);
            pqMax = new PriorityQueue<>(tempMax);
            tempMin.clear();
            tempMax.clear();
        }
        if (pqMin.isEmpty() || pqMax.isEmpty()) return -1;
        else {
            int firstAdversary = pqMin.poll().initialPosition;
            int secondAdversary = pqMax.poll().initialPosition;
            int round = n/2 + 1;
            if (firstAdversary == firstPlayer && secondAdversary == secondPlayer) return round;
            else if (firstAdversary == secondPlayer && secondAdversary == firstPlayer) return round;
            else return -1;
        }
    }

    private int getLatest(int n, int firstPlayer, int secondPlayer, PriorityQueue<pos> pqMin, PriorityQueue<pos> pqMax) {
        PriorityQueue<pos> tempMin = new PriorityQueue<>((a,b)->a.initialPosition-b.initialPosition);
        PriorityQueue<pos> tempMax = new PriorityQueue<>((a,b)->b.initialPosition-a.initialPosition);
        boolean isEven = n % 2 == 0;
        for (int i=1;i<=n/2;i++){
            int nGames = pqMin.size() / 2;
            for (int j= nGames;j> 0;j--) {
                if (pqMin.isEmpty()) return -1;
                int firstAdversary = pqMin.poll().initialPosition;

                if (pqMax.isEmpty()) return -1;
                int secondAdversary = pqMax.poll().initialPosition;

                if (firstAdversary == firstPlayer && secondAdversary == secondPlayer) return i;
                else if (firstAdversary == secondPlayer && secondAdversary == firstPlayer) return i;
                else {
                    if (secondAdversary == secondPlayer) {
                        tempMin.offer(new pos(secondAdversary));
                        tempMax.offer(new pos(secondAdversary));
                    }
                    else{
                        tempMin.offer(new pos(firstAdversary));
                        tempMax.offer(new pos(firstAdversary));
                    }
                }
            }
            if (!isEven) {
                if (pqMin.isEmpty()) return -1;
                int firstAdversary = pqMin.poll().initialPosition;
                tempMin.offer(new pos(firstAdversary));
                tempMax.offer(new pos(firstAdversary));
            }
            isEven = !isEven;
            pqMin = new PriorityQueue<>(tempMin);
            pqMax = new PriorityQueue<>(tempMax);
            tempMin.clear();
            tempMax.clear();
        }
        if (pqMin.isEmpty() || pqMax.isEmpty()) return -1;
        else {
            int firstAdversary = pqMin.poll().initialPosition;
            int secondAdversary = pqMax.poll().initialPosition;
            int round = n/2 + 1;
            if (firstAdversary == firstPlayer && secondAdversary == secondPlayer) return round;
            else if (firstAdversary == secondPlayer && secondAdversary == firstPlayer) return round;
            else return -1;
        }
    }

    public static void main(String[] args) {
        ex1900 solution = new ex1900();
        int n = 10;
        int firstPlayer = 1;
        int secondPlayer = 2;
        int[] result = solution.earliestAndLatest(n, firstPlayer, secondPlayer);
        System.out.println("Earliest: " + result[0]);
        System.out.println("Latest: " + result[1]);
    }
}