import java.util.Arrays;

public class ex1718 {
    public int[] constructDistancedSequence(int n) {
        int siz = 1 + (n-1)*2;
        int[] f = new int[siz];
        boolean[] inserted = new boolean[n+1];
        inserted[0] = true;
        fillTheRest(f, inserted, 1, n);
        return f;
    }
    private boolean fillTheRest (int[] f, boolean[] inserted, int pos, int n) {
        if (pos >= f.length) return true;
        if (f[pos] != 0) return fillTheRest(f, inserted, pos+1, n);
        for (int i = n;i>=1;i--){
            if (inserted[i]) continue;
            int sec = i==1?pos:pos+i;
            if (sec < f.length && f[sec]==0){
                f[pos] = i;
                f[sec] = i;
                inserted[i] = true;
                if (fillTheRest(f, inserted, pos+1, n)) return true;
                f[pos] = 0;
                f[sec] = 0;
                inserted[i] = false;
            }
        }
        return false;
    }
}
