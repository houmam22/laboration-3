package src.set;

public class Engine{
    private double enginePower;
    private boolean turboOn;

    public Engine(double enginePower){
        this.enginePower = enginePower;
    }

    public double turboSpeedFactor(double turboFactor){
        double turbo = 1;
        if(turboOn) turbo = turboFactor;
        return enginePower * 0.01 * turbo;

    }
    
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    public double trimSpeedFactor(double trimFactor){
        return enginePower * 0.01 * trimFactor;
    }
    
}
