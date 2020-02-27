package theCodingInterview3;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin>{
	public void push(int value) {
		int minVal = Math.min(value, min());
		super.push(new NodeWithMin(value, minVal));
    }
    
    public int min() {
    	if(isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return peek().min;
    	}
    }
}
