package algorithms;

/**
 * @author I047020 INT_MAX (2147483647) or INT_MIN (-2147483648)
 */
public class String2IntegerII {
    final int INT_MAX = 2147483647;
    final int INT_MIN = -2147483648;

    /**
     * @param str:
     *            A string
     * @return An integer
     */
    /**
     * @param str
     * @return
     */
    /**
     * @param str
     * @return
     */
    public int atoi(String str) {
	// write your code here
	int result = 0;
	
	StringBuilder sb = new StringBuilder();
	boolean started = false;
	int i = 0;
	char[] chars = str.toCharArray();
	while(i< chars.length){
	    if(started && !isNum(chars[i])){
		break;
	    } else if(!started && isBeginNum(chars[i])){
		started = true;
		sb.append(chars[i]);
	    } else if(isNum(chars[i])){
		sb.append(chars[i]);
	    } else {//not char
		started = false;
	    }
	    i++;
	}
	str = sb.toString();
	if(str == null || str.equals("")){
	    return 0;
	}
	
	try {
	    result = Integer.valueOf(str);
	} catch (java.lang.NumberFormatException e) {
	    try{
		float f = Float.parseFloat(str);
		return (int)f;
	    } catch(Exception e2){
		
	    }
	    char c = chars[0];
	    boolean minus = false;
	    if (c != '-') {
		if (c < '0' || c > '9') {
		    return 0; // invalid char
		}
	    } else {
		minus = true;
	    }
	    for (int j = 1; j < chars.length; j++) {
		c = chars[j];
		if (c < '0' || c > '9') {
		    return 0; // invalid char
		}
	    }
	    // is number
	    if (minus) {
		return INT_MIN;
	    } else {
		return INT_MAX;
	    }

	    // if(chars[0] )
	}

	return result;
    }
    
    private boolean isBeginNum(char c){
	if ((c >= '0' && c <= '9') ||
		 c == '.' ||
		 c == '-' ||
	    	 c == '+'){
	    return true;
	}
	return false;
   }

    private boolean isNum(char c) {
	if ((c >= '0' && c <= '9') ||
		 c == '.' ){
	    return true;
	}
	return false;
    }

}
