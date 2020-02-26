package dynamicproxy;


public class Client {
    public static void main(String [] args) {
        Image img = ImageFactory.getImage();
        short x = 9;
        short y=4;
        img.setLocation(new Point(x,y));
    }
}
