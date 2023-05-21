package MarsRover;

public class North extends CardinalPoint{

	public North() {
		super('n');
	}
	
	@Override
	public CoordinatePoint forwardMovementVector() {
		return new CoordinatePoint(0,1);
	}
	
	@Override
	public CoordinatePoint backwardsMovementVector() {
		return new CoordinatePoint(0,-1);
	}
	
	@Override
	public CardinalPoint rightCardinalPoint() {
		return new East();
	}

	@Override
	public CardinalPoint leftCardinalPoint() {
		return new West();
	}



}
