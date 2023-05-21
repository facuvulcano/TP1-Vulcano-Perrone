package MarsRover;

public class ErrorCommand extends Command {
    
	public ErrorCommand() {
		super('e');
	}
	
	@Override
	public boolean canHandle(char commandIdentifier) {
		return false;
	}

    @Override
    public void execute(MarsRover rover) {
        throw new UnsupportedOperationException(Command.invalidCommandMessage);
    }



}
