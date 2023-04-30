package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class OOStackTest {

private static String SECOND = "Second";
private static  String FIRST = "First";
private static String EXPECTED_MESSAGE_NOT_UNDERSTOOD_ERROR_WAS_NOT_THROWN = "Expected MessageNotUnderstood Error was not thrown.";
private static String SOMETHING = "Something";

@Test public void test01StackShouldBeEmptyWhenCreated() {
    assertTrue( new OOStack().isEmpty() );
  }

  @Test public void test02PushAddElementsToTheStack() {
    assertFalse( new OOStack().push( SOMETHING ).isEmpty() );
  }

  @Test public void test03PopRemovesElementsFromTheStack() {
    OOStack stack = new OOStack();
    stack.push( SOMETHING );
    stack.pop();
    assertTrue( stack.isEmpty() );
  }

  @Test public void test04PopReturnsLastPushedObject() {
     OOStack stack = new OOStack();
     String pushedObject = "Something";
     stack.push( pushedObject );
     assertEquals( stack.pop(), pushedObject );
  }

  @Test public void test05StackBehavesLIFO() {
    OOStack stack = new OOStack();
    
    pushObjectToStack(stack, FIRST);
    pushObjectToStack(stack, SECOND);

    assertEquals( stack.pop(), SECOND );
    assertEquals( stack.pop(), FIRST );
    assertTrue( stack.isEmpty() );
  }


  @Test public void test06TopReturnsLastPushedObject() {
    assertEquals( new OOStack().push( SOMETHING ).top(), 
    		SOMETHING );
  }

  @Test public void test07TopDoesNotRemoveObjectFromStack() {
    OOStack stack = new OOStack();
    stack.push( SOMETHING );
    assertEquals( stack.size(), 1 );
    stack.top();
    assertEquals( stack.size(), 1 );
  }

  @Test public void test08CanNotPopWhenThereAreNoObjectsInTheStack() {
	    OOStack stack = new OOStack();
	    try {
	      stack.pop();
	      fail( EXPECTED_MESSAGE_NOT_UNDERSTOOD_ERROR_WAS_NOT_THROWN );
	    } catch (Error e) {
	      assertTrue( e.getMessage().equals( OOStack.stackEmptyErrorDescription ) );
	    }
	  }

  @Test public void test09CanNotPopWhenThereAreNoObjectsInTheStackAndTheStackHadObjects() {
    OOStack stack = new OOStack();
    stack.push( SOMETHING );
    stack.pop();
    try {
      stack.pop();
      fail( EXPECTED_MESSAGE_NOT_UNDERSTOOD_ERROR_WAS_NOT_THROWN );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( OOStack.stackEmptyErrorDescription ) );
    }
  }

  @Test public void test10CanNotTopWhenThereAreNoObjectsInTheStack() {
	    OOStack stack = new OOStack();	    
	    try {
	      stack.top();
	      fail( "Expected MessageNotUnderstood Error was not thrown." );
	    } catch (Error e) {    	
	      assertTrue( e.getMessage().equals( OOStack.stackEmptyErrorDescription ) );
	    }
	  }
  
  private void pushObjectToStack(OOStack stack, String data) {
		stack.push( data);
	}

}