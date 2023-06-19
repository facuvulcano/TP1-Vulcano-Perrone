package ternilapilli;

import java.util.Set;
import java.util.HashSet;

public class TerniLapilli {
	public static String O = "O";
	public static String X = "X";
	
	public static final String notXTurnErrorMessage = "Not X's turn";
	public static final String notOTurnErrorMessage = "Not O's turn";
	public static final String positionTakenErrorMessage = "Position taken";
	public static final String cannotPlayWhenGameIsOver = "Game is over";
	public static final String cannotPutAFourthToken = "Cannot put a fourth token";
	
	private Set<Position> xs;
	private Set<Position> os;
	private String turn;
	private int maxTokens = 3;
	
	public TerniLapilli() {
		xs = new HashSet<>();
		os = new HashSet<>();
	}

	public Set<Position> getXs() {
		return xs;
	}

	public Set<Position> getOs() {
		return os;
	}

	public void putXAt(Position position) {
		if(turn == O) {
			throw new RuntimeException(notXTurnErrorMessage);
		}
		if(xs.contains(position)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		if(os.contains(position)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		
		if(isWinnerO()) {
			throw new RuntimeException(cannotPlayWhenGameIsOver);
		}
		
		if(getXs().size() >= maxTokens) {
			throw new RuntimeException(cannotPutAFourthToken);
		}
		
		xs.add(position);
		turn = O;
	}

	public void putOAt(Position position) {
		if(turn == X) {
			throw new RuntimeException(notOTurnErrorMessage);
		}
		if(xs.contains(position)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		if(os.contains(position)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		
		if(isWinnerX()) {
			throw new RuntimeException(cannotPlayWhenGameIsOver);
		}
		
		if(getOs().size() >= maxTokens) {
			throw new RuntimeException(cannotPutAFourthToken);
		}
		
		
		os.add(position);
		turn = X;

	}

	public boolean isWinnerX() {
		
		return xHasCompletedRow() || xHasCompletedColumn()
				|| xHasCompletedLeftDiagonal() || xHasCompletedRightDiagonal(); 
				
	}


	public boolean isWinnerO() {
		
		return oHasCompletedRow() || oHasCompletedColumn()
				|| oHasCompletedLeftDiagonal() || oHasCompletedRightDiagonal(); 
	
	}
	
	public boolean gameOver() {
		if (isWinnerX() || isWinnerO()) {
			
			return true;
		}
		
		return false;
	}
	

	private boolean xHasCompletedRow() {
		for( int iteradorFilas = 1; iteradorFilas <= 3; iteradorFilas++ ) {
			int filaObservable = iteradorFilas;
			int count = (int) xs.stream().filter(p -> p.getRow() == filaObservable).count();
			if(count == 3 ) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean xHasCompletedColumn() {
		for( int iteradorColumnas = 1; iteradorColumnas <= 3; iteradorColumnas++ ) {
			int columnaObservable = iteradorColumnas;
			int count = (int) xs.stream().filter(p -> p.getColumn() == columnaObservable).count();
			if(count == 3 ) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean xHasCompletedLeftDiagonal() {
		
		int count = (int) xs.stream().filter(p -> p.getColumn() == p.getRow()).count();
		
		if (count == 3) {
			return true;
			
		}
		
		return false;
	}
	
	private boolean xHasCompletedRightDiagonal() {
		
		int count = (int) xs.stream().filter(p -> p.getColumn() + p.getRow() == 4).count();
		
		if (count == 3) {
			return true;
		}
		
		return false;
	}
	

	private boolean oHasCompletedRow() {
		for( int iteradorFilas = 1; iteradorFilas <= 3; iteradorFilas++ ) {
			int filaObservable = iteradorFilas;
			int count = (int) os.stream().filter(p -> p.getRow() == filaObservable).count();
			if(count == 3 ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean oHasCompletedColumn() {
		for( int iteradorColumnas = 1; iteradorColumnas <= 3; iteradorColumnas++ ) {
			int columnaObservable = iteradorColumnas;
			int count = (int) os.stream().filter(p -> p.getColumn() == columnaObservable).count();
			if(count == 3 ) {
				return true;
			}
		}
		
		return false;
	}
	

	
	private boolean oHasCompletedLeftDiagonal() {
		
		int count = (int) os.stream().filter(p -> p.getColumn() == p.getRow()).count();
		
		if (count == 3) {
			return true;
			
		}
		
		return false;
	}
	
	
	private boolean oHasCompletedRightDiagonal() {
		
		int count = (int) os.stream().filter(p -> p.getColumn() + p.getRow() == 4).count();
		
		if (count == 3) {
			return true;
		}
		
		return false;
	}

	public void slideXFrom(int i, int j, int k, int l) {
		Position fromPosition = new Position(i, j);
		Position toPosition = new Position(k, l);
		
		if(getXs().contains(toPosition)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		
		if(getOs().contains(toPosition)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		
		if(getXs().contains(fromPosition)) {
			
			getXs().remove(fromPosition);
			getXs().add(toPosition);
			
		}
		
	}

	public void slideOFrom(int i, int j, int k, int l) {
		Position fromPosition = new Position(i, j);
		Position toPosition = new Position(k, l);
		
		if(getOs().contains(toPosition)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		
		if(getXs().contains(toPosition)) {
			throw new RuntimeException(positionTakenErrorMessage);
		}
		
		if(getOs().contains(fromPosition)) {
			
			getOs().remove(fromPosition);
			getOs().add(toPosition);
			
		}
		
	}

	
	
}