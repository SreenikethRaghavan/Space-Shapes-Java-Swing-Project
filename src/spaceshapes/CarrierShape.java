package spaceshapes;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Sreeniketh Raghavan
 * 
 */
public class CarrierShape extends Shape {

	private List<Shape> _childrenShapes = new ArrayList<Shape>();

	public CarrierShape() {

		super();
	}

	public CarrierShape(int x, int y) {

		super(x, y);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY) {

		super(x, y, deltaX, deltaY);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {

		super(x, y, deltaX, deltaY, width, height);
	}	

	public CarrierShape(String text) {

		super(text);
	}

	public CarrierShape(int x, int y, String text) {

		super(x, y, text);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY, String text) {

		super(x, y, deltaX, deltaY, text);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {

		super(x, y, deltaX, deltaY, width, height, text);
	}


	public void move(int width, int height) {

		super.move(width, height);

		for (Shape shape : _childrenShapes) {
			shape.move(_width, _height);
		}

	}

	protected void doPaint(Painter painter) {

		painter.drawRect(_x,_y,_width,_height);
		painter.translate(_x, _y);

		for(Shape shape : _childrenShapes) {

			shape.paint(painter);
		}

		painter.translate(-_x, -_y);
	}

	void add(Shape shape) throws IllegalArgumentException {

		if(shape.parent() != null || (shape.x() + shape.width() >= this.width() || shape.y() + shape.height() >= this.height())) {

			throw new IllegalArgumentException();
		}	

		_childrenShapes.add(shape);
		shape.setParent(this);
	}


	void remove (Shape shape) {

		if(contains(shape)) {

			_childrenShapes.remove(_childrenShapes.indexOf(shape));	
			shape.setParent(null);
		}
	}


	public Shape shapeAt(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index > _childrenShapes.size()-1) {

			throw new IndexOutOfBoundsException();
		}

		return _childrenShapes.get(index);
	}


	public int shapeCount() {
		return _childrenShapes.size();
	}

	public int indexOf(Shape shape) {

		if(!contains(shape)) {

			return -1;
		}

		return _childrenShapes.indexOf(shape);
	}

	public boolean contains (Shape shape) {

		for (Shape childShape : _childrenShapes) {

			if (childShape == shape) {

				return true;
			}
		}

		return false;
	}

}
