package spaceshapes;

import java.awt.Color;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sreeniketh Raghavan
 * 
 */
public class TestHexagon {

	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}


	@Test
	public void testSimpleMoveOnRegular() {
		HexagonShape shape = new HexagonShape(60,30,10,12,70,70);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 60,65,80,100)(line 80,100,110,100)(line 110,100,130,65)(line 130,65,110,30)(line 110,30,80,30)(line 80,30,60,65)"
				+ "(line 70,77,90,112)(line 90,112,120,112)(line 120,112,140,77)(line 140,77,120,42)(line 120,42,90,42)(line 90,42,70,77)", 
				_painter.toString());
	}


	@Test
	public void testShapeMoveWithBounceOffRightOnRegular() {
		HexagonShape shape = new HexagonShape(50, 20, 12, 15, 70, 70);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 50,55,70,90)(line 70,90,100,90)(line 100,90,120,55)(line 120,55,100,20)(line 100,20,70,20)(line 70,20,50,55)"
				+ "(line 62,70,82,105)(line 82,105,112,105)(line 112,105,132,70)(line 132,70,112,35)(line 112,35,82,35)(line 82,35,62,70)"
				+ "(line 65,85,85,120)(line 85,120,115,120)(line 115,120,135,85)(line 135,85,115,50)(line 115,50,85,50)(line 85,50,65,85)",		
				_painter.toString());	

	}


	@Test
	public void testShapeMoveWithBounceOffLeftOnRegular() {
		HexagonShape shape = new HexagonShape(10, 20, -12, 15, 70, 70);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,55,30,90)(line 30,90,60,90)(line 60,90,80,55)(line 80,55,60,20)(line 60,20,30,20)(line 30,20,10,55)"
				+ "(line 0,70,20,105)(line 20,105,50,105)(line 50,105,70,70)(line 70,70,50,35)(line 50,35,20,35)(line 20,35,0,70)"
				+ "(line 12,85,32,120)(line 32,120,62,120)(line 62,120,82,85)(line 82,85,62,50)(line 62,50,32,50)(line 32,50,12,85)",				
				_painter.toString());
	}


	@Test
	public void testShapeMoveWithBounceOffBottomAndRightOnRegular() {
		HexagonShape shape = new HexagonShape(10, 90, 45, -45, 70, 70);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,125,30,160)(line 30,160,60,160)(line 60,160,80,125)(line 80,125,60,90)(line 60,90,30,90)(line 30,90,10,125)"
				+ "(line 55,80,75,115)(line 75,115,105,115)(line 105,115,125,80)(line 125,80,105,45)(line 105,45,75,45)(line 75,45,55,80)"
				+ "(line 10,35,30,70)(line 30,70,60,70)(line 60,70,80,35)(line 80,35,60,0)(line 60,0,30,0)(line 30,0,10,35)",				
				_painter.toString());
	}

	@Test
	public void testSimpleMoveOnSmall() {
		HexagonShape shape = new HexagonShape(60,30,10,12);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 60,47,80,65)(line 80,65,100,47)(line 100,47,80,30)(line 80,30,60,47)"
				+ "(line 70,59,90,77)(line 90,77,110,59)(line 110,59,90,42)(line 90,42,70,59)",				
				_painter.toString());
	}


	@Test
	public void testShapeMoveWithBounceOffRightOnSmall() {
		HexagonShape shape = new HexagonShape(50, 20, 12, 15);
		shape.paint(_painter);
		shape.move(60, 10000);
		shape.paint(_painter);
		shape.move(60, 10000);
		shape.paint(_painter);
		assertEquals("(line 50,37,70,55)(line 70,55,90,37)(line 90,37,70,20)(line 70,20,50,37)"
				+ "(line 35,52,55,70)(line 55,70,75,52)(line 75,52,55,35)(line 55,35,35,52)"
				+ "(line 23,67,43,85)(line 43,85,63,67)(line 63,67,43,50)(line 43,50,23,67)",
				_painter.toString());	

	}


	@Test
	public void testShapeMoveWithBounceOffLeftOnSmall() {
		HexagonShape shape = new HexagonShape(18, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 18,37,38,55)(line 38,55,58,37)(line 58,37,38,20)(line 38,20,18,37)"
				+ "(line 6,52,26,70)(line 26,70,46,52)(line 46,52,26,35)(line 26,35,6,52)"
				+ "(line 0,67,20,85)(line 20,85,40,67)(line 40,67,20,50)(line 20,50,0,67)",				
				_painter.toString());
	}


	@Test
	public void testShapeMoveWithBounceOffBottomAndRightOnSmall() {
		HexagonShape shape = new HexagonShape(10, 90, 20, -20);
		shape.paint(_painter);
		shape.move(60, 100);
		shape.paint(_painter);
		shape.move(60, 100);
		shape.paint(_painter);
		assertEquals("(line 10,107,30,125)(line 30,125,50,107)(line 50,107,30,90)(line 30,90,10,107)"
				+ "(line 30,82,50,100)(line 50,100,70,82)(line 70,82,50,65)(line 50,65,30,82)"
				+ "(line 35,82,55,100)(line 55,100,75,82)(line 75,82,55,65)(line 55,65,35,82)",			
				_painter.toString());
	}




	@Test
	public void testSimpleMove() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15, Color.cyan);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		System.out.println(_painter.toString());
		assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)", 
				_painter.toString());



	}









}
