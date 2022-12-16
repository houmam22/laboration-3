package src.set;
import java.awt.*;
import java.util.Random;
public abstract class Vehicle implements Moveable{
    private int nrDoors; // Number of doors on the src.car
    private double enginePower; // Engine power of the src.car
    private double currentSpeed; // The current speed of the src.car
    private Color color; // Color of the src.car
    private String modelName; // The src.car model name
    private double x,y;
    private final int maxCoords = 500;
    private double dir;
    private double turnFactor;
    private boolean allowedToMove = true;
    private boolean carOn;
    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnFactor) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnFactor = turnFactor;
        //Random rnd = new Random();
        x = 0;//rnd.nextDouble(0, maxCoords);
        y = 0;//rnd.nextDouble(0, maxCoords);
    }
    
    private void setCurrentSpeed(double speed){
        if(this.getAllowedToMove()){
            if(speed > getEnginePower()) {
                this.currentSpeed = getEnginePower();
                System.out.print("speed too high, was set to enginePower");
            }
            if(speed < 0) {
                this.currentSpeed = 0;
                System.out.print("speed too low, was set to 0");
            }
            else{
                this.currentSpeed = speed;
            }
        }else{
            currentSpeed = 0;
        }
    }


    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    private void setDir(double dir) {
        if(dir > 0) this.dir = dir % (2 * Math.PI);
        if(dir < 0) this.dir = (2 * Math.PI) -((-dir) % (2 * Math.PI));
    }
    public void setAllowedToMove(boolean allowedToMove) {
        this.allowedToMove = allowedToMove;
    }
    public boolean getAllowedToMove() {
        return allowedToMove;
    }
    public double getDir() {
        return dir;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public int getMaxCoords() {return maxCoords;}

    public void stopEngine(){
        if(carOn){
            setCurrentSpeed(0);
            carOn = false;
        }
    }
    public void startEngine(){
        if(!carOn){
            setCurrentSpeed(0.2);
            carOn = true;
        }
    }
    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
    public void move() {
        if(Math.abs(this.y+currentSpeed * Math.cos(dir)) <= maxCoords){
            this.y += currentSpeed * Math.cos(dir);
        }else{ this.y = Math.signum(currentSpeed * Math.cos(dir)) * maxCoords;}

        if(Math.abs(x+currentSpeed * Math.sin(dir)) <= maxCoords){
            x += currentSpeed * Math.sin(dir);
        }else{ x = Math.signum(currentSpeed * Math.sin(dir)) * maxCoords;}
    }
    public void turnLeft() {setDir(dir + turnFactor);}
    public void turnRight() {setDir(dir - turnFactor);}


    public void gas(double amount){
        if(amount > 0 && carOn) {
            incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if(amount > 0) {
            decrementSpeed(amount);
        }else{
            System.out.print("Invalid amount: " + amount);
        }
    }
    public abstract double speedFactor();
}