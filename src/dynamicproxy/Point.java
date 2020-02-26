package dynamicproxy;

public class Point {
    public short getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(short xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public short getyCoorddinate() {
        return yCoorddinate;
    }

    public void setyCoorddinate(short yCoorddinate) {
        this.yCoorddinate = yCoorddinate;
    }

    public Point(short xCoordinate, short yCoorddinate) {
        this.xCoordinate = xCoordinate;
        this.yCoorddinate = yCoorddinate;
    }
    public Point() {}

    private short xCoordinate;
    private short yCoorddinate;

    @Override
    public String toString() {
        return "x coordinate = " + getxCoordinate() + " y coordinate = " + getyCoorddinate();
    }
}
