package MarsRover;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {
	 
	public List<Command> commands = new ArrayList<>(List.of(new Forward(), new Backward(), new Left(), new Right()));
	
	public CoordinatePoint position;
	public CardinalPoint direction;
	
	public MarsRover (CoordinatePoint position, CardinalPoint direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public void executeCommand(Character command) {
	    Command commandToExecute = commands.stream()
	        .filter(c -> c.canHandle(command))
	        .findFirst()
	        .orElseGet(ErrorCommand::new);
	    commandToExecute.execute(this);
	}
	
	public MarsRover processCommandString(String commandString) {
	    commandString.chars().mapToObj(c -> (char) c).forEach(this::executeCommand);
	    return this;
	}

}
