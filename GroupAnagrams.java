public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] anagram = s.toCharArray();
			Arrays.sort(anagram);
			String sorteds = new String(anagram);
			if (hm.get(sorteds) != null) {
				hm.get(sorteds).add(s);
			} else {
				List<String> g = new ArrayList<String>();
				g.add(s);
				hm.put(sorteds, g);
			}
		}
		for(List<String> l: hm.values()){
			if(l.size()>1){
				result.addAll(l);
			}
		}
		return result;
    }
}
