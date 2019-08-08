package spaceshapes;

import static org.junit.Assert.assertEquals;
import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sreeniketh Raghavan
 * 
 */
public class TestDynamicShape {

	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}


	@Test
	public void testBounceOffRight() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15, Color.green);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)"
				+ "(rectangle 110,35,25,35)[r=0,g=255,b=0]"
				+ "(rectangle 98,50,25,35)[r=0,g=255,b=0]", _painter.toString());	

	}


	@Test
	public void testBounceOffLeft() {
		DynamicShape shape = new DynamicShape(10, 20, -12, 15, Color.cyan);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)"
				+ "(rectangle 0,35,25,35)[r=0,g=255,b=255]"
				+ "(rectangle 12,50,25,35)[r=0,g=255,b=255]",
				_painter.toString());
	}


	@Test
	public void testBounceOffTop() {
		DynamicShape shape = new DynamicShape(90, 160, 12, 10, Color.blue);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 90,160,25,35)"
				+ "(rectangle 102,165,25,35)"
				+ "(rectangle 114,155,25,35)",
				_painter.toString());
	}


	@Test
	public void testBounceOffBottom() {
		DynamicShape shape = new DynamicShape(90, 10, 12, -12, Color.yellow);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 90,10,25,35)"
				+ "(rectangle 102,0,25,35)"
				+ "(rectangle 114,12,25,35)",
				_painter.toString());
	}


	@Test
	public void testBounceOffTopLeft() {
		DynamicShape shape = new DynamicShape(10, 155, -12, 15, Color.red);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,155,25,35)"
				+ "(rectangle 0,165,25,35)[r=255,g=0,b=0]"
				+ "(rectangle 12,150,25,35)[r=255,g=0,b=0]", _painter.toString());
	}


	@Test
	public void testBounceOffTopRight() {
		DynamicShape shape = new DynamicShape(165, 155, 12, 15, Color.red);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 165,155,25,35)"
				+ "(rectangle 175,165,25,35)[r=255,g=0,b=0]"
				+ "(rectangle 163,150,25,35)[r=255,g=0,b=0]", _painter.toString());
	}


	@Test
	public void testBounceOffBottomLeft() {
		DynamicShape shape = new DynamicShape(10, 10, -12, -15, Color.red);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,25,35)"
				+ "(rectangle 0,0,25,35)[r=255,g=0,b=0]"
				+ "(rectangle 12,15,25,35)[r=255,g=0,b=0]", _painter.toString());
	}


	@Test
	public void testBounceOffBottomRight() {
		DynamicShape shape = new DynamicShape(165, 10, 12, -15, Color.pink);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 165,10,25,35)"
				+ "(rectangle 175,0,25,35)[r=255,g=175,b=175]"
				+ "(rectangle 163,15,25,35)[r=255,g=175,b=175]", _painter.toString());
	}
}
