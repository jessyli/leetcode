import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class SortMap{
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
		Map sortmap = sortedmap(map);
		System.out.println(sortmap);
		
    }
    public static Map sortedmap(Map map){
        Map sortmap = new TreeMap(new ValueComparator(map));
        sortmap.putAll(map);
        return sortmap;
    }
}

class ValueComparator implements Comparator{
    Map map;
    public ValueComparator(Map map){
        this.map=map;
    }
    public int compare(Object key1, Object key2){
        Comparable value1 = (Comparable)(map.get(key1));
        Comparable value2 = (Comparable)(map.get(key2));
        return value1.compareTo(value2);
    }
}
