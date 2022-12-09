import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public interface CarImage {
    BufferedImage getImage() throws IOException;
    Point getPoint();
    void movePoint(int x, int y);
}
