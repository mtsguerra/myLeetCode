import java.util.*;

public class ex1352 {

    private List<Integer> allMult;
    private int lastZero = 0;

    public void ProductOfNumbers() {
        allMult = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num==0){
            lastZero = allMult.size();
            allMult.add(num);
        }
        if (num==1){
            allMult.add(num);
            return;
        }
        for (int i=lastZero;i<allMult.size();i++){
            allMult.set(i,allMult.get(i)*num);
        }
        
        allMult.add(num);
    }
    
    public int getProduct(int k) {
        return allMult.get(allMult.size()-k);
    }

    public static void main(String[] args) {
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
