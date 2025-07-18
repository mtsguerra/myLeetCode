public class ex0012 {

    //-----------------------------------------------------------------------------//
    // in this one the logic lies in finding the size of the int, on terms of 10^x, so after
    // that i will be iterating the num until the power is negative, so getting the number
    // of the biggest one (most left) i will be analyzing the cases in which hes equals to
    // 9, where we can form by using CM,XC,IX depending on the power that we currently are,
    // 4, where we can form by using CD,XL,IV depending on the power we currently are, on the
    // rest we will be seeing based on the power, if the number is greater or equal to 5, 
    // we will use the respective roman value with the current power and decrease from the number, 
    // after that we must do a while loop so we can fill the others romans numbers if necessary,

    public String intToRoman(int num) {
        if (num > 3999) return null;
        StringBuilder roman = new StringBuilder();
        int toCalcSize = num;
        int power = 0;
        while (toCalcSize != 0){
            power++;
            toCalcSize /=10;
        }
        power--;   
        while (power >= 0){
            int currentN = num / (int) Math.pow(10, power);
            currentN %= 10;
            if (currentN==9){
                if (power==2){
                    roman.append('C');
                    roman.append('M');
                }
                else if (power==1){
                    roman.append('X');
                    roman.append('C');
                }
                else if (power==0){
                    roman.append('I');
                    roman.append('X');
                }
            }
            else if (currentN==4){
                if (power==2){
                    roman.append('C');
                    roman.append('D');
                }
                else if (power==1){
                    roman.append('X');
                    roman.append('L');
                }
                else if (power==0){
                    roman.append('I');
                    roman.append('V');
                }
            }
            else {
                if (power==3){
                    while (currentN != 0){
                        roman.append('M');
                        currentN--;
                    }
                }
                else if (power==2){
                    if (currentN>=5){
                        roman.append('D');
                        currentN-=5;
                    }
                    while (currentN != 0){
                        roman.append('C');
                        currentN--;
                    }
                }
                else if (power==1){
                    if (currentN>=5){
                        roman.append('L');
                        currentN-=5;
                    }
                    while (currentN != 0){
                        roman.append('X');
                        currentN--;
                    }
                }
                else if (power==0){
                    if (currentN>=5){
                        roman.append('V');
                        currentN-=5;
                    }
                    while (currentN != 0){
                        roman.append('I');
                        currentN--;
                    }
                }
            }      
            power--;      
        }
        return roman.toString();
    }

    //-----------------------------------------------------------------------------//

    public static void main(String[] args) {
        ex0012 myo = new ex0012();
        String roman = myo.intToRoman(3749);
        System.out.println(roman);
    }
}
