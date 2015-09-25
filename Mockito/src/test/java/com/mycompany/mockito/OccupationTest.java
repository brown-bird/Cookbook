package com.mycompany.mockito;

import com.mycompany.mockitopractice.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;


public class OccupationTest
{
    Person troyAikman;
    public OccupationTest()
    {
    }

    
    @Before
    public void setUp() 
    {
        troyAikman = new Person.PersonBuilder("Troy").lastName("Aikman").build();
    }
    
    @Test
    public void jobTest()
    {
        System.out.println("jobTest");
        Person instance = new Person.PersonBuilder("John").build();
        Occupation firstJob = FootballPlayer.QUARTERBACK;
        instance.addJob(firstJob);
        final int first = 0;
        assertEquals(firstJob, instance.jobs.get(first));
        assertEquals(1, instance.jobs());
        final FootballPlayer secondJob = FootballPlayer.RUNNINGBACK;
        
        instance.addJob(secondJob);
        assertEquals(secondJob, FootballPlayer.RUNNINGBACK);
        assertEquals(2, instance.jobs());
        
    }
    
    @Test
    public void raiseTest()
    {
        System.out.println("raiseTest");
        troyAikman.addJob(FootballPlayer.QUARTERBACK);
        int salary = FootballPlayer.QUARTERBACK.baseSalary();
        final int raise = 50_000;
        troyAikman.raiseSalary(raise);
        salary += raise;
        assertEquals(salary, troyAikman.salary());
        
    }
    
    @Test
    public void firedTest()
    {
        Occupation detective = mock(Occupation.class);
        final int detectiveSalary = 58_000;
        when(detective.baseSalary()).thenReturn(detectiveSalary);
        
        this.troyAikman.addJob(FootballPlayer.QUARTERBACK);
        this.troyAikman.addJob(detective);

        
        troyAikman.fired(FootballPlayer.QUARTERBACK);
        verify(detective).baseSalary();
        assertEquals("fired failed", detective.baseSalary(), troyAikman.salary());
        
        troyAikman.fired(detective);
        assertEquals(0, troyAikman.salary());
    }
}
