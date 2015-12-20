package Cars;

import Cars.M3Module.BMW;
import Cars.engines.Engine;
import com.google.inject.Inject;

class Sedan extends FourDoorCar
{
    private final Engine engine;
    private final String brand;
    
    @Inject
    Sedan(Engine engine, String brand)
    {
        this.engine = engine;
        this.brand = brand;
    }

    @Override
    public String startIgnition()
    {
        return "reasonable sedan sound";
    }

    @Override
    public String revEngine()
    {
        return engine.sound;
    }
    
}
