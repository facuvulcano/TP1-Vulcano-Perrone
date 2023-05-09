package marsrover;

import java.util.List;

public class MarsRover{
	
	public Point position;
	
	
	public MarsRover(Point initialPosition) {
		position = initialPosition;
		
	}

	public List<Integer> move(String string) {
		

	    if (string.equals("") && isHeadingNorth() || string.equals("") && isHeadingSouth() || string.equals("") && isHeadingWest() || string.equals("") && isHeadingEast()) {
	        return position.point_array();
	       
	    }
		
	    if (string.equals("f") && isHeadingNorth() || string.equals("b") && isHeadingSouth()) {
	        position.i++;
	    }
	    
	    if (string.equals("f") && isHeadingSouth() || string.equals("b") && isHeadingNorth()) {
	        position.i--;
	    }
	    
	    if (string.equals("f") && isHeadingWest() || string.equals("b") && isHeadingEast()) {
	        position.j--;
	    }
	    
	    if (string.equals("f") && isHeadingEast() || string.equals("b") && isHeadingWest()) {
	        position.j++;
	    }
	       
	    return position.point_array();
	}


	public List<Integer> getPosition() {
		return position.point_array();
	}

	public Boolean isHeadingNorth() {
		String Nposition = position.get_pc();
		if (Nposition == "N") {
			return true;
		}
		return false;
		
	}
	
	public Boolean isHeadingSouth() {
		String Nposition = position.get_pc();
		if (Nposition == "S") {
			return true;
		}
		return false;
		
	}
	
	public Boolean isHeadingEast() {
		String Nposition = position.get_pc();
		if (Nposition == "E") {
			return true;
		}
		return false;
		
	}
	
	public Boolean isHeadingWest() {
		String Nposition = position.get_pc();
		if (Nposition == "W") {
			return true;
		}
		return false;
		
	}

	public void setPosition(Point position) {
		this.position = position;
	}

}
