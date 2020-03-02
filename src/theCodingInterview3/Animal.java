package theCodingInterview3;

public abstract class Animal {
	private int order;
	public String name;
	
	public Animal(String nm) {
		name = nm;
	}
	
	public abstract String name();
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int ord) {
		order = ord;
	}
	
	public boolean isOrderThan(Animal a) {
		return this.order < a.getOrder();
	}
}
