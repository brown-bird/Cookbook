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
class Coupe implements Car
{

    @Override
    public String lockDoors()
    {
        return "2 doors locked";
    }

    @Override
    public String startIgnition()
    {
        return "turn key";
    }

    @Override
    public String revEngine()
    {
        return "coupe like engine rev";
    }
    
}
