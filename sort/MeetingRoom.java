/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    /*
    time: O(nlogn)
    */
    @method1
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval o1, Interval o2){
               return o1.start - o2.start;
           } 
        });
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<intervals[i-1].end)
                return false;
        }
        return true;
    }

    /*
    time: O(n)
    */
    @method2
    public boolean canAttendMeetings(Interval[] intervals) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        int s=0;
        int e=0;
        for(Interval i:intervals){
            start=Math.min(i.start,start);
            end=Math.max(i.end,end);
        }
        boolean[] result=new boolean[end-start+1];
        for(Interval i:intervals){
            s=i.start;
            e=i.end;
            for(int j=s;j<e;j++){
                if(result[j-start]==true)
                    return false;
                result[j-start]=true;
            }
        }
        return true;
    }
}