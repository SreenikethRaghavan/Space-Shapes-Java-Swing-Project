package spaceshapes;
import java.awt.Color;

/**
 * @author Sreeniketh Raghavan
 * 
 */
public class DynamicShape extends Shape {

	private Color _colour = new Color(255, 255, 255);
	private boolean _filled = false;

	public DynamicShape(Color colour) {

		super();
		_colour = colour;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, Color colour) {
		super(x,y,deltaX,deltaY);
		_colour = colour;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color colour) {
		super(x,y,deltaX,deltaY,width,height);
		_colour = colour;
	}

	public DynamicShape() {

		super();
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}	

	public DynamicShape(Color colour, String text) {

		super(text);
		_colour = colour;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, Color colour, String text) {
		super(x,y,deltaX,deltaY, text);
		_colour = colour;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color colour, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
		_colour = colour;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour) {
		super(x,y,deltaX,deltaY,width,height, text);
		_colour = colour;
	}

	public DynamicShape(String text) {

		super(text);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x,y,deltaX,deltaY, text);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}	


	protected void doPaint(Painter painter) {

		if (_filled) {
			Color originalColour = painter.getColor();
			painter.setColor(_colour);
			painter.drawRect(_x,_y,_width,_height);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(originalColour);
		}

		else {
			painter.drawRect(_x,_y,_width,_height);
		}
	}

	@Override
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_filled = false;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_filled = false;
		}


		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_filled = true;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_filled = true;
		}

		_x = nextX;
		_y = nextY;
	}



}
