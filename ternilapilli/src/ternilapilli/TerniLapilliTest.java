package ternilapilli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;

public class TerniLapilliTest {
	@Test
	void test00() {
		TerniLapilli game = new TerniLapilli();

		assertTrue(game.getXs().isEmpty());
		assertTrue(game.getOs().isEmpty());
	}

	@Test
	void test01() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));

		assertEquals(1, game.getXs().size());
		assertTrue(game.getXs().contains(new Position(1, 1)));
		assertTrue(game.getOs().isEmpty());
	}

	@Test
	void test02() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));

		assertEquals(1, game.getXs().size());
		assertTrue(game.getXs().contains(new Position(1, 1)));
		assertEquals(1, game.getOs().size());
		assertTrue(game.getOs().contains(new Position(2, 2)));
	}

	@Test
	void test03XCannotPlayTwiceInARow() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		try {
			game.putXAt(new Position(2, 2));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.notXTurnErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertTrue(game.getOs().isEmpty());
		}
	}

	@Test
	void test04OCannotPlayTwiceInARow() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));

		try {
			game.putOAt(new Position(3, 3));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.notOTurnErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertEquals(1, game.getOs().size());
			assertTrue(game.getOs().contains(new Position(2, 2)));
		}
	}

	@Test
	void test05CannotPutAnXInAnAlreadyOccupiedPositionByX() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));

		try {
			game.putXAt(new Position(1, 1));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.positionTakenErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertEquals(1, game.getOs().size());
			assertTrue(game.getOs().contains(new Position(2, 2)));
		}
	}

	@Test
	void test06CannotPutAnOInAnAlreadyOccupiedPositionByO() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(1, 2));
		try {
			game.putOAt(new Position(2, 2));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.positionTakenErrorMessage, anError.getMessage());
			assertEquals(2, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertTrue(game.getXs().contains(new Position(1, 2)));
			assertEquals(1, game.getOs().size());
			assertTrue(game.getOs().contains(new Position(2, 2)));
		}
	}

	@Test
	void test07CannotPutAnOInAnAlreadyOccupiedPositionByX() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		try {
			game.putOAt(new Position(1, 1));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.positionTakenErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertTrue(game.getOs().isEmpty());
		}
	}

	@Test
	void test08CannotPutAnXInAnAlreadyOccupiedPositionByO() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		try {
			game.putXAt(new Position(2, 2));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.positionTakenErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertEquals(1, game.getOs().size());
			assertTrue(game.getOs().contains(new Position(2, 2)));
		}
	}

	@Test
	void test09NoOneWins() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(3, 3));
		game.putOAt(new Position(1, 2));

		assertFalse(game.isWinnerX());
		assertFalse(game.isWinnerO());
	}

	@Test
	void test10CheckIfXsWinsByRows() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(1, 3));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(1, 2));

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());
	}

	@Test
	void test11CheckIfOsWinsByRows() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(3, 3));
		game.putOAt(new Position(1, 1));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(1, 3));
		game.putXAt(new Position(3, 1));
		game.putOAt(new Position(1, 2));

		assertFalse(game.isWinnerX());
		assertTrue(game.isWinnerO());
	}

	@Test
	void test12CheckIfXsWinsByColumns() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(3, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(1, 1));

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());
	}

	@Test
	void test13CheckIfOsWinsByColumns() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(3, 3));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(1, 2));

		assertFalse(game.isWinnerX());
		assertTrue(game.isWinnerO());
	}

	@Test
	void test14CheckHasWon() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(3, 3));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(1, 2));

		assertFalse(game.isWinnerX());
		assertTrue(game.isWinnerO());
	}

	@Test
	void test15CheckXWinsInTheLeftDiagonal() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(3, 3));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(2, 2));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(1, 1));

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());
	}

	@Test
	void test16CheckOWinsInTheLeftDiagonal() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(3, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 3));
		game.putXAt(new Position(1, 2));
		game.putOAt(new Position(1, 1));

		assertFalse(game.isWinnerX());
		assertTrue(game.isWinnerO());
	}

	@Test
	void test17CheckXWinsInTheRightDiagonal() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 3));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(2, 2));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(3, 1));

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());
	}

	@Test
	void test18CheckOWinsInTheRightDiagonal() {
		TerniLapilli game = new TerniLapilli();
		game.putOAt(new Position(1, 3));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(3, 2));
		game.putOAt(new Position(3, 1));

		assertFalse(game.isWinnerX());
		assertTrue(game.isWinnerO());
	}

	@Test
	void test19OCannotPlayWhenGameIsOver() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 3));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(2, 2));
		game.putOAt(new Position(3, 2));
		game.putXAt(new Position(3, 1));
		
		assertTrue(game.gameOver());
		assertThrowsLike(() -> game.putOAt(new Position(3,3)), TerniLapilli.cannotPlayWhenGameIsOver);
		
		
	
	}

	@Test
	void test20XCannotPutAFourthToken() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 3));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(3, 1));
		game.putOAt(new Position(1, 2));

		assertThrowsLike(() -> game.putXAt(new Position(3, 3)), TerniLapilli.cannotPutAFourthToken);
		assertEquals(3, game.getXs().size());
		assertTrue(game.getXs().contains(new Position(1, 3)));
		assertTrue(game.getXs().contains(new Position(1, 1)));
		assertTrue(game.getXs().contains(new Position(3, 1)));
	}

	@Test
	void test21XCanSlideAToken() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(1, 3));
		game.putXAt(new Position(1, 2));
		game.putOAt(new Position(3, 2));

		game.slideXFrom(2, 1, 3, 1);
		assertEquals(3, game.getXs().size());
		assertTrue(game.getXs().contains(new Position(3, 1)));
		assertTrue(game.getXs().contains(new Position(1, 1)));
		assertTrue(game.getXs().contains(new Position(1, 2)));
	}

	@Test
	void test22PlayerCanSlideAToken() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(1, 3));
		game.putXAt(new Position(1, 2));
		game.putOAt(new Position(3, 2));

		game.slideXFrom(2, 1, 3, 1);
		game.slideOFrom(3, 2, 3, 3);
		assertEquals(3, game.getXs().size());
		assertTrue(game.getXs().contains(new Position(3, 1)));
		assertTrue(game.getXs().contains(new Position(1, 1)));
		assertTrue(game.getXs().contains(new Position(1, 2)));
		assertEquals(3, game.getOs().size());
		assertTrue(game.getOs().contains(new Position(3, 3)));
		assertTrue(game.getOs().contains(new Position(1, 3)));
		assertTrue(game.getOs().contains(new Position(2, 2)));
	}

	@Test
	void test23XCanWinIfItSlidesATokenInARow() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(1, 2));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(2, 3));
		game.putOAt(new Position(3, 2));

		game.slideXFrom(2,3,1,3);

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());

	}

	@Test
	void test24OCanWinIfItSlidesATokenInARow() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(1, 2));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(3, 3));
		game.putOAt(new Position(3, 2));

		game.slideXFrom(1,2, 1, 3);
		game.slideOFrom(3, 2, 2, 3);

		assertTrue(game.isWinnerO());
		assertFalse(game.isWinnerX());

	}

	@Test
	void test25XCanWinIfItSlidesATokenInAColumn() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(2, 3));
		game.putXAt(new Position(3, 2));
		game.putOAt(new Position(1, 3));

		game.slideXFrom(3, 2, 3, 1);

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());

	}

	@Test
	void test26OCanWinIfItSlidesATokenInAColumn() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 3));
		game.putXAt(new Position(2, 2));
		game.putOAt(new Position(1, 3));
		game.putXAt(new Position(3, 2));
		game.putOAt(new Position(1, 2));

		game.slideXFrom(3, 2, 3, 3);

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());

	}

	@Test
	void test27XCanWinIfItSlidesATokenInADiagonal() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 1));
		game.putXAt(new Position(2, 2));
		game.putOAt(new Position(3, 1));
		game.putXAt(new Position(2, 3));
		game.putOAt(new Position(1, 3));

		game.slideXFrom(2, 3, 3, 3);

		assertTrue(game.isWinnerX());
		assertFalse(game.isWinnerO());

	}

	@Test
	void test28OCanWinIfItSlidesATokenInADiagonal() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 1));
		game.putXAt(new Position(3, 2));
		game.putOAt(new Position(2, 3));

		game.slideXFrom(3, 2, 3, 3);
		game.slideOFrom(2, 3, 1, 3);

		assertTrue(game.isWinnerO());
		assertFalse(game.isWinnerX());

	}

	@Test
	void test29CannotSlideAnXInAnAlreadyOccupiedPositionByX() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 1));
		game.putXAt(new Position(3, 2));
		game.putOAt(new Position(2, 3));

		assertThrowsLike(() -> game.slideXFrom(2, 1, 1, 1), TerniLapilli.positionTakenErrorMessage);
		assertEquals(3, game.getXs().size());
		assertTrue(game.getXs().contains(new Position(1, 1)));
		assertTrue(game.getXs().contains(new Position(2, 1)));
		assertTrue(game.getXs().contains(new Position(3, 2)));
	}

	@Test
	void test30CannotSlideAnOInAnAlreadyOccupiedPositionByO() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		game.putXAt(new Position(2, 1));
		game.putOAt(new Position(3, 1));
		game.putXAt(new Position(3, 2));
		game.putOAt(new Position(2, 3));
		game.slideXFrom(2, 1, 1, 2);
		assertThrowsLike(() -> game.slideOFrom(3, 1, 2, 2), TerniLapilli.positionTakenErrorMessage);
		assertEquals(3, game.getOs().size());
		assertTrue(game.getOs().contains(new Position(2, 2)));
		assertTrue(game.getOs().contains(new Position(2, 3)));
		assertTrue(game.getOs().contains(new Position(3, 1)));
	}

	@Test
	void test31CannotSlideAnOInAnAlreadyOccupiedPositionByX() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		try {
			game.putOAt(new Position(1, 1));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.positionTakenErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertTrue(game.getOs().isEmpty());
		}
	}

	@Test
	void test32CannotPutAnXInAnAlreadyOccupiedPositionByO() {
		TerniLapilli game = new TerniLapilli();
		game.putXAt(new Position(1, 1));
		game.putOAt(new Position(2, 2));
		try {
			game.putXAt(new Position(2, 2));
			fail("Exception Error");
		} catch (RuntimeException anError) {
			assertEquals(TerniLapilli.positionTakenErrorMessage, anError.getMessage());
			assertEquals(1, game.getXs().size());
			assertTrue(game.getXs().contains(new Position(1, 1)));
			assertEquals(1, game.getOs().size());
			assertTrue(game.getOs().contains(new Position(2, 2)));
		}
	}

	private void assertThrowsLike(Executable lambda, String message) {
		assertEquals(message, assertThrows(RuntimeException.class, lambda).getMessage());
	}
}
