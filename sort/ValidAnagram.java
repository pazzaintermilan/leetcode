public class Solution {
    /*
    time: O(nlogn)
    space: O(n)
    */
    @method1
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        s = new String(schar);
        t = new String(tchar);
        return s.equals(t);
    }

    /*
    time: O(n)
    space: O(n)
    */
    @method2
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                int count=map.get(ch);
                map.put(ch,++count);
            }else{
                map.put(ch,1);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!map.containsKey(ch))
                return false;
            else{
                int count=map.get(ch);
                if(count<=0)
                    return false;
                map.put(ch,--count);
            }
        }
        for(Character ch:map.keySet()){
            if(map.get(ch)!=0)
                return false;
        }
        return true;
    }

    /*
    time:O(n)
    space:O(1)
    */
    @method3
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()) 
            return false;
        int[] count=new int[26];
        int len=t.length();
        for(int i=0;i<len;i++)
            count[t.charAt(i)-'a']++;
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(count[c-'a']>0)
                count[c-'a']--;
            else
                return false;
        }
        return true;
    } 
}