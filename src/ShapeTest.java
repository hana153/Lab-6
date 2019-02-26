import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
	    Shape rect = new Rectangle("Rectangle1", 3.0, 4.0);
        Assert.assertEquals("Rectangle area incorrect.", 12.0, rect.getArea(), 0.0001);
        Assert.assertEquals("Rectangle perimeter incorrect.", 14.0, rect.getPerimeter(), 0.0001);
        Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect.getShapeType());
        Assert.assertEquals("Rectangle ID incorrect.", "Rectangle1", rect.getId());
        
        Shape rect2 = new Rectangle("Rectangle2", 3.0, 3.0);
        Assert.assertEquals("Rectangle area incorrect.", 9.0, rect2.getArea(), 0.0001);
        Assert.assertEquals("Rectangle perimeter incorrect.", 12.0, rect2.getPerimeter(), 0.0001);
        Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect2.getShapeType());
        Assert.assertEquals("Rectangle ID incorrect.", "Rectangle2", rect2.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
	    Shape tri = new EquilateralTriangle("Triangle1", 3.0);
        Assert.assertEquals("Triangle area incorrect.", 3*3*Math.sqrt((3)/4), tri.getArea(), 0.0001);
        Assert.assertEquals("Triangle perimeter incorrect.", 9.0, tri.getPerimeter(), 0.0001);
        Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
        Assert.assertEquals("Triangle ID incorrect.", "Triangle1", tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
	    Shape trap = new Trapezoid("Trapezoid1", 3.0, 3.0, 2.0, 4.0);
	    // to calculate the area
	    double a = 4.0;
        double b = 2.0;
        double c = 3.0;
        double d = 3.0;
        double e = (a + b) / 2;
        double f = Math.pow(b - a, 2) + Math.pow(c, 2) - Math.pow(d, 2);
        double g = 2 * c * (b - a);
        double h = e * c * Math.sqrt(1 - Math.pow(f/g, 2));
        Assert.assertEquals("Trapezoid area incorrect.", h, trap.getArea(),0.0001);
        Assert.assertEquals("Trapezoid perimeter incorrect.", 12.0, trap.getPerimeter(),0.0001);
        Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid",trap.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trap.getId());

	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
	    Shape circ = new Circle("Circle1", 3.0);
        Assert.assertEquals("Circle area incorrect.", Math.PI*3*3, circ.getArea(),0.0001);
        Assert.assertEquals("Circle perimeter incorrect.", Math.PI*2*3, circ.getPerimeter(),0.0001);
        Assert.assertEquals("Ellipse type incorrect.", "Circle",circ.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Circle1", circ.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
	    Shape rect = new Rectangle("Rectangle1", 3.0, 4.0);
	    Assert.assertEquals("Rectangle\t ID = Rectangle1\t area = 12.000\t perimeter = 14.000", rect.toString());
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimeter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
	    // Test equals:
        Shape rect = new Rectangle("R1", 3.0, 3.0);
        Shape sqr = new Square("S1", 3.0);
        ShapePerimeterComparator sc = new ShapePerimeterComparator();
        Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
        Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

        // Test equal area, different perimeter:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 3.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Shape rect3 = new Rectangle("R3", 2.0, 7.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect3));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect3, sqr2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect3));
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// TODO: complete this...
	    // Test equals:
	    Shape rect = new Rectangle("R1", 3.0, 3.0);
        Shape sqr = new Square("S1", 3.0);
        Assert.assertEquals("NaturalCompareTest should find shapes equal.", 0, rect.compareTo(sqr));

        // Test equal area, different perimeter:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 3.0);
        Assert.assertEquals("NaturalCompareTest gave incorrect ordering.", 1, rect2.compareTo(sqr2));
        Assert.assertEquals("NaturalCompareTest gave incorrect ordering.", -1, sqr.compareTo(rect2));
     
        // Test equal perimeter, different area:
        Shape rect3 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr3 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, rect3.compareTo(sqr3));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sqr3.compareTo(rect3));

        // Test unequal perimeter and area:
        Shape rect4 = new Rectangle("R3", 2.0, 7.0);
        Assert.assertEquals("NaturalCompareTest gave incorrect ordering.", -1, sqr2.compareTo(rect4));
        Assert.assertEquals("NaturalCompareTest gave incorrect ordering.", 1, rect4.compareTo(sqr2));
    }
}
