import java.util.*;

class ex0717 {
    /**
     * Determine if the last character is a one-bit character
     *
     * @param bits array of bits
     * @return true if the last character is a one-bit character, false otherwise
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) {
            i--;
        }
        return (bits.length - 2 - i) % 2 == 0;
    }
}