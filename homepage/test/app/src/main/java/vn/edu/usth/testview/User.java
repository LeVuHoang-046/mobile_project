package vn.edu.usth.testview;

import java.io.Serializable;

public class User implements Serializable {
    private int resourceId;
    private String name;
    private String address;

    public User(int resourceId, String name){ //String address) {
        this.resourceId = resourceId;
        this.name = name;
        this.address = address;
    }

    public User(int restaurant){ //String fincoder3) {
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
