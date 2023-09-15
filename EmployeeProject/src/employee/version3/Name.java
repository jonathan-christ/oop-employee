/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version3;

/**
 *
 * @author User
 */
public class Name {
    private String first;
    private String last;
    private String middle;
    private String suffix;
    private String prefix;
    
//  CONSTRUCTORS
    public Name(){
        this.first="";
        this.last="";
        this.middle="";
        this.suffix="";
        this.prefix="";
    }
    
    public Name(String first, String last, String middle){
        this();
        this.first = first;
        this.last = last;
        this.middle = middle;
    }
    
    public Name(String first, String last, String middle, String suffix, String prefix) {
        this(first, last, middle);
        this.suffix = suffix;
        this.prefix = prefix;
    }
    
//  SETTERS AND GETTERS

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
// METHODS
    @Override
    public String toString() {
        return 
            "\tFirst name='"+this.first+"',\n"+
            "\tLast name='"+this.last+"',\n"+ 
            "\tMiddle name='"+this.middle+"',\n"+
            "\tPrefix='"+this.prefix+"',\n"+
            "\tSuffix='"+this.suffix+"',\n"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
