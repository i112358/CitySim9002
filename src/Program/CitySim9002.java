/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.*;

/**
 *
 * @author AsphaltPanthers, i112358
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";

    //Method for each visitor to visit locations. Returns array of string for the main to print
    public static String[] travelCity(Visitor sb, Random r, int j){
        ArrayList<String> al = new ArrayList<String>();
        boolean firstVisit = true;   //flag for first visit (can't leave city)
        boolean stay = true; //flag if RNG hasn't made the visitor leave
        while(stay){
            if(firstVisit){
                //visitor cannot leave city
                Location l = new Location();
                String visitLocation = l.getLocation(r, 4);
                al.add("Visitor "+j+" is going to "+visitLocation+".");
                boolean like = sb.getPreference(visitLocation);
                if(like){
                    al.add("Visitor "+j+" did like "+visitLocation+".");
                }else{
                    al.add("Visitor "+j+" did not like "+visitLocation+".");
                }
                firstVisit = false;
            }else{
                Location l = new Location();
                String visitLocation = l.getLocation(r, 5);
                if(visitLocation.matches("has left the city")){
                    al.add("Visitor "+j+" "+visitLocation+".");                 
                    stay = false;
                    break;
                }else{
                    al.add("Visitor "+j+" is going to "+visitLocation+".");
                    boolean like = sb.getPreference(visitLocation);
                    if(like){
                        al.add("Visitor "+j+" did like "+visitLocation+".");
                    }else{
                        al.add("Visitor "+j+" did not like "+visitLocation+".");
                    }
                }
            }
        }
        String[] s =al.toArray(new String[al.size()]);
        return s;
    }
    
    //return args[0] argument as an integer for the RNG
    public static int generateSeed(String a){
        int b = Integer.parseInt(a);
        return b;
    }
    
    public static void main(String[] args) {
        //check if argument is valid
        if (new Validator().validateArguments(args)) {
            int seed = generateSeed(args[0]);
            //Print out first line
            System.out.println("Welcome to CitySim! Your seed is "+seed+".");
            Random rseed = new Random(seed);
            //Five visitors in total
            for(int i=1;i<=5;i++){
                Visitor v = new Visitor();
                v.setVisitorType(rseed.nextInt(4)); //type of visitor is random
                System.out.println("Visitor "+i+" is "+v.getVisitorType()+".");
                String[] str = travelCity(v, rseed, i); //let visitor travel city
                for(String sentence : str){
                    System.out.println(sentence);
                }
                System.out.println("***"); //end of one visitor
            }          
            System.exit(0);
        }
        else {
            //if argument not valid throw error message
            System.out.println(errorMessage);
            System.exit(1);
        }
    }
}
