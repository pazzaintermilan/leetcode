public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    //228ms
    @method1
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0)
            return 0;
        int lenIndex = s.length()-1;
        int len = 0;
        for (int i=lenIndex; i>=0 && s.charAt(i)==' '; i--) 
            lenIndex--;
        for (int i=lenIndex; i>=0 && s.charAt(i)!=' '; i--) 
            len++;
        return len;
    }

    //292ms
    @method2
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words.length==0) return 0;
        else return words[words.length-1].length();
    }

    //308ms
    @method3
    public int lengthOfLastWord(String s) {
         return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

}