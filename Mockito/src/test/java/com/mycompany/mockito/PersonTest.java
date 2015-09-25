/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mockito;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.mycompany.mockitopractice.Person;

/**
 *
 * @author richardclay
 */
public class PersonTest
{
    
    public PersonTest()
    {
    }

    /**
     * Test of PersonBuilder, of class Person.
     */
    @org.junit.Test
    public void testGetFirstName()
    {
        System.out.println("build with full name and age");
        
        String firstName = "Richard";
        String lastName = "Clay";
        int age = 32;
        
        Person instance = new Person.PersonBuilder(firstName).lastName(lastName).age(age).build();
        System.out.println("instance:\n" + instance);
        assertEquals(firstName, instance.getFirstName());
        assertEquals(lastName, instance.getLastName());
        assertEquals(age, instance.getAge());
    }

}
