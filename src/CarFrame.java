import src.set.Vehicle;

public class CarFrame {
    private Vehicle car;
    private CarImage image;

    public CarFrame(Vehicle car, CarImage image) {
        this.car = car;
        this.image = image;
    }
    public Vehicle getCar(){
        return car;
    }
    public CarImage getImage() {
        return image;
    }
}
