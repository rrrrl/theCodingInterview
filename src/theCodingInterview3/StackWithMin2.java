package theCodingInterview3;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int value) {
		if(value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if(value == s2.peek()) {
			s2.pop();
		}
		return value;
	}
	
	public Integer min() {
		if(isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}
