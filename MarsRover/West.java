package MarsRover;

public class West extends CardinalPoint{

	public West() {
		super('w');
	}
	
	@Override
	public CoordinatePoint forwardMovementVector() {
		return new CoordinatePoint(-1,0);
	}
	
	@Override
	public CoordinatePoint backwardsMovementVector() {
		return new CoordinatePoint(1,0);
	}

	@Override
	public CardinalPoint rightCardinalPoint() {
		return new North();
	}

	@Override
	public CardinalPoint leftCardinalPoint() {
		return new South();
	}

	

}
