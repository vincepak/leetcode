package algorithms;

import java.util.HashMap;

public class CompareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
	if(B== null || B.isEmpty()){
	    return true;
	}
	if(A==null || A.isEmpty()){
	    return false;
	}
        // write your code here
	HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
	for(int a:A.toCharArray()){
	    if(map.get(a) == null){
		map.put(a, 1);
	    } else {
		map.put(a, (map.get(a) + 1));
	    }
	}
	
	for(int b:B.toCharArray()){
	    if(map.get(b) == null || map.get(b) == 0){
		return false;
	    }
	    map.put(b , (map.get(b) -1 ));
	}
	
	return true;
    }
}
