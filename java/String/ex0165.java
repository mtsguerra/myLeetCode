import java.util.*;

class ex0165{

    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1; if version1 < version2 return -1;
     * otherwise return 0.
     *
     * Time Complexity: O(m + n), where m and n are the lengths of version1
     * and version2 respectively.
     * Space Complexity: O(1), as we are using only a constant amount of extra
     *
     * @param version1 A string representing the first version number.
     * @param version2 A string representing the second version number.
     * @return 1 if version1 > version2, -1 if version1 < version2, otherwise 0.
     */
    public int compareVersion(String version1, String version2) {
        // Split the version strings into their respective components
        String[] revised1 = version1.split("\\.");
        String[] revised2 = version2.split("\\.");
        int length = Math.min(revised1.length, revised2.length);
        for (int i = 0; i < length; i++) {
            int comp = Integer.compare(Integer.parseInt(revised1[i]),
                    Integer.parseInt(revised2[i]));
            if (comp != 0) return comp;
        }
        if (revised1.length > revised2.length) {
            for (int i= length; i < revised1.length; i++) {
                if (Integer.parseInt(revised1[i]) != 0) return 1;
            }
        }
        else if (revised1.length < revised2.length) {
            for (int i= length; i < revised2.length; i++) {
                if (Integer.parseInt(revised2[i]) != 0) return -1;
            }
        }
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        String[] revised1 = version1.split("\\.");
        String[] revised2 = version2.split("\\.");
        boolean r1Bigger = revised1.length > revised2.length;
        boolean r2Bigger = revised1.length < revised2.length;
        if (r1Bigger){
            for (int i = 0; i < revised1.length; i++){
                int r2 = 0;
                if (i < revised2.length){
                    r2 = Integer.parseInt(revised2[i]);
                }
                if (Integer.compare(Integer.parseInt(revised1[i]), r2) != 0){
                    return Integer.compare(Integer.parseInt(revised1[i]),
                            r2);
                }
            }
            return 0;
        }
        else if (r2Bigger){
            for (int i = 0; i < revised2.length; i++){
                int r1 = 0;
                if (i < revised1.length){
                    r1 = Integer.parseInt(revised1[i]);
                }
                if (Integer.compare(r1, Integer.parseInt(revised2[i])) != 0){
                    return Integer.compare(r1,
                            Integer.parseInt(revised2[i]));
                }
            }
            return 0;
        }
        for (int i = 0; i < revised2.length; i++){
            if (Integer.compare(Integer.parseInt(revised1[i]),
                    Integer.parseInt(revised2[i])) != 0){
                return Integer.compare(Integer.parseInt(revised1[i]),
                        Integer.parseInt(revised2[i]));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1.0";
        ex0165 obj = new ex0165();
        System.out.println(obj.compareVersion(version1,version2));
    }
}