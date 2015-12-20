/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import Cars.Car;

/**
 *
 * @author richardclay
 */
public class Team
{
    String manager;
    String cheifMechanic;
    String driver;
    RaceCar car;

    public Team(String manager, String cheifMechanic, String driver, Car car)
    {
        this.manager = manager;
        this.cheifMechanic = cheifMechanic;
        this.driver = driver;
        this.car = car;
    }
    
    public void prepCar()
    {
        System.out.println("prepping car number:" + car.getNumber());
    }
}
