package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    private static final String EMPTY_STR_CHARS = "";

    public List<String> anagrams(String[] strs) {
        // write your code here
	HashMap<String, List<String>> map = new HashMap<String,List<String>>();
	for(String str:strs){
	    String key = getKey(str);
	    if(map.get(key) == null){
		map.put(key, new ArrayList<String>());
	    }
	    map.get(key).add(str);
	}
	
	List<String> ret = new ArrayList<String>();
	for(List<String> list:map.values()){
	    if(list.size()>1){		
		ret.addAll(list);		
	    }
	}
	return ret;
    }

    private String getKey(String str) {
	if(str == null || str.equals("")){
	    return EMPTY_STR_CHARS;
	}
	char[] a = str.toCharArray();
	Arrays.sort(a);
	return String.valueOf(a);
    }
    
    
}
