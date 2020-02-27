package theCodingInterview3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) { 
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int v) {
		Stack st = getLastStack();
		if(st!=null && !st.isFull()) {
			st.push(v);
		} else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack st = getLastStack();
		if(st == null) throw new EmptyStackException();
		int v = st.pop();
		if(st.size == 0) {
			stacks.remove(stacks.size()-1);
		}
		return v;
	}
}
