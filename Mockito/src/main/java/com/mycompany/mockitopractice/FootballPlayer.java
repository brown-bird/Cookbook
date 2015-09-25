/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mockitopractice;

/**
 *
 * @author richardclay
 */
public enum FootballPlayer implements Occupation
{
    QUARTERBACK(150_000_000),
    LINEBACKER(500_000),
    RUNNINGBACK(1_350_000);

    private int baseSalary;
    
    private FootballPlayer(int salary)
    {
        this.baseSalary = salary;
    }
    
    @Override
    public int baseSalary()
    {
        return baseSalary;
    }
}
