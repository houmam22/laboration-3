import src.set.Saab95;
import src.set.Scania;
import src.set.Vehicle;
import src.set.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CarModel {
    private final int delay = 50;
    private ArrayList<CarFrame> cars = new ArrayList<>();
    private Timer timer = new Timer(delay, new TimerListener());
    private CarObserver observer;

    public CarModel(CarObserver observer) throws IOException {
        this.observer = observer;
        populateCars();
    }

    public ArrayList<CarFrame> getCars() {
        return cars;
    }

    private void populateCars() throws IOException {
        Vehicle volvo = new Volvo240();
        cars.add(new CarFrame(volvo, new VolvoImage(new Point((int) volvo.getX(), (int) volvo.getY()))));
        Vehicle saab = new Saab95();
        saab.setCoords(0, 100);
        //cc.cars.add(saab);
        cars.add(new CarFrame(saab, new SaabImage(new Point((int) saab.getX(), (int) saab.getY()))));
        Vehicle scania = new Scania();
        scania.setCoords(0, 200);
        cars.add(new CarFrame(saab, new ScaniaImage(new Point((int) scania.getX(), (int) scania.getY()))));
    }
    public void run() throws IOException {
        Vehicle volvo = new Volvo240();
        cars.add(new CarFrame(volvo, new VolvoImage(new Point((int) volvo.getX(), (int) volvo.getY()))));
        Vehicle saab = new Saab95();
        saab.setCoords(0, 100);
        cars.add(new CarFrame(saab, new SaabImage(new Point((int) saab.getX(), (int) saab.getY()))));
        Vehicle scania = new Scania();
        scania.setCoords(0, 200);
        cars.add(new CarFrame(saab, new ScaniaImage(new Point((int) scania.getX(), (int) scania.getY()))));
        timer.start();
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (CarFrame car : cars) {
                int tmpx = (int)car.getCar().getX();
                int tmpy = (int)car.getCar().getY();
                car.getCar().move();
                int x = (int) Math.round(car.getCar().getX());
                int y = (int) Math.round(car.getCar().getY());
                car.getImage().movePoint(x - tmpx, y - tmpy);
                observer.notifyFrame();
                //frame.drawPanel.repaint();
            }
        }
    }
    public void gas(int amount) {
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
