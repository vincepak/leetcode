package algorithms;

public class UglyNumber {
    // public class Solution {

    private static int[] uglyFactors = { 2, 3, 5 };

    /**
     * @param num
     *            an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
	if(num<=0){
	    return false;
	}
	// Write your code here
	int i = 0;
	
	while (i < uglyFactors.length) {
	    while (num % uglyFactors[i] == 0) {
		num /= uglyFactors[i];
	    }
	    i++;
	}
	
	return num == 1;

    }
}