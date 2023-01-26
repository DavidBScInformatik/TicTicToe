import java.awt.Point;

import de.mpaap.util.com.Communicator;
import de.mpaap.util.com.CommunicatorException;

public class ServerTest {
	
	public static void main(String[] args) throws CommunicatorException {
		Communicator foo = new Communicator("localhost", 7890, "UTF-8");
		String response = foo.communicate("_________\n");
		int respontsAsInt = Integer.parseInt(response.trim());
		System.out.println(respontsAsInt);
		
		int row = ((respontsAsInt-1) / 3);
		int column = ((respontsAsInt-1) % 3);
		
		Point p = new Point(row, column);
		System.out.println(p);
	}
}
