package src.set;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CarTest {
    
    @Test
    public void carTester(){
        Volvo240 car = new Volvo240();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), 0.00000001);

    }

    @Test
    public void moveAndTurnTest(){
        Saab95 car = new Saab95();
        double oldx = car.getX();
        double oldy = car.getY();
        car.turnLeft();
        car.gas(0.5);
        car.move();
        assertEquals(false, oldx == car.getX());
        assertEquals(false, oldy == car.getY());

    }

    @Test
    public void breakTest(){
        Volvo240 car = new Volvo240();
        car.startEngine();
        car.gas(0.5);
        double oldSpeed = car.getCurrentSpeed();
        car.brake(0.5);
        assertEquals(true, oldSpeed > car.getCurrentSpeed());

    }

    @Test
    public void gasTooMuchTest(){
        Volvo240 car = new Volvo240();
        car.startEngine();
        double maxEnginePower = car.getEnginePower();
        car.setCurrentSpeed(car.getEnginePower() + 1);
        assertEquals(maxEnginePower, car.getEnginePower(), 0.00000001);
    }
     @Test
    public void car_always_inside_field(){
         Vehicle car = new Saab95();
        assertEquals(true, Math.abs(car.getX()) <= car.getMaxCoords());
        assertEquals(true, Math.abs(car.getY()) <= car.getMaxCoords());
    }
    @Test
    public void currentSpeed_sanity_check(){
        Vehicle car = new Saab95();
        car.setCurrentSpeed(-20);
        assertEquals(true, car.getCurrentSpeed() >= 0);
        car.setCurrentSpeed(car.getEnginePower() + 50);
        assertEquals(true, car.getCurrentSpeed() <= car.getEnginePower());
    }
    @Test
    public void incrementSpeed_should_not_decrease_speed(){
        Vehicle car = new Saab95();
        car.setCurrentSpeed(40);
        double tmp = car.getCurrentSpeed();
        car.incrementSpeed(-0.3);
        assertEquals(true, tmp >= car.getCurrentSpeed());
    }
    @Test
    public void incrementSpeed_should_not_overgrow_enginPower(){
        Vehicle car = new Volvo240();
        car.setCurrentSpeed(car.getEnginePower());
        car.incrementSpeed(1);
        double currentSpeed = car.getCurrentSpeed();
        assertEquals(true, currentSpeed <= car.getEnginePower());
    }
    @Test
    public void decrementSpeed_should_not_increase_speed(){
        Vehicle car = new Volvo240();
        car.setCurrentSpeed(20);
        car.decrementSpeed(-1);
        assertEquals(true,car.getCurrentSpeed() <= 20);
    }
    @Test
    public void decrementSpeed_should_not_go_below_zero(){
        Vehicle car = new Volvo240();
        car.setCurrentSpeed(0);
        car.decrementSpeed(1);
        assertEquals(true,car.getCurrentSpeed() >= 0);
    }
    @Test
    public void cars_actually_move_when_call_move(){
        Vehicle car = new Volvo240();
        car.setDir(2);
        car.setCurrentSpeed(50);
        double tmpX = car.getX();
        double tmpY = car.getY();
        car.move();
        assertEquals(false, tmpX != car.getX());
        assertEquals(false, tmpY != car.getY());
    }
    @Test
    public void car_cant_move_outside_field(){
        Vehicle car = new Volvo240();
        car.setCurrentSpeed(50);
        car.setX(car.getMaxCoords());
        car.setY(car.getMaxCoords());
        car.setDir(0);
        car.move();
        assertEquals(false, car.getY() > car.getMaxCoords());
        car.setDir(1.5 * Math.PI);
        car.move();
        assertEquals(false, car.getX() > car.getMaxCoords());
    }
    @Test
    public void turn_left_should_not_make_dir_bigger_than_2PI(){
        Vehicle car = new Volvo240();
        car.setDir(1.99 * Math.PI);
        car.turnLeft();
        assertEquals(false, car.getDir() > 2*Math.PI);
    }
    @Test
    public void turn_right_should_not_make_dir_smaller_than_zero(){
        Vehicle car = new Volvo240();
        car.setDir(0);
        car.turnRight();
        assertEquals(false, car.getDir() < 0);
    }
    @Test
    public void turn_left_increase_dir(){
        Vehicle car = new Volvo240();
        car.setDir(0);
        car.turnLeft();
        assertEquals(true, car.getDir() > 0);
    }
    @Test
    public void turn_right_decrease_dir(){
        Vehicle car = new Volvo240();
        car.setDir(Math.PI);
        car.turnRight();
        assertEquals(true, car.getDir() < Math.PI);
    }
    @Test
    public void turn_left_increase_dir_to_zero_after_2PI(){
        Vehicle car = new Volvo240();
        car.setDir(1.99 * Math.PI);
        car.turnLeft();
        assertEquals(true, car.getDir() < 2 * Math.PI);
    }
    @Test
    public void turn_right_decrease_dir_to_2PI_after_zero(){
        Vehicle car = new Volvo240();
        car.setDir(0);
        car.turnRight();
        assertEquals(true, car.getDir() > 0);
    }
    @Test
    public void scania_not_move_when_ramp_up(){
        Scania car = new Scania();
        car.raiseRampByDegrees(50);
        car.gas(1);
        assertEquals(0, car.getCurrentSpeed(), 0.0000001);
    }
    @Test
    public void car_transporter_can_not_be_overloaded(){
        CarTransport car = new CarTransport(1);
        Volvo240 tmp = new Volvo240();
        Saab95 tmp2 = new Saab95();
        tmp.setX(car.getX()); tmp.setY(car.getY());
        tmp2.setX(car.getX()); tmp2.setY(car.getY());
        car.loadCar(tmp);car.loadCar(tmp2);
        assertEquals(car.getLoadCapacity(), car.getLoadedCars().size());
    }
    @Test
    public void unloaded_form_repair_shop_removed_form_list(){
        CarRepairShop shop = new CarRepairShop(2, 0, 0);
        Vehicle car = new Volvo240();
        car.setX(0); car.setY(0);
        shop.loadCar(car);
        assertEquals(shop.getLoadedCars().contains(car), true);
        shop.unloadCar(car);
        assertEquals(shop.getLoadedCars().contains(car), false);
    }
}
