package foo;
import java.awt.Point;

import de.mpaap.util.com.Communicator;
import de.mpaap.util.com.CommunicatorException;
import foo.IPlayer;

public class NetworkPlayer implements IPlayer{
	
	private Communicator com;
	
	public NetworkPlayer(String host) {
		com = new Communicator(host, 7890, "UTF-8");
	}
	
	@Override
	public Point getNextMove(String matchSituation) throws PlayerException {
		try {
			String response = com.communicate(matchSituation);
			if (response.startsWith("Error")) {
				throw new PlayerException("Fehler auf der Serverseite: " + response);
			}
			int respontsAsInt = Integer.parseInt(response.trim());
			int row = ((respontsAsInt-1) / 3);
			int column = ((respontsAsInt-1) % 3);
			return new Point(row, column);
		} catch (CommunicatorException | NumberFormatException e) {
			throw new PlayerException(e);
		}
	}
}
