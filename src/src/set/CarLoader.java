package src.set;
import java.util.*;

public class CarLoader {
    private int marginTrash = 10;

    public void loadCar(Vehicle car, LoaderInter loader){
        if(!car.equals(loader)){
            if(Math.sqrt(Math.pow(loader.getX()-car.getX(), 2) + Math.pow(loader.getY()-car.getY(), 2)) <= 10){
                if(loader.getLoadedCars().size() < loader.getLoadCapacity()){
                    loader.getLoadedCars().add(car);
                    car.setX(car.getMaxCoords() + marginTrash);
                    car.setY(car.getMaxCoords() + marginTrash);
                    car.setAllowedToMove(false);
                } else {
                    System.out.println("Max loaded cars reached");
                }
            }
        }
    }
    public void unloadCar(Vehicle car, LoaderInter loader){
        car.setAllowedToMove(true);
        loader.getLoadedCars().remove(car);
        car.setX(loader.getX());
        car.setY(loader.getY() + marginTrash);
    }
}
