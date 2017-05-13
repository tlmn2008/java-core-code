package kenny.lang.serialize;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 2;
    private String name;
    private String address;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address =address;
    }
}
