package MarsRover;

public class Backward extends Command {

	public Backward() {
		super('b');
	}

	@Override
	public boolean canHandle(char commandIdentifier) {
		return commandIdentifierValue == commandIdentifier;
	}

	@Override
	public void execute(MarsRover rover) {
		rover.position = rover.position.updatePosition(rover.direction.backwardsMovementVector());
		
	}

}
