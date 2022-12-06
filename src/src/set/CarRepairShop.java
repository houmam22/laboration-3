package src.set;

import java.util.ArrayList;
import java.util.List;

public class CarRepairShop implements LoaderInter{
    private CarLoader loader;
    private int capacity;
    private List<Vehicle> loadedCars = new ArrayList<>();
    private double x,y;

    public CarRepairShop(int capacity, double x, double y) {
        loader = new CarLoader();
        this.capacity = capacity;
        this.x = x;this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public List<Vehicle> getLoadedCars() {
        return loadedCars;
    }
    public int getLoadCapacity() {
        return capacity;
    }
    public void loadCar(Vehicle car){
        loader.loadCar(car, this);
    }
    public void unloadCar(Vehicle car) {
        loader.unloadCar(car, this);
    }
}
