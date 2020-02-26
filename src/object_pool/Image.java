package object_pool;

public interface Image extends Poolable {
     void reset();
     void draw();
     Location getLocation();
     void setLocation(int x, int y);
}
