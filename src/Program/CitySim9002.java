/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers, i112358
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";
    public static String[] location = {"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown", "has left the city"};
    
    public static void travelCity(Visitor sb, Random r, int j){
        boolean firstVisit = true;
        boolean stay = true;
        while(stay){
            if(firstVisit){
                String visitLocation = location[r.nextInt(4)];
                System.out.println("Visitor "+j+" is going to "+visitLocation+".");
                boolean like = sb.getPreference(visitLocation);
                if(like){
                    System.out.println("Visitor "+j+" did like "+visitLocation+".");
                }else{
                    System.out.println("Visitor "+j+" did not like "+visitLocation+".");
                }
                firstVisit = false;
            }else{
                int a = r.nextInt(5);
                String visitLocation = location[a];
                if(a==4){
                    System.out.println("Visitor "+j+" "+visitLocation+".");
                    System.out.println("***");
                    stay = false;
                    break;
                }else{
                    System.out.println("Visitor "+j+" is going to "+visitLocation+".");
                    boolean like = sb.getPreference(visitLocation);
                    if(like){
                    System.out.println("Visitor "+j+" did like "+visitLocation+".");
                    }else{
                    System.out.println("Visitor "+j+" did not like "+visitLocation+".");
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        if (new Validator().validateArguments(args)) {
            int seed = Integer.parseInt(args[0]);
            System.out.println("Welcome to CitySim! Your seed is "+seed+".");
            Random rseed = new Random(seed);
            for(int i=1;i<=5;i++){
                Visitor v = new Visitor();
                v.setVisitorType(rseed.nextInt(4));
                System.out.println("Visitor "+i+" is "+v.getVisitorType()+".");
                travelCity(v, rseed, i);
            }          
            System.exit(0);
        }
        else {
            System.out.println(errorMessage);
            System.exit(1);
        }
    }
}
