package algorithms;

import java.util.HashMap;

public class Anagram {
    public boolean anagram(String s, String t) {
        // write your code here
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if(c1 == null || c2 == null){
            return false;
        }
        
        if(c1.length != c2.length){
            return false;
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(char char1:c1){
            String c = String.valueOf(char1);
            int i;
            if(map.get(c) == null){
        	i = 0;
            }else{
                i = map.get(c);
            }
            i++;
            map.put(c, Integer.valueOf(i));
        }
        for(char char1:c2){
            String c = String.valueOf(char1);
            if(map.get(c) == null || map.get(c).equals(0)){
        	return false;
            }
            int i = map.get(c);            
            i--;
            map.put(c, Integer.valueOf(i));
        }
        return true;
    }

}
