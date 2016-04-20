package algorithms;

import java.util.HashSet;

public class TestMain {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }
    
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
        HashSet<String> set = new HashSet<String>();
        for(char c:c1){
            set.add(String.valueOf(c));
        }
        for(char c:c2){
            set.remove(c);
        }
        return set.isEmpty();
    }

}
