package src.set;
import java.awt.*;
public abstract class Truck extends Vehicle implements truckInter{
   
   public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor){
      super(nrDoors, enginePower, currentSpeed, color, modelName, turnFactor);

   }

   @Override
   public double speedFactor() {
      // TODO Auto-generated method stub
      return 1;
   }
}
