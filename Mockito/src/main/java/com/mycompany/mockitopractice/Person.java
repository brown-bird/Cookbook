/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mockitopractice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author richardclay
 */
public class Person
{
    private final String firstName;
    private final String lastName;
    private final int age;
    public List<Occupation> jobs;
    private int salary;
    
    private Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jobs = new ArrayList();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getAge()
    {
        return age;
    }
    
    @Override
    public String toString()
    {
        return String.format("FirstName: %s%nLast Name: %s%nAge: %s", 
                firstName,
                lastName,
                age);
        
    }

    public void addJob(Occupation occupation)
    {
        this.jobs.add(occupation);
        setSalary(occupation);
    }

    public void raiseSalary(int raise)
    {
        this.salary += raise;
    }

    public int salary()
    {
        return this.salary;
    }

    private void setSalary(Occupation occupation)
    {
        this.salary += occupation.baseSalary();
    }

    public int jobs()
    {
        return this.jobs.size();
    }

    public void fired(Occupation job)
    {
        this.jobs.remove(job);
        this.salary -= job.baseSalary();
    }
    
    public static class PersonBuilder
    {
        private final String firstName;
        private String lastName = "Doe";
        private int age = 1;
        
        public PersonBuilder(String firstName)
        {
            this.firstName = firstName;
        }
        
        public PersonBuilder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }
        public PersonBuilder age(int age)
        {
            this.age = age;
            return this;
        }
        public Person build()
        {
            return new Person(firstName, lastName, age);
        }
    }
    
}
