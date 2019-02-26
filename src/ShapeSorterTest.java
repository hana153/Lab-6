import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		// TODO: complete this...
	    ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 1, 9);
        Shape b = new EquilateralTriangle("test2", 4);
        Shape c = new Square("test3", 3);
        Shape d = new Circle("test4", 1.5);

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);
        
        sorter.sortShapes();

        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), b);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), d);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), a);
	    
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		// TODO: complete this...
	    ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 3, 3);
        Shape b = new EquilateralTriangle("test2", 4);
        Shape c = new Square("test3", 3);
        Shape d = new Circle("test4", 1.5);

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);
        
        ShapeAreaComparator sc = new ShapeAreaComparator();
        sorter.sortShapes(sc);

        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), b);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), d);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), a);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), c);
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		// TODO: complete this...
	    ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 1, 9);
        Shape b = new EquilateralTriangle("test2", 4);
        Shape c = new Square("test3", 3);
        Shape d = new Circle("test4", 1.5);

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);
        
        ShapePerimeterComparator sc = new ShapePerimeterComparator();
        sorter.sortShapes(sc);

        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), d);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), a);

	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		// TODO: complete this...
	    ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 1, 9);
        Shape b = new Square("test3", 3);
        
        sorter.addShape(a);
        sorter.addShape(b);
        
        sorter.sortShapes();
        
        String result ="Square\t ID = test3\t area = 9.000\t perimeter = 12.000\n" + 
        "Rectangle\t ID = test\t area = 9.000\t perimeter = 20.000\n";
        Assert.assertEquals(result, sorter.toString());
	    
        
	}
}
