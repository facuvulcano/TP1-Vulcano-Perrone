package MarsRover;

public class Left extends Command {

	public Left() {
		super('l');
	}

	@Override
	public boolean canHandle(char commandIdentifier) {
		return commandIdentifierValue == commandIdentifier;
	}

	@Override
	public void execute(MarsRover rover) {
		rover.direction = rover.direction.leftCardinalPoint();
		
	}

}
