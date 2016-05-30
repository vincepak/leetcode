package algorithms;

import java.util.HashMap;
import java.util.Map;

public class PossibilityBTree {
    
    private Map<Integer, Long> map = new HashMap<Integer,Long>();

    public long possibility(int n){
	if(map.containsKey(n)){
	    return map.get(n);
	}
	//calc p
	long p = 0;
	switch (n){
	    case 0:		 
	    case 1:
		p = 1;
		break;
	    default:
		for(int i = 0; i <n; i ++){
		    p+= possibility(i)* possibility(n-i-1);
		}
	}
	map .put(n,p);
	return p;
    }
    
    public static void main(String [] args){
	PossibilityBTree cut = new PossibilityBTree();
	int n = 0;
	System.out.println("Calcuating possibility of BTree giving size n...");
	while (n++ < 1000){
	 System.out.println("Possibility of "+n+" is "+cut.possibility(n ) );
	}
    }

}
