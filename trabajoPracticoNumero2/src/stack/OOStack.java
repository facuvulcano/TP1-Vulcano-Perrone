package stack;


public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	public static MainNode head;
	public int size;
	
	public OOStack() {
		OOStack.head = new EmptyNode();
	}
	
	public boolean isEmpty() {	
		return head.isEmpty();
	}
	
	public OOStack push(String data) {
		MainNode newNotEmptyNode = createNodeAndAddData(data);
		newNotEmptyNode.previousNode = head;
		head = newNotEmptyNode;
		size ++;
		return this;
	}

	public Object pop() {
		Object content = head.data;
		head.pop();
		head = head.previousNode;
		size --;
		return content;
	}

	public Object top() {
		head.top();
		return head.data;
	}

	public int size() {		
		return size;	
	}
	
	private MainNode createNodeAndAddData(String data) {
		MainNode newNotEmptyNode = new NotEmptyNode(data);
		newNotEmptyNode.data = data;
		return newNotEmptyNode;
	}

}
