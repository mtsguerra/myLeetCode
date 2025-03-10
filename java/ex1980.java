public class ex1980 {
        public String findDifferentBinaryString(String[] nums) {
            int sz = nums[0].length();
            StringBuilder ans = new StringBuilder();
            for (int i=0;i<sz;i++){
                if (i >= nums.length){
                    ans.append('1');
                }
                else{
                    char ch = nums[i].charAt(i);
                    ans.append(ch == '0' ? '1' : '0');
                }
            }
            return ans.toString();
        }
}