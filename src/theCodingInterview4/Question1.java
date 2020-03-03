package theCodingInterview4;

import java.util.LinkedList;

public class Question1 {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[0];
		Node end = n[4];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

    public static boolean search(Graph g,Node start,Node end) {
    	if(start == end)	return true;
    	
    	LinkedList<Node> q = new LinkedList<Node>();
    	
    	for(Node n : g.getNodes()) {
    		n.state = State.Unvisited;
    	}
    	
    	Node n = start;
    	q.add(n);
    	Node u;
    	
    	while(!q.isEmpty()) {
    		u = q.removeFirst();
    		if(u != null) { 
    			for(Node t : u.getAdjacent()) {
    				if(t.state == State.Unvisited) {
    					if(t == end) {
    						return true;
    					} else {
    						t.state = State.Visiting;
    						q.add(t);
    					}
    				}
    			}
    			u.state = State.Visited;
    		}
    	}
    	return false;
    	
    }

}
