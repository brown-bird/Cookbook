/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cars.engines;

/**
 *
 * @author richardclay
 */
public enum Engine
{
    V8("burbble"), V4("vroom"), I4("buzz"), I3("buzz"), V12("Vrrzoom"), I6("growl"), I5("humm");
    
    public String sound;
    Engine(String sound)
    {
        this.sound = sound;
    }
    
}
