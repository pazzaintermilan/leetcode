public class Solution {
    /*
    time: O(n)
    space: O(n)
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret=new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key,list);
            }else{
                map.get(key).add(str);
            }
        }
        Iterator<List<String>> i = map.values().iterator();
        while (i.hasNext()) {
            List<String> item = i.next();
            Collections.sort(item, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.compareTo(s2);
                    
                }
            });
            ret.add(item);
        }
        return ret;
    }
}