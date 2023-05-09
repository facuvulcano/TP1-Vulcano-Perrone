package marsrover;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

public class MarsRoverTest {

	
	
	  @Test public void test00() {
	  
	  
		  Point initialPosition = new Point(1,1, "N"); 
		  MarsRover rover = new MarsRover(initialPosition);
	  
		  assertEquals(initialPosition.point_array(), rover.getPosition());
		  assertTrue(rover.isHeadingNorth()); }
	  
	 
		
	
	
	  @Test public void test01() {
	  
		  Point initialPosition = new Point(1,1, "N"); 
		  MarsRover rover = new MarsRover(initialPosition);
	  
		  rover.move("");
	  
		  assertEquals(initialPosition.point_array(), rover.getPosition());
		  assertTrue(rover.isHeadingNorth()); }
	 
	  
	
	
	  @Test public void test02() {
	  
		  Point initialPosition = new Point(1, 1, "N"); 
		  Point onePositionForward = new Point(2, 1, "N");
	  
		  MarsRover rover1 = new MarsRover(initialPosition); 
		  MarsRover rover2 = new MarsRover(onePositionForward);
	  
	  
		  List<Integer>positionRover2 = rover2.getPosition();
	  
		  assertEquals(positionRover2, rover1.move("f"));
		  assertEquals(rover1.isHeadingNorth(), rover2.isHeadingNorth());
	  
	  }
	 
	  @Test public void test03() {
		  
		  Point initialPosition = new Point(1, 1, "S"); 
		  Point onePositionForward = new Point(0, 1, "S");
	  
		  MarsRover rover1 = new MarsRover(initialPosition); 
		  MarsRover rover2 = new MarsRover(onePositionForward);
	  
	  
		  List<Integer>positionRover2 = rover2.getPosition();
	  
		  assertEquals(positionRover2, rover1.move("f"));
		  assertEquals(rover1.isHeadingSouth(), rover2.isHeadingSouth());
	  
	  }
	  
	  @Test public void test04() {
		  
		  Point initialPosition = new Point(1, 1, "W"); 
		  Point onePositionForward = new Point(1, 0, "W");
	  
		  MarsRover rover1 = new MarsRover(initialPosition); 
		  MarsRover rover2 = new MarsRover(onePositionForward);
	  
	  
		  List<Integer>positionRover2 = rover2.getPosition();
	  
		  assertEquals(positionRover2, rover1.move("f"));
		  assertEquals(rover1.isHeadingWest(), rover2.isHeadingWest());
	  
	  }
	 
	  @Test public void test05() {
		  
		  Point initialPosition = new Point(1, 1, "E"); 
		  Point onePositionForward = new Point(1, 2, "E");
	  
		  MarsRover rover1 = new MarsRover(initialPosition); 
		  MarsRover rover2 = new MarsRover(onePositionForward);
	  
	  
		  List<Integer>positionRover2 = rover2.getPosition();
	  
		  assertEquals(positionRover2, rover1.move("f"));
		  assertEquals(rover1.isHeadingEast(), rover2.isHeadingEast());
	  
	  }
	 
	  @Test public void test06() {
		
		  Point initialPosition = new Point(1, 1, "N"); 
		  Point onePositionBackwards = new Point(0, 1, "N");
		  
		  MarsRover rover1 = new MarsRover(initialPosition); 
		  MarsRover rover2 = new MarsRover(onePositionBackwards);
	  
	  
		  List<Integer>positionRover2 = rover2.getPosition();
	  
		  assertEquals(positionRover2, rover1.move("b"));
		  assertEquals(rover1.isHeadingEast(), rover2.isHeadingEast());
	  
		  
	  }
	  
	  @Test public void test07() {
		  Point initialPosition = new Point(1, 1, "N"); 
		  
		  Point onePositionForward = new Point(1, 1, "N");
		  
		  MarsRover rover1 = new MarsRover(initialPosition);

		  MarsRover rover3 = new MarsRover(onePositionForward);
		  
	
		  List<Integer>positionRover3 = rover3.getPosition();
		  
		  rover1.move("b");
		  
		  
		  assertEquals(positionRover3, rover1.move("f"));
		  
		  
	  }
	 
	 
}
