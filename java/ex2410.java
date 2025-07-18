import java.util.*;

public class ex2410 {

    /**
     * This method matches players with trainers based on their skill levels.
     * Players can only be matched with trainers whose skill level is greater
     * than or equal to the player's skill level.
     *
     * Time Complexity: O(n log n) where n is the number of players or trainers
     * Space Complexity: O(1) for the count variable
     *
     * @param players An array of integers representing the skill levels of players.
     * @param trainers An array of integers representing the skill levels of trainers.
     * @return The number of players that can be matched with trainers.
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int i = 0, j = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
            }
            j++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}