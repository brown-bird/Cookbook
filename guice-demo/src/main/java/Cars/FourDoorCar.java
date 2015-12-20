/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cars;

/**
 *
 * @author richardclay
 */
abstract class FourDoorCar implements Car
{

    @Override
    public String lockDoors()
    {
        return "4 doors locked!";
    }

    @Override
    public abstract String startIgnition();
    
}
