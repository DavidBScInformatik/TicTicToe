package foo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBoardPanel extends JPanel implements IView, IInputDevice{
	
	private IModel model;
	private double scale;
	private IMoveListener iml;
	
	public TicTacToeBoardPanel(IModel model) {
		this.model = model;
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(450, 450));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();
				int column = (int) (x / scale / 100);
				int row = (int) (y / scale / 100);
				
				if (column < 3 && row < 3 && column >= 0 && row >= 0 && iml != null) {
					iml.moveOccurred(row, column);
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		configureGraphicsForUsageOfUserCoordinateSystem(g2);
		drawGrid(g2);
		drawFieldstates(g2);
	}

	private void drawFieldstates(Graphics2D g2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				EFieldState fieldstate = model.getFieldState(j, i);
				switch (fieldstate) {
				case CROSS:
					g2.drawLine(i*100, j*100, i*100+100, j*100+100);
					g2.drawLine(i*100+100, j*100, i*100, j*100+100);
					break;
				case CIRCLE:
					g2.drawOval(i*100, j*100, 100, 100);;
					break;
				default:
					break;
				}
			}
		}
	}

	private void configureGraphicsForUsageOfUserCoordinateSystem(Graphics2D g2) {
		double sx = getWidth() / 300.0;
		double sy = getHeight() / 300.0;
		scale = Math.min(sx, sy);
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(scale, scale);
		g2.setTransform(scaleTransform);
	}
	
	private void drawGrid(Graphics2D g2) {
		g2.drawLine(0, 100, 300, 100);
		g2.drawLine(0, 200, 300, 200);
		g2.drawLine(100, 0, 100, 300);
		g2.drawLine(200, 0, 200, 300);
		g2.drawRect(0, 0, 300, 300);
	}

	@Override
	public void refresh() {
		repaint();
	}

	@Override
	public void setMoveListener(IMoveListener iml) {
		this.iml = iml;
	}
}
