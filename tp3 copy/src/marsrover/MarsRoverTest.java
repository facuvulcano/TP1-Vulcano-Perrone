package marsrover;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MarsRoverTest {

	@Test public void test00() {
		Coordinates inicialPosition = new Coordinates(1,1);
		MarsRover rover = new MarsRover(inicialPosition);
		
		assertEquals( inicialPosition, rover.getCoordinates());
		assertTrue(rover.isHedingNorth());//NO ENTIENDO PORQUE NO ME LO TOMAAAA DEBEN ESTAR MAL LOS IMPORTS :)
		
		/* 
		 *tengo q tener posicion inicial 
		 *el rover debe estar ubicado en posicion inicial 
		 
		 assert que el rover este ubicado en la posicion inicial 
		 assert rover apunta norte
		 */
	}
	

	@Test public void test01() {
		
	}

}
