package theCodingInterview3;

import java.util.Stack;
import CtCILibrary.*;

public class Question5 {
	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			int val = s.pop();
			while(!r.isEmpty() && val < r.peek()) {
				s.push(r.pop());
			}
			r.push(val);
		}
		
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
	}
	
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			s.push(r);
			System.out.println(r);
		}
				
		System.out.println("================");
		sort(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
