package MarsRover;

public class South extends CardinalPoint {

	public South() {
		super('s');
	}
	
	@Override
	public CoordinatePoint forwardMovementVector() {
		return new CoordinatePoint(0,-1);
	}
	
	@Override
	public CoordinatePoint backwardsMovementVector() {
		return new CoordinatePoint(0,-1);
	}
	@Override
	public CardinalPoint rightCardinalPoint() {
		return new West();
	}

	@Override
	public CardinalPoint leftCardinalPoint() {
		return new East();
	}

	

}
