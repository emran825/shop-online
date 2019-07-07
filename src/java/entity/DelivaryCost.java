package entity;
// Generated Nov 5, 2015 5:17:33 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DelivaryCost generated by hbm2java
 */
public class DelivaryCost  implements java.io.Serializable {


     private Integer delivaryId;
     private String zoneName;
     private double delivaryCost;
     private Set proOrders = new HashSet(0);

    public DelivaryCost() {
    }

	
    public DelivaryCost(String zoneName, double delivaryCost) {
        this.zoneName = zoneName;
        this.delivaryCost = delivaryCost;
    }
    public DelivaryCost(String zoneName, double delivaryCost, Set proOrders) {
       this.zoneName = zoneName;
       this.delivaryCost = delivaryCost;
       this.proOrders = proOrders;
    }
   
    public Integer getDelivaryId() {
        return this.delivaryId;
    }
    
    public void setDelivaryId(Integer delivaryId) {
        this.delivaryId = delivaryId;
    }
    public String getZoneName() {
        return this.zoneName;
    }
    
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    public double getDelivaryCost() {
        return this.delivaryCost;
    }
    
    public void setDelivaryCost(double delivaryCost) {
        this.delivaryCost = delivaryCost;
    }
    public Set getProOrders() {
        return this.proOrders;
    }
    
    public void setProOrders(Set proOrders) {
        this.proOrders = proOrders;
    }




}


