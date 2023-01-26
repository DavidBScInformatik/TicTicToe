import javax.swing.JComponent;
import javax.swing.JTable;

import foo.EFieldState;
import foo.IModel;
import foo.IMoveListener;
import foo.JComponentTestFrame;
import foo.Model;
import foo.TicTacToeBoardPanel;

public class ComponentTest {
	
	public static void main(String[] args) {
		IModel model = new Model();
		model.setEFieldState(0, 1, EFieldState.CROSS);
		model.setEFieldState(2, 0, EFieldState.CIRCLE);
		System.out.println(model);
		TicTacToeBoardPanel comp = new TicTacToeBoardPanel(model);
		comp.setMoveListener(new IMoveListener() {
			@Override
			public void moveOccurred(int row, int column) {
				System.out.println(row + " " + column);
			}
		});
		JComponentTestFrame testfram = new JComponentTestFrame(comp);
	}
}
