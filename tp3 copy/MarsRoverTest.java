package marsrover;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

public class MarsRoverTest {

	
	@Test public void test00() {
	  
	  
		Point initialPosition = new Point(1,1, "N"); 
		MarsRover rover = new MarsRover(initialPosition);
	  
		assertEquals(initialPosition, rover.getPosition());
		assertTrue(rover.isHeadingNorth()); }
	 
	 
		
	@Test public void test01() {
		  
		Point initialPosition = new Point(1,1, "N");
		MarsRover rover = new MarsRover(initialPosition);
		  
		//rover.move("");
		  
		assertEquals(initialPosition, rover.getPosition());
		assertTrue(rover.isHeadingNorth()); }
		 
	 
	 @Test public void test02() {
		  
		Point initialPosition = new Point(1, 1, "N");
		Point onePositionForward = new Point(2, 1, "N");
		  
		MarsRover rover1 = new MarsRover(initialPosition);
		MarsRover rover2 = new MarsRover(onePositionForward);
		rover1.move("f");
		List<Object>positionRover1 = rover1.getPosition(); 
		List<Object>positionRover2 = rover2.getPosition();
		
		assertEquals(positionRover1, positionRover2);
		  
	  }
}
