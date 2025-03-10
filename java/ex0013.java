public class ex0013 {

    //--------------------------------------------------------------------//
    // on this romanToInt we will be iterating through the string until the last -1, 
    // creating a switch so we can attribute the numeric values to all the characters, but
    // in the cases (I,X,C) we will also be checking the next character, in which this next
    // will never be out of range, because the loop it does not go until the end of the string,
    // after iterating and the last character being the only remaining character, we use
    // a method to connect the character with his respective numeric value

    public int romanToInt(String s) {
        char[] sentence = s.toCharArray();
        int sum=0;
        for (int i=0;i<sentence.length-1;i++){
            char current = sentence[i];
            switch (current) {
                case 'I':
                    if (sentence[i+1] == 'X' || sentence[i+1] == 'V'){
                        sum -=1;
                        break;
                    }
                    sum+=1;
                    break;

                case 'V':
                    sum+=5;
                    break;
                
                case 'X':
                    if (sentence[i+1] == 'L' || sentence[i+1] == 'C'){
                        sum -=10;
                        break;
                    }
                    sum+=10;
                    break;

                case 'L':
                    sum+=50;
                    break;

                case 'C':
                    if (sentence[i+1] == 'D' || sentence[i+1] == 'M'){
                        sum -=100;
                        break;
                    }
                    sum+=100;
                    break;

                case 'D':
                    sum+=500;
                    break;

                case 'M':
                    sum+=1000;
                    break;
            
                default:
                    break;
            }
        }
        sum += getRomanValue(sentence[sentence.length-1]);
        return sum;
    }

    private int getRomanValue (char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    //--------------------------------------------------------------------//
}
