
package com.lava.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Balance {

    @SerializedName("available")
//    @Expose
    private float available;
//    @SerializedName("current")
//    @Expose
    private float current;
//    @SerializedName("ledger")
//    @Expose
    private float ledger;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Balance() {
    }

    /**
     * 
     * @param current
     * @param available
     * @param ledger
     */
    public Balance(float available, float current, float ledger) {
        this.available = available;
        this.current = current;
        this.ledger = ledger;
    }

    /**
     * 
     * @return
     *     The available
     */
    public float getAvailable() {
        return available;
    }

    /**
     * 
     * @param available
     *     The available
     */
    public void setAvailable(float available) {
        this.available = available;
    }

    /**
     * 
     * @return
     *     The current
     */
    public float getCurrent() {
        return current;
    }

    /**
     * 
     * @param current
     *     The current
     */
    public void setCurrent(float current) {
        this.current = current;
    }

    /**
     * 
     * @return
     *     The ledger
     */
    public float getLedger() {
        return ledger;
    }

    /**
     * 
     * @param ledger
     *     The ledger
     */
    public void setLedger(float ledger) {
        this.ledger = ledger;
    }

}
