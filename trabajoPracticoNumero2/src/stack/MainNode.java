package stack;

public abstract class MainNode {
	String data;
	MainNode previousNode;
	
	public abstract boolean isEmpty(); 
	
	public void popForEmptyStack() {
	}
	
	public void topForEmptyStack() {
	}

	public abstract void pop();
	
	public abstract void top();
	}
