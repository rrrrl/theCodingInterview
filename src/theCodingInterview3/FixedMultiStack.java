package theCodingInterview3;

import java.util.EmptyStackException;

public class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[stackSize];
	}

	/* Push value onto stack. */
	public void push(int stackNum, int value) throws FullStackException {
		if(isFull(stackNum)) {
			throw new FullStackException();
		}
		
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	/* Pop item from top stack. */
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int offset = indexOfTop(stackNum);
		int num = values[offset];
		values[offset] = 0;
		sizes[stackNum]--;
		
		return num;
	}

	/* Return top element. */
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}

	/* Return if stack is empty. */
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	/* Return if stack is full. */
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	/* Returns index of the top of the stack. */
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int index = sizes[stackNum];
		return offset + index - 1;
	}	
	
	public int[] getValues() {
		return values;
	}
}
