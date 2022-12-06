package src.set;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class CarTransport extends Truck implements LoaderInter, Moveable{
    private boolean rampDown = false;
    private List<Vehicle> loadedCars = new ArrayList<>();
    private int loadCapacity;
    private CarLoader loader = new CarLoader();
    

    public CarTransport(int loadCapacity){
        super(2, 125, 0, Color.red, "CarTransport", 0.05);
        this.loadCapacity = loadCapacity;
    }

    public boolean canChangeRampAngle(){
        if(getCurrentSpeed() != 0){
            return false;
        } else {
            return true;
        }
    }

    public void lowerRamp(){
        if(canChangeRampAngle()){
            rampDown = true;
        }
    }

    public void raiseRamp(){
        if(canChangeRampAngle()){
            rampDown = false;  
        }
    }

    @Override
    public void setAllowedToMove(){
        super.setAllowedToMove(!rampDown);
    }
    public List<Vehicle> getLoadedCars(){
        return loadedCars;
    }
    public int getLoadCapacity(){
        return loadCapacity;
    }
    public void loadCar(Vehicle car){
        if(!car.getClass().equals(CarTransport.class)) loader.loadCar(car, this);
    }
    public void unloadCar(Vehicle car){
        loader.unloadCar(car, this);
    }
    
}