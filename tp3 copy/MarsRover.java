package marsrover;

import java.util.List;

public class MarsRover{
	
	public Point position;
	
	
	public MarsRover(Point initialPosition) {
		position = initialPosition;
		
	}

	public  List<Object> move(String string) {
		if (string == "f") {
			for (int i = 0; i < position.point_array().size(); i++) {
			 
			
				if (isHeadingNorth()) {
					
					position.point_array().set(0, ((Integer)position.point_array().get(0)).intValue() + 1);
				
				}
				/*
		
				if (isHeadingSouth()) {
				
				}
				if (isHeadingEast()) {
				
				}
				if (isHeadingWest()) {
				
				}*/
			
			}
		}
		
		
		
		return position.point_array();
	}

	public List<Object> getPosition() {
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
