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
public class VisitorTest {
    @Test
    public void testGetVisitorType(){
        Visitor v = new Visitor();
        v.setVisitorType(0);
        assertEquals("a Student", v.getVisitorType());
    }
    
    //student should like downtown
    @Test
    public void testGetPreference(){
        Visitor v = new Visitor();
        v.setVisitorType(0);
        assertTrue(v.getPreference("Downtown"));
    }
    
    //student should dislike the cathedral of learning
    @Test
    public void testGetPreference2(){
        Visitor v = new Visitor();
        v.setVisitorType(0);
        assertFalse(v.getPreference("The Cathedral of Learning"));
    }
}
