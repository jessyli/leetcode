// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].


//The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals. And then merge some intervals.
//time complexity O(nLogn) which is for sorting
// [1,4][1,4]   [1,4][4,5]  [1,5][2,3] 
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()<=1){
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result =  new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start<=pre.end){
                int max = Math.max(pre.end, intervals.get(i).end);
                Interval cur = new Interval(pre.start, max);
                pre = cur;
            }
            else{
                result.add(pre);
                pre = intervals.get(i);
            }
        }
        result.add(pre);
        return result;
    }
}

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        return i1.start-i2.start;
    }
}
