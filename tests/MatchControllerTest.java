import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;

import foo.ConsoleView;
import foo.HumanPlayer;
import foo.IInputDevice;
import foo.IModel;
import foo.IPlayer;
import foo.IView;
import foo.JComponentTestFrame;
import foo.MatchController;
import foo.Model;
import foo.NetworkPlayer;
import foo.TicTacToeBoardPanel;

public class MatchControllerTest {
	
	public static void main(String[] args) {
		IModel model = new Model();
		IView consoleView = new ConsoleView(model);
		TicTacToeBoardPanel graphicView = new TicTacToeBoardPanel(model);
		
		JComponent compo = graphicView;
		IInputDevice input = graphicView;
		IView view = graphicView;
		
		JComponentTestFrame testfram = new JComponentTestFrame(compo);
		//IPlayer p1 = new NetworkPlayer("localhost");
		//	IPlayer p2 = new NetworkPlayer("localhost");
		IPlayer p1 = new HumanPlayer(input);
		IPlayer p2 = new HumanPlayer(input);
		List<IView> views = new ArrayList<>();
		views.add(consoleView);
		views.add(view);
		MatchController mc = new MatchController(p1, p2, model, views);
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(mc);
				t.start();
			}
		});
		testfram.add(button, BorderLayout.SOUTH);
		testfram.revalidate();
		testfram.pack();
	}
}
