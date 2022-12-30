import src.set.*;
import java.awt.*;
import java.io.IOException;



public class CarApp {
    private CarView frame;
    public CarModel model;


    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarApp app = new CarApp();
        CarObserver observer = new CarObserver();
        app.model = new CarModel(observer);
        app.frame = new CarView(app.model.getCars());
        observer.setFrame(app.frame);
        CarController cc = new CarController(app.model, app.frame);
        cc.initComponents();
        app.frame.initComponents("CarSim 1.0");
        // Start a new view and send a reference of self
        app.model.run();
    }
}
