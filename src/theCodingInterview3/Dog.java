package theCodingInterview3;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
	
	public String name() {
		return "Dog: " + name;
	}
}
