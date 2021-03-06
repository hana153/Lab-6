
public class Rectangle extends Polygon
{

    private double height;

    private double width;

    // Constructor for the Rectangle class
    public Rectangle(String id, double height, double width)
    {
        super(id);
        this.height = height;
        this.width = width;

        this.sideLengths.add(height);
        this.sideLengths.add(height);
        this.sideLengths.add(width);
        this.sideLengths.add(width);
    }

    // returns the area that is calculated by: height * width
    public double getArea()
    {
        return height * width;
    }

    // returns the type of shape that was created and used, ie. rectangle
    public String getShapeType()
    {
        return "Rectangle";
    }

}
