import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VolvoImage implements CarImage{
    Point point;
    BufferedImage image ;

    public VolvoImage(Point point) throws IOException {
        this.point = point;
        this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
    }

    @Override
    public BufferedImage getImage() throws IOException {
        return image;
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
