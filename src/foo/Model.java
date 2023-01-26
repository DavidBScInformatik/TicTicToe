package foo;

import java.util.Iterator;

public class Model implements IModel {

	private EFieldState fieldStates[][] = new EFieldState[3][3];

	public Model() {
		for (int i = 0; i < fieldStates.length; i++) {
			for (int j = 0; j < fieldStates[i].length; j++) {
				setEFieldState(i, j, EFieldState.EMPTY);
			}
		}
	}

	@Override
	public EFieldState getFieldState(int row, int column) {
		return fieldStates[row][column];
	}

	@Override
	public void setEFieldState(int row, int column, EFieldState fieldState) {
		fieldStates[row][column] = fieldState;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(12);
		for (int i = 0; i < fieldStates.length; i++) {
			for (int j = 0; j < fieldStates[i].length; j++) {
				str.append(fieldStates[i][j].getSymbol());
			}
			str.append("\n");
		}
		return str.toString();
	}
	
	@Override
	public String toServerString() {
		StringBuilder str = new StringBuilder(12);
		for (int i = 0; i < fieldStates.length; i++) {
			for (int j = 0; j < fieldStates[i].length; j++) {
				str.append(fieldStates[i][j].getSymbol());
			}
		}
		str.append("\n");
		return str.toString();
	}

}
