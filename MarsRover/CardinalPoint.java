package MarsRover;

public abstract class CardinalPoint {
	
	public char cardinalIdentifierValue;
	
	public CardinalPoint(char cardinalIdentifier) {
		this.cardinalIdentifierValue = cardinalIdentifier;
	}	

	public abstract CoordinatePoint forwardMovementVector();
	
	public abstract CoordinatePoint backwardsMovementVector();
	
	public abstract CardinalPoint rightCardinalPoint();
	
	public abstract CardinalPoint leftCardinalPoint();
			
	

}
