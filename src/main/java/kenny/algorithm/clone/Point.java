package kenny.algorithm.clone;

public class Point implements Cloneable {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y)
    {
        this.x = x;
        this.y = y;
    }

    public Point copyPoint(Point point) throws CloneNotSupportedException
    {
        if(!(point instanceof Cloneable))
        {
            throw new CloneNotSupportedException("Invalid cloning");
        }
        //Can do multiple other things here
        return new Point(point.x, point.y);
    }

    @Override
    public Object clone() {
        Point clone = null;
        try {
            clone = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return clone;
    }

    @Override
    public String toString() {
        return "x = "+x+", y = "+y;
    }
}

class Point2 extends Point {
    private Integer z;

    public Point2(Integer x, Integer y, Integer z)
    {
        super(x, y);
        this.z = z;
    }

    @Override
    public Object clone() {
        Point clone = null;
        clone = (Point) super.clone();
        return clone;
    }
}
class Test {
    public static void main(String[] args) {
        Point point = new Point(1, 2);

        try {
            Point point1 = point.copyPoint(point);
            System.out.println(point1);

            Point point2 = (Point) point.clone();
            System.out.println(point2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        Point2 point11 = new Point2(1, 2, 3);
        Point2 point12 = (Point2)point11.clone();
        System.out.println(point12);
    }
}
