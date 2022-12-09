import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    List<CarImage> carspoints = new ArrayList<>();
    //BufferedImage volvoImage;
    // To keep track of a singel cars position
    //Point volvoPoint = new Point();

    // TODO: Make this genereal for all cars
    /*void moveit(){
        this.repaint();
        //volvoPoint.x = x;
        //volvoPoint.y = y;
    }*/
    public void addCarView(CarImage image){
        carspoints.add(image);
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
         /*try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

          */

        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(CarImage car: carspoints){
            try {
                g.drawImage(car.getImage(), car.getPoint().x, car.getPoint().y, null); // see javadoc for more info on the parameters
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
    }
}
