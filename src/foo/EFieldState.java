package foo;

public enum EFieldState {
	
	EMPTY('_'), CIRCLE('o'), CROSS('x');
	
	private final char symbol;
	
	private EFieldState(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
