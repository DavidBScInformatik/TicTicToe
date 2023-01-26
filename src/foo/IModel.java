package foo;

public interface IModel {
	
	// Hey Model was ist auf Feld 1:1
	EFieldState getFieldState(int row, int column);
	
	// HEy Model setzte auf Feld 1.1
	void setEFieldState(int row, int column, EFieldState fieldState);

	String toServerString();
	
	
}
