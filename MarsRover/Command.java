package MarsRover;

public abstract class Command {
	
	public char commandIdentifierValue;
	
	public Command(char commandIdentifier) {
		this.commandIdentifierValue = commandIdentifier;
	}
	
	public static String invalidCommandMessage = "Invalidad command received";
	
	public abstract boolean canHandle(char commandIdentifier);
	
	public abstract void execute(MarsRover rover);
}
