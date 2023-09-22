package vn.edu.usth.testview.homepage;

import java.io.Serializable;

public class Sale implements Serializable {
    private int resourceIdSale;
    private String nameSale;
    private String addressSale;

    public Sale(int resourceIdSale, String nameSale){
        this.resourceIdSale = resourceIdSale;
        this.nameSale = nameSale;
        this.addressSale = addressSale;
    }

    public Sale(int restaurant){
    }

    public int getResourceId() {
        return resourceIdSale;
    }

    public void setResourceId(int resourceId) {
        this.resourceIdSale = resourceId;
    }

    public String getName() {

        return nameSale;
    }

    public void setName(String name) {
        this.nameSale = nameSale;
    }

}
