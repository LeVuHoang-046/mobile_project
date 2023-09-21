package vn.edu.usth.testview.homepage;

import java.io.Serializable;

public class Cate implements Serializable {
    private int resourceId;
    private String name;
    private String address;

    public Cate(int resourceId, String name){
        this.resourceId = resourceId;
        this.name = name;
        this.address = address;
    }

    public Cate(int restaurant){
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

}
