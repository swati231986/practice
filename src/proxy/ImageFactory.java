package proxy;

public class ImageFactory {
    // we do not want the client to know about proxy so we create another object that implements the Image Interface and send it to the client
    public static Image getImage() {
        return new ImageProxy();
    }
}
