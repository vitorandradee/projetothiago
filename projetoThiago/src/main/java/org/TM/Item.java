package org.TM;

public class Item {
    private String name;
    private double price;
    private int quantify;
    private double valueTotal;

    public Item(String name, double price, int quantify){
        this.name = name;
        this.price = price;
        this.quantify = quantify;
        this.valueTotal = quantify * price;
    }

    public double getValueTotal(){
        return this.valueTotal;
    }
    public String toString(){
        return String.format("%-20s %3d * %6.2f = R$ %7.2f", name,quantify,price,valueTotal);
    }
}
