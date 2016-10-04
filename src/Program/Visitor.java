/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/**
 *
 * @author Rachel
 */
public class Visitor {
    String[] visitorType = {"a Student", "a Professor", "a Business Person", "a Blogger"};
    private String type;
    
    public void setVisitorType(int i){
        this.type = visitorType[i];
    }
    
    public String getVisitorType(){
        return type;
    }
    
    public boolean getPreference(String s){
        if(type == visitorType[0]){
            if(s=="Downtown"||s=="The Point"||s=="Squirel Hill"){
                return true;
            }else{
                return false;
            }
        }else if (type == visitorType[1]){
            return true;
        }else if (type == visitorType[2]){
            if(s=="Downtown"||s=="Squirel Hill"){
                return true;
            }else{
                return false;
            }
        }else if(type == visitorType[3]){
            return false;
        }
        return false;
    }
}
