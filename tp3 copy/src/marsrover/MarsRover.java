package marsrover;

public class MarsRover {

	private Coordinates position;

	public MarsRover(Coordinates roverPosition) {
		position = roverPosition;
	}

	public Coordinates getCoordinates() {
		return position;
	}
	
	public Object isHedingNorth() {
		return true;
	}

}
