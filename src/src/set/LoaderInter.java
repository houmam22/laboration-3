package src.set;
import java.util.*;

public interface LoaderInter {
    double getX();
    double getY();
    List<Vehicle> getLoadedCars();
    int getLoadCapacity();
    void loadCar(Vehicle car);
    void unloadCar(Vehicle car);
}
