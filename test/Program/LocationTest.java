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
public class LocationTest {
    @Mock
    Location mockLocation = mock(Location.class);
    
    //test that getLocation function returns a location
    @Test
    public void testGetLocation(){
        Location l = new Location();
        Random rn = new Random(5);
        assertEquals("The Point",l.getLocation(rn, 4));
    }
}
