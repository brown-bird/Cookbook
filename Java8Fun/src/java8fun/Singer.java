/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8fun;

/**
 *
 * @author Richard
 */
public interface Singer {
    public String sing();
    
    public default String dance()
    {
        return "Twerking time...";
    }
    
}
