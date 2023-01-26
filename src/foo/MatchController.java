package foo;

import java.awt.Point;
import java.util.List;

public class MatchController implements Runnable{

	private IPlayer playerOne;
	private IPlayer playerTwo;
	private IModel model;
	private List<IView> views;

	public MatchController(IPlayer playerOne, IPlayer playerTwo, IModel model, List<IView> views) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.model = model;
		this.views = views;
	}

	private void play() {
		for (int i = 0; i < 9; i++) {
			boolean even = i % 2 == 0;
			IPlayer currentPlayer = even ? playerOne : playerTwo;
			try {
				Point move = currentPlayer.getNextMove(model.toServerString()); // TODO - echte Stellung übergeben
				EFieldState currentState = even ? EFieldState.CROSS : EFieldState.CIRCLE;
				model.setEFieldState(move.x, move.y, currentState);
				for (IView view : views) {
					view.refresh();
				}
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		play();
	}

}
