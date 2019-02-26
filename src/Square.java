
public class Square extends Rectangle
{
    // constructor to create a Square object
    public Square(String id, double size)
    {
        super(id, size, size);

    }

    // returns the type of shape that was created and used, ie. square
    public String getShapeType()
    {
        return "Square";
    }

}
