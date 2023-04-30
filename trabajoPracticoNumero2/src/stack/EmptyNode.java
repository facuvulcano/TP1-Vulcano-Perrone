package stack;

public class EmptyNode extends MainNode {

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public void pop() {
		throwEmptyStackErrorMessage();
	}

	@Override
	public void top() {
		throwEmptyStackErrorMessage();
	}
	
	public void throwEmptyStackErrorMessage() {
		throw new Error( OOStack.stackEmptyErrorDescription );
	}

}