package foo;

import java.awt.Point;

public class HumanPlayer implements IMoveListener, IPlayer {
	
	private volatile Point move;
	private IInputDevice inputDevice;
	
	public HumanPlayer(IInputDevice inputDevice) {
		this.inputDevice = inputDevice;
	}
	
	@Override
	public Point getNextMove(String matchSituation) throws PlayerException {
		move = null;
		inputDevice.setMoveListener(this);
		while (move == null) {
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		return move;
	}

	@Override
	public void moveOccurred(int row, int column) {
		move = new Point(row, column);
	}

}
