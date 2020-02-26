package dynamicproxy;


//concrete class providing the real functionality
public class BitmapImage implements Image {
    private Point point;

    @Override
    public void setLocation(Point point) {
        this.point = point;
    }

    @Override
    public Point getLocation() {
        return this.point;
    }

    @Override
    public void render() {
        System.out.println("x coordinate: "+ this.point.getxCoordinate() + " y coordinate: " + this.point.getyCoorddinate());
    }
}
