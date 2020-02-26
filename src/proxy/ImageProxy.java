package proxy;

import object_pool.Bitmap;

public class ImageProxy implements Image {
    private Point point;
    private BitmapImage bitmapImage;

    @Override
    public void setLocation(Point point) {
        if(bitmapImage != null) {
            bitmapImage.setLocation(point);
        } else {
            this.point = point;
        }
    }

    @Override
    public Point getLocation() {
        if(bitmapImage != null) {
            return bitmapImage.getLocation();
        }
        return this.point;
    }

    @Override
    public void render() {
        if(bitmapImage == null) {
           bitmapImage = new BitmapImage();
           if(point != null) {
               bitmapImage.setLocation(point);
           }

        }
        bitmapImage.render();
    }

}
