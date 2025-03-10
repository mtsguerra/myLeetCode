public class ex0983 {

    public int mincostTickets(int[] days, int[] costs) {
        return mincostTicketsRecursive(days, costs, 0, 0, new int[days.length]);
    }
    public int mincostTicketsRecursive(
        int[] days,
        int[] costs,
        int currentDay, // keep track in the index day
        int lastPassExp, // gives the day until the pass is valid
        int dp[]){
        // got to the final day
        if (currentDay>=days.length) return 0;
        // if the day its still on the valid range return with the next day
        if (days[currentDay] <= lastPassExp) return mincostTicketsRecursive(days, costs, currentDay+1, lastPassExp, dp);
        // if the currentDay already have a min cost just return it
        if (dp[currentDay] != 0) return dp[currentDay];
        // calcs the min cost of all the possible passes
        int minCost = Math.min(
            costs[0] + mincostTicketsRecursive(days, costs, currentDay+1, days[currentDay], dp),
            Math.min(
            costs[1] + mincostTicketsRecursive(days, costs, currentDay+1, days[currentDay] + 6, dp),
            costs[2] + mincostTicketsRecursive(days, costs, currentDay+1, days[currentDay] + 29, dp))
        );
        // sets the min to get till that day
        dp[currentDay] = minCost;
        return minCost;
    }
}
