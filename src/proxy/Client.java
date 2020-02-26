package proxy;

public class Client {
    public static void main(String [] args) {
        Image myImage = ImageFactory.getImage();
        short x= 4;
        short y =6;
        myImage.setLocation(new Point( x,y));
        myImage.getLocation();
        myImage.render();
    }
}
