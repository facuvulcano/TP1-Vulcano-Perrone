package MarsRover;

public class Right extends Command {

	public Right() {
		super('r');
	}
	
	@Override
	public boolean canHandle(char commandIdentifier) {		
		return commandIdentifierValue == commandIdentifier;
	}

	@Override
	public void execute(MarsRover rover) {
		rover.direction = rover.direction.rightCardinalPoint();
		
	}
	
}
