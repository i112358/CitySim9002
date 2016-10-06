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
    public static String[] location = {"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown", "has left the city"};
    
    public static String[] travelCity(Visitor sb, int seed2, int j){
        ArrayList<String> al = new ArrayList<String>();
        Random r = new Random(seed2);
        boolean firstVisit = true;
        boolean stay = true;
        while(stay){
            if(firstVisit){
                String visitLocation = location[r.nextInt(4)];
                al.add("Visitor "+j+" is going to "+visitLocation+".");
                boolean like = sb.getPreference(visitLocation);
                if(like){
                    al.add("Visitor "+j+" did like "+visitLocation+".");
                }else{
                    al.add("Visitor "+j+" did not like "+visitLocation+".");
                }
                firstVisit = false;
            }else{
                int a = r.nextInt(5);
                String visitLocation = location[a];
                if(a==4){
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
    
    public static int generateSeed(String a){
        int b = Integer.parseInt(a);
        return b;
    }
    
    public static void main(String[] args) {
        if (new Validator().validateArguments(args)) {
            int seed = generateSeed(args[0]);
            System.out.println("Welcome to CitySim! Your seed is "+seed+".");
            Random rseed = new Random(seed);
            for(int i=1;i<=5;i++){
                Visitor v = new Visitor();
                v.setVisitorType(rseed.nextInt(4));
                System.out.println("Visitor "+i+" is "+v.getVisitorType()+".");
                String[] str = travelCity(v, seed, i);
                for(String sentence : str){
                    System.out.println(sentence);
                }
                System.out.println("***");
            }          
            System.exit(0);
        }
        else {
            System.out.println(errorMessage);
            System.exit(1);
        }
    }
}
