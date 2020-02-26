package dynamicproxy;


import java.lang.reflect.Proxy;

public class ImageFactory {
    public static Image getImage() {
        return  (Image) Proxy.newProxyInstance(ImageFactory.class.getClassLoader(), new Class[] {Image.class}, new ImageInvocationHandler());

    }
}
