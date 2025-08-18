import java.util.*;

class ex0837{
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }
        double windowSum = 0.0;
        for (int i = k; i <= k+maxPts; i++) {
            if (i <= n) {
                windowSum += 1.0;
            }
        }
        HashMap<Integer, Double> dp = new HashMap<>();
        for (int i = k - 1; i >= 0; i--) {
            dp.put(i, windowSum / maxPts);
            double remove = 0.0;
            if (i + maxPts <= n) {
                remove = dp.getOrDefault(i + maxPts, 1.0);
            }
            windowSum += dp.get(i) - remove;
        }
        return dp.get(0);
    }

}