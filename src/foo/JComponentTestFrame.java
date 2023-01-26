package foo;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JComponentTestFrame extends JFrame {
	
	public JComponentTestFrame(JComponent jcomp) {
		add(jcomp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
