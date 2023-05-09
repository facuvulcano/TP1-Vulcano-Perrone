package marsrover;

import java.util.List;
import java.util.ArrayList;


public class Point {
	
	public int i;
	public int j;
	public String pc;
	
	
	public Point(int i, int j, String pc) {
		
		this.i = i;
		this.j = j;
		this.pc = pc;
	}
	
	public int get_i() {
		return i;
	}
	
	public int get_j() {
		return j;
	}
	
	public String get_pc() {
		return pc;
	}
	
	public List<Integer> point_array() {
	    List<Integer> listaDePuntos = new ArrayList<>(2);
	    listaDePuntos.add(this.i);
	    listaDePuntos.add(this.j);
	    return listaDePuntos;
	}

	
	
}
