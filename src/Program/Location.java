/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.*;
/**
 *
 * @author Rachel
 */
public class Location {
    String[] location = {"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown", "has left the city"};
    
    public String getLocation(Random r, int i){
        return location[r.nextInt(i)];
    }
}
