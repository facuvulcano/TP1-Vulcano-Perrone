package MarsRover;

public class East extends CardinalPoint{
	
	public East() {
		super('e');
	}
	
	@Override
	public CoordinatePoint forwardMovementVector() {
		return new CoordinatePoint(1,0);
	}
	
	@Override
	public CoordinatePoint backwardsMovementVector() {
	return new CoordinatePoint(-1,0);
	}

	@Override
	public CardinalPoint rightCardinalPoint() {
		return new South();
	}

	@Override
	public CardinalPoint leftCardinalPoint() {
		return new North();
	}


}
