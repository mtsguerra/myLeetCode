import java.util.*;

public class ex1233 {

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

    /*public List<String> removeSubfolders(String[] folder) {
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