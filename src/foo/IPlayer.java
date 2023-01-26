package foo;

import java.awt.Point;

public interface IPlayer {

	public Point getNextMove(String matchSituation) throws PlayerException;

}
