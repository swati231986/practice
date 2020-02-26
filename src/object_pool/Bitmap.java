package object_pool;

public class Bitmap implements Image {
    public Bitmap(String name) {
        this.name = name;
    }

    Location location;
    String name;

    @Override
    public void reset() {
        location = null;
        System.out.println("Bitmap is reset");
    }

    @Override
    public void draw() {
        System.out.println("drawing "+ name + " " +location);
    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void setLocation(int x, int y) {

    }


}
