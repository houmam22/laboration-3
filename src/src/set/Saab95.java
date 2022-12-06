package src.set;
import java.awt.*;
public class Saab95 extends PassengerCar{
    private Engine engine;
    private double turboFactor = 1.25;
    public Saab95(){
        super(2, 100, 0, Color.red, "Saab95", 0.07);
	    engine = new Engine(100);
    }
    public double speedFactor(){
        return engine.turboSpeedFactor(turboFactor);
    }
}