package MarsRover;

public class CoordinatePoint {
	int x;
	int y;
	
	public CoordinatePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public CoordinatePoint updatePosition(CoordinatePoint MovementVector) {
		
		return new CoordinatePoint(x+MovementVector.x,y+MovementVector.y);
	}

	
}

