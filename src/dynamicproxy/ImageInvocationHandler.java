package dynamicproxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ImageInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            Method setLocationMethod = Image.class.getMethod("setLocation", new Class[]{Point.class});
            if(setLocationMethod.equals(method) ) {
                Point point = (Point) args[0];
                System.out.println(point);
            }
        } catch (Exception e) {}

        return null;
    }
}
