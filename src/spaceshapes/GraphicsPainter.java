package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Sreeniketh Raghavan
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	public Color getColor() {
		return _g.getColor();
	}

	public void setColor(Color colour) {
		_g.setColor(colour);
	}

	public void translate(int x, int y) {
		_g.translate(x, y);	
	}

	public void drawCentredText(String text, int width, int height) {	

		FontMetrics	fontMetrics = _g.getFontMetrics();

		int textMidPoint = fontMetrics.stringWidth(text)/2;
		int textAscent = fontMetrics.getAscent();
		int textDescent = fontMetrics.getDescent();
		int heightAdjustment = 0;

		if (textAscent > textDescent) {

			heightAdjustment = (textAscent - textDescent)/2;
		}

		else if (textDescent > textAscent) {

			heightAdjustment = (textDescent - textAscent)/2; 
		}

		_g.drawString(text, (width/2) - textMidPoint, (height/2 + heightAdjustment));

	}

	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img, x, y, width, height, null);
	}

}
