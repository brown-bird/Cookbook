/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cars;

import Cars.engines.Engine;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author richardclay
 */
public class M3Module extends AbstractModule
{

    @BindingAnnotation
    @Target({FIELD, PARAMETER, METHOD})
    @Retention(RUNTIME)public @interface BMW{}

    @Override
    protected void configure()
    {
        bind(Car.class).annotatedWith(BMW.class).to(Sedan.class);
        bind(Engine.class).toInstance(Engine.I6);
        bind(String.class).toInstance("BMW");
    }

}
