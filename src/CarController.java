import src.set.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    public ArrayList<CarFrame> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarController cc = new CarController();
        Vehicle volvo = new Volvo240();
        cc.cars.add(new CarFrame(volvo, new VolvoImage(new Point((int) volvo.getX(), (int) volvo.getY()))));
        Vehicle saab = new Saab95();
        saab.setCoords(0, 100);
        //cc.cars.add(saab);
        cc.cars.add(new CarFrame(saab, new SaabImage(new Point((int) saab.getX(), (int) saab.getY()))));
        Vehicle scania = new Scania();
        scania.setCoords(0, 200);
        cc.cars.add(new CarFrame(saab, new ScaniaImage(new Point((int) scania.getX(), (int) scania.getY()))));
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        //cc.frame.addCarView(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")), (int)saab.getX(), (int)saab.getY());
        //cc.frame.addCarView(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")), (int)volvo.getX(), (int)volvo.getY());
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (CarFrame car : cars) {
                int tmpx = (int)car.getCar().getX();
                int tmpy = (int)car.getCar().getY();
                car.getCar().move();
                int x = (int) Math.round(car.getCar().getX());
                int y = (int) Math.round(car.getCar().getY());
                car.getImage().movePoint(x - tmpx, y - tmpy);
                //frame.drawPanel.moveit();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        //double gas = ((double) amount) / 100;
        for (CarFrame car : cars) {
            car.getCar().gas(amount);
        }
    }
    void startEngine(){
        for (CarFrame car : cars
        ) {
            car.getCar().startEngine();
        }
    }
    void stopEngine(){
        for (CarFrame car : cars
        ) {
            car.getCar().stopEngine();
        }
    }
}