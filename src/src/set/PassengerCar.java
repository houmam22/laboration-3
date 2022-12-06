package src.set;
import java.awt.*;
public abstract class PassengerCar extends Vehicle{

    public PassengerCar(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor){
        super(nrDoors, enginePower, currentSpeed, color, modelName, turnFactor);

    }

    @Override
    public abstract double speedFactor();

}
