public class ex0006 {

    /**
     * The zigzag conversion of a string is a way of writing the string in a
     * zigzag pattern on a given number of rows.
     *
     * Time complexity: O(n) where n is the length of the string s.
     * Space complexity: O(n) for the StringBuilder
     *
     * @param s the string to be converted
     * @param numRows the number of rows to convert the string into
     * @return the converted string
     */
    public String convert(String s, int numRows){
        if (numRows == 1) return s;

        StringBuilder answer = new StringBuilder();
        int crrRow = 0;
        int distance = (numRows-1)*2;
        while (crrRow < numRows){
            int tempIndex = crrRow;
            if (tempIndex >= s.length()) return answer.toString();
            if (crrRow==0 || crrRow == numRows-1){
                while (tempIndex < s.length()){
                    answer.append(s.charAt(tempIndex));
                    tempIndex+=distance;
                }
            }
            else{
                int fHalf = distance - (2*crrRow);
                int sHalf = distance - fHalf;
                answer.append(s.charAt(tempIndex));
                tempIndex+=fHalf;
                while (tempIndex < s.length()){
                    answer.append(s.charAt(tempIndex));
                    tempIndex+=sHalf;
                    if (tempIndex < s.length()){
                        answer.append(s.charAt(tempIndex));
                        tempIndex+=fHalf;
                    }
                }
            }
            crrRow++;
        }
        return answer.toString();
    }

    /*
    public String convert(String s, int numRows){

        if (numRows == 1) return s;

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(' ');
        }

        int currentIndex=0;
        int numDiag = numRows-2;
        int pos =0;
        int[] diffs = new int[numDiag];
        int t = 2*numDiag;
        for (int p=0;p<numDiag;p++){
            diffs[p] = t;
            t-=2;
        }

        while (currentIndex<numRows){
            if (currentIndex==0 || currentIndex == numRows-1){
                int tempIndex = currentIndex;
                while (tempIndex < s.length()){
                    sb.setCharAt(pos, s.charAt(tempIndex));
                    tempIndex+=numDiag+numRows;
                    pos++;
                }
            }
            else {
                int tempIndex = currentIndex;
                int sp = currentIndex-1;
                boolean frst = true;
                while (tempIndex < s.length()){
                    sb.setCharAt(pos, s.charAt(tempIndex));
                    if (frst){
                        tempIndex += diffs[sp];
                        frst=false;
                    }
                    else{
                        tempIndex+= diffs[diffs.length-1-sp];
                        frst=true;
                    }
                    pos++;
                }
            }
            currentIndex++;
        }
        return sb.toString();
    }

    //----------------------------------------------------//
    // some old thoughts on the problem,




    ----------------------------------------------------//
    // The first row and the last would always increase the index of their chars in numRows + numDiag, so we can get all the 
    // desirable characters by doing this pattern, on the other hand the other rows would be more tricky to find the pattern, as they
    // alternate between even numbers, like the increase of index of the first line (excluding the first and last as they are already solved) 
    // would start as the numDiag * 2 and alternate with the number 2, as for the last line would alternate between both but in reversed order,
    // now for the remaining lines, i created a (int[numDiag] diffs) containing all the even numbers [numDiag*2, 2], and now as we descend on the remaining
    // lines the pair that the would alternate would be using the index of them, as the first line after the beginning would be index=0 and the last line
    // before the end would be index = numDiag -1, on firstEven = diffs[index] and the second diff[diffs.length-1-index], so there we can find all
    // the remaining characters, and after that we call a function that would create a substring and read it.

    // it can also be more easy to understand the pattern using a drawing like:
    // 0     ->+8                       8      ''            16
    // 1     ->+6           7   ->+4    9      ''        15
    // 2     ->+4        6    ->+4      10    ''    14
    // 3     ->+2    5       ->+6       11 ''   13
    // 4     ->+8                       12

    public String convert(String s, int numRows){
        if (numRows == 1) return s;
        List<List<Character>> grid = new LinkedList<>();
        int currentIndex=0;
        int numDiag = numRows-2;
        int[] diffs = new int[numDiag];
        int t = 2*numDiag;
        for (int p=0;p<numDiag;p++){
            diffs[p] = t;
            t-=2;
        }

        while (currentIndex<numRows){
            if (currentIndex==0 || currentIndex == numRows-1){
                List<Character> temp = new LinkedList<>();
                int tempIndex = currentIndex;
                while (tempIndex < s.length()){
                    temp.add(s.charAt(tempIndex));
                    tempIndex+=numDiag+numRows;
                }
                grid.add(temp);
            }
            else {
                List<Character> temp = new LinkedList<>();
                int tempIndex = currentIndex;
                int sp = currentIndex-1;
                boolean frst = true;
                while (tempIndex < s.length()){
                    temp.add(s.charAt(tempIndex));
                    if (frst){
                        tempIndex += diffs[sp];
                        frst=false;
                    }
                    else{
                        tempIndex+= diffs[diffs.length-1-sp];
                        frst=true;
                    }
                }
                grid.add(temp);
            }
            currentIndex++;
        }
        return readGrid(grid);
    }

    public String readGrid(List<List<Character>> grid){
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : grid){
            for (char ch : l){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    //----------------------------------------------------//
    // now on this first try i would alternate between the indexes that would be on the rows, for example the 0-3, 6-9 and beyond, after all the
    // the pattern between this sizes would always be the same, such as the diff between the start of each roll being the numRows + numDiag, and
    // in between the rolls being the size of the rows

    /*public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<List<Character>> grid = new LinkedList<>();
        int currentIndex = 0;
        int currentLevel = 0;
        while (currentIndex < s.length()){
            while (currentLevel < numRows){
                if (currentIndex < s.length()){
                    if (currentLevel >= grid.size()){
                        List<Character> temp = new LinkedList<>();
                        temp.add(s.charAt(currentIndex));
                        grid.add(temp);
                    }
                    else grid.get(currentLevel).add(s.charAt(currentIndex));
                }
                else return readGrid(grid);
                currentIndex++;
                currentLevel++;
            }
            currentLevel -=2;
            while (currentLevel > 0){
                if (currentIndex < s.length()){
                    grid.get(currentLevel).add(s.charAt(currentIndex));               
                }
                else return readGrid(grid);
                currentIndex++;
                currentLevel--;
            }
        }
        return readGrid(grid);
    }

    public String readGrid(List<List<Character>> grid){
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : grid){
            for (char ch : l){
                sb.append(ch);
            }
        }
        return sb.toString();
    }/* */

    public static void main(String[] args) {
        ex0006 myo = new ex0006();
        System.out.println(myo.cnv("PAYPALISHIRING", 4));
    }
}
