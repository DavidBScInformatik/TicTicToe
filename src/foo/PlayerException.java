package foo;

public class PlayerException extends Exception {

	public PlayerException(String arg0) {
		super(arg0);
	}

	public PlayerException(Throwable arg0) {
		super(arg0);
	}

	public PlayerException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
