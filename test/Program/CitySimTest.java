/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.*;
import Program.CitySim9002;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Rachel
 */
public class CitySimTest {
    @Mock
    Visitor mockVisitor = Mockito.mock(Visitor.class);
    CitySim9002 mockCitySim = Mockito.mock(CitySim9002.class);
    Location mockLocation = Mockito.mock(Location.class);
    Random mockRandom = mock(Random.class);
    
    //A string element should return as an integer
    //one character
    @Test
    public void testGenerateSeed1(){
        String input = "1";
        CitySim9002 someTest = new CitySim9002();
        assertEquals(1, someTest.generateSeed(input));
    }
    
    //more than one charactor
    @Test
    public void testGenerateSeed2(){
        String input = "123";
        CitySim9002 someTest = new CitySim9002();
        assertEquals(123, someTest.generateSeed(input));
    }
    
    //travelCity should at least return an array of 3 elements, location, preference and left city
    @Test
    public void testTravelCity1(){
        Visitor testV = new Visitor();
        CitySim9002 testCity = new CitySim9002();
        testV.setVisitorType(0);
        Random r = new Random(5);
        String[] output = testCity.travelCity(testV,r,1);
        assertTrue(output.length >= 3);
    }
    
    //The first element of travelCity should be a string starting with "Visitor 1 is going to Point."
    @Test
    public void testTravelCity2(){
        Visitor testV = new Visitor();
        CitySim9002 testCity = new CitySim9002();
        testV.setVisitorType(0);
        Random r = new Random(5);
        String[] output = testCity.travelCity(testV,r,1);
        assertEquals("Visitor 1 is going to The Point.",output[0]);
    }
    
    //The secont element of travelCity should be a string starting with "Visitor 1 did like "
    @Test
    public void testTravelCity3(){
        String input = "The Point";
        Visitor testV = new Visitor();
        CitySim9002 testCity = new CitySim9002();
        testV.setVisitorType(0);
        when(mockVisitor.getPreference(input)).thenReturn(true);
        Random r = new Random(5);
        String[] output = testCity.travelCity(testV,r,1);
        assertEquals("Visitor 1 did like The Point.",output[1]);
    }
    
    //The last element of travelCity should be a string saying "Visitor 1 has left the city."
    @Test
    public void testTravelCity4(){
        Visitor testV = new Visitor();
        CitySim9002 testCity = new CitySim9002();
        testV.setVisitorType(0);
        Random r = new Random(5);
        String[] output = testCity.travelCity(testV,r,1);
        assertTrue(output[output.length-1].matches("Visitor 1 has left the city."));
    }
}
