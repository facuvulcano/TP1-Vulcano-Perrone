package stack;

public class NotEmptyNode extends MainNode {
	String data;
	MainNode next;
	
	public NotEmptyNode(String string)	{
		data = string;
		next = new EmptyNode();	
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void pop() {
	}

	@Override
	public void top() {	
	}

}
