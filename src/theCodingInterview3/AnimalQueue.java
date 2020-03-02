package theCodingInterview3;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Dog) dogs.addLast((Dog) a);
		else if(a instanceof Cat) cats.add((Cat) a);
	}
	
	public Animal dequeueAny() {
		if(dogs.size() == 0) {
			return dequeueCats();
		} else if(cats.size() == 0) {
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOrderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}
	
	public Dog dequeueDogs()  {
		return dogs.poll();
	}
	
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	public int size() {
		return dogs.size() + cats.size();
	}
}
