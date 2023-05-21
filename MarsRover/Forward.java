package MarsRover;

public class Forward extends Command {

	public Forward() {
		super('f');
	}

	@Override
	public boolean canHandle(char commandIdentifier) {
		return commandIdentifierValue == commandIdentifier;
	}

	@Override
	public void execute(MarsRover rover) {
		rover.position = rover.position.updatePosition(rover.direction.forwardMovementVector());
		
	}
	
}
