package algorithms;

public class CommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
	if(A == null || A.equals("") || B == null || B.equals("")){
	    return 0;
	}
	
	char[] charA = A.toCharArray();
	char[] charB = B.toCharArray();
	int lengthA = A.length(), lengthB = B.length();
	int start, offSet;
	int longest = 0;
	for( int startB = lengthA - 1; startB >= -lengthB + 1; startB -- ){
	    //consider starting A is 0. 
	    //start is the starting position of String B
	    /*
	     * calc the intersect
	     * if startB > 0, 
	     *     lengthA - 1, [start, 
	    */
	   if(startB >= 0){
	       start = startB;
	       int offA = lengthA - 1 + 1 - startB;
	       offSet = (offA < lengthB) ? offA : lengthB;
	   } else {
	       start = 0;
	       int offB = lengthB + startB;
	       offSet = (lengthA < offB)? lengthA : offB;
	   }
	   
	   //calc current intersect
	   int count = 0;
	   for(int i = start; i < (start + offSet); i ++){
	       if(charA[i] == charB[i-startB]){
		   count ++;
	       } else {
		   longest = longest > count? longest: count;
		   count = 0;
	       }
	   }
	   longest = longest > count? longest: count;
	   
	}
	
	return longest;
    }
}
