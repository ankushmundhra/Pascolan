
package com.example.pascolan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("i")
    @Expose
    private Integer i;
    @SerializedName("n")
    @Expose
    private String n;
    @SerializedName("a")
    @Expose
    private String a;
    @SerializedName("p")
    @Expose
    private String p;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

}
