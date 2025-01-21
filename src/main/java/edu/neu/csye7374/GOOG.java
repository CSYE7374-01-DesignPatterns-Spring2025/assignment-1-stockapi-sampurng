package edu.neu.csye7374;

public class GOOG extends Stock{
    private double totalPrice; 
    private int bids;
    public GOOG(String name, double price, String description, double totalPrice, int bids) {
        super(name, price, description);
        this.totalPrice = totalPrice;
        this.bids = bids;
    }
    
    @Override
    public void setPrice(double price) {
        // Average pricing model here
        this.totalPrice = this.totalPrice + price;
        this.bids = this.bids+1;
        int value = (int) (price-(this.totalPrice/this.bids));
        setMetric(value*20);
        this.price = price;
    }
}