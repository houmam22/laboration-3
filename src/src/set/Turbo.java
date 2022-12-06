package src.set;

import java.awt.*;

public abstract class Turbo extends PassengerCar{
    private boolean turboOn;
    private double turboFactor;

    public Turbo(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor, double turboFactor){
        super(nrDoors, enginePower, currentSpeed, color, modelName, turnFactor);
        this.turboFactor = turboFactor;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = turboFactor;
        return getEnginePower() * 0.01 * turbo;
    }
    
}
