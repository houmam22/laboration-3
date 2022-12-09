import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaniaImage implements CarImage{
    Point point;

    public ScaniaImage(Point point) {
        this.point = point;
    }

    @Override
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public void movePoint(int dx, int dy) {
        point.x += dx;
        point.y += dy;
    }
}
